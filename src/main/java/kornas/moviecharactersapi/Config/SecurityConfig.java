package kornas.moviecharactersapi.Config;
/*
* Built based on -Hibernate with CI- repo by Greg Linklater
* https://gitlab.com/noroff-accelerate/java/projects/hibernate-with-ci/-/tree/master
*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;
import java.util.HashSet;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests(authorize -> {
                    authorize
                            .antMatchers("/movie-docs", "/movie-docs/*", "/movie-docs/**").permitAll()
                            .antMatchers("/swagger-ui", "/swagger-ui/*", "/swagger-ui/**").permitAll()
                            .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                            .anyRequest().authenticated();
                })
                .oauth2ResourceServer(oauth2 -> {
                    // Convert Jwt to AbstractAuthenticationToken(authorities)
                    JwtAuthenticationConverter authnConverter = new JwtAuthenticationConverter();

                    // Convert Jwt scopes claim to GrantedAuthorities
                    JwtGrantedAuthoritiesConverter scopeConverter = new JwtGrantedAuthoritiesConverter();

                    // Convert Jwt groups claim to GrantedAuthorities
                    JwtGrantedAuthoritiesConverter groupConverter = new JwtGrantedAuthoritiesConverter();
                    groupConverter.setAuthorityPrefix("GROUP_");
                    groupConverter.setAuthoritiesClaimName("groups");

                    // Jwt -> GrantedAuthorities -> AbstractAuthenticationToken
                    authnConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
                        // This will read the 'scope' claim inside the payload
                        Collection<GrantedAuthority> scopes = scopeConverter.convert(jwt);

                        // This will read the 'groups' claim you configured above
                        // jwt["groups"] -> new GrantedAuthority("GROUP_groupName")
                        Collection<GrantedAuthority> groups = groupConverter.convert(jwt);

                        // Merge the above sets
                        HashSet<GrantedAuthority> union = new HashSet<>();
                        union.addAll(scopes);
                        union.addAll(groups);

                        for (var a : union) {
                            logger.warn("JWT Authority: {}", a.getAuthority());
                        }
                        return union;
                    });

                    oauth2.jwt().jwtAuthenticationConverter(authnConverter);
                });
    }


}
