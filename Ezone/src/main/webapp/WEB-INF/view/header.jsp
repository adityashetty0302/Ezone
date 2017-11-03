<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<style>

.w3-dropdown-toggle {
   
    background-color: #222;
}



</style>
	
<title>Ezone</title>
</head>

<body>

	<nav id="navbar-red" class="navbar navbar-inverse navbar-static-top"
		role="navigation">
	<div class="container">
		<ul class="nav navbar-nav">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-nav">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
		</ul>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-nav">
		<ul class="nav navbar-nav">
			<li><a href="/Ezone"><img
					src="<c:url value="resources/logo.jpg"/>" alt=""
					height="20px" width="90px"></a></li>
			<li><a href="/Ezone">Home</a></li>
			<li><a href="${pageContext.request.contextPath}/productlist">View Products</a></li>
			
			<%-- <li class="w3-dropdown-hover"><a class="w3-dropdown-toggle"
				data-toggle="dropdown" href="drop">Product Category<span
					class="caret"></span></a>
				<div class="w3-dropdown-content w3-bar-block w3-card-4">
					<a href="productlist" class="w3-bar-item w3">All Products</a> 
						 <c:forEach var="catlist" items="${categoryList}">
							<a href="#" class="w3-bar-item w3">${catlist.catName}</a>
							</c:forEach>
		</div></li> --%>
		
		
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<li class="w3-dropdown-hover"><a class="w3-dropdown-toggle"
				data-toggle="dropdown" href="#">Admin Tools<span
					class="caret"></span></a>
				<div class="w3-dropdown-content w3-bar-block w3-card-4">
					<a href="${pageContext.request.contextPath}/admin/category" class="w3-bar-item w3">Category</a> 
					<a href="${pageContext.request.contextPath}/admin/supplier" class="w3-bar-item w3">Supplier</a> 
					<a href="${pageContext.request.contextPath}/admin/product" class="w3-bar-item w3">Product</a>
				    <!-- <a href="#" class="w3-bar-item w3">Edit Cart</a> -->
				</div></li>
				</security:authorize>
				
				
		</ul>
		<ul class="nav navbar-nav navbar-right">
		
			<security:authorize access="isAnonymous()">
			<li><a href="${pageContext.request.contextPath}/register"><span class="glyphicon glyphicon-user"></span>
					Sign Up</a></li>
			<li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li>
					</security:authorize>
					
					<security:authorize access="isAuthenticated()">
					
		<li class="w3-dropdown-hover">
					<a href="drop"
					class="w3-dropdown-toggle"
					data-toggle="dropdown" >
					
					${userModel.name}
					
					<span
					class="caret"></span></a>
		
		
		<div class="w3-dropdown-content w3-bar-block w3-card-4">
		<a href="${pageContext.request.contextPath}/logout" class="w3-bar-item w3">Logout</a> 
		</div>
		</li>
		
		</security:authorize>
		
		</ul>
		
		
		
		
		<%-- <form class="navbar-form navbar-left">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form> --%>
		
	</div>
	</nav>

	