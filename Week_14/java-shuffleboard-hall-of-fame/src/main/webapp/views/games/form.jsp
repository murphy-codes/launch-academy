<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Games Galore!</title>
  </head>
  <body>
    <h1>Shuffleboard Form</h1>
    <form action="/games" method="post">

    <div>
      <label>Red Team Player 1 Name: <input type="text" id="redTeamPlayer1" name"redReamPlayer1" value="" /></label>
    </div><br>
    <div>
      <label>Red Team Player 2 Name: <input type="text" id="redTeamPlayer2" name"redReamPlayer2" value="" /></label>
    </div><br>
    <div>
      <label>Red Team Player Score: <input type="text" id="redTeamScore" name"redReamScore" value="" /></label>
    </div><br>
    <div>
      <label>Blue Team Player 1 Name: <input type="text" id="blueTeamPlayer1" name"blueReamPlayer1" value="" /></label>
    </div><br>
    <div>
      <label>Blue Team Player 2 Name: <input type="text" id="blueTeamPlayer2" name"blueReamPlayer2" value="" /></label>
    </div><br>
    <div>
      <label>Blue Team Player Score: <input type="text" id="blueTeamScore" name"blueReamScore" value="" /></label>
    </div><br>

    <input type="submit" value="Add Your Game" />
    </form>
  </body>
</html>