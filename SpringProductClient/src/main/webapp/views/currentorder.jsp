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
	<h1>Current Order</h1>
	<table border ="1">
				<tr>
					<th>Product</th>
					<th>Quantity</th>
					
				</tr>
				<c:forEach var="orderline" items="${order.orderLines}">
				<tr>
   					<td><c:out value="${orderline.product.productName}"/></td>
   					<td><c:out value="${orderline.quantity}"/></td>
   				</tr>
				</c:forEach>
				<tr><td></td><td></td></tr>
				<tr>
					<td>Total Amount</td>
					<td><c:out value="${order.getTotalAmount()}"/></td>
				</tr>
				
			</table>
			<form method="post" action="/addOrder"><input type="submit" value="Submit Order" /></form>
</body>
</html>