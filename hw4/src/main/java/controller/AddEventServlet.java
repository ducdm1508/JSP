package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Event;
import dao.EventDAO;

@WebServlet("/addEvent")
public class AddEventServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("addEvent.jsp").forward(req,res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        try{
            String name = req.getParameter("name");
            String date = req.getParameter("date");
            String venue = req.getParameter("venue");
            int seats = Integer.parseInt(req.getParameter("seats"));

            if(name.length() < 5) throw new Exception("Name >=5");

            Event e = new Event();
            e.setName(name);
            e.setDate(java.sql.Date.valueOf(date));
            e.setVenue(venue);
            e.setSeats_available(seats);

            new EventDAO().addEvent(e);

            res.sendRedirect("events");

        }catch(Exception ex){
            req.setAttribute("error", ex.getMessage());
            req.getRequestDispatcher("addEvent.jsp").forward(req,res);
        }
    }
}