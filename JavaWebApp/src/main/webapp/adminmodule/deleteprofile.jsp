<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.java.databasehelper.*,java.sql.*" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Datahelper.connect();
ResultSet res = Datahelper.getAdminData(session.getAttribute("ukey").toString());
if(res.next())
{

%>
<h1>Are you sure to delete profile</h1>
<form action="../DeleteAdminProfile" method="post">
  <input type="text" name="uname" placeholder="Enter username" value="<%= res.getString(1) %>" />
  <br/><br/>
  <input type="password" name="upass" placeholder="Enter password" value="<%= res.getString(2) %>" />
  <br /><br/>
  <input type="submit" name="btnsubmit" value="Delete" />
</form>

<%
}
%>
</body>
</html>