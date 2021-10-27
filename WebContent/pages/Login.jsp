<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Insert title here</title>
</head>
<body>
<p><center><h1>Real Estate Management System</h1></center></p><br><hr>
<div class="container">
		<div style="background-color:#D0DABA" style="background:transparent !important" class="jumbotron">
<h2 align="center">Login</h2>
<form action="login.do">
<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
	</tr>
	 <div class="container">
	<tr>
		<td><h4>Email id</h4></td>
		<td><h4><input type="text" placeholder="Enter Username" name="email"></h4></td><br><br>
	</tr>
	
	<tr>
		<td><h4>password</h4></td>
		<td><h4><input type="Password" placeholder="Enter Password" name="password"></h4></td>
	</tr>

	<tr>
	<td><h4>Enter your Role:</h4></td><td><h4><select name="role">
				<option value="">Please Select Your Role</option>
				<option value="Buyer">Buyer</option>
				<option value="Seller">Seller</option>
				<option value="Admin">Admin</option>
	</select></h4></td>
	</tr>
	</br></br>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Login"></td>
	</tr>
	</div>
</table>
</form>
</div>
</div>
</body>
</html>