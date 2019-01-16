<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

</head>
<body>
	<h2 align="center">Product Records</h2>

	<div align="center">

		<table border="2">

			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Description</th>
			</tr>

			<c:forEach items="${products}" var="product">

				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.description}</td>
				</tr>

			</c:forEach>

		</table>
	</div>
	<ul class="pagination pagination-sm">
		<li class="page-item"><a class="page-link"
			href="/springwebapp/productsbypage/1">1</a></li>
		<li class="page-item"><a class="page-link"
			href="/springwebapp/productsbypage/2">2</a></li>
		<li class="page-item"><a class="page-link"
			href="/springwebapp/productsbypage/3">3</a></li>
	</ul>

</body>
</html>