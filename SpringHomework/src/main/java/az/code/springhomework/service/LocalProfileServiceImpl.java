package az.code.springhomework.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@Profile("local")
public class LocalProfileServiceImpl implements ProfileService {
    @Override
    public void test() {
        log.info("Local service is used");
    }

    @Override
    public void async() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("asynchrone");
    }
}
