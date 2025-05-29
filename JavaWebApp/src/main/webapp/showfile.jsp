<%@page import="com.java.databasehelper.Datahelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"    %>
<%
Datahelper.connect();
ResultSet res = Datahelper.ShowFile();
while(res.next())
{%>
	<img src="upload/<%= res.getString(2)  %>" width="200" height="200" />
<%}


%>