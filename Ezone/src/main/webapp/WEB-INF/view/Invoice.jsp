
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

<title>Invoice</title>
</head>
<body>

	<%@ include file="/WEB-INF/view/header.jsp"%>

	<br>

	<div class="container">
		<div class="row main">

			<h1>Your order has been placed!</h1>
			<br>
			<h1>Order Details</h1>

			<br>
			<div class='form-row'>
				&emsp;<label class='control-label'>Customer Name: </label>&nbsp;${userModel.name}
			</div>
			<div class='form-row'>
				&emsp;<label class='control-label'>Customer Email: </label>&nbsp;${userModel.email}
			</div>
			<div class='form-row'>
				&emsp;<label class='control-label'>Customer Phone: </label>&nbsp;${userModel.phone}
			</div>
			<div class='form-row'>
				&emsp;<label class='control-label'>Shipping Address: </label>&nbsp;${userModel.address}
			</div>

			<div class='form-row'>
				&emsp;<label class='control-label'>Amount Payable: </label>&nbsp;&#8377;
				${gtot}
			</div>
			<div class='form-row'>
				&emsp;<label class='control-label'>Date of Delivery:
					Delivered within 7 working days</label>
			</div>
			<br>
			<h2>Thank you for shopping with us!</h2>
			<br> <a class="btn btn-primary navbar-inverse btn-lg"
				href="${pageContext.request.contextPath}/productlist">Continue
				Shopping</a> <a class="btn btn-primary navbar-inverse btn-lg"
				href="${pageContext.request.contextPath}/">Home</a>

		</div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>



	<%@ include file="/WEB-INF/view/footer.jsp"%>



</body>
</html>