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
					<div class="p-3 mb-2 bg-light text-dark mt-3 border-bottom">Thêm
						danh mục sản phẩm</div>
					<form action="/Final/admin/billProduct/add" method="post">
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput"
								name="billId" value="${sessionScope.billId}" readonly="readonly"><label
								for="floatingInput">Bill ID</label>
						</div>

						<c:if test="${param.e != null }">
							<div class="alert alert-danger mt-3 mb-3" role="alert">Không
								đủ số lượng</div>
						</c:if>
						<div class="form-floating mt-3 mb-3">
							<input type="text" class="form-control" id="floatingInput"
								name="quantity" required placeholder="Enter quantity"> <label
								for="floatingInput">Quantity</label>
						</div>
						<div class="form-floating mt-3 mb-3">
							<select class="form-select" aria-label="Default select example"
								name="product">
								<option selected>Open this select menu</option>
								<option value="Samsung s7">Samsung s7</option>
								<option value="LG L8">LG L8</option>
								<option value="Sony Xperia 1">Sony Xperia 1</option>
								<option value="IPhone 7">IPhone 7</option>
								<option value="Samsung J2">Samsung J2</option>
								<option value="Nokia 320">Nokia 320</option>
								<option value="LG V2">LG V2</option>
								<option value="IPhone 8">IPhone 8</option>
								<option value="Sony Xperia 2">Sony Xperia 2</option>
								<option value="Samsung J5">Samsung J5</option>
								<option value="IPhone 6">IPhone 6</option>
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