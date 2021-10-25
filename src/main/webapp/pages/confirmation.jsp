<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="red">

<table border="2" >

<h1 id="abc" > Dear <c:out value="${sessionScope.username}"/> your  ${message}</h1>
<tr>
<th>Book id</th>
<th>Books</th>
<th>Book name</th>
<th>Booking Date </th>
<th>Due Date</th>
<th>order ID</th>
</tr>

  <tr>
  
    <td>${booking1.bookid}</td>
    <td>${booking1.books}</td>
    <td>${booking1.bookname}</td>
    <td>${booking1.bookingdate}</td>
    <td>${booking1.endDate}</td>
     <td>${booking1.orderid}</td>
  </tr>
  </form>
</table>

</br>
<button id="b" onclick="buttonClick()">Clickhere</button>
</body>
<script type="text/javascript" src="/pages/confirmation.js"></script>
</html>