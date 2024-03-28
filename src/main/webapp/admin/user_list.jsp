<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Management Users  - Online Book Store Administration</title>
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
		<h2>
			<a href="user_form.jsp">Create new User</a>	
		</h2>
	</div>
	
	<div align="center">
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Username</th>
				<th>Contact</th>
				<th>Role</th>
				<th>Enabled</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach var="user" items="${ users }">
				<tr>
					<td> ${ user.id } </td>
					<td> ${ user.name } </td>
					<td> ${ user.email } </td>
					<td> ${ user.username } </td>
					<td> ${ user.cellphone } </td>
					<td> ${ user.role } </td>
					<td> ${ user.isActive } </td>
					<td>
						<a href="">Edit</a>
						&nbsp;
						<a href="">Delete</a>
					</td>
				<tr>
			
			</c:forEach>


			
		
		
		</table>
	</div>
	



	<jsp:include page="/pages/template/footer.jsp" />

</body>
</html>