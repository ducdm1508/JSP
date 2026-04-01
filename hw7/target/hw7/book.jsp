<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Book List</title>
    </head>
    <body>
        <h2>Danh sách sách</h2>

        <table border="1">
            <tr>
                <th>ID</th><th>Title</th><th>Category</th><th>Price</th><th>Delete</th>
            </tr>

            <c:forEach var="b" items="${list}">
                <tr>
                    <td>${b.id}</td>
                    <td>${b.title}</td>
                    <td>${b.category.name}</td>
                    <td>${b.price}</td>
                    <td>
                        <a href="books?action=delete&id=${b.id}"
                        onclick="return confirm('Delete?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>