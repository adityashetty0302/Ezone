
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>




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

	
<title>Product-Frontend</title>
</head>
<body>

<%@ include file="/WEB-INF/view/header.jsp" %>

<br>

<div class="container">
  	<div class="row main">
 <h2>Product Module</h2>
  <form:form action="AddProduct" class="form-horizontal" modelAttribute="prodmodel"  enctype="multipart/form-data" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2">Product ID:</label>
      <div class="col-sm-5">
        <form:input path="productId" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Product Name:</label>
      <div class="col-sm-5">          
        <form:input path="productName" class="form-control" />
      </div>
    </div>
      <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Product Desc:</label>
      <div class="col-sm-5">          
        <form:input path="productDesc" class="form-control" />
      </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Stock:</label>
      <div class="col-sm-5">          
        <form:input path="stock" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Price:</label>
      <div class="col-sm-5">          
        <form:input path="price" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Category</label>
      <div class="col-sm-5">          
        <form:select path="catName">
				<form:option value="0" label="---Select---"/>
				<form:options items="${categoryList}"/>
			</form:select>
      </div>
     
      </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Supplier</label>
      <div class="col-sm-5">          
        <form:select path="supName">
				<form:option value="0" label="---Select---"/>
				<form:options items="${supplierList}"/>
			</form:select>
      </div>
    </div>
    
     <div class="form-group">
      <label class="control-label col-sm-2" >Product Image:</label>
      <div class="col-sm-7">          
        <form:input type="file" path="pimage" class="form-control" />
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

<br>
<div class="container">
  	<div class="row main">
<table class="table table-hover " cellspacing="2" align="center">
<thead bgcolor="#222">

<tr>
	<th><font color="#FFFFFF">Product ID</font></th>
	<th><font color="#FFFFFF">Product Name</font></th>
	<th><font color="#FFFFFF">Product Description</font></th>
	<th><font color="#FFFFFF">Price</font></th>
	<th><font color="#FFFFFF">Stock</font></th>
	<th><font color="#FFFFFF">Category Name</font></th>
	<th><font color="#FFFFFF">Supplier Name</font></th>
	<th><font color="#FFFFFF">Picture</font></th>
	<th><font color="#FFFFFF">Delete or Update</font></th>
</tr>
 </thead>
 <tbody>
<c:forEach var="prodlist" items="${productList}">
<tr>
<td>${prodlist.productId}</td>
<td>${prodlist.productName}</td>
<td>${prodlist.productDesc}</td>
<td>${prodlist.price}</td>
<td>${prodlist.stock}</td>
<td>${prodlist.catName}</td>
<td>${prodlist.supName}</td>
<td>
<img src="<c:url value="/resources/${prodlist.productId}.jpg"/>" width="100px" height="80px"/>
</td>

<td>
	 <input type="button" class="btn btn-info navbar-inverse" value="Delete" onclick="location.href = '<c:url value="deleteProduct${prodlist.productId}"/>';">
	 <input type="button" class="btn btn-info navbar-inverse" value="Update" onclick="location.href = '<c:url value="updateProduct${prodlist.productId}"/>';">
</td>

</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
<br>


<%@ include file="/WEB-INF/view/footer.jsp" %>

</body>
</html>