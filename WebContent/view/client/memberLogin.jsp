<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="/view/client/common/cssjs.jsp" />
<style>
.login {
	display: flex;
	justify-content: center;
	margin-bottom: 30px;
}

.container-fluid {
	background-color: #eff0f5;
}

.login .col-md-4 {
	background-color: white;
}

.username {
	margin: 20px 0;
}

.password {
	margin: 20px 0;
}

.form-check {
	margin: 20px 0;
}

button {
	width: 100%;
}

.login__title h2 {
	font-size: 22px;
	color: #424242;
	font-weight: 400;
}

.login__title {
	display: flex;
	justify-content: center;
	margin-top: 50px;
	margin-bottom: 15px;
}

.form-label{
	font-size: 12px;
    height: 15px;
    line-height: 15px;
    overflow: hidden;
    color: #424242;
    display: block;
    margin-bottom: 5px;
}
</style>
<title>Login</title>
</head>
<body>
	<jsp:include page="/view/client/common/header.jsp"></jsp:include>
	<div class="container-fluid">
			<div class="login__title">
				<h2 class = "title">Welcome to Ustora! Please login.</h2>
			</div>
		<div class="row login">
			<div class="col-md-4">
				<form method="post" action="/Final/login">
					<c:if test="${param.e != null }">
						<div class="alert alert-danger" role="alert">${param.e }</div>
					</c:if>
					<div class="username">
						<label for="exampleInputEmail1" class="form-label">Username</label>
						<input type="text" name="username" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Please enter your username">
					</div>
					<div class="password">
						<label for="exampleInputPassword1" class="form-label">Password</label>
						<input type="password" name="password" class="form-control"
							id="exampleInputPassword1" placeholder="Please enter your password">
					</div>
					<div class=" form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Check
							me out</label>
					</div>
					<div>
						<p>
							Dont have a account? <a href="/Final/signup">Signup here</a>
						</p>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>

	</div>

	<jsp:include page="/view/client/common/footer.jsp"></jsp:include>
</body>
</html>