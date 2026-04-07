<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Add New Ticket</title>
</head>
<body>
    <h2>Add New Event Ticket</h2>
    
    <c:if test="${not empty errorMessage}">
        <div style="color: red;"><c:out value="${errorMessage}"/></div>
    </c:if>

    <form action="${pageContext.request.contextPath}/tickets" method="POST">
        <label>Event Name:</label><br>
        <input type="text" name="eventName" required /><br><br>

        <label>Customer Name:</label><br>
        <input type="text" name="customerName" required /><br><br>

        <label>Seat Number:</label><br>
        <input type="text" name="seatNumber" required /><br><br>

        <label>Date:</label><br>
        <input type="date" name="date" required /><br><br>

        <label>Price:</label><br>
        <input type="number" step="0.01" name="price" required /><br><br>

        <button type="submit">Save Ticket</button>
        <a href="${pageContext.request.contextPath}/tickets">Cancel</a>
    </form>
</body>
</html>