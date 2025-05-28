<%@page import="com.java.databasehelper.Datahelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"    %>
<%
ResultSet res = Datahelper.verifyEmail(request.getParameter("q").toString());
if(res.next())
{
	out.print("Email id already exist");
}
else
{
	out.print("");
}

%>