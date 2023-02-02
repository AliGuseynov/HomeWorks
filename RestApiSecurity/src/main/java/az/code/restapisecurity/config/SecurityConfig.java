package az.code.restapisecurity.config;

import az.code.restapisecurity.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@Slf4j
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/api/v1/register", "/api/v1/setRole");
    }


//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//
//        UserDetails user1 = User.withUsername("AdminUser")
//                .password(getBCryptPasswordEncoder().encode("admin123"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user2 = User.withUsername("user1")
//                .password(getBCryptPasswordEncoder().encode("user2Pass"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("user2")
//                .password(getBCryptPasswordEncoder().encode("adminPass"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2, admin);
//    }

    @Bean
    public UserDetailsService userDetailsService(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {

                return username -> {
                    return userRepo.findByUsername(username).map(user -> User.builder()
                            .username(user.getUsername())
                            .password(user.getPassword())
                            .roles("ADMIN")
//                            .roles(user.getRoles().stream()
//                                    .map(object -> object.getRoleName())
//                                    .toList().toArray().toString())
                            .build()).orElseThrow(() -> new UsernameNotFoundException("Not found"));
                };
            }

    }



