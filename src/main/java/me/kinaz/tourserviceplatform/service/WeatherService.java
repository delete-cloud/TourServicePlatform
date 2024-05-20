package me.kinaz.tourserviceplatform.service;

import me.kinaz.tourserviceplatform.dao.WeatherInfoDAO;
import me.kinaz.tourserviceplatform.dto.WeatherInfoDTO;
import me.kinaz.tourserviceplatform.entity.WeatherInfo;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class WeatherService {
    @Inject
    private WeatherInfoDAO weatherInfoDAO;

    public WeatherInfoDTO getWeatherInfo(Long scenicSpotId) {
        WeatherInfo weatherInfo = weatherInfoDAO.findWeatherInfoByScenicSpotId(scenicSpotId);
        WeatherInfoDTO weatherInfoDTO = new WeatherInfoDTO();
        weatherInfoDTO.setId(weatherInfo.getId());
        weatherInfoDTO.setScenicSpotId(weatherInfo.getScenicSpotId());
        weatherInfoDTO.setTemperature(weatherInfo.getTemperature());
        weatherInfoDTO.setCondition(weatherInfo.getCondition());
        return weatherInfoDTO;
    }
}
