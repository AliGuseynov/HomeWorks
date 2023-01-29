package com.example.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ServiceApp {

    private final AgencyInterface firstClass;

    private final AgencyInterface secondClass;

    public ServiceApp(@Qualifier("firstClassAgency")AgencyInterface firstClass,
                      @Qualifier("secondClassAgency") AgencyInterface secondClass) {
        this.firstClass = firstClass;
        this.secondClass = secondClass;
    }
//    @PostConstruct
    @Scheduled(fixedDelay = 5000)
    public void init() throws InterruptedException {
        firstClass.addAgency(1,"YE");
        secondClass.addAgency(2,"test");
    }
}
