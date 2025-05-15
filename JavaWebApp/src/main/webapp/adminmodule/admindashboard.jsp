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
<ul>
<li><a href="../LogoutSer">Logout</a></li>
<li><a href="changepassword.jsp">Change Password</a></li>
<li><a href="deleteprofile.jsp">Delete Profile</a></li>
<li><a href="addsubadmin.jsp">Add Subadmin</a></li>
</ul>




<%
if(session.getAttribute("isloggedin")==null)
{
	response.sendRedirect("../LoginForm.jsp");
}

%>
</body>
</html>