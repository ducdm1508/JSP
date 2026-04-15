<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><title>Add a Group</title></head>
<body>
    <h2>Add a Group</h2>
    <form action="${pageContext.request.contextPath}/SaveGroup" method="post">
        <table>
            <tr><td>Name:</td><td><input type="text" name="name" required></td></tr>
            <tr><td>Description:</td><td><input type="text" name="description"></td></tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Add</button>
                    <a href="${pageContext.request.contextPath}/ListGroups"><button type="button">Return To Group List</button></a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>