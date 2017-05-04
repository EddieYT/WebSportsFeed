package sports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sports.data.NbaPlayerRepository;
import sports.data.TeamRepository;
import sports.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eddie on 4/30/17.
 */
@Controller
public class SearchController {
    @Autowired
    private NbaPlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @RequestMapping("/search/{name}")
    public String searchDetails(@PathVariable String name, ModelMap modelMap) throws IOException {
        if (name.equals("teams")) {
            List<Team> teams = teamRepository.getAllTeams();
            modelMap.put("teams", teams);
            return "teams";
        }
        if (name.equals("player")) { return "player"; }
        if (name.equals("standings")) {
            NbaStandings standings = new NbaStandings();
            List<Record> records = standings.getLeagueStandings();
            modelMap.put("records", records);
            return "standings";
        }

        NbaPlayer player = playerRepository.findByName(name);
        Team team = teamRepository.findByName(name);

        if (team != null) {
            ArrayList<String> topScorers = team.getTop5Scorer();
            ArrayList<String> topAssisters = team.getTop5Assistant();
            ArrayList<String> topRebounders = team.getTop5Rebounder();
            ArrayList<String> topStealers = team.getTop5Stealer();
            ArrayList<String> topBlockers = team.getTop5Blocker();


            String topScorer = topScorers.get(0);
            String topAssister = topAssisters.get(0);
            String topRebounder = topRebounders.get(0);
            String topStealer = topStealers.get(0);
            String topBlocker = topBlockers.get(0);

            int count = 1;
            ArrayList<String[]> rankings = new ArrayList<>();
            for(int i = 0; i < 5; i++){
                String topPlayers[] = new String[6];
                topPlayers[0] = Integer.toString(count);
                topPlayers[1] = topScorers.get(i);
                topPlayers[2] = topAssisters.get(i);
                topPlayers[3] = topRebounders.get(i);
                topPlayers[4] = topStealers.get(i);
                topPlayers[5] = topBlockers.get(i);
                rankings.add(topPlayers);
                count++;
            }

            modelMap.put("rankings", rankings);
            modelMap.put("team", team);
            modelMap.put("topScorer", topScorer);
            modelMap.put("topAssister", topAssister);
            modelMap.put("topRebounder", topRebounder);
            modelMap.put("topStealer", topStealer);
            modelMap.put("topBlocker", topBlocker);

            return "team_stats";
        }

        if (player != null) {
            player.setAvgAssist(PlayerStatsParser.getPLayerAstPerGame(player));
            player.setAvgBlock(PlayerStatsParser.getPLayerBlkPerGame(player));
            player.setAvgPoint(PlayerStatsParser.getPLayerPtsPerGame(player));
            player.setAvgRebound(PlayerStatsParser.getPLayerRebPerGame(player));
            player.setAvgSteal(PlayerStatsParser.getPLayerStlPerGame(player));
            player.setHeight(PlayerStatsParser.getPlayerHeight(player));
            player.setWeight(PlayerStatsParser.getPlayerWeight(player));
            player.setPosition(PlayerStatsParser.getPlayerPosition(player));
            player.setTeam(PlayerStatsParser.getPlayerTeam(player));
            modelMap.put("player", player);
            return "player-details";
        } else {
            player = new NbaPlayer(name);
            try {
                player.setAvgAssist(PlayerStatsParser.getPLayerAstPerGame(player));
                player.setAvgBlock(PlayerStatsParser.getPLayerBlkPerGame(player));
                player.setAvgPoint(PlayerStatsParser.getPLayerPtsPerGame(player));
                player.setAvgRebound(PlayerStatsParser.getPLayerRebPerGame(player));
                player.setAvgSteal(PlayerStatsParser.getPLayerStlPerGame(player));
                player.setHeight(PlayerStatsParser.getPlayerHeight(player));
                player.setWeight(PlayerStatsParser.getPlayerWeight(player));
                player.setPosition(PlayerStatsParser.getPlayerPosition(player));
                player.setTeam(PlayerStatsParser.getPlayerTeam(player));
                modelMap.put("player", player);
                return "player-details";
            } catch (Exception e) {
                return "home";
            }
        }
    }
}
