<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management System</title>
    <style type="text/css">
    body {
    font-family: Arial, sans-serif;
}

h1, h2 {
    color: #333;
}

button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}

#postJobForm, #viewJobApplications {
    margin-top: 20px;
}

table {
    width: 100%;
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid black;
    padding: 15px;
    text-align: left;
}

th {
    background-color: #4CAF50;
    color: white;
}
    
    </style>
</head>
<body>
<div class="toolbar">
		<h1>Employee Management System</h1>
		<a href="loglout"><button type="submit">Logout</button></a>
	</div>
   <form action="search">
		<div>
			<label for="search">Search Employee with Employee Role or Department :</label> <input type="text"
				id="search" name="employeerole" required>
			<button type="submit">Search</button>
		</div>
		</form>
		<table>
			<tr>
			    <th>Serial number</th>
				<th>Employee name</th>
				<th>Email</th>
				<th>Contact Number</th>
				<th>Date of Birth</th>
				<th>Gender</th>
				<th>Employee role</th>
				<th>Employee departmen</th>
				<th>Employee age</th>
				
			</tr>
			<c:forEach items="${Employee}" var="employee">
				<tr>
				    
				<td>${employee.slno}</td>
				<td>${employee.employeename}</td>
				<td>${employee.email}</td>
				<td>${employee.contactnumber}</td>
				<td>${employee.dateofbirth}</td>
				<td>${employee.gender}</td>
				<td>${employee.employeerole}</td>
				<td>${employee.employeedepartment}</td>
				<td>${employee.age}</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>
