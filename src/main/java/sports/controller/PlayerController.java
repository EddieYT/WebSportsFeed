package sports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sports.data.NbaPlayerRepository;
import sports.data.TeamRepository;
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

    @Autowired
    private TeamRepository teamRepository;

    @RequestMapping("/player/{name}")
    public String playerDetails(@PathVariable String name, ModelMap modelMap) {
        name = name.replace("-"," ");
        NbaPlayer player = playerRepository.findByName(name);
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
    }
}
