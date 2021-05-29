<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<div class="p-3 mb-2 bg-light text-dark mt-3 border-bottom">Thêm
						danh mục</div>
					<form action="" /Final/admin/category/add" method="post">
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput"
								name="categoryName" required placeholder="Enter name"> <label
								for="floatingInput">Name</label>
						</div>
						<button type="submit" class="btn btn-primary mt-4 float-end w-25">Thêm</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>