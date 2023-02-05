package com.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectEmployee {

    @Around("execution(public void com.example.controller.EmployeeController.get*())")
    public void beforeGetMethod() {
        log.info("Get method for Employee starting....");
    }

    @After("execution(public void com.example.controller.EmployeeController.get*())")
    public void aftereGetMethod() {
        log.info("Get method for Employee started");
    }

    @Before("execution(public void com.example.controller.EmployeeController.delete*())")
    public void beforeDeleteMethod() {
        log.info("Delete method for Employee starting....");
    }

    @After("execution(public void com.example.controller.EmployeeController.delete*())")
    public void aftereDeleteMethod() {
        log.info("Delete method for Employee starting....");
    }

    @Before("execution(public void com.example.controller.EmployeeController.add*())")
    public void beforePostMethod() {
        log.info("Post method for Employee starting....");
    }

    @After("execution(public void com.example.controller.EmployeeController.add*())")
    public void afterePostMethod() {
        log.info("Post method for Employee starting....");
    }

    @Before("execution(public void com.example.controller.EmployeeController.update*())")
    public void beforePutMethod() {
        log.info("Put method for Employee starting....");
    }

    @After("execution(public void com.example.controller.EmployeeController.update*())")
    public void afterePutMethod() {
        log.info("Put method for Employee starting....");
    }


}
