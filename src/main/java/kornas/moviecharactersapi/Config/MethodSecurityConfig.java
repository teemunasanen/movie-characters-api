package kornas.moviecharactersapi.Config;
/*
 * Built based on -Hibernate with CI- repo by Greg Linklater
 * https://gitlab.com/noroff-accelerate/java/projects/hibernate-with-ci/-/tree/master
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
}
