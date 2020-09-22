<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Java Spring Dice Roller - Standard Rolls</title>
  <meta name="description" content="Launch Academy - Coding Bootcamp - Assignment: Java Spring Dice Roller">
  <meta name="author" content="Tom Murphy">
</head>
<body>
  <h1>LA Java Spring Dice Roller - Dice Roller</h1>
  <ul>
    <li><a href="/rolls/new">Roll 1d6</a></li>
    <li><a href="/rolls/new<c:out value="${requestScope.guess1d6}"/>">Guess 1d6</a></li>
    <li><a href="/rolls/new<c:out value="${requestScope.rollNd6}"/>">Roll/Guess nd6</a></li>
  </ul>
  <br><br><a href="/">Return Home</a> | <a href="/batchRolls">Go to Batch Rolls</a>
</body>
</html>