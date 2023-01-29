package com.example.service;

import com.example.entity.Agency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;


@Service
@Slf4j
@Profile("test")
public class SecondClassAgency extends AbstractAgency implements AgencyInterface{
    @Override
    public void addAgency(int id, String agencyName) throws InterruptedException {

        EntityManager entityManager = getEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(new Agency(id,agencyName,"Second Class"));

        entityManager.getTransaction().commit();
        entityManager.close();
        Thread.sleep(2000);
    }

    @Override
    @Async
    public boolean readLogo(String logoFile) throws InterruptedException {
        log.info("Logo loaded");
        Thread.sleep(1500);
        return true;
    }
}
