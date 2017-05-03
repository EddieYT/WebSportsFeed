package sports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import sports.model.LeagueStats;
import sports.model.Player;

import java.io.IOException;
import java.util.ArrayList;


/**
 * The Controller executes functions corresponding to a specified request.
 * Created by Eddie on 4/16/17.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String greeting() {
        return "home";
    }

    @RequestMapping("/home")
    public String displayHomePage() {
        return "home";
    }

    @RequestMapping("/player")
    public String showImplactPlayers(ModelMap modelMap) throws IOException {
        LeagueStats stats = new LeagueStats();
        ArrayList<Player> topImpactPlayers = stats.getTopImpactPlayers(30);

        for(Player player : topImpactPlayers){
            System.out.println("name: " + player.getName());
            System.out.println("img name: " + player.getImageName());
            System.out.println("url name: " + player.getUrlName());
            System.out.println("points: " + player.getAvgPoint());
            System.out.println("assists: " + player.getAvgAssist());
            System.out.println("rebounds: " + player.getAvgRebound());
            System.out.println("steals: " + player.getAvgSteal());
            System.out.println("blocks: " + player.getAvgBlock());
            System.out.println("impact: " + player.getImpact());
            System.out.println();
        }

        int temp[] = new int[6];

        for(int i = 0; i < temp.length; i++){
            temp[i] = i;
        }

        Player[][] topPlayers = new Player[6][5];
        int counter = 0;

        for(int row = 0; row < 6; row++){
            for(int col = 0; col < 5; col++) {
                topPlayers[row][col] = topImpactPlayers.get(counter);
                counter++;
            }
        }

        modelMap.put("impactPlayers", topPlayers);
        modelMap.put("iterations", temp);
        return  "player2";
    }
}