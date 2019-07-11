<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="home" method="post">
		<input type="text" name="usrName" />
		<button type="submit">Send</button>
	</form>
	<h2>Add Employee</h2>
	<form action="addEmployee" method="post">
		ID: <input type="text" name="empID" type="text" />
		NAME: <input type="text" name="empName" type="text" />
		<button type="submit">Add</button>
	</form>
	
</body>
</html>