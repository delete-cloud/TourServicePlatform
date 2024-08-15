<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Weather Information</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Weather Information</h2>

<!-- Form to select Scenic Spot ID for weather information -->
<form action="weather" method="get">
    <label for="scenicSpotId">Enter Scenic Spot ID:</label>
    <input type="text" id="scenicSpotId" name="scenicSpotId" required>
    <button type="submit">Get Weather Info</button>
</form>

<!-- Display weather information if available -->
<c:if test="${not empty weatherInfo}">
    <h3>Weather for Scenic Spot ID: ${weatherInfo.scenicSpotId}</h3>
    <p>Temperature: ${weatherInfo.temperature}</p>
    <p>Condition: ${weatherInfo.condition}</p>
    <a href="weather_info.jsp">Back to Weather Information</a>
</c:if>

<!-- Display an error message if any -->
<c:if test="${not empty errorMessage}">
    <p style="color:red;">${errorMessage}</p>
</c:if>

<a href="homepage.jsp">Back to Homepage</a>
</body>
</html>
