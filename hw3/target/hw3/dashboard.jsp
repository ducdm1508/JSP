<%@ page import="models.User" %>
<%
    User user = (User) session.getAttribute("user");
%>

<h1>Dashboard</h1>
<p>Email: <%= user.getEmail() %></p>
<p>Role: <%= user.getRole() %></p>

<a href="settings.jsp">Settings</a><br>
<a href="logout">Logout</a>