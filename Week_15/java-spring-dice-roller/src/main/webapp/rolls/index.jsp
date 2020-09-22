<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>LA Java Spring Dice Roller - Dice Roller</h1>
<ul>
  <li><a href="/rolls/new">Roll 1d6</a></li>
  <li><a href="/rolls/new<c:out value="${requestScope.guess1d6}"/>">Guess 1d6</a></li>
  <li><a href="/rolls/new<c:out value="${requestScope.rollNd6}"/>">Roll/Guess nd6</a></li>
</ul>
<br><br><a href="/">Return Home</a> | <a href="/batchRolls">Go to Batch Rolls</a>