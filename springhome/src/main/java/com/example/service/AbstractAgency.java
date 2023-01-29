package com.example.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractAgency {

    public EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("org.example.entity");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
