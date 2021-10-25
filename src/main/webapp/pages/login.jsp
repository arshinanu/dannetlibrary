<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validSubmit(){
if (document.frm1.aadharid.value == ""){
alert ( "Please enter Login Name." );
document.frm1.aadharid.focus();
return false;
}
if (document.frm1.password.value == ""){
alert ( "Please enter password." );
document.frm1.password.focus();
return false;
}
alert ( "Welcome User" );
return true;
}
</script>
</head>
<body bgcolor="red">
<p style="color:white;">${message}</p>
<h3>please login</h3>
<form:form name="frm1"  method="POST" 
          action="/login" modelAttribute="login" onsubmit="return validSubmit();">
             <table border="1">
               
                <tr>
                    <td><form:label path="aadharid">
                      Aadhar Idr</form:label></td>
                    <td><form:input path="aadharid"/></td>
                </tr>
                <tr>
                    <td><form:label path="password" >
                      Password</form:label></td>
                    <td><form:input path="password" type="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
</body>
</html>