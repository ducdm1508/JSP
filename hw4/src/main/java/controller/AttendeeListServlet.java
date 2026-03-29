package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttendeeDAO;

@WebServlet("/attendees")
public class AttendeeListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int eventId = Integer.parseInt(req.getParameter("event_id"));

        req.setAttribute("attendees",
                new AttendeeDAO().getByEventId(eventId));

        req.getRequestDispatcher("attendeeList.jsp")
                .forward(req, res);
    }
}