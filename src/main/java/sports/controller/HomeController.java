package sports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The Controller executes function corresponding to certain request.
 * Created by Eddie on 4/16/17.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String greeting() {
        return "Home";
    }
}
