package me.kinaz.tourserviceplatform.service.mdb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import me.kinaz.tourserviceplatform.dao.TicketDAO;
import me.kinaz.tourserviceplatform.entity.Ticket;

@MessageDriven(name = "TicketMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/TicketQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
})
public class TicketMDB implements MessageListener {

    @Inject
    private TicketDAO ticketDAO;

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                String ticketCode = ((TextMessage) message).getText();
                Ticket ticket = ticketDAO.findByTicketCode(ticketCode);
                if (ticket != null) {
                    ticket.setCheckedIn(true);
                    ticket.setCheckinTime(new java.sql.Timestamp(System.currentTimeMillis()));
                    ticketDAO.updateTicket(ticket);
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
