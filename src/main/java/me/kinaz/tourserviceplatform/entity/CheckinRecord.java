package me.kinaz.tourserviceplatform.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "checkin_records")
public class CheckinRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "ticket_code")
    private String ticketCode;

    @Column(nullable = false, name = "checkin_time")
    private Date checkinTime;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }
}
