package az.code.springhomework.service;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainService {

    @Value("${project.name}")
    private String projectName;

    private final ProfileService Service;

//    @Scheduled(fixedDelay = 3)
    @Scheduled(cron = "* */20,*/45 1 * * *")
    @PostConstruct
    public void init(){
        log.info("project_name= "+projectName);
        Service.test();
        Service.async();
    }
}
