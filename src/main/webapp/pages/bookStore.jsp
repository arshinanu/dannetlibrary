<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="red">
<h1>Welcome To Nithu Books </h1>
<c:out value="${sessionScope.username}"/>
<p style="color:white;"> ${message}</p>
<table border="2">
<tr>
<th>Book id</th>
<th>Books</th>
<th>Bookname</th>
<th>Author</th>
<th>Contry</th>
<th>Language</th>
</tr>
  <form:form id="yourForm" action="/booking" method="POST" modelAttribute="mybooking">
<c:forEach items="${Book.book}" var="book1" varStatus="tagStatus">
  <tr>
  	
     	  	
    <td><input type = "checkbox" name = "bookid" value = ${book1.bookid}  /></td>
    <td>${book1.books}</td>
    <td>${book1.bookname}</td>
    <td>${book1.author}</td>
    <td>${book1.contry}</td>
    <td>${book1.language}</td>
  </tr>
</c:forEach>
</table>
<table>
	<tr>
		<td>
			<INPUT id="submit" name="submit" type="submit" value="Submit Items"/>
		</td>
	</tr>
	</form:form>
</table>
<td><a href="myprofiile">Retry for Myprofile</a></td>
</form>
</body>
</html>