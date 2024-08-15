package me.kinaz.tourserviceplatform.dao;

import me.kinaz.tourserviceplatform.entity.ScenicSpot;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ScenicSpotDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ScenicSpot> findAllScenicSpots() {
        return entityManager.createQuery("SELECT s FROM ScenicSpot s", ScenicSpot.class).getResultList();
    }

    public ScenicSpot findById(Long id) {
        return entityManager.find(ScenicSpot.class, id);
    }
}
