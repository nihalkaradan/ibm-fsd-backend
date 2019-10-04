<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View</title>
</head>
<body>
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Age</th><th>Designation</th><th>Department</th><th>Country</th></tr>  
   <c:forEach var="emp" items="${elist}">   
   <tr>  
   <td>${emp.empId}</td>  
   <td>${emp.name}</td>  
   <td>${emp.age}</td>  
   <td>${emp.desgn}</td> 
   <td>${emp.dept}</td>
   <td>${emp.country}</td> 
<%--    <td><a href="editemp/${emp.id}">Edit</a></td>   --%>
<%--    <td><a href="deleteemp/${emp.id}">Delete</a></td>   --%>
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  

</body>
</html>
