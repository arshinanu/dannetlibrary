<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body bgcolor="red" >


<h1> Book Search</h1>
   <form:form id="searchform" method="POST" 
          action="/search" modelAttribute="books1">
             <table border="1">
                <tr>
                    <td><form:label path="bookid">Bookid</form:label></td>
                    <td><form:input path="bookid" /></td>
                </tr>
                <tr>
                    <td><form:label path="books">books</form:label></td>
                    <td><form:input path="books" /></td>
                </tr>
                <tr>
                    <td><form:label path="bookname">
                     Bookname</form:label></td>
                    <td><form:input path="bookname"/></td>
                </tr>
                <tr>
                    <td><form:label path="author" >
                      author</form:label></td>
                    <td><form:input path="author" /></td>
                </tr>
                <tr>
                    <td><form:label path="contry" >
                      country</form:label></td>
                    <td><form:input path="contry" /></td>
                </tr>
                <tr>
                    <td><form:label path="language" >
                      language</form:label></td>
                    <td><form:input path="language" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td> </form:form>
                 
                    
                </tr>
            </table>

<table border="2">
<tr>
<th>Book id</th>
<th>Books</th>
<th>Bookname</th>
<th>Author</th>
<th>Contry</th>
<th>Language</th>
</tr>
  <form:form id="displayform" action="/booking" method="POST" modelAttribute="mybooking">
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


</body>
</html>