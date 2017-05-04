package sports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import sports.model.Record;
import sports.model.NbaStandings;
import java.io.IOException;
import java.util.List;

/**
 * Created by obinnaasinugo on 4/29/17.
 */
@Controller
public class StandingsController {

    @RequestMapping("/standings")
    public String displayStandings(ModelMap modelMap) throws IOException {
        NbaStandings standings = new NbaStandings();
        List<Record> records = standings.getLeagueStandings();
        modelMap.put("records", records);

        return "standings";
    }

}
