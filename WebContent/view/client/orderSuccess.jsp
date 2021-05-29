<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/view/client/common/cssjs.jsp" />
<title>Insert title here</title>
<style>
.background {
    background-color: #eff0f5;
}

.order {
	margin-top: 40px;
	height: auto;
	position: relative;
	margin-bottom: 50px;
}

.order__header--success {
	margin-left: 10px;
}

.order__p {
	width: 700px;
	line-height: 4rem;
	font-size: small;
	margin-bottom: 50%;
}

.order button {
	width: 140px;
	height: auto;
	cursor: pointer;
	background: #5a88ca;
	position: absolute;
	left: 16px;
	bottom: 100px;
}

.order button a {
	text-decoration: none;
	color: white;
}

.order button:hover {
	opacity: 0.9;
}
</style>
</head>
<body>
	<jsp:include page="/view/client/common/header.jsp"></jsp:include>
	<div class="product-big-title-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="product-bit-title text-center">
						<h2>Shopping Cart</h2>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container background">
		<div class="row order  mb-5 mt-5">
			<h2 class="order__header--success">Your order has been placed!</h2>
			<div class="col-md-4">
				<p class="order__p">
					Your order has been successfully processed!<br />You can view your
					order history by going to the <a>my account</a> menu and by
					clicking on <a href="/Final/member/order-history">history.</a><br /> Thank you for shopping with us
					online!
				</p>
				<button>
					<a href="/Final/shop">Continue shopping</a>
				</button>
			</div>
		</div>
	</div>
	
	<jsp:include page="/view/client/common/footer.jsp"></jsp:include>
</body>
</html>