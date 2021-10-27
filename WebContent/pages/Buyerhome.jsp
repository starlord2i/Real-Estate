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
<center><h2>Welcome ${requestScope.Name }</h2></center>
	<center><h2>Your ID: ${requestScope.Id }</h2></center>
	<% String name = (String)request.getAttribute("Name"); 
		int id= (Integer)request.getAttribute("Id");
		session.setAttribute("Id", id);
		session.setAttribute("Name", name);
	%>
	<table>
	<ol><tr><td><h2 style="clear:both;">Select Your Operation: </h2></td></tr>
		<tr><td><h3><li><a href="..\pages\Viewsite.jsp">Book a Site</a></li></h3></td></tr>
</ol>
	</table>
</body>
</html>