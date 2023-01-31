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
<%List<Techer> rs=(List)session.getAttribute("teacher"); %>
<table cellpadding="20px" border="1">
 <th>id_no</th>
  <th>name</th>
  <th>sal</th>
   <th>Subject</th>
 
  
 <%for(Techer t: rs) {%>
 <tr align="center">
 <td><%= t.getId() %></td>
 <td><%= t.getName() %></td>
 <td><%= t.getSal() %></td>
  <td><%= t.getSubject() %></td>
 </tr>
 <%} %>
 </table>
 

</body>
</html>