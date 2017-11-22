<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="coretag" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/pages/header.jsp"  %>
	<jsp:include page="/pages/employeeHeader.jsp"></jsp:include>
	
	<c:choose>
		<c:when test="${not empty param.action && param.action eq 'get' }">
			<jsp:include page="/pages/GetEmployee.jsp"></jsp:include>
		</c:when>
		<c:when test="${not empty param.action && param.action eq 'create' }">
			<jsp:include page="/pages/CreateEmployee.jsp"></jsp:include>
		</c:when>
	</c:choose>
</body>
</html>