<%@page import="vn.topica.itlab4.springweb.model.ProductModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset= UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="/spring-web/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/spring-web/resources/css/shop-homepage.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="/spring-web/resources/fontawsome/css/all.min.css">

</head>

<body>
	
	<%@include file="/resources/common/header.jsp" %>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3">

				<h1 class="my-4">Shop Name</h1>
				<div class="list-group">
				
					<c:forEach var="type" items="${types }">
						<a href="#" class="list-group-item">${type }</a> 
					</c:forEach>
				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid" src="/spring-web/resources/img/banner1.jpg"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="/spring-web/resources/img/banner2.jpg"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="/spring-web/resources/img/banner3.jpg"
								alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>

				<div class="row">

					<c:forEach var="product" items="${products }">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="/spring-web/web/product/${product.id }">
								<img class="card-img-top" src="${product.img }" alt=""></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="/spring-web/web/product/${product.id }">${product.name }</a>
									</h4>
									<h5>$${product.price }</h5>
									<p class="card-text">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit. Amet numquam aspernatur!</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733;
										&#9733; &#9734;</small>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="/spring-web/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="/spring-web/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
