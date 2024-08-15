package me.kinaz.tourserviceplatform.controller;

import me.kinaz.tourserviceplatform.entity.QueueStatus;
import me.kinaz.tourserviceplatform.entity.ServiceStation;
import me.kinaz.tourserviceplatform.service.QueueStatusService;
import me.kinaz.tourserviceplatform.service.ServiceStationService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queue_status")
public class QueueStatusController extends HttpServlet {

    @Inject
    private QueueStatusService queueStatusService;

    @Inject
    private ServiceStationService serviceStationService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<QueueStatus> queueStatuses = queueStatusService.getAllQueueStatuses();
        List<ServiceStation> serviceStations = serviceStationService.getAllServiceStations();
        request.setAttribute("queueStatuses", queueStatuses);
        request.setAttribute("serviceStations", serviceStations);
        request.getRequestDispatcher("queue_status.jsp").forward(request, response);
    }
}
