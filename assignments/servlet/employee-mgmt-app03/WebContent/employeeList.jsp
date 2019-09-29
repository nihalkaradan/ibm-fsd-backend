<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,com.training.java.empapp.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% List <Employee>eList = (List)request.getAttribute("empList"); %>
	<table>
		<thead> 
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Salary</td>
				<td>Delete</td>
			</tr> 
		</thead>
		<tbody>
			<% for(Employee emp: eList) { %>
			<tr>
				<td><%= emp.getEmpId() %> </td>
				<td><%= emp.getEmpName() %> </td>
				<td><%= emp.getEmpSalary() %> </td>
				<td><a href="http://localhost:8080/employee-mgmt-app03/deleteemployee.do?id=<%=emp.getEmpId() %>">Delete</a> </td>
			</tr>
			<%} %>
		</tbody>
		</tbody>
	</table>
	<br>
	<a href="index.jsp">Back to Menu</a>
</body>
</html>