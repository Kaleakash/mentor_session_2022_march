<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login Page</h2>
<form action="LoginController" method="get">
<label>EmailId</label>
<input type="email" name="email" required><br/>
 <label>Password</label>
<input type="password" name="password" required><br/>
<input type="submit" value="SingIn">
<input type="reset" value="reset">
</form>
<a href="signUp.jsp">signUp</a>
</body>
</html>