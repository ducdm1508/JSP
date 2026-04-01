package controller;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = request.getParameter("msg");
        if ("success".equals(msg)) {
            request.setAttribute("success", "Đăng ký thành công! Vui lòng đăng nhập.");
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
            UserDAO userDAO = new UserDAO();
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = userDAO.login(username, password);
            if (user != null) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/books");
            } else {
                System.out.println("LOGIN FAIL");
                request.setAttribute("error", "tài khoản hoặc mật khẩu không đúng!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
    }
}
