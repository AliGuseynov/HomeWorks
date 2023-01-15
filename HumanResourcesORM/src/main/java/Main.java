import az.code.entities.Countries;
import az.code.entities.Locations;
import az.code.entities.Regions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("code");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("Start");
        entityManager.getTransaction().begin();

//Region-Countries

//        Regions region2 = new Regions();
//        region2.setRegionName("a1");
//        Regions region3 = new Regions();
//        region3.setRegionName("a2");
//
//        Regions region4 = new Regions();
//        region4.setRegionName("b1");
//
//        Regions region5 = new Regions();
//        region5.setRegionName("b2");
//
//        entityManager.persist(region2);
//        entityManager.persist(region3);
//        entityManager.persist(region4);
//        entityManager.persist(region5);
//
//
//        List<Regions> regionsList1 = new ArrayList<>();
//        List<Regions> regionsList2 = new ArrayList<>();
//        regionsList1.add(region2);
//        regionsList1.add(region3);
//
//        regionsList2.add(region4);
//        regionsList2.add(region5);
//
//
//        Countries countries1 = new Countries("AZ", "Azerbaycan", regionsList1);
//        Countries countries2 = new Countries("TR", "Turkiye", regionsList2);

//        entityManager.persist(countries1);
//        entityManager.persist(countries2);

//        regions.setRegionName("Baku");
//        regions.setRegionName("Paris");
        //??
//        Regions regions1 = entityManager.find(Regions.class, regions.getRegionId());


        //Location-Countries
        Countries countries = new Countries();
        countries.setCountryName("LC1");


        Locations locations1 = new Locations();
        locations1.setCity("City1");
        locations1.setPostalCode("postal1");
        locations1.setStreetAddress("addrees1");
        locations1.setStateProvince("province1");
        locations1.setCountriesList(countries);

        Locations locations2 = new Locations();
        locations2.setCity("City2");
        locations2.setPostalCode("postal2");
        locations2.setStreetAddress("addrees2");
        locations2.setStateProvince("province2");
        locations2.setCountriesList(countries);

        entityManager.persist(locations1);
        entityManager.persist(locations2);

//        List<Locations> locationsList1 = new ArrayList<>();
//        locationsList1.add(locations1);
//
//        List<Locations> locationsList2 = new ArrayList<>();
//        locationsList2.add(locations1);
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
