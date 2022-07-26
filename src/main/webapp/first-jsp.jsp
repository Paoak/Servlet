<%@page import="java.time.LocalDateTime" %>
<%@ page import="horsov.User" %>
<%@ page import="java.util.List" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>Hello world</h1>
<%
    response.getWriter().write("Hello from response.getWriter");
    out.print("Hi after response");
%>
<br>
<%= request.getRequestURI()%>
<br>
<%= LocalDateTime.now()%>
<hr/>
<%
    List<User> users = (List<User>) request.getAttribute("users");
    User anUser = users.get(0);
%>
<table>
<% for (User user:users) { %>
    <tr>
        <td><%= user.getName() %></td>
        <td><%= user.getAge() %> </td>
        <td><%= user.getCountry()%></td>
    </tr>
<%} %>
</table>
</body>
</html>