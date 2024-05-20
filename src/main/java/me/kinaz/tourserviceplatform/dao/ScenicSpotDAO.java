package me.kinaz.tourserviceplatform.dao;

import me.kinaz.tourserviceplatform.entity.ScenicSpot;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ScenicSpotDAO {
    @PersistenceContext
    private EntityManager em;

    public List<ScenicSpot> getAllScenicSpots() {
        return em.createQuery("SELECT s FROM ScenicSpot s", ScenicSpot.class).getResultList();
    }

    public ScenicSpot findScenicSpotById(Long id) {
        return em.find(ScenicSpot.class, id);
    }
}
