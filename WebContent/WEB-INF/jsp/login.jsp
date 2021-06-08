<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<form action="${pageContext.request.contextPath }/exams" method="post">
		<h2>Login</h2>
		<table class="formtable">
			<tr>
				<td class="label">Index:</td>
				<td class="control"><input name="index" id="index" type="text"></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit" value="Login"></td>
			</tr>
		</table>

	</form>
	<br>
	<p class="validation">
			<%
				if (request.getAttribute("message") != null) {
			%>
			<%=request.getAttribute("message")%>
			<%
				}
			%>
		</p>
	<br>
	<p>
		<a class="text-decoration button"
			href="${pageContext.request.contextPath }/">Home page</a> <a
			class="text-decoration button"
			href="${pageContext.request.contextPath }/exams">View all exams</a>
	</p>
	<br>
	<%@ include file="footer.jsp"%>
</body>
</html>