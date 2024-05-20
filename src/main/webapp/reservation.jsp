<!DOCTYPE html>
<html>
<head>
  <title>Reservation</title>
</head>
<body>
<h2>Reserve a Scenic Spot</h2>
<form action="reserve" method="post">
  <input type="hidden" name="scenicSpotId" value="${scenicSpotId}">
  Visit Time: <input type="text" name="visitTime" required><br>
  <input type="submit" value="Reserve">
</form>
</body>
</html>
