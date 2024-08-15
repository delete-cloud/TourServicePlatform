package me.kinaz.tourserviceplatform.controller;

import me.kinaz.tourserviceplatform.dto.ReservationDTO;
import me.kinaz.tourserviceplatform.entity.ScenicSpot;
import me.kinaz.tourserviceplatform.entity.User;
import me.kinaz.tourserviceplatform.service.ReservationService;
import me.kinaz.tourserviceplatform.service.ScenicSpotService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.inject.Inject;
import java.io.IOException;
import java.util.List;

@WebServlet("/reservations")
public class ReservationController extends HttpServlet {
    @Inject
    private ReservationService reservationService;

    @Inject
    private ScenicSpotService scenicSpotService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<ReservationDTO> reservations = reservationService.findReservationsByUserId(user.getId());
        List<ScenicSpot> scenicSpots = scenicSpotService.findAllScenicSpots();
        request.setAttribute("scenicSpots", scenicSpots);
        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("reservations.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Long scenicSpotId = Long.parseLong(request.getParameter("scenicSpotId"));
        String reservationTime = request.getParameter("reservationTime");

        // Get ScenicSpot details
        ScenicSpot scenicSpot = scenicSpotService.findScenicSpotById(scenicSpotId);
        if (scenicSpot == null) {
            response.sendRedirect("reservations?error=invalidScenicSpot");
            return;
        }

        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setUserId(user.getId());
        reservationDTO.setScenicSpotId(scenicSpotId);
        reservationDTO.setScenicSpotName(scenicSpot.getName());
        reservationDTO.setScenicSpotDescription(scenicSpot.getDescription());
        reservationDTO.setScenicSpotImageUrl(scenicSpot.getImageUrl());
        System.out.println("ScenicSpotName: "+reservationDTO.getScenicSpotName() + "\n" + "ScenicSpotDescription: "+
                reservationDTO.getScenicSpotDescription() + "\n" + "ScenicSpotImageUrl: "+reservationDTO.getScenicSpotImageUrl() + "\n" +
                "ScenicSpotId: "+reservationDTO.getScenicSpotId() + "\n" + "UserId: "+reservationDTO.getUserId() + "\n" + "ReservationTime: "
                +reservationDTO.getReservationTime() + "\n");
        reservationDTO.setReservationTime(java.sql.Timestamp.valueOf(reservationTime.replace("T", " ") + ":00"));

        reservationService.addOrUpdateReservation(reservationDTO);
        response.sendRedirect("reservations");
    }
}
