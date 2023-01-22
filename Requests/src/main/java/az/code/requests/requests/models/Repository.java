package az.code.requests.requests.models;

import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Repository {
    private static final long serialVersionUID = 1L;
    final String URL = "jdbc:postgresql://localhost/RequestsLesson";
    final String USER = "postgres";
    final String PASSWORD = "admin";
    final String DRIVER = "org.postgresql.Driver";
    Connection conn = null;

    @SneakyThrows
    public Person createPerson(String name, String surname){


        this.initDBConnection();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Api");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = Person.builder().person_name(name).person_surname(surname).build();
        em.merge(person);
        em.getTransaction().commit();
        em.close();

        return person;
    }

    private void initDBConnection() throws SQLException {

        if (conn == null) {

            try {

                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println("Unable to load Driver class");


                System.exit(1);
            }

            conn = DriverManager.getConnection(URL, USER, PASSWORD);

/*
        Statement stmt = conn.createStatement();
        String sql = "select * from public.persons;";
        ResultSet rs = ((Statement) stmt).executeQuery(sql);
        List<Person> personList = new ArrayList<>();

        while (rs.next()) {

            System.out.println(rs);


        }
*/
        }

    }

    public Person getPerson(String id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Api");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Person> personList = em.createNamedQuery("getPersonByID").setParameter(1, Long.parseLong(id)).getResultList();

        Person person = null;

        if (personList.size()>0){
            person = personList.get(0);
        }

        em.close();

        return person;
    }

}
