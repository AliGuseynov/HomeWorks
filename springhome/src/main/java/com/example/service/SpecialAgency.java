package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
@Slf4j
public class SpecialAgency implements AgencyInterface{
    @Override
    public void addAgency(int id, String agencyName) throws InterruptedException {
        //Day eyni prosesleri yazmagla bosh yer tutmuram
        System.out.println("Added");
    }

    @Override
    @Async
    public boolean readLogo(String logoFile) throws InterruptedException {
        log.info("Logo loaded");
        Thread.sleep(1500);
        return true;
    }
}
