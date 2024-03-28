<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Book Store Administration</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div align="right">
		<p>
			Welcome, Administrator | <a href="">Logout</a>
		</p>
	</div>
	<hr width="60%">

	<h2 align="center">Administrative Dashboard</h2>
	
	<div align="center">
		<strong>
			<a href="ListUserServlet">Users</a> |
			<a href="">Categories</a> |
			<a href="">Books</a> |
			<a href="">Customers</a> |
			<a href="">Reviews</a> |
			<a href="">Orders</a> |
		</strong>
	</div>
	<hr width="60%">
	
	<div align="center">
		<h2>Recent Sales</h2>
		<hr width="60%">
	</div>
	
	<div align="center">
		<h2>Recent Reviews</h2>
		<hr width="60%">
	</div>
	
	<div align="center">
		<h2>Statistics</h2>
		<hr width="60%">
	</div>


	<jsp:include page="/pages/template/footer.jsp" />

</body>
</html>