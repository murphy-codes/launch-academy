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
        <th>Quantity</th>
        <th>Item Name</th>
        <th>Photo</th>
        <th>Options</th>
        <th>Status</th>
      </tr>
      <tr>
        <td><c:out value="${order.itemQuantity}"/></td>
        <td><c:out value="${order.itemName}"/></td>
        <td><img src=<c:out value="${order.itemImageURL}"/> alt="Item Image" width="50" height="50"></td>
        <td><c:out value="${order.glutenFree == 'y' ? 'GF' : ''}"/>&nbsp;<c:out value="${order.vegan == 'y' ? 'V' : ''}"/></td>
        <td><c:out value="${order.status}"/></td>
      </tr>
    </table>
  </body>
</html>