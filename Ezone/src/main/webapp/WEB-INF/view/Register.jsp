
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="com.model.Product"%>
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

<div class="container">
  	<div class="row main">
  	<h2>Registration Form</h2>
  <form:form action="AddUser" class="form-horizontal" modelAttribute="usermodel" method="post">
  
  
  <div class="form-group">
							<label for="name" class="control-label col-sm-1">Name</label>
							<div class="col-sm-5">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="name"  placeholder="Enter your Name"/>
								</div>
							</div>
						</div>
  
    <div class="form-group">
							<label for="email" class="control-label col-sm-1">Email</label>
							<div class="col-sm-5">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="email" id="email"  placeholder="Enter your Email"/>
								</div>
							</div>
						</div>

<div class="form-group">
							<label for="password" class="control-label col-sm-1">Password</label>
							<div class="col-sm-5">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
								</div>
							</div>
						</div>
						
						
						
						<div class="form-group">
							<label for="phone" class="control-label col-sm-1">Phone</label>
							<div class="col-sm-5">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-phone fa-lg" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="phone" id="phone"  placeholder="Enter your Phone No."/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="country" class="control-label col-sm-1">Country</label>
							<div class="col-sm-5">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-globe fa-lg" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="country" id="country"  placeholder="Enter Country"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="address" class="control-label col-sm-1">Address</label>
							<div class="col-sm-11">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-map-marker fa-lg" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="address" id="country"  placeholder="Enter your Address"/>
								</div>
							</div>
						</div>
						
						 <div class="form-group">        
      <div class="col-sm-offset-1 col-sm-10">
      	
        <button type="submit" class="btn btn-primary navbar-inverse">Submit</button>
         <button type="reset" class="btn btn-primary navbar-inverse">Cancel</button>
        
      </div>
    </div>
    
    </form:form>
    
    
    
</div>
</div>
	
<br>

<%@ include file="/WEB-INF/view/footer.jsp" %>

</body>
</html>