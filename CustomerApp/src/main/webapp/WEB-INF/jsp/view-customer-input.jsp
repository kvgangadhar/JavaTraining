<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript">
        function onBtnClick(btn) {
            //alert(btn.value);
            var custId = document.getElementById("customer-id").value;
            var elem = document.getElementById("CustomerIDInputForm");
            elem.method = 'post';
            elem.action = elem.action + custId + "/view";
            //alert(elem.action);
            elem.submit();
        }
    </script>
</head>

<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="logout.jsp"></jsp:include>

<h2>Please enter your customer ID </h2>

<form id="CustomerIDInputForm" action="<%=request.getContextPath()%>/customers/" method="post">

    <input id="customer-id" name="customer-id" value="1" type="input"/> <br>
    <input id= "customer-id-button" name="customer-id-submit" value="customer-id-button" type="button" onclick="onBtnClick(this)"/> <br>

</form>
</body>
</html>