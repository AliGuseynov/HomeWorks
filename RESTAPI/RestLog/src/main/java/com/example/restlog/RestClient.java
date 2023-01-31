package com.example.restlog;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("api/v1/employees")
public class RestClient {
    @GetMapping
    public void getProductList() {
        String uri = "http://localhost:8080/api/v1/employees/";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        log.info(result);
    }
    public void createEmployee() {
        RestTemplate restTemplate = new RestTemplate();

        String resourceUrl
                = "http://localhost:8080/api/v1/employees/save";


        HttpEntity<Employee> request = new HttpEntity<Employee>(
                new Employee(7, "Sadiq", "Ekberov", null));

        String productCreateResponse = restTemplate
                .postForObject(resourceUrl, request, String.class);

        System.out.println(productCreateResponse);
    }
    public void updateProductWithExchange() {
        RestTemplate restTemplate = new RestTemplate();

        String resourceUrl
                = "http://localhost:8080/employees";

        // Create the request body by wrapping
        // the object in HttpEntity
        HttpEntity<Employee> request = new HttpEntity<Employee>(
                new Employee(7, "Sadiq", "Ekberov", null));

        // Send the PUT method as a method parameter
        restTemplate.exchange(
                resourceUrl,
                HttpMethod.PUT,
                request,
                Void.class);


    }
    @PostConstruct
    public void init(){
//        getProductList();
        createEmployee();
    }
}