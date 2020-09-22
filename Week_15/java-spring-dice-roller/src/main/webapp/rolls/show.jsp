<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Java Spring Dice Roller - Standard Rolls</title>
  <meta name="description" content="Launch Academy - Coding Bootcamp - Assignment: Java Spring Dice Roller">
  <meta name="author" content="Tom Murphy">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
  <h1>LA Java Spring Dice Roller - Dice Roller</h1>
  <p>Die Rolled: <c:out value="${requestScope.dieCount}"/></p>
  <p>Roll(s): <c:out value="${requestScope.icons}" escapeXml="false"/></p>
  <p>Total: <c:out value="${requestScope.total}"/></p>
  <c:out value="${requestScope.guess}" escapeXml="false"/>
  <c:out value="${requestScope.result}" escapeXml="false"/>
  <br><br><a href="/">Return Home</a> | <a href="/rolls">Return to Rolls</a> | <a href="/batchRolls">Go to Batch Rolls</a>
</body>
</html>