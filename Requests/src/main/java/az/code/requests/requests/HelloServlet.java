package az.code.requests.requests;

import java.io.*;
import java.sql.*;
import java.util.List;

import az.code.requests.requests.models.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;
    final String URL = "jdbc:postgresql://localhost/RequestsLesson";
    final String USER = "postgres";
    final String PASSWORD = "admin";
    final String DRIVER = "org.postgresql.Driver";
    Connection conn = null;

    public void init() {
    }

    // Task 1,2
    @SneakyThrows
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        String [] uri = request.getRequestURI().split("/");

        boolean allusers = false;

        if (uri.length > 3){
            allusers = !uri[3].matches("\\d+");
        } else {
            allusers = true;
        }

        try {
            initDBConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (allusers){
        for (Person per: getPersons()){
            out.println(per.PrintPersonWeb());
        } }
        else {

            Person p = getPerson(uri[3]);
            if (p == null) {
                out.println("ERROR - 404;    User not found");
            } else {
                out.println(p.PrintPersonWeb());
            }

        }
//        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    // Task 3
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//        super.doPost(req, resp);
        response.setContentType("text/html");

        System.out.println(createPerson(request.getParameter("name"), request.getParameter("surname")));

    }

    // Task 4
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean newUser = false;
        PrintWriter out = response.getWriter();

        String [] uri = request.getRequestURI().split("/");

        if (uri.length > 3){
            if (!uri[3].matches("\\d+")){ newUser = true; }
        } else { newUser = true;}


        if (!newUser){
            Person person = getPerson(uri[3]);
            person.setPerson_name(request.getParameter("name"));
            person.setPerson_surname(request.getParameter("surname"));
            updatePerson(person);
            if (person == null) {
                out.println("ERROR - 404;    User not found");
            } else {
                out.println(person);
            }        }
    }


    public void destroy() {
    }


    public List<Person> getPersons(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Api");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Person> products = em.createNamedQuery("all_persons").getResultList();

        em.close();
        return products;
    }

    private Person getPerson(String id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Api");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Person> personList = em.createNamedQuery("getPersonByID").setParameter(1, Long.parseLong(id)).getResultList();

        Person person = null;



        if (personList.size()>0){
            person = personList.get(0);
        }

//        List<Person> person = em.createNamedQuery("getPersonByID").setParameter(1, "1").getResultList();

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

        }

    }

    @SneakyThrows
    private Person createPerson(String name, String surname){


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

    @SneakyThrows
    private Person updatePerson(Person person){


        this.initDBConnection();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.Api");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(person);
        em.getTransaction().commit();
        em.close();

        return person;
    }
}