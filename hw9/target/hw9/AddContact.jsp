<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><title>Add Contact</title></head>
<body>
    <h2>Add a Contact</h2>
    <form action="${pageContext.request.contextPath}/SaveContact" method="post">
        <table>
            <tr><td>First Name:</td><td><input type="text" name="firstName" required></td></tr>
            <tr><td>Last Name:</td><td><input type="text" name="lastName" required></td></tr>
            <tr>
                <td>Group:</td>
                <td>
                    <select name="groupId">
                        <c:forEach var="g" items="${groups}">
                            <option value="${g.id}">${g.name} - ${g.description}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr><td>Phone Number:</td><td><input type="text" name="phone" pattern="\d+" required></td></tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Add</button>
                    <a href="${pageContext.request.contextPath}/ListContacts"><button type="button">Return To Contact List</button></a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>