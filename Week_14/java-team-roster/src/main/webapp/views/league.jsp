<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Olympic Curling League - All Teams</title>
  </head>
  <body>
    <h1>Olympic Curling League - All Teams</h1>
    <ul>
      <c:forEach items="${requestScope.teams}" var="team" varStatus="loop">
        <li><a href="/team?teamIndex=${loop.index}"><c:out value="${team.getTeamName()}"/></a></li>
      </c:forEach>
    </ul>
  </body>
</html>