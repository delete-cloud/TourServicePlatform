package me.kinaz.tourserviceplatform.dao;

import me.kinaz.tourserviceplatform.entity.ServiceStation;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ServiceStationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ServiceStation> findAll() {
        return entityManager.createQuery("SELECT s FROM ServiceStation s", ServiceStation.class).getResultList();
    }
}
