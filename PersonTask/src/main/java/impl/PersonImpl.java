package impl;

import inter.AbstractDao;
import inter.PersonInter;
import models.Person;

import javax.persistence.EntityManager;

public class PersonImpl extends AbstractDao implements PersonInter {
    @Override
    public void add(Person person) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Person person) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Person findById(int id) {
        EntityManager em = em();
        Person person = em.find(Person.class, id);
        em.close();
        return person;
    }

    @Override
    public void remove(int id) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.remove(id);
        em.getTransaction().commit();
        em.close();
    }
}
