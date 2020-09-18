<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Games Galore!</title>
  </head>

  <body>
    <h1>This is our form page!</h1>

    <form action="/games" method="post">
      <div>
        <label for="redTeamPlayer1">Red Team Player 1 Name</label>
        <input type="text" id="redTeamPlayer1" name="redTeamPlayer1" value="" />
      </div>
      <div>
        <label for="redTeamPlayer2">Red Team Player 2 Name</label>
        <input type="text" id="redTeamPlayer2" name="redTeamPlayer2" value="" />
      </div>
      <div>
        <label for="redTeamScore">Red Team Score</label>
        <input type="text" id="redTeamScore" name="redTeamScore" value="" />
      </div>
      <div>
        <label for="blueTeamPlayer1">Blue Team Player 1 Name</label>
        <input type="text" id="blueTeamPlayer1" name="blueTeamPlayer1" value="" />
      </div>
      <div>
        <label for="blueTeamPlayer2">Blue Team Player 2 Name</label>
        <input type="text" id="blueTeamPlayer2" name="blueTeamPlayer2" value="" />
      </div>
      <div>
        <label for="blueTeamScore">Blue Team Score</label>
        <input type="text" id="blueTeamScore" name="blueTeamScore" value="" />
      </div>

      <input type="submit" value="Add Your Game" />
    </form>
  </body>
 </html>