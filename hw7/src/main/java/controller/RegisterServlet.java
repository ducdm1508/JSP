package controller;

import java.io.IOException;
import dao.UserDAO;
import model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String confirm = request.getParameter("confirmPassword");

        if (pass == null || !pass.equals(confirm)) {
            request.setAttribute("error", "Mật khẩu xác nhận không khớp!");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        UserDAO dao = new UserDAO();

        if (dao.isUsernameExists(user)) {
            request.setAttribute("error", "Tên đăng nhập này đã có người sử dụng!");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        User newUser = new User();
        newUser.setUsername(user);
        newUser.setPassword(pass);

        boolean isSuccess = dao.register(newUser);

        if (isSuccess) {
            response.sendRedirect(request.getContextPath() + "/login?msg=success");
        } else {
            request.setAttribute("error", "Đăng ký thất bại. Tên đăng nhập có thể đã tồn tại!");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}