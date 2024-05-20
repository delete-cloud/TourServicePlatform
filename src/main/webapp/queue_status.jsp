<!DOCTYPE html>
<html>
<head>
    <title>Queue Status</title>
</head>
<body>
<h2>Queue Status</h2>
<c:forEach var="entry" items="${queueStatus}">
    <div>
        <h3>${entry.key}</h3>
        <p>Queue Length: ${entry.value}</p>
    </div>
</c:forEach>
</body>
</html>
