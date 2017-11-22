<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function submitForm() {
		var salary = document.getElementsByName("salary")[0].value;
		console.log('salary: ', salary);
		if (salary < 4000) {
			alert('salary should be > 4000');
			return false;
		}
	}
</script>
</head>
<body>
	<form action="<%=request.getContextPath() %>/employee" method="post" onsubmit="return submitForm()">
		Emp No : <input required="required" type="text" name="empNo" >
		Emp Name : <input required="required" type="text" name="empName">
		Salary : <input required="required" type="number" name="salary">
		<input type="submit"  	value="Create Employee">
	</form>
</body>
</html>