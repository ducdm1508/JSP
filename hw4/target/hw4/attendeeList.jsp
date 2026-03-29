<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Attendee List</title>
</head>
<body>

<h2>Attendees</h2>

<table border="1" cellpadding="10">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
</tr>

<c:forEach var="e" items="${attendees}">
<tr>
    <td>${e.id}</td>
    <td>${e.name}</td>
    <td>${e.email}</td>
</tr>
</c:forEach>

</table>

<br>
<a href="events">Back</a>

</body>
</html>