<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<style>
	form {
  margin: 0 auto;
  width: 50%;
  background-color: #f2f2f2;
  padding: 20px;
  border-radius: 10px;
}

label {
  font-weight: bold;
  display: block;
  margin-bottom: 10px;
}

input[type="text"],
input[type="email"],
input[type="tel"],
input[type="date"],
input[type="number"],
select {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-bottom: 10px;
}

select {
  appearance: none;
  -webkit-appearance: none;
  -moz-appearance: none;
  background-position: right 10px center;
  background-repeat: no-repeat;
}

input[type="submit"] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type="submit"]:hover {
  background-color: #45a049;
}

input[type="checkbox"] {
  margin-right: 5px;
}

a {
  color: #4CAF50;
  text-decoration: none;
}

a:hover {
  text-decoration: underline;
}
.toolbar {
  background-color: #333; /* Change this to the background color you want for the toolbar */
  color: #fff; /* Change this to the font color you want for the toolbar */
  padding: 5px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.toolbar button {
  background-color: #007bff; /* Change this to the background color you want for the button */
  color: #fff; /* Change this to the font color you want for the button */
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
}

.toolbar button:hover {
  background-color: #0069d9; /* Change this to the background color you want for the button on hover */
}
	

</style>
</head>
<body bgcolor="#f0f6ff" align="center">
	<div class="toolbar">
    <h1>Employee Management System</h1>
    <h2>${um}</h2>
    <a href="loglout"><button type="submit">Logout</button></a>
    <a href="back3"><button type="submit">Back</button></a>
    </div>


	<form action="updatepage" method="post">
		
		<h2>Personal Information</h2>
		<input type="text" name="slno"  value="${r.slno}" placeholder="Sl no *" readonly="readonly" required>
		<label>Employee Name:</label> 
		<input type="text" id="employeename" name="employeename" pattern="[A-Z a-z]+"  value="${r.employeename}" required> <br>
		<br> 
		
		
		<label>Email:</label> <input type="email" id="email" name="email" pattern="[A-Za-z0-9]+@gmail.com" value="${r.email}" required> <br>
		<br> 
		
		<label>Contact Number:</label> 
		<input type="text" id="contactnumber" pattern="[0-9]{10}" name="contactnumber" value="${r.contactnumber}" required> <br>
		<br> 
		
		<label>Date of Birth:</label> 
		<input type="date" id="dateofbirth" name="dateofbirth" value="${r.dateofbirth}" required> <br>
		<br>
		
	    <label>Gender:</label> 
	    <select id="gender" name="gender" value="${r.gender}" required>
			 <option value="">Select Gender</option>
			<option value="male">Male</option>
			<option value="female">Female</option>
			<option value="other">Other</option>
		</select> <br>
		<br>

			<label>Employee Role:</label>
			<input type="text" id="employeerole" name="employeerole" pattern="[A-Z a-z]+"  value="${r.employeerole}" required> <br>
			<br>

			<label>Employee Department:</label>
			<input type="text" id="employeedepartment" name="employeedepartment" pattern="[A-Z a-z]+" value="${r.employeedepartment}" required> <br>
			<br>

			<label>Employee Age:</label>
			<input type="number" id="age" name="age" value="${r.age}" min="0" max="999999999" required> <br>
			<br>
			
		 <button type="submit" value="submit">Submit</button>
	</form>
</body>
</html>


