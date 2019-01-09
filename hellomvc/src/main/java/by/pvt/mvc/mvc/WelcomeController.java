package by.pvt.mvc.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/welcome")
public class WelcomeController {

    @RequestMapping(value = "/welcome", method= RequestMethod.GET)
    public String getWelcome(Model model){
        model.addAttribute("greeting", "Hello spring mvc");
        return "welcome";
    }
}
