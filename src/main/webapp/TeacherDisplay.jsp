<%@page import="SchoolManagement.Techer"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Techer>t=(List)session.getAttribute("teacher"); %>
<table cellpadding="20px" border="1">
  <th>Id</th>
  <th>Name</th>
  <th>Subject</th>
  <th>Sal</th>
  
 <% for(Techer s:t){%>
 <tr align="center">
 <td><%= s.getId() %></td>
 <td><%=s.getName() %></td>
 <td><%=s.getSubject() %></td>
 <td><%=s.getSal() %></td>
 </tr>
 <%} %>
 </table>
 

</body>
</html>