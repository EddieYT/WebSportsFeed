package sports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sports.data.PlayerRepository;
import sports.model.Player;

/**
 * The PlayerController can gather information for a specified player page request.
 * Created by Eddie on 4/26/17.
 */
@Controller
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @RequestMapping("/player/{name}")
    public String playerDetails(@PathVariable String name, ModelMap modelMap) {
        Player player = playerRepository.findByName(name);
        // TODO something to update the player's statistics
        modelMap.put("player", player);
        return "player-details";
    }
}
