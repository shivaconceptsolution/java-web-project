<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login Form</h1>

<form action="LoginSer" method="post">
  <input type="text" name="uname" placeholder="Enter username" />
  <br/><br/>
  <input type="password" name="upass" placeholder="Enter password" />
  <br /><br/>
  <input type="submit" name="btnsubmit" value="Login" />
</form>
<br>

<br>
<%
if(request.getParameter("error")!=null)
{
	out.print(request.getParameter("error"));
}

%>
</body>
</html>