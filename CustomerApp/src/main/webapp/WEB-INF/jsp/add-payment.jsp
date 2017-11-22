<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add New Payment</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="logout.jsp"></jsp:include>

<form:form commandName="payment" modelAttribute="payment" action="${contextPath}/customers/${customerId}/addPaymentMethod" method="post">
    Card name:  <form:input path="cardName"/> <br>
    Card No: <form:input path="cardNumber"/> <br>
    Card Type:  <form:select path="cardType">
    <form:option value="DEBIT_CARD" label="DEBIT_CARD"/>
    <form:option value="CREDIT_CARD" label="CREDIT_CARD"/>
</form:select>
    <br> <%--
    Date Issued: <form:input path="dateFrom"/> <br>  --%>
    Test Date: <input type="text" path="dateFrom" class= "date" name = "dueDate" value = "<fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />"/>
    <br>
    <input type="submit" value="Create" />
</form:form>
</body>