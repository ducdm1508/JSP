package controller;

import dao.TicketDAO;
import model.Ticket;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {
    private TicketDAO ticketDAO;

    @Override
    public void init() throws ServletException {
        ticketDAO = new TicketDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("new".equals(action)) {
            request.getRequestDispatcher("/ticket-form.jsp").forward(request, response);
            return;
        }

        String keyword = request.getParameter("search");
        String pageStr = request.getParameter("page");
        int page = (pageStr != null && !pageStr.isEmpty()) ? Integer.parseInt(pageStr) : 1;
        int pageSize = 10; 

        List<Ticket> listTickets = ticketDAO.findTickets(keyword, page, pageSize);

        
        
        long totalRecords = ticketDAO.countTickets(keyword);
        int totalPages = (int) Math.ceil((double) totalRecords / pageSize);

        
        request.setAttribute("listTickets", listTickets);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("searchKeyword", keyword); 
        
        request.getRequestDispatcher("/tickets.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String eventName = request.getParameter("eventName");
        String customerName = request.getParameter("customerName");
        String seatNumber = request.getParameter("seatNumber");
        String dateStr = request.getParameter("date");
        String priceStr = request.getParameter("price");

       
        if (eventName == null || eventName.isEmpty() ||
            customerName == null || customerName.isEmpty() ||
            seatNumber == null || seatNumber.isEmpty() ||
            dateStr == null || dateStr.isEmpty() ||
            priceStr == null || priceStr.isEmpty()) {
            
            request.setAttribute("errorMessage", "All fields are required!");
            request.getRequestDispatcher("/ticket-form.jsp").forward(request, response);
            return;
        }

        try {
            LocalDate date = LocalDate.parse(dateStr);
            BigDecimal price = new BigDecimal(priceStr);

            Ticket newTicket = new Ticket(eventName, customerName, seatNumber, date, price);
            ticketDAO.save(newTicket);

            response.sendRedirect(request.getContextPath() + "/tickets");
            
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Invalid data format or database error!");
            request.getRequestDispatcher("/ticket-form.jsp").forward(request, response);
        }
    }
}