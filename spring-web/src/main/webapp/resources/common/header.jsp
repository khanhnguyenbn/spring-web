<%@page import="vn.topica.itlab4.springweb.model.UserModel"%>
<%@ page language="java" contentType="text/html; charset= UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
	
	<% UserModel user = (UserModel) session.getAttribute("user"); %>

<nav
	class="navbar navbar-icon-top navbar-expand-lg navbar-dark bg-dark ">
	<a class="navbar-brand" href="#">Navbar</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="/spring-web/web/product/home"> <i
					class="fa fa-home"></i> Home <span class="sr-only">(current)</span>
			</a></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user-circle"> </i> <%=user.getName() %>
			</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Sign in</a> <a
						class="dropdown-item" href="/spring-web/web/user/logout">Log
						out</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
		</ul>
		<ul class="navbar-nav ">
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fa fa-bell"> <span class="badge badge-info">11</span>
				</i> Test
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fa fa-globe"> <span class="badge badge-success">11</span>
				</i> Test
			</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0" method="post" action="/spring-web/web/product">
			<input class="form-control mr-sm-2" type="text" placeholder="Search"
				aria-label="Search" name = "productName">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
</nav>