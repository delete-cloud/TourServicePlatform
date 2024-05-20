package me.kinaz.tourserviceplatform.dao;

import me.kinaz.tourserviceplatform.entity.WeatherInfo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class WeatherInfoDAO {
    @PersistenceContext
    private EntityManager em;

    public void createWeatherInfo(WeatherInfo weatherInfo) {
        em.persist(weatherInfo);
    }

    public WeatherInfo findWeatherInfoByScenicSpotId(Long scenicSpotId) {
        return em.createQuery("SELECT w FROM WeatherInfo w WHERE w.scenicSpotId = :scenicSpotId", WeatherInfo.class)
                .setParameter("scenicSpotId", scenicSpotId)
                .getSingleResult();
    }

    public WeatherInfo findWeatherInfoById(Long id) {
        return em.find(WeatherInfo.class, id);
    }
}
