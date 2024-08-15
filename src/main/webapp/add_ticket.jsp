<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Ticket</title>
</head>
<body>
<h2>Add New Ticket</h2>
<c:if test="${param.success == 'true'}">
    <p style="color:green;">Ticket added successfully!</p>
</c:if>
<form action="add_ticket" method="post">
    <label for="ticketCode">Ticket Code:</label>
    <input type="text" id="ticketCode" name="ticketCode" required>
    <input type="submit" value="Add Ticket">
</form>
</body>
</html>
