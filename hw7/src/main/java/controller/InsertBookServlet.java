package controller;

import java.io.IOException;

import dao.BookDAO;
import dao.CategoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Book;
import model.Category;

@WebServlet("/insert-book")
public class InsertBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        CategoryDAO cateDAO = new CategoryDAO();
        req.setAttribute("categories", cateDAO.getAllCategories());
        req.getRequestDispatcher("insertBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        String title = request.getParameter("title");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        CategoryDAO categoryDAO = new CategoryDAO();
        Category category = categoryDAO.getCategoryById(categoryId);

        Book book = new Book();
        book.setTitle(title);
        book.setPrice(price);
        book.setCategory(category);

        BookDAO bookDAO = new BookDAO();
        bookDAO.addBook(book);

        response.sendRedirect(request.getContextPath() + "/books");
    }
}
