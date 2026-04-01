<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert Book</title>
    </head>
    <body>
        <h2>Insert New Book</h2>

        <form action="insert-book" method="post">
            <table>
                <tr>
                    <td>Title:</td>
                    <td><input type="text" name="title" required></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="number" step="0.01" name="price" required></td>
                </tr>
                <tr>
                    <td>Category:</td>
                    <td>
                        <select name="categoryId" required>
                            <c:forEach var="cate" items="${categories}">
                                <option value="${cate.id}">${cate.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Insert Book">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>