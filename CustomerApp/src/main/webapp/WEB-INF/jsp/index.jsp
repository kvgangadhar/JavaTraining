<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript">
        function onBtnClick(btn) {
            val = btn.value;
            // alert(val);
            if  (val == 'view-customers') {
                document.getElementById('CustomerForm').method='get';
                document.getElementById('CustomerForm').submit();
            }

            if  (val == 'create-customer') {
                document.getElementById('CustomerForm').method='post';
                document.getElementById('CustomerForm').submit();
            }

            if  (val == 'display-customer') {
                var dom = document.getElementById('CustomerForm');
                dom.method='get';
                //dom.action = dom.action +
                dom.submit();
            }
        }
	</script>
</head>

<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="logout.jsp"></jsp:include>

<h2>Welcome to the Customers page</h2>

<form id="CustomerForm" action="<%=request.getContextPath()%>/customers" method="get">

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<table>
		<tr>
			<th> Customer operations </th>
		</tr> <br>
		<tr><td>
			<%--
			<form action="<%=request.getContextPath()%>/customers/view" method="get">
		<input type="submit"  value="view-customers" name="View Customer" >
			</form>
			<form action="<%=request.getContextPath()%>/customers/create" method="get">
		<input type="submit"  value="create-customer" name="Create Customer">
			</form>
			<form action="<%=request.getContextPath()%>/customers/viewAll" method="get">
		<input type="submit"  value="display-customer" name="Display Customer">
			</form>
			--%>
		</td></tr>
		<br>

		<tr>
			<th> <a href="<%=request.getContextPath()%>/customers/view"> View Customers </a> </th>
		</tr>

		<tr>
			<th> <a href="<%=request.getContextPath()%>/customers/create"> Create Customer </a> </th>
		</tr>

		<tr>
			<th> <a href="<%=request.getContextPath()%>/customers/viewAll"> Shows All Customers </a> </th>
		</tr>

	</table>
</form>
</body>
</html>