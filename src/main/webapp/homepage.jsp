<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="me.kinaz.tourserviceplatform.entity.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
    } else {
%>
<h2>Welcome, ${user.username}!</h2>
<nav>
    <ul>
        <li><a href="scenic_spots">View Scenic Spots</a></li>
        <li><a href="reservations">Make a Reservation</a></li>
        <li><a href="add_ticket.jsp">Add New Ticket</a></li>
        <li><a href="checkin">Check-in</a></li>
        <li><a href="queue_status.jsp">View Queue Status</a></li>
        <li><a href="weather_info.jsp">View Weather Info</a></li>
        <li><a href="transport_routes.jsp">View Transport Routes</a></li>
        <li><a href="logout.jsp">Logout</a></li>
    </ul>
</nav>
<%
    }
%>
</body>
</html>
