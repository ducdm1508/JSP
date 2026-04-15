<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><title>List Of Contacts</title></head>
<body>
    <h2>List Of Contacts</h2>
    <p>There are ${totalContacts} contacts in the List</p>
    <table border="1" cellpadding="5">
        <tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Group</th><th>Phone Number</th><th>Operations</th></tr>
        <c:forEach var="c" items="${contacts}">
            <tr>
                <td>${c.id}</td><td>${c.firstName}</td><td>${c.lastName}</td>
                <td>${c.group.name}</td><td>${c.phoneNumber}</td>
                <td>
                    <a href="EditContact?id=${c.id}">Edit</a> | 
                    <a href="DeleteContact?id=${c.id}" onclick="return confirm('Are you sure?')">Remove</a>
                </td>
            </tr>
        </c:forEach>
    </table><br>
    <a href="${pageContext.request.contextPath}/AddContact">Add Contact</a> | 
    <a href="${pageContext.request.contextPath}/ListGroups">List Group</a>
</body>
</html>