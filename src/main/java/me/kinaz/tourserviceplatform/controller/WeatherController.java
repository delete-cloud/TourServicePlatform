package me.kinaz.tourserviceplatform.controller;

import me.kinaz.tourserviceplatform.dto.WeatherInfoDTO;
import me.kinaz.tourserviceplatform.service.WeatherService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/weather")
public class WeatherController extends HttpServlet {
    @Inject
    private WeatherService weatherService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scenicSpotIdParam = request.getParameter("scenicSpotId");
        if (scenicSpotIdParam == null || scenicSpotIdParam.isEmpty()) {
            request.setAttribute("errorMessage", "Missing or empty scenicSpotId parameter");
            request.getRequestDispatcher("weather_info.jsp").forward(request, response);
            return;
        }

        Long scenicSpotId;
        try {
            scenicSpotId = Long.parseLong(scenicSpotIdParam);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid scenicSpotId parameter");
            request.getRequestDispatcher("weather_info.jsp").forward(request, response);
            return;
        }

        WeatherInfoDTO weatherInfo = weatherService.getWeatherInfo(scenicSpotId);
        request.setAttribute("weatherInfo", weatherInfo);
        request.getRequestDispatcher("weather_info.jsp").forward(request, response);
    }
}
