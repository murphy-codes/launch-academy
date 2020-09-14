<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Donut Orders</title>
  </head>
  <body>
    <%
      Map<String, Integer> donutOrders = new HashMap<String, Integer>();
      donutOrders.put("Jennifer", 10);
      donutOrders.put("Alex", 1);
      donutOrders.put("Carly", 3);
      int totalDonuts = 0;
      List<String> donutNuts = new ArrayList<String>();

      Map<String, String> favDonuts = new HashMap<String, String>();
      favDonuts.put("Alex", "Maple");
      favDonuts.put("Carly", "Glazed");

    %>

    <h2>Donut Orders</h2>
    <p>As of: <%= (new java.util.Date()).toLocaleString() %></p>

    <ul>
    <% for(String employee: donutOrders.keySet()) { %>
      <li><%= employee %>:
      <% if (donutOrders.get(employee)>5) {
        donutNuts.add(employee);
        totalDonuts+=2;
        %> 2 <%
      } else{
        totalDonuts+=donutOrders.get(employee);
        %> <%= donutOrders.get(employee) %> <%
      } %>
       donut(s) <% if (favDonuts.containsKey(employee)) { %> (fav donut: <%= favDonuts.get(employee) %>) <% } %>
      </li> <%
    } %>
    </ul>

    <p>Total donuts: <%= totalDonuts %></p>





    <% if (donutNuts.size() != 0) { %>
      <p>Talk to the following people about not trying to game the donut system (and the perils of sugar crashes!): </p>
      <ul>
        <% for(String employee: donutNuts) {%>
          <li> <%= employee %> </li>
        <%} %>
      </ul>
    <% } %>





  </body>
</html>