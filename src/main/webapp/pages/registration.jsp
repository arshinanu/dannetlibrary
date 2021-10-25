<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Registration</title>
</head>
<body>
<div align="center">
<body bgcolor="cyan">
<p style="color:white;"> ${message}</p>
<h1> Welcome to Library Management System</h1>
   <form:form name="reg1" method="POST" 
          action="/registration" modelAttribute="registration">
             <table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="emailid">Emailid</form:label></td>
                    <td><form:input path="emailid" type="email"/></td>
                </tr>
                <tr>
                    <td><form:label path="aadharid">
                      Aadhar Idr</form:label></td>
                    <td><form:input id="aadhar" path="aadharid"/></td>
                </tr>
                <tr>
                    <td><form:label path="password" >
                      Password</form:label></td>
                    <td><form:input path="password" type="password"/></td>
                </tr>
                <tr>
                    <td><input onclick="validateReg()"  type="submit" value="Submit"/></td> </form:form>
                  <td>  <form action="login"><input type="submit" value="Go to Login" /> </form> </td>
                    
                </tr>
            </table>
        
      </div>     
     
       
</form>

</body>
<script type="text/javascript" src="/pages/registration.js"></script>
</body>
</html>