package filter;

import models.User;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

@WebFilter(urlPatterns = {"/dashboard.jsp", "/settings.jsp"})
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        // chưa login
        if (session == null || session.getAttribute("user") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        String uri = req.getRequestURI();

        // user không được vào settings
        if (uri.contains("settings") && user.getRole().equals("user")) {
            res.getWriter().println("Access Denied!");
            return;
        }

        chain.doFilter(request, response);
    }
}