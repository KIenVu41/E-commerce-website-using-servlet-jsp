<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.mobile-brand__list{
	padding-left:0;
	list-style: none;
}

.mobile-brand__list li {
	width: 258px;
	height: 40px;
}
.mobile-brand__list li a{
	color: #757575;
	font-weight: bold;
	padding: 8px 16px;
	text-decoration: none;
	font-size:18px;
}

.mobile-brand__list li:hover{
	color: #000;
	background-color: #ccc;
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
						<h2>Shop</h2>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="single-product-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<!-- 
			<div class="row">
				<div class="col-md-3">
					<div class="single-sidebar">
						<h2 class="sidebar-title">Search Products</h2>
						<form action="/Final/product/search" method="post">
							<input type="text" placeholder="Search products..."
								name="productName">
							<button type="submit">Search</button>
						</form>
					</div>
				</div>
			</div> -->


			<div class="row">
				<div class="col-md-3">
					<div class="single-sidebar">
						<h2 class="sidebar-title">Search Products</h2>
						<form action="/Final/product/search" method="post">
							<input type="text" placeholder="Search products..."
								name="productName">
							<button type="submit">Search</button>
						</form>
					</div>
					<div class = "mobile-brand">
                        <ul class = "mobile-brand__list">
                        	<li><a href="/Final/product/search?category=Apple">Apple</a></li>
							<li><a href="/Final/product/search?category=Sony">Sony</a></li>
							<li><a href="/Final/product/search?category=HTC">HTC</a></li>
							<li><a href="/Final/product/search?category=LG">LG</a></li>
							<li><a href="/Final/product/search?category=Nokia">Nokia</a></li>
							<li><a href="/Final/product/search?category=Samsung">Samsung</a></li>
                        </ul>
                    </div>
				</div>
				<div class="col-md-9">
					<c:forEach items="${products }" var="product">
						<div class="col-md-3 col-sm-6">
							<div class="single-shop-product">
								<div class="product-upper">
									<img src="/Final/product/download?url=${product.image }" alt="">
								</div>
								<h2>
									<a href="/Final/product/detail?id=${product.id }">${product.name }</a>
								</h2>
								<div class="product-carousel-price">
									<ins>${product.price }$</ins>
									<del>$999.00</del>
								</div>

								<div class="product-option-shop text-center">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="/Final/add-to-cart?productId=${product.id }">Add to cart</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="product-pagination text-center">
						<nav>
							<ul class="pagination">
								<li><a href="#" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
								<c:forEach begin="1" end="${endPage}" var="i">
									<c:choose>
										<c:when test="${i eq current }">
											<li class="page-item active"><a class="page-link"
												href="/Final/shop?pageIndex=${i}">${i}</a></li>
										</c:when>
										<c:otherwise>
											<li class="page-item"><a class="page-link"
												href="/Final/shop?pageIndex=${i}">${i}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<li><a href="#" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/view/client/common/footer.jsp"></jsp:include>
</body>
</html>