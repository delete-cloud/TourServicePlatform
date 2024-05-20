package me.kinaz.tourserviceplatform.controller;

import me.kinaz.tourserviceplatform.service.CheckinService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkin")
public class CheckinController extends HttpServlet {
    @Inject
    private CheckinService checkinService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ticketCode = request.getParameter("ticketCode");
        checkinService.checkIn(ticketCode);
        response.sendRedirect("checkin_success.jsp");
    }
}
