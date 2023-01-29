package com.example.springaoptask.service;

import com.example.springaoptask.inter.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {
    private final ProfileService profileService;

    //    @PostConstruct
    public void test() {
        profileService.MethodOne();
        log.info("basladi");
        profileService.MethodTwo();
        log.info("bitdi");
    }

    @Scheduled(fixedDelay = 3000l)
    public void timeMethod() {
        log.info("3 saniyeden bir");
    }
    @Scheduled(cron = "* 20,45 * * * *")
    public void timeCron() {
        log.info("20 45  deqiqe");
    }

}
