<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="orange">
<h1>Book Dash Board </h1>
<table border="2">
<tr>
<th>Book id</th>
<th>Total copies</th>
<th>Booked copies</th>
<th>Available copies</th>
</tr>
<c:forEach items="${Book.bookkeeping}" var="book1" varStatus="tagStatus">
  <tr>
    <td>${book1.bookid}</td>
    <td>${book1.totalcopies}</td>
    <td>${book1.bookedcopies}</td>
    <td>${book1.availablecopies}</td>
  </tr>
</c:forEach>
</table>
<h1>Order Dash Board </h1>
<table border="2">
<tr>
<th>Orderid</th>
<th>Book id</th>
<th>Aadharid</th>
<th>bookingdate</th>
<th>status</th>
</tr>
<c:forEach items="${Order.orderlist}" var="ord1" varStatus="tagStatus">
  <tr>
    <td>${ord1.orderid}</td>
    <td>${ord1.bookid}</td>
    <td>${ord1.aadharid}</td>
    <td>${ord1.bookingdate}</td>
    <td>${ord1.status}</td>
  </tr>
</c:forEach>
</table>
</body>
</html>