package az.code.springhw.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainService implements CommandLineRunner {
    @Value("${profile_name}")
    private String profileName;

    private final IProfileService profileService;

    @Override
//    @Scheduled(fixedRate = 3000)
//    @Scheduled(cron = "20,45 * * * ?")
//    @Scheduled(cron = "13 3 30 1 ?")
    public void run(String... args) throws Exception {
        log.info("Profile : " + profileName);
        profileService.getProfileInfo();
        profileService.testAsync();
    }
}
