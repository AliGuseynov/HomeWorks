package az.code.springhomework.homework;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Profile("local")
@Slf4j
public class ProfileServiceLocal implements ProfileService{
    @Value("${version}")
    private String version;


    @Override
    public String getVersion() {
        return version;
    }
    @Scheduled(fixedRate = 3000)
    public void get3SecTime() {
        log.info("3 seconds schedule is up - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(cron = "0 20,45 * * * *")
    @Override
    public void get3045() {
        log.info("it's 20-th or 45-th minute of hour");
    }


    @Async
    @Override
    public void asyncMethod() {
        log.info("Async method started");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("Wake up");
    }
}
