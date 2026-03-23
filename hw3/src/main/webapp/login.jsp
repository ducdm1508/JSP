<form action="login" method="post">
    Email: <input type="text" name="email" /><br/>
    Password: <input type="password" name="password" /><br/>
    <button type="submit">Login</button>
</form>

<%
    if(request.getParameter("error") != null){
%>
    <p style="color:red">Sai tài khoản hoặc mật khẩu</p>
<%
    }
%>