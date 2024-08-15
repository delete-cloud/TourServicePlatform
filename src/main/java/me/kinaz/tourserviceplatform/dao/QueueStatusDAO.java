package me.kinaz.tourserviceplatform.dao;

import me.kinaz.tourserviceplatform.entity.QueueStatus;
import me.kinaz.tourserviceplatform.entity.ServiceStation;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class QueueStatusDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<QueueStatus> findAll() {
        return entityManager.createQuery("SELECT q FROM QueueStatus q", QueueStatus.class).getResultList();
    }

    public List<QueueStatus> findByScenicSpotId(Long scenicSpotId) {
        return entityManager.createQuery("SELECT q FROM QueueStatus q WHERE q.scenicSpot.id = :scenicSpotId", QueueStatus.class)
                .setParameter("scenicSpotId", scenicSpotId)
                .getResultList();
    }
}

