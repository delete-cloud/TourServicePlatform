package me.kinaz.tourserviceplatform.service.jms;

import me.kinaz.tourserviceplatform.dao.TicketDAO;
import me.kinaz.tourserviceplatform.entity.Ticket;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;
import java.sql.Timestamp;
import java.util.logging.Logger;

@ApplicationScoped
public class TicketProducer {

    @Inject
    private Logger log;

    @Inject
    private TicketDAO ticketDAO;

    @Resource(lookup = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/queue/TicketQueue")
    private Queue queue;

    public void sendTicketMessage(String ticketCode) {
        try (JMSContext context = connectionFactory.createContext()) {
            context.createProducer().send(queue, ticketCode);
            log.info("Ticket message sent: " + ticketCode);

            // Update the ticket as checked in
            Ticket ticket = ticketDAO.findByTicketCode(ticketCode);
            if (ticket != null) {
                ticket.setCheckedIn(true);
                ticket.setCheckinTime(new Timestamp(System.currentTimeMillis()));
                ticketDAO.updateTicket(ticket);
            }
        } catch (Exception e) {
            log.severe("Failed to send ticket message: " + e.getMessage());
        }
    }
}
