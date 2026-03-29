<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Attendee</title>
</head>
<body>

<h2>Add Attendee</h2>

<%
    String eventId = request.getParameter("event_id");
%>

<form action="addAttendee" method="post">
    <input type="hidden" name="event_id" value="<%=eventId%>">

    Name: <input type="text" name="name" required><br><br>
    Email: <input type="email" name="email"><br><br>

    <button type="submit">Add</button>
</form>

<br>
<a href="events">Back</a>

</body>
</html>