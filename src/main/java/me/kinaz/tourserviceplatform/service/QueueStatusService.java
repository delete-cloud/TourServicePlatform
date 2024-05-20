package me.kinaz.tourserviceplatform.service;

import jakarta.ejb.Stateless;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class QueueStatusService {

    public Map<String, Integer> getQueueStatus() {
        // Dummy data for queue status
        Map<String, Integer> queueStatus = new HashMap<>();
        queueStatus.put("Scenic Spot 1", 10);
        queueStatus.put("Scenic Spot 2", 5);
        return queueStatus;
    }
}
