<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"    %>
<%@page import="com.java.databasehelper.*" %>
<script>
function showstate(cid)
{
   var xmlhttp = new XMLHttpRequest();
   xmlhttp.onreadystatechange=function()
   {
	   if(xmlhttp.readyState==4 && xmlhttp.status==200)
		   {
	         document.getElementById("state").innerHTML = xmlhttp.responseText;
		   }
   }
   xmlhttp.open("GET","state.jsp?q="+cid,true);
   xmlhttp.send();
   
}

</script>
<select onchange="showstate(this.value)">
<option value="">Select Country</option>
<%
Datahelper.connect();
ResultSet res = Datahelper.showallcountry();
while(res.next())
{%>
	<option value="<%= res.getString(1)  %>"><%= res.getString(2)  %></option>
<%}


%>
</select>
<div id="state">
<select>
 <option>Select State</option>
</select>
</div>