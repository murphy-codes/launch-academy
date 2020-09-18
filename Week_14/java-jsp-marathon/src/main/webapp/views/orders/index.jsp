<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="orders" value="${requestScope.orders}" />

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Bakery</title>
  </head>
  <body>
    <ul>
      <c:forEach items="${orders}" var="order">
        <li><a href="/orders?orderId=${order.id}"> <c:out value="${order.itemName} for ${order.username}"/></a> - <a href="/orders/update?orderId=${order.id}">Update</a> | <a href="/orders/cancel?orderId=${order.id}">Delete</a></li>
      </c:forEach>
    </ul>
  </body>
</html>