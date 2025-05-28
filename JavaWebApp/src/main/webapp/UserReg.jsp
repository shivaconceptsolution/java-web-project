<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function checkemail()
{
	var email = document.getElementById("email").value;
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	{
		if(xmlhttp.readyState==4 && xmlhttp.status==200)
			{
		if(xmlhttp.responseText.length>=28)
			{
		     document.getElementById("spemail").innerHTML = xmlhttp.responseText;
		     document.getElementById("email").focus();
			}
		else
			{
			 document.getElementById("spemail").innerHTML = "";
			 document.getElementById("mobile").focus();
			}
			}
	}
	xmlhttp.open("GET","verifyemail.jsp?q="+email,true);
	xmlhttp.send();
}

</script>
</head>
<body>
<h1>Reg Form</h1>

<form action="RegSer" method="post">
  <input type="text" name="uname" placeholder="Enter username" required/>
  <br/><br/>
  <input type="password" name="upass" placeholder="Enter password" required/>
  <br /><br/>
  <input type="text" name="email" id="email" placeholder="Enter email" required onblur="checkemail()" />
  <span id="spemail">
  
  </span>
  <br /><br/>
  <input type="text" name="mobileno" id="mobile" placeholder="Enter mobileno" required/>
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