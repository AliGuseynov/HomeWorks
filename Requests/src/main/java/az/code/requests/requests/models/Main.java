package az.code.requests.requests.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {


        findPersonById();
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Api");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        em.merge(Person.builder().person_name("Miron").person_surname("Yanovich").build());
//        em.getTransaction().commit();
//        em.close();
    }

    private static void findPersonById(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Api");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = (Person) em.createNamedQuery("getPersonByID").setParameter(1, Long.parseLong("2")).getSingleResult();
//        List<Person> person = em.createNamedQuery("getPersonByID").setParameter(1, "1").getResultList();

        em.close();

        System.out.println(person.PrintPersonWeb());
    }
}
