<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><title>Edit a Contact</title></head>
<body>
    <h2>Edit a Contact</h2>
    <form action="${pageContext.request.contextPath}/SaveContact" method="post">
        <input type="hidden" name="id" value="${contact.id}">
        <table>
            <tr><td>ID:</td><td>${contact.id}</td></tr>
            <tr><td>First Name:</td><td><input type="text" name="firstName" value="${contact.firstName}" required></td></tr>
            <tr><td>Last Name:</td><td><input type="text" name="lastName" value="${contact.lastName}" required></td></tr>
            <tr>
                <td>Group:</td>
                <td>
                    <select name="groupId">
                        <c:forEach var="g" items="${groups}">
                            <option value="${g.id}" ${g.id == contact.group.id ? 'selected' : ''}>${g.name} - ${g.description}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr><td>Phone Number:</td><td><input type="text" name="phone" value="${contact.phoneNumber}" pattern="\d+" required></td></tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Edit</button>
                    <a href="${pageContext.request.contextPath}/ListContacts"><button type="button">Return To Contact List</button></a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>