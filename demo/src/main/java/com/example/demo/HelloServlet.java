package com.example.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "users", value = {"/users", "/users/*"})
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    List<User> users = List.of(new User(1, "leyla"),
            new User(2, "dhkjg"));

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (String.valueOf(request.getRequestURI()).split("/")[2].equals("users")) {
            if(String.valueOf(request.getRequestURI()).split("/").length==4){
                for (int i = 0; i < users.size(); i++) {
                    if(Integer.toString(users.get(i).getId()).equals(String.valueOf(request.getRequestURI()).split("/")[3])){
                        out.println("<a href=" + "/" + users.get(i).getId() + ">" + users.get(i).getName() + "</a>");
                        response.setStatus(200);

                    }
                    else{
                        response.setStatus(404);
                    }
                }
            }
            else {
                for (int i = 0; i < users.size(); i++) {
                    out.println("<a href=" + "users/" + users.get(i).getId() + ">" + users.get(i).getName() + "</a>");
                }
            }
        }

        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        out.println(request.getReader().lines().collect(Collectors.joining()));
//        out.println("<html><body>");

    }

    public void destroy() {
    }
}