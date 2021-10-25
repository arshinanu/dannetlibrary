<%@page import="java.net.http.HttpClient.Redirect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
</head>
<body>

<html>

<head>
<title>First Web Application</title>
</head>

<body bgcolor="red">
<% if(session.getAttribute("username")==null) { %>
<c:redirect url="/login" />
 <% } %>
   <h1> Welcome ${name}!! </br1></h1>
    <p id="abc"> <c:out value="${sessionScope.username}"/> </p>
     <form action="uploadFile.jsp">
    <input type="submit" value="Uload" />
</form>

</br>

<a href="bookStore">Retry for Bookstore</a></br>

<a href="myprofiile">Retry for Myprofile</a>
     
  <a href="logout">click for logout</a>   
<a href="search">Search for Books</a>   
  
  
</body>

</html>
 

</body>
</html>