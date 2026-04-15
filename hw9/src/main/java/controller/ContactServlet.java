package controller;

import dao.ContactDAO;
import dao.GroupDAO;
import model.Contact;
import model.ContactGroup;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/AddContact", "/ListContacts", "/SaveContact", "/EditContact", "/DeleteContact"})
public class ContactServlet extends HttpServlet {
    private ContactDAO contactDAO = new ContactDAO();
    private GroupDAO groupDAO = new GroupDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/ListContacts".equals(path)) {
            List<Contact> contacts = contactDAO.getAllContacts();
            request.setAttribute("contacts", contacts);
            request.setAttribute("totalContacts", contacts.size());
            request.getRequestDispatcher("ListContacts.jsp").forward(request, response);
        } else if ("/EditContact".equals(path)) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("contact", contactDAO.getContactById(id));
            request.setAttribute("groups", groupDAO.getAllGroups());
            request.getRequestDispatcher("EditContact.jsp").forward(request, response);
        } else if ("/DeleteContact".equals(path)) {
            int id = Integer.parseInt(request.getParameter("id"));
            contactDAO.deleteContact(id);
            response.sendRedirect(request.getContextPath() + "/ListContacts");
        } else {
            request.setAttribute("groups", groupDAO.getAllGroups());
            request.getRequestDispatcher("AddContact.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String idStr = request.getParameter("id");
        
        Contact contact = new Contact();
        contact.setFirstName(request.getParameter("firstName"));
        contact.setLastName(request.getParameter("lastName"));
        contact.setPhoneNumber(request.getParameter("phone"));
        
        ContactGroup group = new ContactGroup();
        group.setId(Integer.parseInt(request.getParameter("groupId")));
        contact.setGroup(group);

        if (idStr != null && !idStr.isEmpty()) {
            contact.setId(Integer.parseInt(idStr));
            contactDAO.updateContact(contact);
        } else {
            contactDAO.saveContact(contact);
        }
        response.sendRedirect(request.getContextPath() + "/ListContacts");
    }
}