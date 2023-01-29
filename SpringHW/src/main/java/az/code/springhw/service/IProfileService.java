package az.code.springhw.service;

import lombok.extern.slf4j.Slf4j;

public interface IProfileService {
    void getProfileInfo() throws InterruptedException;
    void testAsync();
}
