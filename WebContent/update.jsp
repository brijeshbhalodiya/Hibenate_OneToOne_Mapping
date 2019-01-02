<%@page import="com.bean.*"%>
<%@page import="com.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>

<% 

	Person p = (Person)request.getAttribute("Person");
	PersonDetail pd = p.getpDetail();
	
%>
<form name="frm" method="post" action="PersonController">
	<table cellspacing="5" cellpadding="5">
		<tr>
			<td><input type="hidden" name="pid" value="<%= p.getpId() %>"></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="fname" value="<%= pd.getFname() %>"></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lname" value="<%= pd.getLname() %>"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" value="<%= pd.getEmail() %>"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="action" value="Update">
			</td>
		</tr>
	</table>
</form>
</body>
</html>