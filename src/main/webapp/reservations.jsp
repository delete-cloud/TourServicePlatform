<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="me.kinaz.tourserviceplatform.dto.ReservationDTO" %>
<%@ page import="me.kinaz.tourserviceplatform.entity.User" %>
<%@ page import="me.kinaz.tourserviceplatform.entity.ScenicSpot" %>
<%--<%@ taglib uri="jakarta.tags.core" prefix="c" %>--%>
<!DOCTYPE html>
<html>
<head>
    <title>Reservations</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<ReservationDTO> reservations = (List<ReservationDTO>) request.getAttribute("reservations");
    List<ScenicSpot> scenicSpots = (List<ScenicSpot>) request.getAttribute("scenicSpots");
%>

<h2>Your Reservations</h2>

<c:if test="${not empty reservations}">
    <ul>
        <c:forEach var="reservation" items="${reservations}">
            <li>
                Scenic Spot: ${reservation.scenicSpotName}<br>
                Description: ${reservation.scenicSpotDescription}<br>
                Image: <img src="${reservation.scenicSpotImageUrl}" alt="${reservation.scenicSpotName}" width="200"><br>
                Reservation Time: ${reservation.reservationTime}<br>
            </li>
        </c:forEach>
    </ul>
</c:if>

<c:if test="${empty reservations}">
    <p>You have no reservations.</p>
</c:if>

<h2>Make a New Reservation</h2>
<form action="reservations" method="post">
    <label for="scenicSpotId">Scenic Spot:</label>
    <select name="scenicSpotId" id="scenicSpotId" required>
        <c:forEach var="scenicSpot" items="${scenicSpots}">
            <option value="${scenicSpot.id}">${scenicSpot.name}</option>
        </c:forEach>
    </select>
    <br>
    <label for="reservationTime">Reservation Time:</label>
    <input type="datetime-local" name="reservationTime" id="reservationTime" required>
    <br>
    <input type="submit" value="Reserve">
</form>

<a href="homepage.jsp">Back to Homepage</a>
</body>
</html>
