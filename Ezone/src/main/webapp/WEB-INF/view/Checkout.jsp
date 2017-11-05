
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

<title>Checkout</title>

<style>
.jumbotronTransp {
	padding: 2px;
	font-size: 21px;
	font-weight: 200;
	color: white;
	background-color: #323232;
}
</style>

</head>
<body>

	<%@ include file="/WEB-INF/view/header.jsp"%>


	<div class="container">
		<div class='row'>

			<div class='col-md-4'></div>
			<div class='col-md-4'>
				<div align="center">
					<h1>Checkout</h1>
				</div>
				<div class="col-sm-12 jumbotronTransp" align="center">
					<div class="head">
						<h4>Customer Details</h4>
					</div>
				</div>
				<div class='form-row'>
					&nbsp;&nbsp;<label class='control-label'>Name: </label>&nbsp;${userModel.name}
				</div>
				<div class='form-row'>
					&nbsp;&nbsp;<label class='control-label'>Email: </label>&nbsp;${userModel.email}
				</div>
				<div class='form-row'>
					&nbsp;&nbsp;<label class='control-label'>Phone: </label>&nbsp;${userModel.phone}
				</div>
				<div class='form-row'>
					&nbsp;&nbsp;<label class='control-label'>Address: </label>&nbsp;${userModel.address}
				</div>
				<div class='form-row'>
					&nbsp;&nbsp;<label class='control-label'>Country: </label>&nbsp;${userModel.country}
				</div>
				<div class="col-sm-12 jumbotronTransp" align="center">
					<div class="head">
						<h4>Payment Details</h4>
					</div>
				</div>
				<div class='form-row'>
					<div class='col-xs-12 form-group required'></div>
				</div>
				<div class='form-row'>
					<div class='col-xs-12 form-group required'>
						<label class='control-label'>Pay By</label> <select name="Payment">
							<option value="CD">Credit or Debit Card</option>
							<option value="COD">Cash on Delivery</option>
							<option value="NB">Net Banking</option>
						</select>
					</div>
				</div>

				<div class='form-row'>
					<div class='col-xs-12 form-group required'>
						<label class='control-label'>Name on Card</label> <input
							class='form-control' type='text'>
					</div>
				</div>
				<div class='form-row'>
					<div class='col-xs-12 form-group card required'>
						<label class='control-label'>Card Number</label> <input
							class='form-control card-number' type='text'>
					</div>
				</div>
				<div class='form-row'>
					<div class='col-xs-4 form-group cvc required'>
						<label class='control-label'>CVV</label> <input
							class='form-control card-cvc' placeholder='ex. 311' type='text'>
					</div>
					<div class='col-xs-4 form-group expiration required'>
						<label class='control-label'>Expiration</label> <input
							class='form-control card-expiry-month' placeholder='MM'
							type='text'>
					</div>
					<div class='col-xs-4 form-group expiration required'>
						<label class='control-label'> </label> <input
							class='form-control card-expiry-year' placeholder='YYYY'
							type='text'>
					</div>
				</div>


				<div class='form-row'>
					<div class='col-md-12 form-group'>
						<form action="${pageContext.request.contextPath}/invoice"
							method="post">
							<input type="hidden" value="${gtot}" name="gtot" />
							<tab4> <input
								class="form-control btn btn-primary navbar-inverse"
								type="submit" value="Pay
							Rs. ${gtot}"></tab4>
						</form>
					</div>
				</div>
				<div class='form-row'>
					<div class='col-md-12 form-group'>
						<a class='form-control btn btn-primary navbar-inverse'
							href="${pageContext.request.contextPath}/cart">Go to Cart</a>
					</div>
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


	<%@ include file="/WEB-INF/view/footer.jsp"%>



</body>
</html>