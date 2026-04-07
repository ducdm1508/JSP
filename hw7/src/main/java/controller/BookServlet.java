package controller;

import java.io.IOException;


import dao.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        BookDAO dao = new BookDAO();
        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.deleteBook(id);
            resp.sendRedirect("books");
            return;
        }

        req.setAttribute("list", dao.getAllBooks());
        req.getRequestDispatcher("book.jsp").forward(req, resp);
    }
}
