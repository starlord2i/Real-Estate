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
<h2 align="center">Book The Site</h2>
<%
String name = (String)request.getAttribute("Name");
int id = (Integer) request.getAttribute("Id");
String choice = (String) request.getAttribute("choice");
int sid = (Integer) request.getAttribute("sid");
if(choice.equalsIgnoreCase("Yes"))
{
%>
<form action="BookUser.do">
<table>
<tr>
<td><h4>Enter Your Card Number: &nbsp; </h4> </td><td><h4><input type="text" name="cardno"></h4></td>
</tr>
<tr>
<td><h4>Enter the date(Enter in yyyy-mm-dd format)&nbsp;</h4></td><td><h4><input type="text" name="datebook"></h4></td>
</tr>
<tr>
<td><input type="hidden" value="<%=(sid)%>" name="sid"></td>
</tr>
<tr>
<td><input type="hidden" value="<%=(name)%>" name="name"></td>
</tr>
<tr>
<td><input type="hidden" value="<%=(id)%>" name="id"></td>
</tr>
<tr>
<td><input type="hidden" value="<%=(choice)%>" name="choice"></td>
</tr>
<tr>
<td><h4><input type="Submit" value="Submit"></h4></td><td><h4><input type="Reset" value="Reset"></h4></td>
</tr>
</table>
</form>
<% } else { %>
<a href="Login.jsp"></a>
<% } %>
</div>
</div>
</body>
</html>