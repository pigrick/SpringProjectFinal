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
	<a href="/">Home</a>
	<h1>Product Creation</h1>
	<form method="post" action="/createProduct">
		Product Name: <input type="text" name="productName" /><br/>
		Description: <input type="text" name="description" /><br/>
		Price: <input type="text" name="price" /><br/>
		Product Type: <select name="productType">
			<option value="BREAKFAST">Breakfast</option>
			<option value="LUNCH">Lunch</option>
			<option value="DINNER">Dinner</option>
		</select>
		<br />
		<input type="submit" value="Create Product" />		
	</form>
</body>
</html>