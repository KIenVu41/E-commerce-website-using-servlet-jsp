<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.bill__header {
	margin: 40px 0;
}

table th {
 text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="/view/client/common/header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="p-3 mb-3 bg-light text-dark mt-4 border-bottom">
					<h2 class="bill__header">Order History</h2>
				</div>

				<table class="table table-hover" border="1" style = "text-align:center">
					<thead style = "text-align:center">
						<tr>
							<th>ID</th>
							<th>BuyDate</th>
							<th>TotalPrice</th>
							<th>Code</th>
							<th>Discount</th>
						 	<th>Option</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${bills }" var="bill">
							<tr>
								<td>${bill.id }</td>
								<td>${bill.buyDate }</td>
								<td>${bill.totalPrice }</td>
								<c:choose>
									<c:when test="${coupons != null }">
										<c:forEach items="${coupons }" var="coupon">
											<c:if test="${coupon.bill.id eq bill.id }">
												<td>${coupon.code}</td>
												<td>${coupon.percent }</td>
											</c:if>
											<c:if test="${coupon.bill.id != bill.id }">
												<td>0</td>
												<td>0</td>
											</c:if>
										</c:forEach>
									</c:when>							
							</c:choose>
							 <c:if test="${empty coupons}">
    							<td>0</td>
								<td>0</td>
    						</c:if>
							 <td><a href="/Final/member/order-history/detail?id=${bill.id }">
										Detail</a></td>								
							</tr>				
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="/view/client/common/footer.jsp"></jsp:include>
</body>
</html>