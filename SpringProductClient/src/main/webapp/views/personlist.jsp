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
	<h1>List of Persons</h1>
	<form method="get" action="/addPerson"><input type="submit" value="Add Person" /></form>
	<table border="1">
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Phone</th>
		<th>City</th>
		<th>State</th>
		<th>Zipcode</th>
		<th>Country</th>

	</tr>
	<c:forEach var="person" items="${persons}">
		<tr>
   			<td><c:out value="${person.firstName}"/></td>
   			<td><c:out value="${person.lastName}"/></td>
   			<td><c:out value="${person.email}"/></td>
   			<td><c:out value="${person.phone}"/></td>
   			<td><c:out value="${person.address.city}"/></td>
   			<td><c:out value="${person.address.state}"/></td>
   			<td><c:out value="${person.address.zipcode}"/></td>
   			<td><c:out value="${person.address.country}"/></td>
   			

   		</tr>
	</c:forEach>
	
	</table>
</body>
</html>