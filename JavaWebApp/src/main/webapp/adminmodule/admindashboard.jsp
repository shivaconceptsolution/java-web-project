<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Expires","0");
response.setDateHeader("Expires",-1);

%>
</head>
<body>
<a href="../LogoutSer">Logout</a>
<%
if(session.getAttribute("isloggedin")==null)
{
	response.sendRedirect("../LoginForm.jsp");
}

%>
</body>
</html>