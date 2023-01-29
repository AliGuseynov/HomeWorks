package az.code.springhw.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Profile("!prod")
@EnableAsync
public class ProfileServiceImpl implements IProfileService {
    @Override
    @Async
    public void getProfileInfo() throws InterruptedException {
        Thread.sleep(2000);
        log.info("Not Prod Test Service");
    }

    @Override
    @Async
    public void testAsync() {
        log.info("Async Test!");
    }
}
