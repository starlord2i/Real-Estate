<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		<form action="logout.jsp">
<div class="container">

<p align="right">
	<button type="Submit" class="btn btn-primary">Logout</button>
</p>
</div>
</form>
		<h2 align="center">View Sites</h2>
<form action="Buyer.do">
<%
String name = (String)session.getAttribute("Name");
int id = (Integer)session.getAttribute("Id");
%>
<table>
	<tr>
<td><h4>Enter the Property Type You Wish To View: &nbsp;</h4> </td><td><h4><select name="type">
				<option value="">Property Type</option>
				<option value="Plot">Plot</option>
				<option value="Home">Home</option>
				<option value="Apartment">Apartment</option>
	</select></h4></td>
</tr>
<tr>
<td><input type="hidden" value="<%=(name)%>" name="name"></td>
</tr>
<tr>
<td><input type="hidden" value="<%=(id)%>" name="id"></td>
</tr>
<tr>
<td><h4>Enter Your Location: &nbsp;  </h4></td><td><h4><input type="text" name="loc"></h4></td>
</tr>
<br><br>
<tr>
<td><h4>Enter Your Minimum Budget: &nbsp; </h4></td><td><h4><input type="text" name="mini"></h4></td>
</tr>
<br><br>
<tr>
<td><h4>Enter Your Maximum Budget: &nbsp; </h4></td><td><h4><input type="text" name="maxi"></h4></td>
</tr>
<br><br>
<tr>
	<td><h4>Enter The Purpose : &nbsp; </h4> </td><td><h4><input type="radio" name="pur" value="Selling"> Buying 
								<input type="radio" name="pur" value="Renting"> Renting</h4></td> 
</tr>
<br><br>
<tr>
<td><h4><input type="Submit" value="Submit"></h4></td><td><h4><input type="Reset" value="Reset"></h4></td>
</tr>
</table>
</form>
</div>
</div>
</body>
</html>