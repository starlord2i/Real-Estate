<%@page import="com.keane.training.domain.User"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>Insert title here</title>
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
<h2 align="center">List Of Available Buyers </h2>
<form action="sellsite.do">
<div class="container-fluid">
		<div class="table-responsive">
<table class="table">
<tr>
<th>Buyer Id</th><th>Buyer Name</th><th>Buyer Email</th><th>Buyer Contact</th>
</tr>
<%
List list1 = (List)request.getAttribute("List1");
Iterator itr = list1.iterator();
String name = (String)request.getAttribute("Name");
int id = (Integer) request.getAttribute("Id");
int sid = (Integer) request.getAttribute("sid");
while(itr.hasNext())
{
	User u = (User)itr.next();
%>
	<tr><td><%=(u.getId())%></td><td><%=(u.getName())%></td><td><%=(u.getEmail())%></td><td><%=(u.getContact())%></td></tr>
	<% } %>
</table>
</div>
</div>
<table>
<tr>
	<td><h4>Do You Wish to sell this site? &nbsp; </h4></td><td><h4><input type="radio" name="sell" value="Yes"> Yes 
								<input type="radio" name="sell" value="No"> No </h4></td>
</tr>
<tr>
<td><input type="hidden" value="<%=(name)%>" name="name"></td>
</tr>
<tr>
<td><input type="hidden" value="<%=(id)%>" name="id"></td>
</tr>
<tr>
<td><input type="hidden" value="<%=(sid)%>" name="sid"></td>
</tr>
<tr>
<td><h4><input type="Submit" value="Submit"></h4></td><td><h4><input type="Reset" value="Reset"></h4></td>
</tr>
</table>
</form>
</div>
</div>
</body>
</html>