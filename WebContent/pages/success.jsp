<%@page import="com.keane.training.domain.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

</form>
<font color="green" size="20">${requestScope.success }</font>
<table>
<ol>
		<tr><td><h3><li><a href="index.jsp">Click Here To Login</a></li></h3></td></tr>
</ol>
</table>
</div>
</div>
</body>
</html>