package com.example.config;

import com.example.entity.Roles;
import com.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;
import java.util.stream.Collectors;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
@Profile("prod")
public class SecurityConfig implements SecurityConfigInterface{


   @Bean
   public BCryptPasswordEncoder bCryptPasswordEncoder(){
       return new BCryptPasswordEncoder();
   }


   @Bean
   public UserDetailsService userDetailsService(UserRepository userRepository){
      return username -> userRepository.findByUsernameAndActiveIsTrue(username)
              .map(user ->
                  User.builder()
                          .username(user.getUsername())
                          .password(user.getPassword())
                          .roles(user.getRoles().
                                  stream().map(Roles::toString).toList().toArray(String[]::new))
                          .build()).orElseThrow( ()-> new UsernameNotFoundException("User not found"));

   }


}
