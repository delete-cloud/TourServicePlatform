package me.kinaz.tourserviceplatform.controller;

import me.kinaz.tourserviceplatform.service.QueueStatusService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/queueStatus")
public class QueueStatusController extends HttpServlet {
    @Inject
    private QueueStatusService queueStatusService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Integer> queueStatus = queueStatusService.getQueueStatus();
        request.setAttribute("queueStatus", queueStatus);
        request.getRequestDispatcher("queue_status.jsp").forward(request, response);
    }
}
