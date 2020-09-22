<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Java Spring Dice Roller - Batch Rolls</title>
  <meta name="description" content="Launch Academy - Coding Bootcamp - Assignment: Java Spring Dice Roller">
  <meta name="author" content="Tom Murphy">
</head>
<body>
  <h1>LA Java Spring Dice Roller - Batch Dice Roller</h1>
  <ul>
    <li><a href="/batchRolls/new<c:out value="${requestScope.nRollsNd6}"/>">Roll/Guess nd6 multiple times</a></li>
  </ul
  <br><br><a href="/">Return Home</a> | <a href="/rolls">Go to Standard Rolls</a>
</body>
</html>