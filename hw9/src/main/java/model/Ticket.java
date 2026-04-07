package model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "seat_number", nullable = false, length = 50)
    private String seatNumber;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    
    public Ticket() {}

    
    public Ticket(String eventName, String customerName, String seatNumber, LocalDate date, BigDecimal price) {
        this.eventName = eventName;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
        this.date = date;
        this.price = price;
    }

    public Integer getTicketId() { return ticketId; }
    public void setTicketId(Integer ticketId) { this.ticketId = ticketId; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}