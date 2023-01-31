<%@page import="SchoolManagement.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Student>rs=(List)session.getAttribute("students"); %>
<table cellpadding="20px" border="1">
 <th>id</th>
  <th>name</th>
  <th>Strem</th>
   <th>fees</th>
   
    <%for(Student t: rs) {%>
 <tr align="center">
 <td><%= t.getId() %></td>
 <td><%= t.getName() %></td>
 <td><%= t.getStrem() %></td>
  <td><%= t.getFees() %></td>
 </tr>
 <%} %>
   
   
   
   
   
   </table>>
</body>
</html>