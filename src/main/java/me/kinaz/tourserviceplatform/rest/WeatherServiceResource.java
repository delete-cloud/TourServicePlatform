package me.kinaz.tourserviceplatform.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import me.kinaz.tourserviceplatform.dto.WeatherInfoDTO;
import me.kinaz.tourserviceplatform.service.WeatherService;

import jakarta.inject.Inject;

@Path("/weather")
public class WeatherServiceResource {

    @Inject
    private WeatherService weatherService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public WeatherInfoDTO getWeatherInfo(@QueryParam("scenicSpotId") Long scenicSpotId) {
        return weatherService.getWeatherInfo(scenicSpotId);
    }
}
