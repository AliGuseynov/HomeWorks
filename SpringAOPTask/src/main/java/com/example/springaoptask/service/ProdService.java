package com.example.springaoptask.service;

import com.example.springaoptask.inter.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Profile("prod")
public class ProdService implements ProfileService {
    @Override
    public void MethodOne() {
        log.info("prod service are called");
    }

    @Override
    @Async
    public void MethodTwo() {
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("run wait");
    }
    }

