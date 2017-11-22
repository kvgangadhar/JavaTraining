<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript">
        function onBtnClick(val) {
            //alert(btn.value);
            var paymentForm = document.getElementById("payment-form");
            paymentForm.method = 'get';
            if(val.id == "payment-create-button") {
                // add payments
                paymentForm.action = paymentForm.action + "/getPaymentAddMethod";
            } else if(val.id == "payment-view-button") {
                //  view the payment
                paymentForm.action = paymentForm.action + "/view";
                paymentForm.method = "get";
            }
            //alert(elem.action);
            paymentForm.submit();
        }
    </script>
</head>

<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="logout.jsp"></jsp:include>

<h2>Customer Information</h2>

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
    <br>

</table>

<br> <br>
<c:if test="${not empty paymentList}">
    <table style="width:60%">
        <tr>
            <th>PaymentId</th> <th>Card Name</th> <th>Card Number</th> <th>Card Type</th> <th>Date From</th>
        </tr>
        <c:forEach var="payment" items="${paymentList}">
            <tr>
                <td>${payment.id}</td>
                <td>${payment.cardName}</td>
                <td>${payment.cardNumber}</td>
                <td>${payment.cardType}</td>
                <td>${payment.dateFrom}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form id="payment-form" action="<%=request.getContextPath()%>/customers/${customer.id}">

    <c:if test="${empty paymentList}">
        <input id="payment-view-button" name="payment-view-submit" value="View payments" type="button"
               onclick="return onBtnClick(this);"/> <br>

    </c:if>
    <input id="payment-create-button" name="payment-create-submit" value="Add payments" type="button"
           onclick="return onBtnClick(this);"/> <br>
</form>
</body>
</html>