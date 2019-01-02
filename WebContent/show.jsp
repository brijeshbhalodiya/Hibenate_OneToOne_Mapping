<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.bean.*"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

List<Person> list= PersonDao.getAll();

%>
<table border="1" width="100%">
	<tr>
		<th>ID</th>
		<th>FNAME</th>
		<th>LNAME</th>
		<th>EMAIL</th>
		<th>EDIT</th>
		<th>DELETE</th>
	</tr>
	<%
		for(Person p:list)
		{
			PersonDetail pd = p.getpDetail();
	%>
	<tr>
		<td><%=p.getpId() %></td>
		<td><%= pd.getFname() %></td>
		<td><%= pd.getLname() %></td>
		<td><%= pd.getEmail() %></td>
		<td>
			<form name="edit" method="post" action="PersonController">
				<input type="hidden" name="pid" value="<%=p.getpId()%>">
				<input type="submit" name="action" value="Edit">
			</form>
		</td>
		<td>
			<form name="delete" method="post" action="PersonController">
				<input type="hidden" name="pid" value="<%=p.getpId()%>">
				<input type="submit" name="action" value="Delete">
			</form>
		</td>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>