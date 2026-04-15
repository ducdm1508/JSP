<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><title>List Of Group</title></head>
<body>
    <h2>List Of Group</h2>
    <table border="1" cellpadding="5">
        <tr><th>ID</th><th>Group Name</th><th>Description</th></tr>
        <c:forEach var="g" items="${groups}">
            <tr><td>${g.id}</td><td>${g.name}</td><td>${g.description}</td></tr>
        </c:forEach>
    </table><br>
    <a href="${pageContext.request.contextPath}/AddGroup">Add Group</a> | 
    <a href="${pageContext.request.contextPath}/ListContacts">List Contact</a>
</body>
</html>