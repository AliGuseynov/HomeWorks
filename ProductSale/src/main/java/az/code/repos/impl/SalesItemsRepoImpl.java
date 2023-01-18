package az.code.repos.impl;

import az.code.models.Product;
import az.code.models.SalesItems;
import az.code.repos.SalesItemsRepo;

import javax.persistence.EntityManager;

public class SalesItemsRepoImpl implements SalesItemsRepo{
    @Override
    public void add(Long id ,double count) {
//        SalesItems salesItem = findById(id);
//        EntityManager em = em();
//        em.getTransaction().begin();
//        if (salesItem != null) {
//
//        } else {
//            em.merge(product);
//        }
//        em.getTransaction().commit();
//        em.close();
    }

    @Override
    public SalesItems findById(Long id) {
//        EntityManager em = em();
//        SalesItems salesItems = em.find(SalesItems.class, id);
//        em.close();
        return null;
    }
}
