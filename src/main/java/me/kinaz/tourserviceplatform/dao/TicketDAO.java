package me.kinaz.tourserviceplatform.dao;

import me.kinaz.tourserviceplatform.entity.Ticket;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TicketDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Transactional
    public void updateTicket(Ticket ticket) {
        entityManager.merge(ticket);
    }

    public Ticket findByTicketCode(String ticketCode) {
        return entityManager.createQuery("SELECT t FROM Ticket t WHERE t.ticketCode = :ticketCode", Ticket.class)
                .setParameter("ticketCode", ticketCode)
                .getSingleResult();
    }

    public List<Ticket> findAllTickets() {
        return entityManager.createQuery("SELECT t FROM Ticket t", Ticket.class)
                .getResultList();
    }
}
