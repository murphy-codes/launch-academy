<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="icons" value="${requestScope.icons}"/>
<c:set var="totals" value="${requestScope.totals}"/>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Java Spring Dice Roller - Batch Rolls</title>
  <meta name="description" content="Launch Academy - Coding Bootcamp - Assignment: Java Spring Dice Roller">
  <meta name="author" content="Tom Murphy">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
  <h1>LA Java Spring Dice Roller - Batch Dice Roller</h1
  <p>Rolled <c:out value="${requestScope.dieCount}"/> Die <c:out value="${requestScope.rollCount}"/> Time(s)</p>
  <c:out value="${requestScope.guess}" escapeXml="false"/>
  <c:forEach var="result" items="${requestScope.results}" varStatus="loop">
    <c:set var="index" value="${loop.index}"/>
    <li> <h2 style="display: inline; font-size: 1.125em;">Game <c:out value="${index+1}"/></h2><br>
      Roll(s): <c:out value="${icons.get(index)}" escapeXml="false"/><br>
      Total: <c:out value="${totals.get(index)}"/><br>
      Result: <c:out value="${result}" escapeXml="false"/>
    </li><br>
  </c:forEach>
  <p>Grand Total: <c:out value="${requestScope.grandTotal}"/></p>
  <br><br><a href="/">Return Home</a> | <a href="/rolls">Go to Rolls</a> | <a href="/batchRolls">Return to Batch Rolls</a>
</body>
</html>