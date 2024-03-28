<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:include page="template/header.jsp"/>

	<div align="center">
		<form action="../LoginServlet" method="post">

			<h3>Please, Sign In</h3>
			<label>Email: </label> <input type="email" required="required" name="email" /><br>
			<br> <label>Password: </label> <input type="password"
				required="required" name="password"/>

			<button type="submit">Login</button>
			<button type="reset">Cancel</button>
		</form>
	</div>

	<jsp:include page="template/footer.jsp"/>

</body>
</html>