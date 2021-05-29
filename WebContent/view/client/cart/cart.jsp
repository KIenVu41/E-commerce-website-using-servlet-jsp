<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/view/client/common/cssjs.jsp" />
<title>Cart</title>
<style>
.quantity {
	display: flex;
	box-sizing: border-box;
	justify-content: center;
}

.quantity-value {
	border: 1px solid black;
	width: 30px;
}

.quantity__decrease-btn {
	border: 1px solid black;
	width: 30px;
	background: #5a88ca;
}

.quantity__increase-btn {
	border: 1px solid black;
	width: 30px;
	background: #5a88ca;
}

.quantity__decrease-btn a, .quantity__increase-btn a {
	color: white;
	text-decoration: none;
}

.quantity__decrease-btn:hover, .quantity__increase-btn:hover {
	background: black;
}

.checkout__btn {
	margin-left: 320px;
	width: 100px;
	height:auto;
	background:#5a88ca;
	padding: 11px 20px;
}

.checkout__btn a{
	color:white;
	text-decoration: none;
}

.checkout__btn:hover{
	background: black;
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

	<div class="single-product-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="single-sidebar">
						<h2 class="sidebar-title">Search Products</h2>
						<form action="#">
							<input type="text" placeholder="Search products..."> <input
								type="submit" value="Search">
						</form>
					</div>

					<div class="single-sidebar">
						<h2 class="sidebar-title">Products</h2>
						<div class="thubmnail-recent">
							<img src="img/product-thumb-1.jpg" class="recent-thumb" alt="">
							<h2>
								<a href="single-product.html">Iphone 7 Plus</a>
							</h2>
							<div class="product-sidebar-price">
								<ins>$700.00</ins>
								<del>$800.00</del>
							</div>
						</div>
						<div class="thubmnail-recent">
							<img src="img/product-thumb-1.jpg" class="recent-thumb" alt="">
							<h2>
								<a href="single-product.html">Samsung galaxy J2</a>
							</h2>
							<div class="product-sidebar-price">
								<ins>$700.00</ins>
								<del>$800.00</del>
							</div>
						</div>
						<div class="thubmnail-recent">
							<img src="img/product-thumb-1.jpg" class="recent-thumb" alt="">
							<h2>
								<a href="single-product.html">Nokia 320</a>
							</h2>
							<div class="product-sidebar-price">
								<ins>$700.00</ins>
								<del>$800.00</del>
							</div>
						</div>
						<div class="thubmnail-recent">
							<img src="img/product-thumb-1.jpg" class="recent-thumb" alt="">
							<h2>
								<a href="single-product.html">Sony Xperia 2</a>
							</h2>
							<div class="product-sidebar-price">
								<ins>$700.00</ins>
								<del>$800.00</del>
							</div>
						</div>
					</div>

					<div class="single-sidebar">
						<h2 class="sidebar-title">Recent Posts</h2>
						<ul>
							<li><a href="#">Iphone 7</a></li>
							<li><a href="#">Iphone 7 Plus</a></li>
							<li><a href="#">Iphone 8</a></li>
							<li><a href="#">Samsung Note 8</a></li>
							<li><a href="#">Oppo F1</a></li>
						</ul>
					</div>
				</div>

				<div class="col-md-8">
					<div class="product-content-right">
						<div class="woocommerce">
							<table cellspacing="0" class="shop_table cart">
								<thead>
									<tr>
										<th class="product-remove">&nbsp;</th>
										<th class="product-thumbnail">&nbsp;</th>
										<th class="product-name">Product</th>
										<th class="product-price">Price</th>
										<th class="product-quantity">Quantity</th>
										<th class="product-subtotal">Total</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="total" value="${0}" />
									<c:forEach items="${sessionScope.cart}" var="entry">
										<tr class="cart_item">
											<td class="product-remove"><a title="Remove this item"
												class="remove" href="/Final/cart/delete?id=${entry.key }">×</a></td>

											<td class="product-thumbnail"><a
												href="single-product.html"><img width="145" height="145"
													alt="poster_1_up" class="shop_thumbnail"
													src="/Final/product/download?url=${entry.value.product.image }"></a></td>

											<td class="product-name">${entry.value.product.name }</td>

											<td class="product-price"><span class="amount">${entry.value.price}$</span>
											</td>

											<td class="product-quantity">
												<div class="quantity buttons_added">
													<div class="quantity__decrease-btn">
														<a
															href="/Final/cart/update?action=decrease&id=${entry.key }">-</a>
													</div>
													<div class="quantity-value">${entry.value.quantity }</div>
													<div class="quantity__increase-btn">
														<a
															href="/Final/cart/update?action=increase&id=${entry.key }">+</a>
													</div>
												</div>
											</td>

											<td class="product-subtotal"><span class="amount">${entry.value.quantity * entry.value.price}</span>
												<c:set var="total"
													value="${total + entry.value.quantity * entry.value.price}" />
											</td>
										</tr>
									</c:forEach>
									<tr>
										<td class="actions" colspan="6">
											<!--
                                                <div class="coupon">
                                                    <label for="coupon_code">Coupon:</label>
                                                    <input type="text" placeholder="Coupon code" value="" id="coupon_code" class="input-text" name="coupon_code">
                                                    <input type="submit" value="Apply Coupon" name="apply_coupon" class="button">
                                                </div>-->
											<div class = "checkout__btn">
												<a href="/Final/member/check-out?total=${total }">Checkout</a>
											</div>
										</td>
									</tr>
								</tbody>
							</table>

							<div class="cart-collaterals">


								<div class="cross-sells">
									<h2>You may be interested in...</h2>
									<ul class="products">
										<li class="product"><a href="single-product.html"> <img
												width="325" height="325" alt="T_4_front"
												class="attachment-shop_catalog wp-post-image"
												src="/Final/product/download?url=product-2.jpg">
												<h3>Ship Your Idea</h3> <span class="price"><span
													class="amount">£20.00</span></span>
										</a> <a class="add_to_cart_button" data-quantity="1"
											data-product_sku="" data-product_id="22" rel="nofollow"
											href="single-product.html">Select options</a></li>

										<li class="product"><a href="single-product.html"> <img
												width="325" height="325" alt="T_4_front"
												class="attachment-shop_catalog wp-post-image"
												src="/Final/product/download?url=product-4.jpg">
												<h3>Ship Your Idea</h3> <span class="price"><span
													class="amount">£20.00</span></span>
										</a> <a class="add_to_cart_button" data-quantity="1"
											data-product_sku="" data-product_id="22" rel="nofollow"
											href="single-product.html">Select options</a></li>
									</ul>
								</div>


								<div class="cart_totals ">
									<h2>Cart Totals</h2>

									<table cellspacing="0">
										<tbody>
											<tr class="cart-subtotal">
												<th>Cart Subtotal</th>
												<td><span class="amount">£${total }</span></td>
											</tr>

											<tr class="shipping">
												<th>Shipping and Handling</th>
												<td>Free Shipping</td>
											</tr>

											<tr class="order-total">
												<th>Order Total</th>
												<td><strong><span class="amount">£${total }</span></strong>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/view/client/common/footer.jsp"></jsp:include>
</body>
</html>