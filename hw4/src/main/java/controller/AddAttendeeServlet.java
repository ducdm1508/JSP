package controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttendeeDAO;
import dao.EventDAO;
import model.Attendee;
import model.Event;

@WebServlet("/addAttendee")
public class AddAttendeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int eventId = Integer.parseInt(req.getParameter("event_id"));

        Event e = new EventDAO().getEventById(eventId);

        Attendee a = new Attendee();
        a.setName(name);
        a.setEmail(email);
        a.setEvent(e);

        new AttendeeDAO().addAttendee(a);;

        res.sendRedirect("events");
    }
}