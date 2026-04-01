<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h2>Đăng nhập</h2>

        <c:if test="${param.msg == 'success'}">
            <p style="color: green; font-weight: bold;"> ${success}</p>
        </c:if>

        <form action="login" method="post">
            <div>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <br>
            <div>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <br>
            <input type="submit" value="Login">
        </form>

        <c:if test="${not empty error}">
            <p style="color:red; font-weight:bold;">${error}</p>
        </c:if>
        <br>
        <p>Chưa có tài khoản? <a href="register">Đăng ký ngay</a></p>

    </body>
</html>