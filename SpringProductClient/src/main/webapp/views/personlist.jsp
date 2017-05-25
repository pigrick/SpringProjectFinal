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
		<th>Zip code</th>
		<th>Country</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="pers" items="${persons}">
	<tr>
			<td><c:out value="${pers.firstName}" /></td>
   			<td><c:out value="${pers.lastName}" /></td>
   			<td><c:out value="${pers.email}" /></td>
   			<td><c:out value="${pers.phone}" /></td>
   			<td><c:out value="${pers.address.city}" /></td>
   			<td><c:out value="${pers.address.state}" /></td>
   			<td><c:out value="${pers.address.zipcode}" /></td>
   			<td><c:out value="${pers.address.country}" /></td>
   			<td>
   				<form method="get" action="/editPerson">
   					<input type="hidden" name="id" value="${pers.id}" />
   					<input type="submit" value="edit" />
   				</form>
   			</td>
   			<td>
   				<form method="post" action="/removePerson">
   					<input type="hidden" name="id" value="${pers.id}" />
   					<input type="submit" value="Remove" />
   				</form>
   			</td>
   	</tr>
	</c:forEach>
	
	</table>
</body>
</html>