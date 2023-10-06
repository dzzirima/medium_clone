package com.suprememedia.funda.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //TODO meaning :
@EnableWebSecurity //TODO meaning :
public class SecurityConfig {


    @Bean
    // authentication is handledBy the UserDetailsService
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails  admin = User.withUsername("admin")
                .password(passwordEncoder().encode("pwd"))
                .roles("ADMIN")
                .build();
        UserDetails  user = User.withUsername("user")
                .password(passwordEncoder.encode("pwd"))
                .roles("USER")
                .build();

        // we are not loading them from db , we have to store them in memory

        return  new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    // This deals  with authorisation which endpoints to free or not.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/v1/auth/signup", "/product-service/addNewUser").permitAll() // allow permit no authorisation needed for this path
                                .requestMatchers("/api/v1/admin/**")
                                .authenticated()
                )
                .httpBasic(Customizer.withDefaults()).build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}
