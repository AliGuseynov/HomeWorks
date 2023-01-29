package az.code.demospring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Profile("local")
public class LocalService implements IDemoService {
    @Override
    public void test() {
        log.info("local service");
    }

    @Override
    @Async
    public void forAsync() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("After async");
    }

}
