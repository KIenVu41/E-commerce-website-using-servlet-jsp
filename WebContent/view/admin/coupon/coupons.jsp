<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/view/admin/common/cssjs.jsp"></jsp:include>
<title>Coupon</title>
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
						Coupon</div>
					<table class="table table-hover" border="1">
						<thead>
							<tr>
								<th>ID</th>
								<th>Code</th>
								<th>Discount</th>
								<th>User</th>
								<th>Bill</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${coupons }" var="coupon">
								<tr>
									<td>${coupon.id }</td>
									<td>${coupon.code }</td>
									<td>${coupon.percent }</td>
									<td>${coupon.user.id }</td>
									<td>${coupon.bill.id }</td>
									<td>${coupon.status }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>