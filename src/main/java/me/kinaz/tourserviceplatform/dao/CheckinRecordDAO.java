package me.kinaz.tourserviceplatform.dao;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import me.kinaz.tourserviceplatform.entity.CheckinRecord;

import java.util.List;

@Stateless
public class CheckinRecordDAO {
    @Inject
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
