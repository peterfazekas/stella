package hu.stella.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

@Controller
public class MusicController {

    private static final String URL = "https://www.googleapis.com/gmail/v1/users/%s/profile?fields=emailAddress&key=AIzaSyDVVDtmSxrLNrbKJ5uJYi7FVHBbcL7wfP0";

    @RequestMapping("/music/callback")
    public String goglePostLogin(@CookieValue(value = "JSESSIONID", required = false) String token, Principal principal, Model model) {
        model.addAttribute("user", principal.getName());
        model.addAttribute("principal", principal);
        model.addAttribute("data", token);
        //model.addAttribute("data", getUserName(principal.getName()));
        return "music/in";
    }

    private String getUserName(final String userId) {
        RestTemplate rest = new RestTemplate();
        return rest.getForEntity(getUrl(userId), String.class).toString();
    }

    private String getUrl(final String userId) {
        return String.format(URL, userId);
    }
}
