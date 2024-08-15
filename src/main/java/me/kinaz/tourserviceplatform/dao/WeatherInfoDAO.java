package me.kinaz.tourserviceplatform.dao;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import me.kinaz.tourserviceplatform.entity.WeatherInfo;

@Stateless
public class WeatherInfoDAO {
    @Inject
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
