<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="/view/client/common/cssjs.jsp" />
<style>
.dropbtn {
	background-color: #f4f4f4;
	color: #888;
	padding: 16px;
	font-size: 13px;
	border: none;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #f4f4f4;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	opacity: 0.5
}

.user-menu ul li a{
	text-decoration: none;
}
</style>
<title>Header</title>
</head>
<body>
	<div class="header-area">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="user-menu">
						<ul>
							<c:if test="${sessionScope.memberLogin != null }">
								<div class="dropdown">
									<button class="dropbtn">
										<i class="fa fa-user"></i> My Account
									</button>
									<div class="dropdown-content">
										<a href="#">Profile</a> <a href="/Final/member/order-history">Order
											history</a> <a href="/Final/member/logout"><i
											class="fa fa-sign-out-alt"></i>Logout</a>
									</div>
								</div>
								<li><a href="#"><i class="fa fa-heart"></i> Wishlist</a></li>
								<li><a href="/Final/cart"><i class="fa fa-user"></i> My
										Cart</a></li>
								<li><a href="checkout.html"><i class="fa fa-user"></i>
										Checkout</a></li>
							</c:if>
							<c:if test="${ sessionScope.memberLogin eq null}">
								<li><a href="/Final/login"><i class="fa fa-user"></i>
										Login</a></li>
								<li><a href="/Final/signup"><i class="fa fa-user"></i>
										Sign up</a></li>
							</c:if>
							<li><a href="#"><i class="fa fa-user"></i>
										Customer care</a></li>
						</ul>
					</div>
				</div>

				<div class="col-md-4">
					<div class="header-right">
						<ul class="list-unstyled list-inline">
							<li class="dropdown dropdown-small"><a
								data-toggle="dropdown" data-hover="dropdown"
								class="dropdown-toggle" href="#"><span class="key">currency
										:</span><span class="value">USD </span><b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#">USD</a></li>
									<li><a href="#">INR</a></li>
									<li><a href="#">GBP</a></li>
								</ul></li>

							<li class="dropdown dropdown-small"><a
								data-toggle="dropdown" data-hover="dropdown"
								class="dropdown-toggle" href="#"><span class="key">language
										:</span><span class="value">English </span><b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#">English</a></li>
									<li><a href="#">French</a></li>
									<li><a href="#">German</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End header area -->

	<div class="site-branding-area">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="logo">
						<h1>
							<a href="./"><img
								src="${pageContext.request.contextPath}/style/client/img/logo.png"></a>
						</h1>
					</div>
				</div>

				<c:set var="total" value="${0}" />
				<c:forEach var="entry" items="${sessionScope.cart}">
					<c:set var="total" value="${total + 1}" />
				</c:forEach>

				<div class="col-sm-6">
					<div class="shopping-item">
						<a href="/Final/cart">Cart <i class="fa fa-shopping-cart"></i>
							<span class="product-count">${total }</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End site branding area -->

	<div class="mainmenu-area">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>

				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="/Final/shop">Shop page</a></li>
						<li><a href="cart.html">Cart</a></li>
						<li><a href="checkout.html">Checkout</a></li>
						<li><a href="#">Others</a></li>
						<li><a href="#">Contact</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End mainmenu area -->

</body>
</html>