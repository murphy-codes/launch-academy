<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="order" value="${requestScope.order}" />

<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Update Bakery Order</title>
  </head>
  <body>
    <h1>Update an order</h1>
    <form action="/orders/update" method="post">
      <div>
        <label for="orderId">Username:</label>
        <input type="hidden" id="orderId" name="orderId" value="<c:out value="${order.id}"/>" readonly>
      </div>
      <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="<c:out value="${order.username}"/>" readonly>
      </div>
      <div>
        <label>Item name: <input type="text" name="itemName" value="<c:out value="${order.itemName}"/>" readonly> </label>
      </div>
      <div>
        <label>Item quantity: <input type="number" name="itemQuantity" value="<c:out value="${order.itemQuantity}"/>" readonly> </label>
      </div>
      <div>
        <label>Gluten Free: <input type="text" name="glutenFree" value="<c:out value="${order.glutenFree}"/>" readonly> </label>
      </div>
      <div>
        <label>Vegan: <input type="text" name="vegan" value="<c:out value="${order.vegan}"/>" readonly> </label>
      </div>
      <div>
        <img src=<c:out value="${order.itemImageURL}"/> alt="Item Image" width="50" height="50">
      </div>
      <div>
        <p>Order Status:<br>
          &nbsp;&nbsp;&nbsp;&nbsp;<label>Confirmed <input type="radio" name="status" value="confirmed" required checked> </label><br>
          &nbsp;&nbsp;&nbsp;&nbsp;<label>In progress <input type="radio" name="status" value="in progress" required> </label><br>
          &nbsp;&nbsp;&nbsp;&nbsp;<label>Completed <input type="radio" name="status" value="completed" required> </label><br>
          &nbsp;&nbsp;&nbsp;&nbsp;<label>Cancelled <input type="radio" name="status" value="cancelled" required> </label>
        </p>
      </div>
      <div>
        <input type="submit" value="Submit">
      </div>
    </form>
  </body>
</html>