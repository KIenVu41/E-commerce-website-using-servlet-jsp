<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/view/admin/common/cssjs.jsp"></jsp:include>
<title>User</title>
</head>
<body>
	<div class="container">
		<!-- navbar -->
		<jsp:include page="/view/admin/common/navbar.jsp"></jsp:include>

		<!-- main -->
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<jsp:include page="/view/admin/common/menu.jsp"></jsp:include>
				</div>
				<div class="col-sm-6">
					<div class="p-3 mb-2 bg-light text-dark mt-3 border-bottom">Thêm
						người dùng</div>
					<form action=""/Final/admin/user/add" method = "post">
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput" name = "name"
								required placeholder="Enter name"> <label
								for="floatingInput">Name</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput" name = "username"
								required placeholder="Enter username"> <label
								for="floatingInput">Username</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<input type="password" class="form-control" id="floatingInput" name = "password"
								required placeholder="Enter password"> <label
								for="floatingInput">Password</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput" name = "phone"
								required placeholder="Enter phone"> <label
								for="floatingInput">Phone</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput" name = "address"
								required placeholder="Enter address"> <label
								for="floatingInput">Address</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput" name = "email"
								required placeholder="Enter email"> <label
								for="floatingInput">Email</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="role" value = "admin"
								id="flexRadioDefault1" checked> <label
								class="form-check-label" for="flexRadioDefault1"> Admin
							</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="role" value = "member"
								id="flexRadioDefault2"> <label
								class="form-check-label" for="flexRadioDefault2"> Member
							</label>
						</div>
						<button type="submit" class="btn btn-primary mt-4 float-end w-25">Thêm</button>
					</form>
				</div>
			</div>
		</div>
</body>
</html>