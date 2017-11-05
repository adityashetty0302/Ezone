
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>




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
hr {
	border: none;
	height: 1px;
	/* Set the hr color */
	color: #333; /* old IE */
	background-color: #333; /* Modern Browsers */
}

tab5 {
	padding-left: 27em;
}

tab4 {
	padding-left: 67em;
}
</style>


<title>Cart</title>
</head>
<body>

	<%@ include file="/WEB-INF/view/header.jsp"%>

	<br>

	<div class="container">
		<h1>Your Cart</h1>
	</div>

	<div class="container">
		<div class="row main">
			<div class="container-fluid">
				<div class="table-responsive">
					<table class="table table-hover " cellspacing="2" align="center">
						<thead bgcolor="#222">

							<tr>
								<th><font color="#FFFFFF">Product Name</font></th>
								<th><font color="#FFFFFF">Quantity</font></th>
								<th><font color="#FFFFFF">Price</font></th>
								<th><font color="#FFFFFF">Picture</font></th>
								<th><font color="#FFFFFF">Change Quantity</font></th>
								<th><font color="#FFFFFF">Total</font></th>
								<th><font color="#FFFFFF">Remove</font></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="cartlist" items="${cartlist}">
								<tr>
									<td>${cartlist.productName}</td>
									<td>${cartlist.quantity}</td>
									<td>${cartlist.price}</td>
									<td><img
										src="<c:url value="/resources/${cartlist.productId}.jpg"/>"
										width="100px" height="80px" /></td>
									<td>
										<form action="${pageContext.request.contextPath}/updateCart"
											method="post">
											<input type="hidden" value="${cartlist.productId}" name="pid" />
											<input type="hidden" value="${cartlist.price}" name="pPrice" />
											<input type="hidden" value="${cartlist.productName}"
												name="name" /> <input type="number" class="form-control"
												name="quant" required /> <br> <input
												class="btn btn-primary navbar-inverse" type="submit"
												value="Enter">
										</form>
									</td>
									<td><c:out
											value="Rs. ${ cartlist.price * cartlist.quantity }"></c:out></td>
									<td>
										<form action="${pageContext.request.contextPath}/deleteCart"
											method="post">
											<input type="hidden" value="${cartlist.productId}" name="pid" />
											<input class="btn btn-primary navbar-inverse" type="submit"
												value="Remove">
										</form>
									</td>
									<c:set var="gtot"
										value="${ gtot + cartlist.price * cartlist.quantity }"></c:set>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<hr
						style="height: 1px; border: none; color: #333; background-color: #333;" />
					<h2>
						&nbsp; Grand Total:
						<tab5>Rs. <c:out value="${gtot}"></c:out></tab5>
					</h2>
					<hr
						style="height: 1px; border: none; color: #333; background-color: #333;" />
					&nbsp;<a class="btn btn-primary navbar-inverse btn-lg"
						href="${pageContext.request.contextPath}/productlist">Continue
						Shopping</a>

					<c:if test="${not empty cartlist}">
						<form action="${pageContext.request.contextPath}/checkout"
							method="post">
							<input type="hidden" value="${gtot}" name="gtot" />
							<tab4>
							<input class="btn btn-primary navbar-inverse btn-lg"
								type="submit" value="Checkout"></tab4>
						</form>
					</c:if>

				</div>
			</div>
		</div>
	</div>


	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<%@ include file="/WEB-INF/view/footer.jsp"%>



</body>
</html>