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
	<hr width="80%">

	<h2 align="center">Administrative Dashboard</h2>

	<div align="center">
		<strong> <a href="ListUserServlet">Users</a> | <a href="">Categories</a>
			| <a href="">Books</a> | <a href="">Customers</a> | <a href="">Reviews</a>
			| <a href="">Orders</a> |
		</strong>
	</div>
	<hr width="80%">

	<h2 align="center">Create New User</h2>

	<div align="center">

		<form action="SaveUserServlet" method="post">
			<table>
				<tr>
					<td><label>Name</label></td>
					<td><input type="text" name="name" required="required"></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><input type="email" name="email" required="required"></td>
				</tr>
				<tr>
					<td><label>Username</label></td>
					<td><input type="text" name="username" required="required"></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><input type="password" name="password" required="required" placeholder=""></td>
				</tr>
				<tr>
					<td><label>Role: </label></td>
					<td><input type="radio" name="role" value="ROLE_ADMIN"></td>
					<td><label>ADMIN</label></td>

					<td><input type="radio" name="role" value="ROLE_USER"></td>
					<td><label>USER</label></td>

					<td><input type="radio" name="role" value="ROLE_CUSTOMER"></td>
					<td><label>CUSTOMER</label></td>
				</tr>
				<tr>
					<td><label>Cellphone</label></td>
					<td><input type="text" name="cellphone" required="required"></td>
				</tr>
				<tr>
					<td><label>Zip Code</label></td>
					<td><input type="text" name="zipCode" required="required" /></td>
				</tr>
				<tr>
					<td><label>Public Place</label></td>
					<td><input type="text" name="publicPlace" required="required" /></td>
				</tr>
				<tr>
					<td><label>Complement</label></td>
					<td><input type="text" name="complement" required="required" /></td>
				</tr>
				<tr>
					<td><label>Neighborhood</label></td>
					<td><input type="text" name="neighborhood" required="required" /></td>
				</tr>
				<tr>
					<td><label>City</label></td>
					<td><input type="text" name="city" required="required" /></td>
				</tr>
				<tr>
					<td><label>UF</label></td>
					<td><input type="text" name="federativeUnit" required="required" /></td>
				</tr>
				<tr>
					<td><label>House Number</label></td>
					<td><input type="text" name="houseNumber" required="required"/></td>
				</tr>
				<tr>
					<td><label>Address Type: </label></td>

					<td><input type="radio" name="addressType" value="COMMERCIAL"></td>
					<td><label>COMMERCIAL</label></td>

					<td><input type="radio" name="addressType" value="RESIDENTIAL"></td>
					<td><label>RESIDENTIAL</label></td>

					<td><input type="radio" name="addressType" value="OTHER"></td>
					<td><label>OTHER</label></td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td><button type="submit">Save</button></td>
					<td><button type="reset">Cancel</button></td>
				</tr>
			</table>
		</form>
	</div>


	<jsp:include page="/pages/template/footer.jsp" />

<script type="text/javascript">
	
	
</script>
</body>
</html>