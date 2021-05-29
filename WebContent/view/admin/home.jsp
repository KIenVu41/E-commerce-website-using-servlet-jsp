<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/view/admin/common/cssjs.jsp"/>
<style>
	p {
		font-size: 30px;
	}
</style>
<title>Admin</title>
</head>
<body>
  	<div class = "container">
  		<!-- navbar -->
  		<jsp:include page="/view/admin/common/navbar.jsp"></jsp:include>

  		<!-- main -->
  		<div class = "container">
  			<div class = "row">
  				<div class = "col-md-3">
  					<jsp:include page="/view/admin/common/menu.jsp"></jsp:include>
  				</div>
  				<div class = "col-sm-6">
  					<p>Welcome Admin!</p>
  				</div>
  			</div>
  		</div>
  	</div>
</body>
</html>