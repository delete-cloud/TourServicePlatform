package me.kinaz.tourserviceplatform.service;

import me.kinaz.tourserviceplatform.dao.CheckinRecordDAO;
import me.kinaz.tourserviceplatform.entity.CheckinRecord;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.Date;

@Stateless
public class CheckinService {
    @Inject
    private CheckinRecordDAO checkinRecordDAO;

    public void checkIn(String ticketCode) {
        CheckinRecord checkinRecord = new CheckinRecord();
        checkinRecord.setTicketCode(ticketCode);
        checkinRecord.setCheckinTime(new Date());
        checkinRecordDAO.createCheckinRecord(checkinRecord);
    }
}
