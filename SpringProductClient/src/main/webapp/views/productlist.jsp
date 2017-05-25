<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of products</h1>
	<form method="get" action="/createProduct"><input type="submit" value="Create Product" /></form>
	<form method="get" action="/currentorder"><input type="submit" value="Order Cart" /></form>
	<table border="1">
	<tr>
		<th>Product Name</th>
		<th>Price</th>
		<th>Order</th>
		<th>Update</th>
		<th>Delete</th>

	</tr>
	<c:forEach var="product" items="${products}">
		<tr>
   			<td><c:out value="${product.productName}"/></td>
   			<td><c:out value="${product.description}"/></td>
   			<td><c:out value="${product.price}"/></td>
  
   			<td>
   			<form method="post" action="/addOrderline">
   				<input type="hidden" name="productId" value="${product.id}" />
   				<input size="5" type="text" name="quantity" placeholder="Quantity" />
   			<input type="submit" value="Add to Order" /></form>
   			</td>
   			<td>
   			<form method="get" action="/editProduct">
   				<input type="hidden" name="id" value="${product.id}" />
   				<input type="submit" value="Edit" />
   			</form>   			
   			</td>
   			<td>
   			<form method="post" action="/removeProduct">
   				<input type="hidden" name="id" value="${product.id}" />
   				<input type="submit" value="Remove" />
   			</form>   			
   			</td>
   			
   			
   			

   		</tr>
	</c:forEach>
	
	</table>
</body>
</html>