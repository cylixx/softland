<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<%
			String userName = (String) session.getAttribute("Username");
			String additionalURL = (String) request.getAttribute("alias");
			if (userName != null)
			{
					out.write("Hello" + userName);
			}
			else
			{
					out.write("Hello World!");
			}
			if (additionalURL == null)
			{
					additionalURL = "";
			}
	%>
	<form method="post" action="<%=request.getContextPath()%>/customServlet">
		<input type="text" name = "userName" >
		<br>
		<input type="submit" value="View My Name"/>
		<input type="hidden" name="_s" value="<%=additionalURL%>"/>
	
	</form>
	

	
</body>
</html>