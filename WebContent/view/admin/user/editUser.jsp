<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<div class="p-3 mb-2 bg-light text-dark mt-3 border-bottom">Sửa
						người dùng</div>
					<form action="/Final/admin/user/edit" method="post">
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput"
								name="id" required value="${user.id }" readonly="readonly">
							<label for="floatingInput">ID</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput"
								name="name" required value="${user.name}"> <label
								for="floatingInput">Name</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput"
								name="username" required value="${user.username}"> <label
								for="floatingInput">Username</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<input type="password" class="form-control" id="floatingInput"
								name="password" required value="${user.password }"> <label
								for="floatingInput">Password</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput"
								name="phone" required value="${user.phone }"> <label
								for="floatingInput">Phone</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput"
								name="address" required value="${user.address }"> <label
								for="floatingInput">Address</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput"
								name="email" required value="${user.email }"> <label
								for="floatingInput">Email</label>
						</div>
						<c:choose>
							<c:when test="${user.role eq 'admin' }">
								<div class="form-check">
									<input class="form-check-input" type="radio" name="role"
										value="admin" id="flexRadioDefault1" checked> <label
										class="form-check-label" for="flexRadioDefault1">
										Admin </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="role"
										value="member" id="flexRadioDefault2"> <label
										class="form-check-label" for="flexRadioDefault2">
										Member </label>
								</div>
							</c:when>
							<c:otherwise>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="role"
										value="admin" id="flexRadioDefault1"> <label
										class="form-check-label" for="flexRadioDefault1">
										Admin </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="role"
										value="member" id="flexRadioDefault2" checked> <label
										class="form-check-label" for="flexRadioDefault2">
										Member </label>
								</div>
							</c:otherwise>
						</c:choose>
						<button type="submit" class="btn btn-primary mt-4 float-end w-25">Sửa</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>