package az.code.demospring.services;


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
public class MainService {


    private final IDemoService iDemoService;

    @Value("${project.global.name}")
    private String globalName;

    @Value("${project.name}")
    private String projectName;

//    @PostConstruct
//    public void init() {
//        log.info(projectName);
//        iDemoService.test();
//        log.info("START");
//        iDemoService.forAsync();
//
//        log.info("STOP");
////        log.info(globalName);
//    }


    //    @Scheduled(fixedDelay = 1000L)
    @Scheduled(cron = "0 20,45 * * * *")
    public void init() {
        log.info(projectName);
        iDemoService.test();

    }
}
