package model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "attendees")
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 🔹 Quan hệ ManyToOne với Event
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Invalid email format")
    private String email;

    // 🔹 Constructor rỗng (bắt buộc cho JPA)
    public Attendee() {
    }

    // 🔹 Constructor đầy đủ
    public Attendee(Event event, String name, String email) {
        this.event = event;
        this.name = name;
        this.email = email;
    }

    // 🔹 Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 🔹 toString (debug)
    @Override
    public String toString() {
        return "Attendee{" +
                "id=" + id +
                ", event=" + (event != null ? event.getId() : "null") +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}