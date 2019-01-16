<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<h2 align="center">Product Record</h2>

			<div align="center">
			
				<table border="2">
					
					<tr>
						<th>Id</th><th>Name</th><th>Price</th><th>Description</th>
					</tr>
					
					<tr>
						<td>${product.id}</td><td>${product.name}</td><td>${product.price}</td><td>${product.description}</td>
					</tr>
						
				</table>
				
			</div>
</body>
</html>