package com.suprememedia.funda.config;


import com.suprememedia.funda.config.filter.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration //TODO meaning :
@EnableWebSecurity //TODO meaning :
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private JwtAuthFilter authFilter;


    @Bean
    // authentication is handledBy the UserDetailsService
    public UserDetailsService userDetailsService(){

//        UserDetails  admin = User.withUsername("admin")
//                .password(passwordEncoder.encode("123"))
//                .roles("ADMIN")
//                .build();
//        UserDetails  user = User.withUsername("user")
//                .password(passwordEncoder.encode("123"))
//                .roles("USER")
//                .build();

        // we are not loading them from db , we have to store them in memory

        return  new UserInforDetailsService();
    }

    @Bean
    // This deals  with authorisation which endpoints to free or not.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/v1/auth/signup", "/api/v1/auth/signin").permitAll() // allow permit no authorisation needed for this path
                                .requestMatchers("/api/v1/**")
                                .authenticated()
                )
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
//         http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth ->
//                        auth.requestMatchers("/api/v1/auth/signup", "/api/v1/auth/signin").permitAll() // allow permit no authorisation needed for this path
//                                .requestMatchers("/api/v1/**")
//                                .authenticated()
//                )
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authenticationProvider(authenticationProvider())
//                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//
//         return  http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return  authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
