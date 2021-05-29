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
				<div class="col-sm-7">
					<div class="p-3 mb-2 bg-light text-dark mt-3 border-bottom">
						Người dùng</div>
					<form action="/Final/admin/user/add" class="mb-2" method="get">
						<input type="submit" class="bg-primary text-white btn_hover"
							value="Thêm">
					</form>

					<form action="/Final/admin/user" method="post">
						<div class="form-group">
							<input type="text" name="searchName"> <input
								type="submit" class="bg-primary text-white btn_hover mb-2"
								value="Tìm">
						</div>
					</form>
					<table class="table table-hover" border="1">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Username</th>
								<th scope="col">Email</th>
								<th scope="col">Phone</th>
								<th scope="col">Address</th>
								<th scope="col">Role</th>
								<th scope="col">Option</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${users}" var="user">
								<tr>
									<td>${user.id}</td>
									<td>${user.username}</td>
									<td>${user.email}</td>
									<td>${user.phone}</td>
									<td>${user.address }</td>
									<td>${user.role }</td>
									<td><a href="/Final/admin/user/detail?id=${user.id}"><i
											class="fas fa-info"></i></a> | <a
										href="/Final/admin/user/delete?id=${user.id }"><i
											class="far fa-trash-alt"></i></a> | <a
										href="/Final/admin/user/edit?id=${user.id }"><i
											class="far fa-edit"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<!--Pagination-->
					<nav aria-label="..." class="d-flex justify-content-end">
						<ul class="pagination pagination-sm">
							<c:forEach begin="1" end="${endPage}" var="i">
								<c:choose>
									<c:when test="${i eq current }">
										<li class="page-item active"><a class="page-link"
											href="/Final/admin/user?pageIndex=${i}">${i}</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="/Final/admin/user?pageIndex=${i}">${i}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</body>
</html>