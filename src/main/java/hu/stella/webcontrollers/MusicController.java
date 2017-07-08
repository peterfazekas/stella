package hu.stella.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MusicController {

    @GetMapping("/music/callback")
    public String googleLogin(Principal principal, Model model) {
        model.addAttribute("user", principal.getName());
        model.addAttribute("principal", principal);
        return "music/in";
    }
}
