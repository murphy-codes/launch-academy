<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>LA Java Spring Dice Roller - Batch Dice Roller</h1
<c:out value="${requestScope.guess}" escapeXml="false"/>
<c:forEach var="result" items="${results}" varStatus="loop">
  <c:set var="index" value="${loop.index}"/>
  <li> <h2 style="display: inline; font-size: 1.125em;">Game <c:out value="${index+1}"/></h2><br>
    Total: <c:out value="${rolls.get(index)}"/><br>
    Result: <c:out value="${result}" escapeXml="false"/>
  </li><br>
</c:forEach>
<p>Grand Total: <c:out value="${requestScope.total}"/></p>
<br><br><a href="/">Return Home</a> | <a href="/rolls">Go to Rolls</a> | <a href="/batchRolls">Return to Batch Rolls</a>