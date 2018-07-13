<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.softland.example.model.Users"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
</head>
<body>
	<%
	List<Users> users = (List<Users>) request.getAttribute( "users" );
	%>
	<table  border="1">
	<thead><tr><td align="center"><b>Users</b></td></tr></thead>
	<tbody>
	<tr>
	<td>
	<%
	for (Users user : users) {
		pageContext.setAttribute("firstname", user.getFirstName() );
		pageContext.setAttribute("lastname", user.getLastName() );
	%>
		<div>${firstname}&nbsp;${lastname}</div>
	<%
	}
	%>
	</td>
	</tr>
	</tbody>
	</table>
</body>
</html>