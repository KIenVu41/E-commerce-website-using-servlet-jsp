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
					<div class="p-3 mb-2 bg-light text-dark mt-3 border-bottom">Thêm
						sản phẩm</div>
					<form action="/Final/admin/product/add" method="post">
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput"
								name="productName" required placeholder="Enter name"> <label
								for="floatingInput">Name</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<input type="number" class="form-control" id="floatingInput"
								name="quantity" required placeholder="Enter quantity"> <label
								for="floatingInput">Quantity</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<input type="number" class="form-control" id="floatingInput"
								name="price" required placeholder="Enter price"> <label
								for="floatingInput">Price</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<select class="form-select" aria-label="Default select example"
								name="category">
								<option selected>Open this select menu</option>
								<option value="Apple">Apple</option>
								<option value="HTC">HTC</option>
								<option value="LG">LG</option>
								<option value="Nokia">Nokia</option>
								<option value="Samsung">Samsung</option>
								<option value="Sony">Sony</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary mt-4 float-end w-25">Thêm</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>