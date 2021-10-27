<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="./css/Index.css">
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	   
<style>
body {
  		background-repeat: no-repeat;
   		background-position: center;
  		background-repeat: no-repeat;
  		background-size: cover;
 		position: relative;
    }
    
</style>
<title>Log Out</title>
</head>
<body>
 <p><center><h1>Real Estate Management System</h1></center></p><br><hr>
<body>
<div class="container">
		<div style="background-color:#D0DABA" style="background:transparent !important" class="jumbotron">

<h1>SUCCESSFULLY LOGGED OUT!!!!</h1>
<% session.invalidate(); %>
<h3><a href = "index.jsp">Redirect to Home page</a></h3>
</div>
</div>
</body>
</html>