<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>




<html>
<head>
<title>Category-Frontend</title>
</head>
<body>

<form:form action="AddCategory" modelAttribute="catmodel" >
<table align="center" cellspacing="2">
	<tr>
		<td colspan="2">Category Module</td>
	</tr>
	<tr>
		<td>Category ID</td>
		<!--<td><input type="text" name="catId"/></td>-->
		<td><form:input path="catId"/></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<!-- <td><input type="text" name="catName"/></td> -->
		<td><form:input path="catName"/></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		<!-- <td><input type="text" name="catDesc"/></td> -->
		<td><form:input path="catDesc"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<center><input type="submit" value="Insert"/></center>
		</td>
	</tr>
</table>
</form:form>

<table cellspacing="2" align="center">
<tr bgcolor="red">
	<td>Category ID</td>
	<td>Category Name</td>
	<td>Category Description</td>
	<td>Update or Delete</td>
</tr>

<c:forEach var="catlist" items="${categoryList}">
<tr bgcolor="yellow">
<td>${catlist.catId}</td>
<td>${catlist.catName}</td>
<td>${catlist.catDesc}</td>
<td>
			<a href="<c:url value="deleteCategory${catlist.catId}"/>">DELETE</a>/
			<a href="<c:url value="updateCategory/${catlist.catId}"/>">UPDATE</a>
		</td>
</tr>
</c:forEach>
</table>
</body>
</html>