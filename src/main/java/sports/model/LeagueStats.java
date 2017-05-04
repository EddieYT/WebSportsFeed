package sports.model;

import javafx.scene.layout.Priority;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by obinnaasinugo on 4/30/17.
 */
public class LeagueStats {
    private FileDownloader dl;
    private FileReaderv3 cumu;
    private String teamName;
    private ArrayList<String> lines;
    private PriorityQueue<NbaPlayer> playerStats;

    public LeagueStats() throws IOException {
        dl = new FileDownloader("src/main/resources/");
        dl.cumulativePlayers();
        cumu = new FileReaderv3("src/main/resources/cumulative_player_stats.csv");
        lines = cumu.getLines();
        ComparePlayerImpact comparePlayerImpact = new ComparePlayerImpact();
        playerStats = new PriorityQueue<NbaPlayer>(comparePlayerImpact);
        statsGenerator();
    }

    /**
     * This method will parse a player's stats and the player to aggregate list
     * of all players in the league.
     */
    public void statsGenerator(){
        for(String line: lines){
            String[] str = line.split(",");
            if (str.length < 19) {
                continue;
            }

            NbaPlayer player;
            if(str.length == 82) {
                String team = str[16] + " " + str[17];
                String name = str[3] + " " + str[2];
                player = new NbaPlayer(name, team);
                player.setAvgPoint(str[48]);
                player.setAvgAssist(str[46]);
                player.setAvgRebound(str[44]);
                player.setAvgBlock(str[54]);
                player.setAvgSteal(str[52]);
            }
            else{
                String team = str[15] + " " + str[16];
                String name = str[3] + " " + str[2];
                player = new NbaPlayer(name, team);
                player.setAvgPoint(str[47]);
                player.setAvgAssist(str[45]);
                player.setAvgRebound(str[43]);
                player.setAvgBlock(str[53]);
                player.setAvgSteal(str[51]);
            }



            // calculate player impact metric
            player.setImpact();

            playerStats.add(player);
        }
    }

    public NbaPlayer[] getAllPlayerStats(){
        return playerStats.toArray(new NbaPlayer[playerStats.size()]);
    }

    /**
     * Return a list of the top n impact players.
     * @param n, size of the list.
     * @return list of the top n impact players.
     */
    public ArrayList<NbaPlayer> getTopImpactPlayers(int n){

        ArrayList<NbaPlayer> topImpactPlayers = new ArrayList<>();
        for(int i = 0; i < n; i++){
            topImpactPlayers.add(playerStats.remove());
        }

        return topImpactPlayers;
    }
}
