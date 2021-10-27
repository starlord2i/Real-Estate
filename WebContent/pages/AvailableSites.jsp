<%@page import="java.util.Iterator"%>
<%@page import="com.keane.training.domain.Site"%>
<%@page import="java.util.List"%>
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
<h2 align="center">List Of Available Sites </h2>
<form action="Site1.jsp">
<div class="container-fluid">
		<div class="table-responsive">
<table class="table">
<tr><th>Site ID</th><th>Property Type</th><th>Location</th><th>Amount</th><th>Purpose</th></tr>
<%
List list1 = (List)request.getAttribute("list1");
Iterator itr = list1.iterator();
String name = (String)request.getAttribute("Name");
int id = (Integer) request.getAttribute("Id");
while(itr.hasNext())
{
	int sid=0;
	Site s1 = (Site) itr.next();
	sid= s1.getSid(); %>
	<tr><td><%=(s1.getSid())%></td><td><%=(s1.getType())%></td><td><%=(s1.getLocation())%></td><td><%=(s1.getAmount())%></td><td><%=(s1.getPurpose())%></td></tr>
<% 
} 
%>
</table>
</div>
</div>
<table>
<tr>
<td><input type="hidden" value="<%=(name)%>" name="name"></td>
</tr>
<tr>
<td><input type="hidden" value="<%=(id)%>" name="id"></td>
</tr>
<tr>
<td><h4>Do you Wish to view if the site is available?</h4></td><td><h4><select name="sel" onchange="toggle()">
            <option value="Yes"> Yes</option>
            <option value="No"> No</option>
        </select></h4></td>
</tr>
<tr>

<td> <div id="cont" 
        style="display:block;
        border:solid 1px #CCC;padding:10px;">

        Enter Site id: <input type="text" name="sid" />
    </div></td>
 </tr>
<tr>
<td><input type="Submit"></td><td><input type="Reset">
</tr>
</table>
</form>
</div>
</div>
</body>
<script>
    function toggle() {
        var cont = document.getElementById('cont');
        if (cont.style.display == 'block') {
            cont.style.display = 'none';
        }
        else {
            cont.style.display = 'block';
        }
    }
</script>
</html>