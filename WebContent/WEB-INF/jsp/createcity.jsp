<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new city</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<p class="validation">
		<%
			if (request.getAttribute("message") != null) {
		%>
		<%=request.getAttribute("message")%>
		<%
			}
		%>
	</p>
	<form action="${pageContext.request.contextPath }/docreate-city"
		method="post">
		<h2>Create new city</h2>

		<table class="formtable">
			<tr>
				<td class="label">Zip_code:</td>
				<td class="control"><input name="zipCode" id="zipCode" required="required"
					type="text"></td>
			</tr>
			<tr>
				<td class="label">Name:</td>
				<td class="control"><input name="name" id="name" required="required" type="text"></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit"
					value="Create new City"></td>
			</tr>


		</table>

	</form>
	<br>
	<p>
		<a class="text-decoration button"
			href="${pageContext.request.contextPath }/">Home page</a>
	</p>
	<br>
	<%@ include file="footer.jsp"%>
</body>
</html>