<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="violations" value="${requestScope.violations}" scope="request" />
<c:set var="username" value="${requestScope.username}" scope="request" />

<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>New Bakery Order</title>
  </head>
  <body>
    <h1>Add a new order</h1>
    <form action="/orders" method="post">
      <div>
        <c:choose>
        <c:when test = "${not empty username}" >
          <input type="hidden" id="username" name="username" value="<c:out value="${username}"/>" readonly>
        </c:when>
        <c:otherwise>
          <label>Username: <input type="text" id="username" name="username" required></label>
        </c:otherwise>
        </c:choose>
      </div>
      <div>
        <label>Item name: <input type="text" name="itemName" required> </label>
      </div>
      <div>
        <label>Item quantity: <input type="number" name="itemQuantity" required> </label>
      </div>
      <div>
        <p>Gluten Free:
          <label>Yes <input type="radio" name="glutenFree" value="y"> </label>
          <label>No <input type="radio" name="glutenFree" value="n"> </label>
        </p>
      </div>
      <div>
        <p>Vegan:
          <label>Yes <input type="radio" name="vegan" value="y"> </label>
          <label>No <input type="radio" name="vegan" value="n"> </label>
        </p>
      </div>
      <div>
        <label>Item image URL: <input type="url" name="itemImageURL" required> </label>
      </div>
      <div>
        <input type="submit" value="Submit">
      </div>
    </form>
    <c:choose>
      <c:when test = "${not empty violations}" >
        <h2>Please fix the following errors: </h2>
        <c:forEach var="violation" items="${violations}">
          <li><c:out value="${violation.getPropertyPath().toString()}: ${violation.getMessage()}"/></li>
        </c:forEach>
      </c:when>
    </c:choose>
  </body>
</html>