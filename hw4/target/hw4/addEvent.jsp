<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Event</title>
</head>
<body>

<h2>Add Event</h2>

<form action="addEvent" method="post">
    Name: <input type="text" name="name" required><br><br>
    Date: <input type="date" name="date" required><br><br>
    Venue: <input type="text" name="venue"><br><br>
    Seats: <input type="number" name="seats" min="1"><br><br>

    <button type="submit">Add</button>
</form>

<p style="color:red">${error}</p>

<a href="events">Back</a>

</body>
</html>