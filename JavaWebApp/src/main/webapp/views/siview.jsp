<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../FrontController" method="post">
<input type="text" name="txtp" placeholder="Enter value of P" />
<br/>
<input type="text" name="txtr" placeholder="Enter value of P" />
<br/>
<input type="text" name="txtt" placeholder="Enter value of T" />
<br />
<input type="submit" value="Calculate" />
</form>
<%
if(request.getParameter("result")!=null)
{
	out.print(request.getParameter("result"));
}

%>
</body>
</html>