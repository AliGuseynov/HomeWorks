package az.code.springhomework;

import az.code.springhomework.homework.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@Slf4j
@EnableAsync
@EnableScheduling
public class MainService implements CommandLineRunner {

    @Autowired
    ApplicationContext applicationContext;
    ProfileService profileService;
    @Override
    public void run(String... args) throws Exception {

        profileService = applicationContext.getBean(ProfileService.class);

        profileService.asyncMethod();

        this.test();

        profileService.get3SecTime();

        profileService.get3045();



    }

    private void test(){
        log.info(profileService.getVersion());
    }



}
