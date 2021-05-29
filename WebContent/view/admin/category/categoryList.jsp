<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/view/admin/common/cssjs.jsp"></jsp:include>
<title>Category</title>
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
					<div class="p-3 mb-2 bg-light text-dark mt-3 border-bottom">
						Danh mục</div>
					<form action="/Final/admin/category/add" class="mb-2" method="get">
						<input type="submit" class="bg-primary text-white btn_hover"
							value="Thêm">
					</form>

					<table class="table table-hover" border="1">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Option</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${categories}" var="category">
								<tr>
									<td>${category.id}</td>
									<td>${category.name}</td>
									<td><a
										href="/Final/admin/category/detail?id=${category.id}"><i
											class="fas fa-info"></i></a> | <a
										href="/Final/admin/category/delete?id=${category.id }"><i
											class="far fa-trash-alt"></i></a> | <a
										href="/Final/admin/category/edit?id=${category.id }"><i
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
											href="/Final/admin/category?pageIndex=${i}">${i}</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="/Final/admin/category?pageIndex=${i}">${i}</a></li>
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