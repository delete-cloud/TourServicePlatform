package me.kinaz.tourserviceplatform.dao;

import me.kinaz.tourserviceplatform.entity.CheckinRecord;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CheckinRecordDAO {
    @PersistenceContext
    private EntityManager em;

    public void createCheckinRecord(CheckinRecord checkinRecord) {
        em.persist(checkinRecord);
    }

    public List<CheckinRecord> findCheckinRecordsByTicketCode(String ticketCode) {
        return em.createQuery("SELECT c FROM CheckinRecord c WHERE c.ticketCode = :ticketCode", CheckinRecord.class)
                .setParameter("ticketCode", ticketCode)
                .getResultList();
    }

    public CheckinRecord findCheckinRecordById(Long id) {
        return em.find(CheckinRecord.class, id);
    }
}
