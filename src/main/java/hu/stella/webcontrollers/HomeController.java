package hu.stella.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
 @RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        String welcomeMessage = "Helló Stella";
        model.addAttribute("welcome", welcomeMessage);
        return "home";
    }
}
