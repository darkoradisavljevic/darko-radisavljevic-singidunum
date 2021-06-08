<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new title</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<form action="${pageContext.request.contextPath }/docreate-title"
		method="post">

		<h2>Create new title</h2>
		<table class="formtable">
			<tr>
				<td class="label">Name:</td>
				<td class="control"><input name="name" id="name" type="text" required="required"></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit"
					value="Create new Title"></td>
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