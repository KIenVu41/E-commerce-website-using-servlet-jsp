<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	.bill__header{
		margin: 40px 0;
	}
</style>
</head>
<body>
	<jsp:include page="/view/client/common/header.jsp"></jsp:include>
	    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div class="p-3 mb-3 bg-light text-dark mt-4 border-bottom">
                    <h2 class = "bill__header">Bill Detail</h2></div>
               
                <table class="table table-hover" border="1">
						<thead>
							<tr>
								<th>ID</th>
								<th>BuyDate</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Product</th>
								<th>Image</th>
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
										src="/Final/product/download?url=${billProduct.product.image}"
										width="50" height="50"></td>
								</tr>
							</c:forEach>
						</tbody>
						<c:set var="total" value="${0}" />
						<c:forEach var="billProduct" items="${billProducts}">
							<c:set var="total" value="${total + billProduct.price}" />
						</c:forEach>

						<tfoot>
							<tr>
								<td colspan="4" style="text-align: center; font-weight: bold;">Total price</td>
								<td colspan="4" style="text-align: center; font-weight: bold;">${total}</td>
							</tr>
						</tfoot>
					</table>
            </div>
        </div>
    </div>
    <jsp:include page="/view/client/common/footer.jsp"></jsp:include>
</body>
</html>