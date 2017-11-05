
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
<title>Supplier-Frontend</title>
</head>
<body>

	<%@ include file="/WEB-INF/view/header.jsp"%>

	<div class="container">
		<div class="row main">
			<h2>Supplier Module</h2>
			<form:form
				action="${pageContext.request.contextPath}/admin/AddSupplier"
				class="form-horizontal" modelAttribute="suppmodel" method="post">
				<div class="form-group">
					<label class="control-label col-sm-2">Supplier ID:</label>
					<div class="col-sm-5">
						<form:input path="supId" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="pwd">Supplier
						Name:</label>
					<div class="col-sm-5">
						<form:input path="supName" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="pwd">Supplier
						Address</label>
					<div class="col-sm-5">
						<form:input path="supAdd" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary navbar-inverse">Insert</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>

	<br>
	<div class="container">
		<div class="row main">
			<table class="table table-hover " cellspacing="2" align="center">
				<thead bgcolor="#222">

					<tr>
						<th><font color="#FFFFFF">Supplier ID</font></th>
						<th><font color="#FFFFFF">Supplier Name</font></th>
						<th><font color="#FFFFFF">Supplier Address</font></th>
						<th><font color="#FFFFFF">Delete or Update</font></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="suplist" items="${supplierList}">
						<tr>
							<td>${suplist.supId}</td>
							<td>${suplist.supName}</td>
							<td>${suplist.supAdd}</td>
							<td><input type="button" class="btn btn-info navbar-inverse"
								value="Delete"
								onclick="location.href = '<c:url value="deleteSupplier${suplist.supId}"/>';">
								/ <input type="button" class="btn btn-info navbar-inverse"
								value="Update"
								onclick="location.href = '<c:url value="updateSupplier${suplist.supId}"/>';">
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<br>



	<br>
	<br>
	<br>


	<%@ include file="/WEB-INF/view/footer.jsp"%>

</body>
</html>
</body>
</html>