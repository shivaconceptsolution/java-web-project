<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Reg Form</h1>

<form action="RegSer" method="post">
  <input type="text" name="uname" placeholder="Enter username" />
  <br/><br/>
  <input type="password" name="upass" placeholder="Enter password" />
  <br /><br/>
  <input type="text" name="email" placeholder="Enter email" />
  <br /><br/>
  <input type="text" name="mobileno" placeholder="Enter mobileno" />
  <br /><br/>
  <input type="submit" name="btnsubmit" value="Registration" />
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