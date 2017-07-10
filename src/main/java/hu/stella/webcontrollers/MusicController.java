package hu.stella.webcontrollers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MusicController {

    private static final String URL = "https://www.googleapis.com/gmail/v1/users/%s/profile?fields=emailAddress&key=AIzaSyDVVDtmSxrLNrbKJ5uJYi7FVHBbcL7wfP0";

    @RequestMapping("/music/callback")
    public String goglePostLogin(@CookieValue(value = "JSESSIONID", required = false) String jsessionid, OAuth2Authentication authentication, Model model) {
        Map<String, String> details = (LinkedHashMap) authentication.getUserAuthentication().getDetails();
        OAuth2AuthenticationDetails token = (OAuth2AuthenticationDetails) authentication.getDetails();
        model.addAttribute("name", details.get("name"));
        model.addAttribute("family_name", details.get("family_name"));
        model.addAttribute("given_name", details.get("given_name"));
        model.addAttribute("link", details.get("link"));
        model.addAttribute("picture", details.get("picture"));
        model.addAttribute("principal", authentication);
        model.addAttribute("tokenType", token.getTokenType());
        model.addAttribute("tokenValue", token.getTokenValue());
        model.addAttribute("jsessionid", jsessionid);
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
