<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Customer New add</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="logout.jsp"></jsp:include>

<form:form commandName="customer" modelAttribute="customer" action="${contextPath}/customers/createCus" method="post">
    Name:  <form:input path="name"/> <br>
    Apt No: <form:input path="address.aptNo"/> <br>
    Street No: <form:input path="address.streetNo"/> <br>
    Street Name: <form:input path="address.streetName"/> <br>
    City: <form:input path="address.city"/> <br>
    State : <form:input path="address.state"/> <br>
    Zip: <form:input path="address.zip"/> <br>
    <input type="submit" value="Create" />
</form:form>
</body>