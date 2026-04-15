<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="views/new.jsp">New Exam</a>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Duration</th><th>Description</th><th>Action</th></tr>
<c:forEach var="e" items="${list}">
<tr>
<td>${e.id}</td>
<td>${e.name}</td>
<td>${e.duration}</td>
<td>${e.description}</td>
<td><a href="exam?action=delete&id=${e.id}">Delete</a></td>
</tr>
</c:forEach>
</table>