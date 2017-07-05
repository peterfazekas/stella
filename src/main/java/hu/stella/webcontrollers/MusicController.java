package hu.stella.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MusicController {

    @GetMapping("/music/in")
    public String getLogin(Principal principal, Model model) {
        model.addAttribute("method", "GET");
        model.addAttribute("user", principal);
        return "music/in";
    }

}
