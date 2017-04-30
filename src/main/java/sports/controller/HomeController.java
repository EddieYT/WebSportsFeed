package sports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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
    public String showPlayers() { return  "player";}

}
