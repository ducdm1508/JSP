<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Event List</title>
</head>
<body>

<h2>Event List</h2>

<a href="addEvent">+ Add Event</a>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Date</th>
    <th>Venue</th>
    <th>Seats</th>
    <th>Action</th>
</tr>

<c:forEach var="e" items="${events}">
<tr>
    <td>${e.id}</td>
    <td>${e.name}</td>
    <td>${e.date}</td>
    <td>${e.venue}</td>
    <td>${e.seats_available}</td>
    <td>
        <a href="deleteEvent?id=${e.id}">Delete</a> |
        <a href="attendees?event_id=${e.id}">View Attendees</a> |
        <a href="addAttendee.jsp?event_id=${e.id}">Add Attendee</a>
    </td>
</tr>
</c:forEach>

</table>

</body>
</html>