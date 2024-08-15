package me.kinaz.tourserviceplatform.service;

import me.kinaz.tourserviceplatform.dao.ServiceStationDAO;
import me.kinaz.tourserviceplatform.entity.ServiceStation;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class ServiceStationService {

    @Inject
    private ServiceStationDAO serviceStationDAO;

    public List<ServiceStation> getAllServiceStations() {
        return serviceStationDAO.findAll();
    }
}
