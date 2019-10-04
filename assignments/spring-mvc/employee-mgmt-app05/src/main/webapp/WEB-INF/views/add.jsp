<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add</title>
</head>
<body>
<form:form target="add" method="POST" modelAttribute="employee">
	<p>Enter Name: <form:input path="name" /> </p>
	<p>Enter Age: <form:input path="age" /> </p>
	<p>Enter Designation: <form:input path="desgn"/></p>
	<p>Enter Department: <form:input path="dept" /> </p>	
		<p>Enter Country: <form:input path="country" /> </p>	

	<p><button type="submit" value="Submit">Add</button>  </p>
</form:form>



</body>
</html>