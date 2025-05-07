package ru.nikolai.daohibernetehw.security;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
                        .requestMatchers("/persons/by-city").permitAll()
                        .requestMatchers("/persons/by-age").hasRole("ADMIN")
                        .requestMatchers("/persons/by-age").hasRole("by-age")
                        .requestMatchers("/persons/by-name-surname").hasRole("ADMIN")
                        .requestMatchers("/persons/by-name-surname").hasRole("by-name")
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(encoder().encode("admin"))
                .roles("ADMIN").build());
        manager.createUser(User.withUsername("user1")
                .password(encoder().encode("password1"))
                .roles("by-age").build());
        manager.createUser(User.withUsername("user2")
                .password(encoder().encode("password2"))
                .roles("by-name").build());
        return manager;
    }


}
