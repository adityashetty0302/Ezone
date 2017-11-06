<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<%@ include file="/WEB-INF/view/header.jsp"%>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
		<li data-target="#myCarousel" data-slide-to="3"></li>
	</ol>

	<!-- Wrapper for slides -->
	<div class="carousel-inner">
		<div class="item active">
			<img src="<c:url value="/resources/car1.jpg"/>" alt="car1">
			<div class="carousel-caption">
				<h2>Welcome to ezone</h2>
			</div>
		</div>

		<div class="item">
			<img src="<c:url value="/resources/car2.jpg"/>" alt="car2">
			<div class="carousel-caption">
				<h2>Mobiles</h2>
			</div>
		</div>

		<div class="item">
			<img src="<c:url value="/resources/car3.jpg"/>" alt="car3">
			<div class="carousel-caption">
				<h2>Laptops</h2>
			</div>
		</div>

		<div class="item">
			<img src="<c:url value="/resources/car4.jpg"/>" alt="car4">
			<div class="carousel-caption">
				<h2>Games</h2>
			</div>
		</div>

	</div>
</div>




<!-- Left and right controls -->
<a class="left carousel-control" href="#myCarousel" data-slide="prev">
	<span class="glyphicon glyphicon-chevron-left"></span> <span
	class="sr-only">Previous</span>
</a>
<a class="right carousel-control" href="#myCarousel" data-slide="next">
	<span class="glyphicon glyphicon-chevron-right"></span> <span
	class="sr-only">Next</span>
</a>
</div>

<br>
<br>
<%@ include file="/WEB-INF/view/footer.jsp"%>

