<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Customer List</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="logout.jsp"></jsp:include>

<table style="width:60%">
    <tr>
        <th> Customer Id</th>
        <th> Customer Name</th>
        <th> Apartment No</th>
        <th> Street No</th>
        <th> Street Name</th>
        <th> City</th>
        <th> State</th>
        <th> Zip code</th>
    </tr>

    <c:forEach var="customer" items="${customersList}">
        <tr>
            <td> ${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.address.aptNo}</td>
            <td>${customer.address.streetNo}</td>
            <td>${customer.address.streetName}</td>
            <td>${customer.address.city}</td>
            <td>${customer.address.state}</td>
            <td>${customer.address.zip}</td>
        </tr>
    </c:forEach>
    <br>

</table>
</body>