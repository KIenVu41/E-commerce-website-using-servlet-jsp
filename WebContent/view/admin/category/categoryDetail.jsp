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
					<div class="p-3 mb-2 bg-light text-dark mt-3 border-bottom">Chi
						tiết</div>
					<table class="table table-hover" border="1">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Name</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>${categoryDetail.id }</th>
								<th>${categoryDetail.name }</th>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>