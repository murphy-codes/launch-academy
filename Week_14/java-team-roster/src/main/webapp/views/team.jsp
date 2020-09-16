<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Olympic Curling - Team <c:out value="${requestScope.teamName}"/></title>
  </head>
  <body>
    <h1>Olympic Curling - Team <c:out value="${requestScope.teamName}"/></h1>
    <h2>Players:</h2>
    <ul>
      <c:forEach items="${requestScope.players}" var="player">
        <li>${player.getPosition()}: ${player.getName()}</li>
      </c:forEach>
    </ul>
  </body>
</html>