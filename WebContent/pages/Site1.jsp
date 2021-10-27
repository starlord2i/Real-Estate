<%@page import="com.keane.training.dao.SiteDAO"%>
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
<h2 align="center">Book Site</h2>
<form action="booking.do">
<%
String choice = request.getParameter("sel");
String name= request.getParameter("name");
int id = Integer.parseInt(request.getParameter("id"));
SiteDAO s = new SiteDAO(); %>
<input type="hidden" value="<%=(choice)%>" name="choice">
<input type="hidden" value="<%=(name)%>" name="name">
<input type="hidden" value="<%=(id)%>" name="id">
<% 
if(choice.equalsIgnoreCase("Yes"))
{
	int sid = Integer.parseInt(request.getParameter("sid"));
	int res = s.getAvailability(sid);
	if(res!=0)
	{
%>
<input type="hidden" value="<%=(sid)%>" name="sid">	
		<h2>Site is available for booking</h2>
		
		<p><h4>Do you wish to book the site</h4></p><h4><input type="radio" name="avail" value="Yes"> Yes 
								<input type="radio" name="avail" value="No"> No </h4>
			<h4><input type="Submit"></h4><h4><input type="Reset"></h4>
		<%} else { %>
		<h2>Site Is not available for booking</h2><% } %>
<%} else
  { %>
  <p> Thank you</p>
  <% } %>
  </form>
  </body>
</html>