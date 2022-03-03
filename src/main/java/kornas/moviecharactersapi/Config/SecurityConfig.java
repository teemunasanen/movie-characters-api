package kornas.moviecharactersapi.Config;

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

                    // Convert Jwt to GrantedAuthorities
                    JwtGrantedAuthoritiesConverter scopeConverter = new JwtGrantedAuthoritiesConverter();

                    scopeConverter.setAuthoritiesClaimName("groups");
                    scopeConverter.setAuthorityPrefix("GROUP_");

                    authnConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
                        // This will read the 'scope' claim inside the payload
                        Collection<GrantedAuthority> scopes = scopeConverter.convert(jwt);

                        // Merge the above sets
                        HashSet<GrantedAuthority> union = new HashSet<>();
                        union.addAll(scopes);

                        for (var a : union) {
                            logger.warn("JWT Authority: {}", a.getAuthority());
                        }

                        return union;
                    });

                    oauth2.jwt().jwtAuthenticationConverter(authnConverter);
                });
    }


}
