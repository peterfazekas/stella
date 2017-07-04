package hu.stella.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class MusicController {

    @GetMapping("music/in")
    public String getLogin(Principal principal) {
        principal.getName();
        return "music";
    }

    @PostMapping("music/in")
    public String postLogin(Principal principal) {
        principal.getName();
        return "music";
    }

}
