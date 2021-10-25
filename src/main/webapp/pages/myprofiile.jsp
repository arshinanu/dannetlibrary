<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC List of objects display</title>
</head>
<body bgcolor="red">
<table border="2">
<tr>
<th>Book id</th>
<th>Books</th>
<th>Book name</th>
<th>Booking Date </th>
<th>Due Date</th>
<th>order ID</th>
</tr>

<c:forEach items="${Mybooking.booking}" var="booking1" varStatus="tagStatus">
  <tr>
  
    <td>${booking1.bookid}</td>
    <td>${booking1.books}</td>
    <td>${booking1.bookname}</td>
    <td>${booking1.bookingdate}</td>
    <td>${booking1.endDate}</td>
    <td>
    <form action="returnbook" method="post" >
    <input value="${booking1.orderid}" name="orderid" readonly/>
   
    <input type="submit"  value="returnbook" /></td>
  </tr>
  </form>
</c:forEach>
</table>
<button id="b" onclick="buttonClick()">Clickhere</button>
</body>
<script type="text/javascript" src="/pages/myprofile.js"></script>
</body>
</html>