<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Đăng ký tài khoản</title>
        <style>
            .error-msg { color: red; font-weight: bold; }
        </style>
    </head>
    <body>

        <h2>Đăng ký User</h2>

        <%-- Hiển thị thông báo lỗi nếu có --%>


        <form action="register" method="post">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username" value="${oldUsername}"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" value="${oldEmail}"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Đăng ký</button></td>
                </tr>
            </table>
        </form>
        <% if(request.getAttribute("error") != null) { %>
        <p style="color:red"><%= request.getAttribute("error") %></p>
        <% } %>
    </body>
</html>