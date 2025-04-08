package pe.example.springWeb.v01.config;

import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import pe.example.springWeb.v01.filter.JwtGeneratorFilter;
import pe.example.springWeb.v01.filter.JwtValidationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable);
        http.addFilterBefore((Filter) new JwtValidationFilter(), BasicAuthenticationFilter.class);
        http.addFilterAfter(new JwtGeneratorFilter(), BasicAuthenticationFilter.class);

        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/swagger-ui/**").permitAll()
                .requestMatchers("/v3/api-docs*/**").permitAll()

                .requestMatchers(HttpMethod.POST, "/user").permitAll()
                .requestMatchers("/user/**").authenticated()

                .requestMatchers(HttpMethod.POST, "/product").hasRole("admin")
                .requestMatchers(HttpMethod.PUT, "/product/**").hasRole("admin")
                .requestMatchers( "/product/**").hasAnyRole("admin", "seller")
                .requestMatchers("/product/**").authenticated()
        );

        http.formLogin(AbstractHttpConfigurer::disable);
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
