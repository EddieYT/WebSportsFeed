package sports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sports.model.FullGameSchedule;
import sports.model.Game;

import java.io.IOException;
import java.util.List;

/**
 * Created by obinnaasinugo on 4/29/17.
 */
@Controller
public class ScheduleController {

    @RequestMapping("/schedule/{team}")
    public String displayTeamSchedule(@PathVariable String team, ModelMap modelMap) throws IOException {
        FullGameSchedule schedule = new FullGameSchedule(team);
        List<Game> games = schedule.getAllGames();
        modelMap.put("games", games);
        modelMap.put("team", team);

        return "team_schedule";
    }

}
