package me.kinaz.tourserviceplatform.service;

import jakarta.ejb.Stateless;
import me.kinaz.tourserviceplatform.dto.WeatherInfoDTO;

@Stateless
public class WeatherService {

    public WeatherInfoDTO getWeatherInfo(Long scenicSpotId) {
        // 模拟的天气信息
        WeatherInfoDTO weatherInfo = new WeatherInfoDTO();
        weatherInfo.setScenicSpotId(scenicSpotId);
        weatherInfo.setTemperature("25°C");
        weatherInfo.setCondition("Sunny");
        return weatherInfo;
    }
}
