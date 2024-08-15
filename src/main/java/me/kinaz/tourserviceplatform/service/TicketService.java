package me.kinaz.tourserviceplatform.service;

import me.kinaz.tourserviceplatform.dao.TicketDAO;
import me.kinaz.tourserviceplatform.entity.Ticket;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.sql.Timestamp;

@Stateless
public class TicketService {
    @Inject
    private TicketDAO ticketDAO;

    public void createTicket(Ticket ticket) {
        ticketDAO.createTicket(ticket);
    }

    public void updateCheckinStatus(String ticketCode, Timestamp checkinTime) {
        Ticket ticket = ticketDAO.findByTicketCode(ticketCode);
        if (ticket != null) {
            ticket.setCheckinTime(checkinTime);
            ticket.setCheckedIn(true);
            ticketDAO.updateTicket(ticket);
        }
    }
}
