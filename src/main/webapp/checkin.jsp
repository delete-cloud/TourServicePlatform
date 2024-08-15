<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="me.kinaz.tourserviceplatform.entity.Ticket" %>
<%--<%@ taglib uri="jakarta.tags.core" prefix="c" %>--%>
<!DOCTYPE html>
<html>
<head>
    <title>Checkin</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>All Tickets</h2>
<c:if test="${not empty tickets}">
    <ul>
        <c:forEach var="ticket" items="${tickets}">
            <li>
                Ticket Code: ${ticket.ticketCode}<br>
                Scenic Spot: ${ticket.scenicSpot.name}<br>
                User: ${ticket.user.username}<br>
                Checkin Status:
                <c:choose>
                    <c:when test="${ticket.checkedIn}">
                        Checked in at ${ticket.checkinTime}
                    </c:when>
                    <c:otherwise>
                        Not checked in
                    </c:otherwise>
                </c:choose>
                <br>
            </li>
        </c:forEach>
    </ul>
</c:if>

<h2>Checkin Ticket</h2>
<form action="checkin" method="post">
    <label for="ticketCode">Ticket Code:</label>
    <input type="text" name="ticketCode" id="ticketCode" required>
    <input type="submit" value="Checkin">
</form>

<a href="homepage.jsp">Back to Homepage</a>
</body>
</html>
