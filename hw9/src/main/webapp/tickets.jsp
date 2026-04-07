<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Ticket List</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Event Tickets Management</h2>

    <form action="${pageContext.request.contextPath}/tickets" method="GET">
        <input type="text" name="search" value="<c:out value='${searchKeyword}'/>" placeholder="Search by event or customer..." />
        <button type="submit">Search</button>
        <a href="${pageContext.request.contextPath}/tickets">Clear</a>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/tickets?action=new"> + Add New Ticket</a>
    <br><br>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Event Name</th>
                <th>Customer Name</th>
                <th>Seat</th>
                <th>Date</th>
                <th>Price ($)</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="ticket" items="${listTickets}">
                <tr>
                    <td><c:out value="${ticket.ticketId}"/></td>
                    <td><c:out value="${ticket.eventName}"/></td>
                    <td><c:out value="${ticket.customerName}"/></td>
                    <td><c:out value="${ticket.seatNumber}"/></td>
                    <td><c:out value="${ticket.date}"/></td>
                    <td><c:out value="${ticket.price}"/></td>
                </tr>
            </c:forEach>
            <c:if test="${empty listTickets}">
                <tr><td colspan="6" style="text-align: center;">No tickets found.</td></tr>
            </c:if>
        </tbody>
    </table>

    <div style="margin-top: 15px;">
        <c:if test="${currentPage > 1}">
            <a href="?page=${currentPage - 1}&search=<c:out value='${searchKeyword}'/>">Previous</a>
        </c:if>
        
        <span> Page <c:out value="${currentPage}"/> </span>
        
        <c:if test="${currentPage < totalPages}">
            <a href="?page=${currentPage + 1}&search=<c:out value='${searchKeyword}'/>">Next</a>
        </c:if>
    </div>

</body>
</html>