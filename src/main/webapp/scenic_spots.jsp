<!DOCTYPE html>
<html>
<head>
    <title>Scenic Spots</title>
</head>
<body>
<h2>Scenic Spots</h2>
<c:forEach var="spot" items="${scenicSpots}">
    <div>
        <h3>${spot.name}</h3>
        <p>${spot.description}</p>
        <img src="${spot.imageUrl}" alt="${spot.name}" width="200"><br>
        <a href="reserve?scenicSpotId=${spot.id}">Reserve</a>
    </div>
</c:forEach>
</body>
</html>
