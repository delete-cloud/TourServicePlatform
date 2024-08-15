<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="me.kinaz.tourserviceplatform.entity.QueueStatus" %>
<%@ page import="me.kinaz.tourserviceplatform.entity.ServiceStation" %>
<%--<%@ taglib uri="jakarta.tags.core" prefix="c" %>--%>
<!DOCTYPE html>
<html>
<head>
    <title>Queue Status and Service Stations</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Queue Statuses</h2>
<c:if test="${not empty queueStatuses}">
    <ul>
        <c:forEach var="queueStatus" items="${queueStatuses}">
            <li>
                Scenic Spot: ${queueStatus.scenicSpot.name}<br>
                Queue Length: ${queueStatus.queueLength}<br>
                Last Updated: ${queueStatus.updatedTime}<br>
            </li>
        </c:forEach>
    </ul>
</c:if>

<h2>Service Stations</h2>
<c:if test="${not empty serviceStations}">
    <ul>
        <c:forEach var="serviceStation" items="${serviceStations}">
            <li>
                Name: ${serviceStation.name}<br>
                Description: ${serviceStation.description}<br>
                Type: ${serviceStation.type}<br>
                Scenic Spot: ${serviceStation.scenicSpot.name}<br>
            </li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>
