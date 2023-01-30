package az.code.springhomework.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Profile("prod")
public class ProdProfileServiceImpl implements ProfileService{
    @Override
    public void test() {
        log.info("Prod profile is used");
    }

    @Override
    public void async() {

    }
}
