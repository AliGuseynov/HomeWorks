package az.code.servlettest;

import java.io.*;
import java.util.List;

import impl.PersonImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Person;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private  static PersonImpl personImpl=new PersonImpl();
    private String message;

    public void init() {
        message = "Hello World!";
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        String action = request.getParameter("action");
        if (action.equals("update")) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            Person person = personImpl.findById(id);
            person.setName(name);
            person.setSurname(surname);
            personImpl.update(person);
        } else if (action.equals("delete")) {
            personImpl.remove(id);
        }
        response.sendRedirect("users");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String usedIdStr = request.getParameter("id");
            if (usedIdStr == null || usedIdStr.trim().isEmpty()) {
                throw new IllegalArgumentException("id is not specified");
            }
            Integer userId = Integer.parseInt(usedIdStr);
            PersonImpl userDao =new PersonImpl();
            Person u = userDao.findById(userId);
            if (u == null) {
                throw new IllegalArgumentException("There is no user with this id");
            }
            request.setAttribute("owner", true);
            request.setAttribute("user", u);
            request.getRequestDispatcher("persons.jsp").forward(request, response);

    }



    public void destroy() {
    }

}