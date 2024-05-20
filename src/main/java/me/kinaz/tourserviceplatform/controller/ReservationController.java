package me.kinaz.tourserviceplatform.controller;

import me.kinaz.tourserviceplatform.dto.ReservationDTO;
import me.kinaz.tourserviceplatform.service.ReservationService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reserve")
public class ReservationController extends HttpServlet {
    @Inject
    private ReservationService reservationService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long scenicSpotId = Long.parseLong(request.getParameter("scenicSpotId"));
        String visitTime = request.getParameter("visitTime");

        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setScenicSpotId(scenicSpotId);
        reservationDTO.setVisitTime(visitTime);
        reservationDTO.setUserId((Long) request.getSession().getAttribute("userId")); // Assumes userId is stored in session

        reservationService.addReservation(reservationDTO);

        response.sendRedirect("confirmation.jsp");
    }
}
