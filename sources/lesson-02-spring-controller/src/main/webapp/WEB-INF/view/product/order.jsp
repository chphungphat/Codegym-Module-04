<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: reyon
  Date: 16/06/2023
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<h1>Products</h1>
<p><a href="/products">Products</a></p>
<p>There are ${orders.size()} products in this list.</p>
<table border="1">
    <tr>
        <td>Code</td>
        <td>Name</td>
        <td>Quantity</td>
        <td>Price</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.getId()}</td>
                <%--      <td><a href="/detail?id=${product.getId()}"> ${product.getName()}</a></td>--%>
            <td>${order.getName()}</td>
            <td>${order.getQuantity()}</td>
            <td>${order.getPrice() * order.getQuantity()}</td>
            <td>
                <a href="/orders/inc/${order.getId()}"><input type="button" value="increase"></a>
            </td>
            <td>
                <a href="/orders/dec/${order.getId()}"><input type="button" value="decrease"></a>
            </td>
            <td>
                <a href="/orders/delete/${order.getId()}"><input type="button" value="delete"></a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>Summary</td>
        <td colspan="6">${summary}</td>
    </tr>
</table>
</body>
</html>
