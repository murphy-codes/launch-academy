<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Olympic Curling - Position <c:out value="${requestScope.position}"/></title>
  </head>
  <body>
    <h1>Olympic Curling - Position <c:out value="${requestScope.position}"/></h1>
    <h2>Players:</h2>
    <ul>
      <c:forEach var="player" items="${requestScope.players}">
        <li>${player.name} | Team: ${player.team}</li>
      </c:forEach>
    </ul>
  </body>
</html>