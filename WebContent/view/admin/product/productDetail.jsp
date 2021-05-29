<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<div class="p-3 mb-2 bg-light text-dark mt-3 border-bottom">Chi
						tiết</div>
					<form action="/Final/admin/product/upload?id=${productDetail.id }"
						method="post" enctype="multipart/form-data">
						<div class="mb-3">
							<label for="formFile" class="form-label">Image</label> <input
								class="form-control" type="file" id="formFile" name="imageFile"
								accept="image/*">
						</div>
						<input type="submit" value="Upload">
					</form>
					<table class="table table-hover" border="1">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Image</th>
								<th>Category</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${productDetail.id }</td>
								<td>${productDetail.name }</td>
								<td>${productDetail.quantity }</td>
								<td>${productDetail.price }</td>
								<td><img
									src="/Final/admin/product/download?url=${productDetail.image }" height = "60" width = "60"></td>
								<td>${productDetail.category.id }</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>