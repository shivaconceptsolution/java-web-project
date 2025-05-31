<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"    %>
<%@page import="com.java.databasehelper.*" %>

<select >
<option value="">Select State</option>
<%
Datahelper.connect();
ResultSet res = Datahelper.showallstate(Integer.parseInt(request.getParameter("q")));
while(res.next())
{%>
	<option value="<%= res.getString(1)  %>"><%= res.getString(2)  %></option>
<%}


%>
</select>
