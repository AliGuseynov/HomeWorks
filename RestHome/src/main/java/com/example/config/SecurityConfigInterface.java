package com.example.config;


import com.example.repo.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public interface SecurityConfigInterface {


    BCryptPasswordEncoder bCryptPasswordEncoder();

    UserDetailsService userDetailsService(UserRepository userRepository);


}
