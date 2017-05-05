package sports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sports.data.NbaPlayerRepository;
import sports.model.NbaPlayer;
import sports.model.PlayerStatsParser;

/**
 * The PlayerController can gather information for a specified player page request.
 * Created by Eddie on 4/26/17.
 */
@Controller
public class PlayerController {
    @Autowired
    private NbaPlayerRepository playerRepository;

    @RequestMapping("/player/{name}")
    public String playerDetails(@PathVariable String name, ModelMap modelMap) {
        NbaPlayer player = playerRepository.findByName(name);
        PlayerStatsParser.setAllPlayerInfo(player);
        modelMap.put("player", player);
        modelMap.put("parser", PlayerStatsParser.getTimeStamp());
        return "player-details";
    }
}
