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
.container-fluid{
  padding: 16px;
  background-color: #eff0f5;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

.row {
	display: flex;
	justify-content: center;
}


input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

button {
	width:100%;
}

.signup{
	background: white;
	margin-bottom: 30px;
}

.form-label{
	font-size: 12px;
    height: 15px;
    line-height: 15px;
    overflow: hidden;
    color: #424242;
    display: block;
    margin-bottom: 5px;
    margin-top: 10px;
}

.signup__title {
	display: flex;
	justify-content: center;
	margin-top: 50px;
	margin-bottom: 15px;
}

.signup__title h2 {
	font-size: 22px;
	color: #424242;
	font-weight: 400;
}
</style>
</head>
<body>
	<jsp:include page="/view/client/common/header.jsp"></jsp:include>
	<div class="container-fluid">
	<div class="signup__title">
				<h2 class = "title">Create your Ustora Account</h2>
			</div>
		<div class="row">
			<div class="col-md-4 signup">
				<form action="/Final/signup"  method = "post">						
						<label class="form-label"><b>Name</b></label> 
						<input type="text" placeholder="Enter name" name="name" required> 	
						<label class="form-label"><b>Username</b></label> 
						<input type="text" placeholder="Enter username" name="username" required> 	
						<label class="form-label"><b>Password</b></label> 
						<input type="password" placeholder="Enter Password" name="password" required> 
						<label class="form-label"><b>Repeat Password</b></label> 
						<c:if test="${param.e != null }">
							<div class="alert alert-danger" role="alert">${param.e }</div>
						</c:if>
						<input type="password" placeholder="Repeat Password" name="repeatPassword" required> 
						<input type="checkbox" checked="checked" name="remember" style="margin-bottom: 15px">
							Remember me

						<p>
							By creating an account you agree to our <a href="#"
								style="color: dodgerblue">Terms & Privacy</a>.
						</p>

						<div class="clearfix">
							<button type="submit" class="signupbtn">Sign Up</button>
						</div>
					
				</form>
			</div>
		</div>

	</div>

	<jsp:include page="/view/client/common/footer.jsp"></jsp:include>
</body>
</html>