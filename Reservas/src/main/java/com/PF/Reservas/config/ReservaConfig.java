package com.PF.Reservas.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Configuration
public class ReservaConfig  implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception {

        httpSecurity
                .csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())   // activar una vez se usa frontend : csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())) // Habilitar CSRF con cookies
                .authorizeHttpRequests(c -> c.requestMatchers(HttpMethod.POST,"/reservas/**").permitAll()
                        .requestMatchers("/eureka/**").permitAll()
                .requestMatchers("/usuarios/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/actuator/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/reservas/**").hasAuthority("ROLE_ADMIN")
                        .anyRequest()
                .authenticated())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }



    @Bean
    PasswordEncoder passwordEncoder(){return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();}

    @LoadBalanced
    @Bean
    RestClient.Builder builder(){
        return RestClient.builder();
    }


}
