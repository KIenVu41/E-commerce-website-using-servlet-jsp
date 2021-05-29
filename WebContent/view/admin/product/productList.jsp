<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/view/admin/common/cssjs.jsp"></jsp:include>
<title>Product</title>
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
						Sản phẩm</div>
					<form action="/Final/admin/product/add" class="mb-2" method="get">
						<input type="submit" class="bg-primary text-white btn_hover"
							value="Thêm">
					</form>

					<form method="post" action="/Final/admin/product/search">
						<div class="form-group">
							<input type="text" name="productName" required="required">
							<input type="submit" class="bg-primary text-white btn_hover mb-2"
								value="Tìm">
						</div>
					</form>
					<table class="table table-hover" border="1">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Category</th>
								<th>Image</th>
								<th>Option</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${searchProduct}" var="product">
								<tr>
									<td>${product.id}</td>
									<td>${product.name}</td>
									<td>${product.quantity}</td>
									<td>${product.price}</td>
									<td>${product.category.id}</td>
									<td><img
										src="/Final/admin/product/download?url=${product.image }"
										width="50" height="50"></td>
									<td><a
										href="/Final/admin/product/detail?id=${product.id }"><i
											class="fas fa-info"></i></a> | <a
										href="/Final/admin/product/delete?id=${product.id }"><i
											class="far fa-trash-alt"></i></a> | <a
										href="/Final/admin/product/edit?id=${product.id }"><i
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
											href="/Final/admin/product/search?pageIndex=${i}">${i}</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="/Final/admin/product/search?pageIndex=${i}">${i}</a></li>
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