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
						Chi tiết</div>
					<form method="get" action="/Final/admin/billProduct/add">
						<div class="form-group mb-3">
							<input type="submit" class="bg-primary text-white btn_hover"
							value="Thêm">
						</div>
					</form>
					<table class="table table-hover" border="1">
						<thead>
							<tr>
								<th>ID</th>
								<th>BuyDate</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Product</th>
								<th>Image</th>
								<th>Option</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${billProducts }" var="billProduct">
								<tr>
									<td>${billProduct.id }</td>
									<td>${billProduct.bill.buyDate }</td>
									<td>${billProduct.quantity }</td>
									<td>${billProduct.price }</td>
									<td>${billProduct.product.name }</td>
									<td><img
										src="/Final/admin/product/download?url=${billProduct.product.image}"
										width="50" height="50"></td>
									<td><a
										href="/Final/admin/billProduct/delete?id=${billProduct.id}&billId=${billProduct.bill.id }&productId=${billProduct.product.id}&quantity=${billProduct.quantity}"><i
											class="far fa-trash-alt"></i></a> | <a
										href="/Final/admin/billProduct/edit?id=${billProduct.id }"><i
											class="far fa-edit"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
						<c:set var="total" value="${0}" />
						<c:forEach var="billProduct" items="${billProducts}">
							<c:set var="total" value="${total + billProduct.price * billProduct.quantity}" />
						</c:forEach>

						<tfoot>
							<tr>
								<td colspan="4">Total price</td>
								<td colspan="4" style="text-align: right;">${total}</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>