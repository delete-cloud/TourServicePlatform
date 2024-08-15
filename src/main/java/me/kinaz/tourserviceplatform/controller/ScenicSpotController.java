package me.kinaz.tourserviceplatform.controller;

import me.kinaz.tourserviceplatform.dao.ScenicSpotDAO;
import me.kinaz.tourserviceplatform.entity.ScenicSpot;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.inject.Inject;
import java.io.IOException;
import java.util.List;

@WebServlet("/scenicSpots")
public class ScenicSpotServlet extends HttpServlet {
    @Inject
    private ScenicSpotDAO scenicSpotDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ScenicSpot> scenicSpots = scenicSpotDAO.findAllScenicSpots();
        request.setAttribute("scenicSpots", scenicSpots);
        request.getRequestDispatcher("scenicSpots.jsp").forward(request, response);
    }
}
