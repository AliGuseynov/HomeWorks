package com.example.aspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;


@Component
@Aspect
@Slf4j
public class AspectLog {

    @Before("execution(public void com.example.service.FirstClassAgency.addAgency(..)))")
    public void beforeFirstClassAgency(){
        log.info("First Class Agency adding... ");
    }

    @Before("execution(public void com.example.service.SecondClassAgency.addAgency(..)))")
    public void beforeSecondClassAgency(){
        log.info("Second Class Agency adding... ");
    }

    @After("execution(public void com.example.service.FirstClassAgency.addAgency(..)))")
    public void afterFirstClassAgency(){
        log.info("Firs Class Agency Added succesfully");
    }

    @After("execution(public void com.example.service.SecondClassAgency.addAgency(..)))")
    public void afterSecondClassAgency(){
        log.info("Second Class Agency Added succesfully");
    }
}
