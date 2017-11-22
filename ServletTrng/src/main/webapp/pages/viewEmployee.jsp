<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% if(request.getAttribute("employee") != null) { %>
	<table>
		<thead>
			<tr>
				<th>Employee Details</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Employee Id</td>
				<td>${employee.empId}</td>
			</tr>
			<tr>
				<td>First Name</td>
				<td>${employee.firstName}</td>
			</tr>
			<tr>
				<td>Last name</td>
				<td>${employee.lastName}</td>
			</tr>
			<tr>
				<td>Salary</td>
				<td>${employee.salary}</td>
			</tr>
		</tbody>
	</table>
	<% } %>
</body>
</html>