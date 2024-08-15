package me.kinaz.tourserviceplatform.service;

import me.kinaz.tourserviceplatform.dao.QueueStatusDAO;
import me.kinaz.tourserviceplatform.dao.ScenicSpotDAO;
import me.kinaz.tourserviceplatform.entity.QueueStatus;
import me.kinaz.tourserviceplatform.entity.ScenicSpot;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class QueueStatusService {

    @Inject
    private QueueStatusDAO queueStatusDAO;

    @Inject
    private ScenicSpotDAO scenicSpotDAO;

    public List<QueueStatus> getAllQueueStatuses() {
        List<QueueStatus> queueStatuses = queueStatusDAO.findAll();
        for (QueueStatus queueStatus : queueStatuses) {
            ScenicSpot scenicSpot = scenicSpotDAO.findById(queueStatus.getScenicSpotId());
            queueStatus.setScenicSpot(scenicSpot);
        }
        return queueStatuses;
    }
}
