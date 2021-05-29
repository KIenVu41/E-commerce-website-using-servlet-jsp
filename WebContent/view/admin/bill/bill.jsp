<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/view/admin/common/cssjs.jsp"></jsp:include>
<title>Bill</title>
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
						Hóa đơn</div>
					<form method="post" action="/Final/admin/bill">
						<div class="form-group">
							<label>Từ</label> <input type="date" name="start" required="required"> <label>Đến</label>
							<input type="date" name="end" required="required"> <input type="submit"
								class="bg-primary text-white btn_hover mb-2" value="Tìm">
						</div>
					</form>
					<table class="table table-hover" border="1">
						<thead>
							<tr>
								<th>ID</th>
								<th>BuyDate</th>
								<th>TotalPrice</th>
								<th>User</th>
								<th>Option</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${bills }" var="bill">
								<tr>
									<td>${bill.id }</td>
									<td>${bill.buyDate }</td>
									<td>${bill.totalPrice }</td>
									<td>${bill.user.name }</td>
									<td><a href="/Final/admin/bill/detail?id=${bill.id }"><i
											class="fas fa-info"></i></a></td>
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
											href="/Final/admin/bill?pageIndex=${i}">${i}</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="/Final/admin/bill?pageIndex=${i}">${i}</a></li>
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