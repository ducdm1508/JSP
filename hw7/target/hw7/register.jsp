<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký thành viên</title>
</head>
<body>
    <h2>Tạo tài khoản mới</h2>

    <form action="register" method="post">
        <div>
            <label>Tên đăng nhập:</label><br>
            <input type="text" name="username" required>
        </div><br>

        <div>
            <label>Mật khẩu:</label><br>
            <input type="password" name="password" required>
        </div><br>

        <div>
            <label>Xác nhận mật khẩu:</label><br>
            <input type="password" name="confirmPassword" required>
        </div><br>

        <button type="submit">Đăng ký</button>
    </form>

    <c:if test="${not empty error}">
        <p style="color:red; font-weight:bold;">${error}</p>
    </c:if>

    <p>Đã có tài khoản? <a href="login.jsp">Đăng nhập ngay</a></p>
</body>
</html>