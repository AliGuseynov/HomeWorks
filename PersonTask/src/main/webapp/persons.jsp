<%@ page import="models.Person" %><%--
  Created by IntelliJ IDEA.
  User: nihad
  Date: 23.01.2023
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    Person person=(Person) request.getAttribute("person");
    if(person==null){
        System.out.println("null");
    }
%>
<div>
    <form action="persons" method="POST">
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="id" value="<%=person.getId()%>"/>
        <label>name:</label>
        <input type="text" name="name" value="<%=person.getName()%>"/>
        <br>
        <label>surname:</label>
        <input type="text" name=surname value="<%=person.getSurname()%>"/>
        <input type="submit" name="save" value="Save"/>

    </form>
</div>
</body>
</html>
