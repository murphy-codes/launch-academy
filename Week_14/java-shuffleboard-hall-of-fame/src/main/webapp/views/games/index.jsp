<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Shuffleboard Hall of Fame</title>
  </head>
  <body>
    <h1>Shuffleboard Hall of Fame</h1>

    <table>
      <tr>
        <th>Red Team Player 1</th>
        <th>Red Team Player 2</th>
        <th>Red Team Score</th>
        <th>Blue Team Player 1</th>
        <th>Blue Team Player 2</th>
        <th>Blue Team Score</th>
        <th>Winner</th>
      </tr>
      <c:forEach items="${games}" var="game">
        <tr>
          <td><c:out value="${game.getRedTeamPlayer1()}"/></td>
          <td><c:out value="${game.getRedTeamPlayer2()}"/></td>
          <td><c:out value="${game.getRedTeamScore()}"/></td>
          <td><c:out value="${game.getBlueTeamPlayer1()}"/></td>
          <td><c:out value="${game.getBlueTeamPlayer2()}"/></td>
          <td><c:out value="${game.getBlueTeamScore()}"/></td>
          <td><c:out value="${game.getRedTeamScore() > game.getBlueTeamScore() ? 'Red' : 'Blue'}"/></td>
        </tr>
      </c:forEach>
    </table>

  </body>
</html>