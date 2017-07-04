package hu.stella.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({InternationalizationConfig.class, OAuthSecurityConfig.class})
public class ApplicationConfig {

}
