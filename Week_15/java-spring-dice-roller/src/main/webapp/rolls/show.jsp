<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>LA Java Spring Dice Roller - Dice Roller</h1>
<p>Die Rolled: <c:out value="${requestScope.dieCount}"/></p>
<p>Total: <c:out value="${requestScope.total}"/></p>
<c:out value="${requestScope.guess}" escapeXml="false"/>
<c:out value="${requestScope.result}" escapeXml="false"/>
<br><br><a href="/">Return Home</a> | <a href="/rolls">Return to Rolls</a> | <a href="/batchRolls">Go to Batch Rolls</a>