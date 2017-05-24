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
	<h1>Person Creation</h1>
	<form method="post" action="/addPerson">
		First Name: <input type="text" name="firstName" /><br/>
		Last Name: <input type="text" name="lastName" /><br/>
		Email: <input type="text" name="email" /><br/>
		Phone: <input type="text" name="phone" /><br/>
		Address: <br/>
		City: <input type="text" name="city" /><br/>
		State: <input type="text" name="state" /><br/>
		Zipcode: <input type="text" name="zipcode" /><br/>
		Country: <input type="text" name="country" /><br/>
		Enable: <input type="checkbox" name="enable" value="1"/>
		<br />
		<input type="submit" value="Create Product" />		
	</form>
</body>
</html>