<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type = "text/css" href="${pageContext.request.contextPath}/style/admin/css/login.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Login</title>
</head>
<body>	
	<div class="center">
		<h1>Login</h1>
		<c:if test="${param.e != null }">
			<div class="alert alert-danger" role="alert">
  				Tên đăng nhập hoặc mật khẩu không đúng
			</div>
		</c:if>
		<form action = "/Final/admin/login" method = "post">
			<div class="txt_field">
				<input type="text" name = "username" required>
				<label for="">Username</label>
			</div>
			<div class="txt_field">
				<input type="password" name = "password" required>
				<label for="">Password</label>
			</div>
			<div class="pass">Forgot password?</div>
			<input type="submit" value="Login">
			<div class="singup_link">
				Dont have a account? <a href="">Signup</a>
			</div>
		</form>
	</div>
</body>
</html>