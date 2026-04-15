package controller;

import dao.GroupDAO;
import model.ContactGroup;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/ListGroups", "/AddGroup", "/SaveGroup"})
public class GroupServlet extends HttpServlet {
    private GroupDAO groupDAO = new GroupDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/ListGroups".equals(path)) {
            request.setAttribute("groups", groupDAO.getAllGroups());
            request.getRequestDispatcher("ListGroups.jsp").forward(request, response);
        } else if ("/AddGroup".equals(path)) {
            request.getRequestDispatcher("AddGroup.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ContactGroup group = new ContactGroup();
        group.setName(request.getParameter("name"));
        group.setDescription(request.getParameter("description"));
        groupDAO.saveGroup(group);
        response.sendRedirect(request.getContextPath() + "/ListGroups");
    }
}