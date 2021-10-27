<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	   
<style>
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
<h2 align="center">Manage Details of The Site</h2>
<%
String name = (String)session.getAttribute("Name");
int id = (Integer)session.getAttribute("Id");
%>
<form action="UserDetails.do">

<table>
<tr>
<td><input type="hidden" value="<%=(name)%>" name="name"></td>
</tr>
<tr>
<td><input type="hidden" value="<%=(id)%>" name="id"></td>
</tr>
<tr>
<td><h4>Enter the site id for which you wish to verify &nbsp;</h4></td><td><h4><input type="text" name="sid"></h4></td>
</tr>
<tr>
<td><h4><input type="Submit" value="Submit"></h4></td><td><h4><input type="Reset" value="Reset"></h4></td>
</tr>
</table>
</form>
</body>
</html>