<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-dark bg-primary">
	<!-- Navbar content -->
	<div class="container">
		<a class="navbar-brand" href="#"> <img
			src="${pageContext.request.contextPath}/style/admin/img/admin.png"
			width="50" height="50" alt="" width="30" height="24"> Admin
			panel
		</a>
		<div class="btn-group">
			<button type="button"
				class="btn bg-primary dropdown-toggle text-white"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<i class="fas fa-user"></i> Account
			</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="#">Setting</a> <a
					class="dropdown-item" href="#">Profile</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="/Final/admin/logout">Logout</a>
			</div>
		</div>
	</div>
</nav>