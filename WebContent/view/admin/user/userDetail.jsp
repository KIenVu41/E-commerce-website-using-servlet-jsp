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
				 	<div class="p-3 mb-2 bg-light text-dark mt-3 border-bottom">Chi tiết</div>
					<table class="table table-hover" border="1">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Name</th>
								<th scope="col">Username</th>
								<th scope="col">Email</th>
								<th scope="col">Phone</th>
								<th scope="col">Address</th>
								<th scope="col">Role</th>
								<th scope="col">Option</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${userDetail.id}</td>
								<td>${userDetail.name}</td>
								<td>${userDetail.username}</td>
								<td>${userDetail.password}</td>
								<td>${userDetail.email}</td>
								<td>${userDetail.phone}</td>
								<td>${userDetail.address }</td>
								<td>${userDetail.role }</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>