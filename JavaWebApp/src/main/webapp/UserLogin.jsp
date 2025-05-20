<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>User Login Form</h1>
<%
Cookie arr[] = request.getCookies();
String data1="",data2="";
for(int i=0;i<arr.length;i++)
{
     if(arr[i].getName().equals("ukey"))
     {
              data1 = arr[i].getValue();
     }
     if(arr[i].getName().equals("upass"))
     {
              data2 = arr[i].getValue();
     }

}
if(data1!="" && data2!="")
{
	  response.sendRedirect("usermodule/userdashboard.jsp");
}
%>
<form action="LoginUserSer" method="post">
  <input type="text" name="uname" placeholder="Enter username" />
  <br/><br/>
  <input type="password" name="upass" placeholder="Enter password" />
  <br /><br/>
  <input type="checkbox" name="remember" 
  <%
  if(data1!="" && data2!="")
  {
	  out.print("checked");
  }
  
  
  %>
  
     />Remember Me
  <br /><br />
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