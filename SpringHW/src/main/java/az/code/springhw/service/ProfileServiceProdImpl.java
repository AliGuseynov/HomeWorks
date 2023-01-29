package az.code.springhw.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Profile("prod")
public class ProfileServiceProdImpl implements IProfileService{
    @Override
    public void getProfileInfo() {
        log.info("Prod Test Service");
    }

    @Override
    public void testAsync() {

    }
}
