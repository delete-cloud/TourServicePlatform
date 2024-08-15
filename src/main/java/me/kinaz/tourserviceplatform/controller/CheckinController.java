package me.kinaz.tourserviceplatform.controller;

import me.kinaz.tourserviceplatform.service.jms.TicketProducer;
import me.kinaz.tourserviceplatform.service.TicketService;
import me.kinaz.tourserviceplatform.dao.TicketDAO;
import me.kinaz.tourserviceplatform.entity.Ticket;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/checkin")
public class CheckinController extends HttpServlet {

    @Inject
    private TicketProducer ticketProducer;

    @Inject
    private TicketService ticketService;

    @Inject
    private TicketDAO ticketDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ticket> tickets = ticketDAO.findAllTickets();
        request.setAttribute("tickets", tickets);
        request.getRequestDispatcher("checkin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ticketCode = request.getParameter("ticketCode");
        Timestamp checkinTime = new Timestamp(System.currentTimeMillis());
        ticketService.updateCheckinStatus(ticketCode, checkinTime);
        ticketProducer.sendTicketMessage(ticketCode);
        response.sendRedirect("checkin?success=true");
    }
}
