package me.kinaz.tourserviceplatform.dto;

import java.util.Date;

public class CheckinRecordDTO {
    private Long id;
    private String ticketCode;
    private Date checkinTime;

    public CheckinRecordDTO() {
    }

    public CheckinRecordDTO(Long id, String ticketCode, Date checkinTime) {
        this.id = id;
        this.ticketCode = ticketCode;
        this.checkinTime = checkinTime;
    }

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
