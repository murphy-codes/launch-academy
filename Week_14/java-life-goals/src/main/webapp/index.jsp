<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Hello from JSP</title>
  </head>
  <body>
    <h2>Life Goals</h2>
    
    <% List<String> goals = new ArrayList<String>();
      goals.add("Become Immortal");
      goals.add("Master traveling through time & space");
      goals.add("Travel the multiverse, learning all that I can");
      goals.add("Get slightly proficient at 3-27 programming languages");
      goals.add("Learn to play piano");
    %>

    <ul>
    <% for(String goal : goals) { %>
      <li> <%= goal %> </li>
    <% } %>
    </ul>
  </body>
</html>