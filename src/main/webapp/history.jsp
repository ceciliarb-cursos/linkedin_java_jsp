<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>History</title>
</head>
<body>
    <fmt:setBundle basename="com.cecihero.onceagain.resources.applicationResources" var="msg"></fmt:setBundle>
    <c:if test="${requestScope.orders != null}">
        <h2><fmt:message bundle="${msg}" key="label.header.orders"></fmt:message></h2>
        <table>
            <tr>
                <td>Order no.</td>
                <td>Product name</td>
                <td>Order date</td>
                <td>Product image</td>
            </tr>
            <c:forEach items="${requestScope.orders}" var="order" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${order.productName}</td>
                <td><fmt:formatDate pattern="dd/MM/YYYY" value="${order.orderDate}"></fmt:formatDate></td>
                <td><img width="200px" height="150px" src="${order.imgPath}"></td>
            </tr>
            </c:forEach>
        </table>
    </c:if>
${orders}
</body>
</html>