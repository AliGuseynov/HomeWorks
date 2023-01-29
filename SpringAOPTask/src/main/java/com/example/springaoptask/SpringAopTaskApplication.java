package com.example.springaoptask;

import com.example.springaoptask.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
//@EnableScheduling
public class SpringAopTaskApplication {
    @Autowired
    MainService mainService;

    public static void main(String[] args) {
        SpringApplication.run(SpringAopTaskApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                mainService.test();


            }
        };
        return clr;
    }

}
