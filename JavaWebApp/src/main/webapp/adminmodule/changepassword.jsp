<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../AdminChangePassword" method="post">
  <input type="text" name="uname" placeholder="Enter username" value="<%= session.getAttribute("ukey") %>" readonly="true"/>
  <br/><br/>
  <input type="password" name="upass" placeholder="Enter password" />
  <br /><br/>
  <input type="submit" name="btnsubmit" value="Change Password" />
</form>
</body>
</html>