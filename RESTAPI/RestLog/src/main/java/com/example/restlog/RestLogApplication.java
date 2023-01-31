package com.example.restlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestLogApplication.class, args);
    }
    @Autowired(required = false)
    RestClient restClient;
    @Bean
    public CommandLineRunner runner() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                restClient.getProductList();


            }
        };
        return clr;
    }

}
