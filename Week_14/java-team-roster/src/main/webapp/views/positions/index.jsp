<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Olympic Curling - All Positions</title>
  </head>
  <body>
    <h1>Olympic Curling - All Positions</h1>
    <ul>
      <c:forEach var="position" items="${requestScope.positions}" varStatus="loop">
        <li><a href="/position?name=${position}"><c:out value="${position}"/></a></li>
      </c:forEach>
    </ul>
  </body>
</html>