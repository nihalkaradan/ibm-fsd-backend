<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Employee</h1>
<form action="http://localhost:8080/employee-mgmt-app03/addemployee.do">
	Enter name: <input type="text" name="empName" ></input>
	Enter Id:<input type="number" name="empId"></input>
	Enter Salary:<input type="number" name="empSalary"></input>
	
	
	<input type="submit" value ="Add">
</form>
</body>
</html>