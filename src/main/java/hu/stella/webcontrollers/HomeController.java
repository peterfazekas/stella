package hu.stella.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
 @RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(Principal principal, Model model) {
        String welcomeMessage = "Helló Stella";
        model.addAttribute("welcome", welcomeMessage);
        return (principal != null) ? "redirect:/music/callback" : "home";
    }
}
