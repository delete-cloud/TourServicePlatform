package me.kinaz.tourserviceplatform.service;

import me.kinaz.tourserviceplatform.dao.ScenicSpotDAO;
import me.kinaz.tourserviceplatform.entity.ScenicSpot;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class ScenicSpotService {
    @Inject
    private ScenicSpotDAO scenicSpotDAO;

    public List<ScenicSpot> findAllScenicSpots() {
        return scenicSpotDAO.findAllScenicSpots();
    }

    public ScenicSpot findScenicSpotById(Long id) {
        return scenicSpotDAO.findById(id);
    }
}
