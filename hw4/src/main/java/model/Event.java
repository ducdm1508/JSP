package model;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 5, message = "Name must be at least 5 characters")
    private String name;

    @NotNull(message = "Date cannot be null")
    @Temporal(TemporalType.DATE)
    private Date date;

    @NotNull(message = "Venue cannot be null")
    private String venue;

    @NotNull(message = "Seats cannot be null")
    @Min(value = 1, message = "Seats must be greater than 0")
    private int seats_available;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Attendee> attendees;

   
    public Event() {
    }

    public Event(String name, Date date, String venue, int seats_available) {
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.seats_available = seats_available;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }


    public int getSeats_available() {
        return seats_available;
    }

    public void setSeats_available(int seats_available) {
        this.seats_available = seats_available;
    }


    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }


}