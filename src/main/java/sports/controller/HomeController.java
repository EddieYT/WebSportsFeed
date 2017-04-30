package sports.controller;

import org.springframework.stereotype.Controller;
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
    public String showPlayers() throws IOException {
        LeagueStats stats = new LeagueStats();
        ArrayList<Player> topImpactPlayers = stats.getTopImpactPlayers(30);

        for(Player player : topImpactPlayers){
            System.out.println(player.getName());
        }

        return  "player";

    }

}
