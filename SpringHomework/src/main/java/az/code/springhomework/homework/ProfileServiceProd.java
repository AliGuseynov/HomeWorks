package az.code.springhomework.homework;

import az.code.springhomework.MainService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
@Profile("prod")
@Slf4j
public class ProfileServiceProd implements ProfileService{

    DateTimeFormatter dtf;

    @Value("${version}")
    private String version;

    @Override
    public String getVersion() {
        return version;
    }

    @Scheduled(fixedRate = 3000)
    public void get3SecTime() {
        LocalDateTime now = LocalDateTime.now();
        log.info("3 seconds schedule is up - " + dtf.format(now));
    }



    @Scheduled(cron = "0 4,20,45 * * * *")
    @Override
    public void get3045() {
    log.info("it's 30-th or 45-th minute of hour");
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


    @PostConstruct
    private void getTimeStamp(){
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    }

}
