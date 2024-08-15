<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Scenic Spots</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Scenic Spots</h2>
<c:forEach var="scenicSpot" items="${scenicSpots}">
    <div>
        <h3>${scenicSpot.name}</h3>
        <p>${scenicSpot.description}</p>
        <img src="${scenicSpot.imageUrl}" alt="${scenicSpot.name}" width="200">
        <br>
        <a href="weather?scenicSpotId=${scenicSpot.id}">View Weather Info</a>
    </div>
</c:forEach>
</body>
</html>
