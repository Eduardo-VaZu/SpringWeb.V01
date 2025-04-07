package pe.example.springWeb.v01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/swagger-ui/**").permitAll()
                .requestMatchers("/v3/api-docs*/**").permitAll()

                .requestMatchers(HttpMethod.POST, "/user").permitAll()
                .requestMatchers("/user/*").authenticated()

                .requestMatchers(HttpMethod.POST, "/product").hasRole("admin")
                .requestMatchers(HttpMethod.PUT, "/product/**").hasRole("admin")
                .requestMatchers( "/product/**").hasAnyRole("admin", "seller")
        );

        return http.build();
    }
}
