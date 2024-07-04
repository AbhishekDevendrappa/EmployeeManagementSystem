<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
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

#Employeetable, #Managertable {
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

<h1>Well Come To Employee Management System</h1>

	<a href="getallemp" id="EmployeeDetails"><button>Employee
			Details</button></a>
	<a href="getallman" id="ManagerDetails"><button>Manager
			Details</button></a>
	<a href="logout" ><button>Log out</button></a>

	<div id="Employeetable">
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
			<c:forEach items="${emsg}" var="employee">
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

	</div>
	
	<div id="Managertable">
		<table>
			<tr>
				<th>Serial number</th>
				<th>Manager name</th>
				<th>Manager Email</th>
				<th>Contact Number</th>
			</tr>
			<c:forEach items="${manmsg}" var="employee">
				<tr>
					<td>${employee.slno}</td>
					<td>${employee.name}</td>
					<td>${employee.email}</td>
					<td>${employee.number}</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<script>
        $(document).ready(function() {
            $("#EmployeeDetails").click(function() {
                $("#Managertable").hide();
                $("#Employeetable").show();
            });

            $("#ManagerDetails").click(function() {
                $("#Employeetable").hide();
                $("#Managertable").show();
            });
        });
    </script>
	
</body>
</html>