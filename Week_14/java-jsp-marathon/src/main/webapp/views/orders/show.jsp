<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="order" value="${requestScope.order}" />
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order for <c:out value="${order.username}"/></title>
  </head>
  <body>
    <h1>Order for <c:out value="${order.username}"/></h1>
    <h2>Order Info:</h2>
    <table>
      <tr>
        <th>Item Name</th>
        <th>Quantity</th>
        <th>Photo</th>
        <th>Options</th>
      </tr>
      <tr>
        <td><c:out value="${order.getItemName()}"/></td>
        <td><c:out value="${order.getItemQuantity()}"/></td>
        <td><img src=<c:out value="${order.getItemImageURL()}"/> alt="Item Image" width="50" height="50"></td>
        <td><c:out value="${order.getGlutenFree() == 'y' ? 'GF' : ''}"/>&nbsp;<c:out value="${order.getVegan() == 'y' ? 'V' : ''}"/></td>
      </tr>
    </table>
  </body>
</html>