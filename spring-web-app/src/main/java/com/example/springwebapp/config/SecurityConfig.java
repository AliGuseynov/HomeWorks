package com.example.springwebapp.config;

import com.example.springwebapp.entity.Role;
import com.example.springwebapp.repo.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                return null;
//            }
//        };
//    }
    @Bean
    @Profile("local")
    public UserDetailsService userDetailsService(UserRepo userRepo) {
        return username -> userRepo.findByUsernameAndActiveIsTrue(username).map(user -> User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().stream().map(Role::toString).toArray(String[]::new))
                .build()).orElseThrow(() -> new UsernameNotFoundException("Not found"));
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(UserDetailsService users) {// MENDE ISLEMIR(user1)
        return web -> web.ignoring().requestMatchers("api/v1/students/free");
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests
//                (auth -> {
//                    try {
//                        auth
//                                .requestMatchers("/api/v1/students/free").permitAll();
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//        return http.build();
//    }
}
