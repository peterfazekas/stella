package hu.stella.configuration;

import hu.stella.i18n.InternationalizationConfig;
import hu.stella.security.OAuthSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({InternationalizationConfig.class, OAuthSecurityConfig.class})
public class ApplicationConfig {

}
