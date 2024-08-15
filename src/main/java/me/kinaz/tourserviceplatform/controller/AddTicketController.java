package me.kinaz.tourserviceplatform.controller;

import me.kinaz.tourserviceplatform.dao.TicketDAO;
import me.kinaz.tourserviceplatform.entity.ScenicSpot;
import me.kinaz.tourserviceplatform.entity.Ticket;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.kinaz.tourserviceplatform.entity.User;

import java.io.IOException;

@WebServlet("/add_ticket")
public class AddTicketController extends HttpServlet {

    @Inject
    private TicketDAO ticketDAO;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ticketCode = request.getParameter("ticketCode");
        Long userId = Long.parseLong(request.getParameter("userId"));
        Long scenicSpotId = Long.parseLong(request.getParameter("scenicSpotId"));

        Ticket ticket = new Ticket();
        ticket.setTicketCode(ticketCode);
        ticket.setUser(new User(userId)); // Assume you have a constructor in User class that takes an ID
        ticket.setScenicSpot(new ScenicSpot(scenicSpotId)); // Assume you have a constructor in ScenicSpot class that takes an ID

        ticketDAO.createTicket(ticket);
        response.sendRedirect("checkin");
    }
}
