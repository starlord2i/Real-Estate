<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Yourself</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
h3 {
  display: inline-block;
}

body {
        background-color: 'Black;;
        font-family: 'Ubuntu', sans-serif;
         background-repeat: no-repeat;
   background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
    }
    
</style>

</head>
<body>
<center><p><h1>Real Estate Management System</h1></p></center><br><hr>
<div class="container">
		<div style="background-color:#D0DABA" style="background:transparent !important" class="jumbotron">
<h2 align="center">Register</h2>
<form action="register.do">
<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
	</tr>
	<tr>
		<td><h4>Name &nbsp;</h4></td>
		<td><h4><input type="text" name="name"></h4></td>
	</tr>
	<tr>
		<td><h4>Email Id&nbsp;</h4></td>
		<td><h4><input type="text" name="email"></h4></td>
	</tr>
	<tr>
		<td><h4>Password &nbsp;</h4></td>
		<td><h4><input type="password" name="pass"></h4></td>
	</tr>
	<tr>
		<td><h4>Phone No &nbsp;</h4></td>
		<td><h4><input type="text" name="phno"></h4></td>
	</tr>
	<tr>
		<td><h4>Enter your Role &nbsp; </h4></td>
		<td><h4><select name="role">
			<option value="">Enter your role</option>
			<option value="Buyer">Buyer</option>
			<option value="Seller">Seller</option>
			<option value="Admin">Admin</option>
		</select></h4></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><h4><input type="submit"
			value="Register"></h4></td>
	</tr>
</table>
</form>
</div>
</div>
</body>
</html>