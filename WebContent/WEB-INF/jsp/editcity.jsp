<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit city</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<form action="${pageContext.request.contextPath }/updatecity"
		method="post">
		<input name="id" type="hidden" value="${city.id}">

		<h2>Edit city</h2>
		<table class="formtable">
			<tr>
				<td class="label">Zip_code:</td>
				<td class="control"><input name="zipCode" type="text"
					value="${city.zipCode}"></td>
			</tr>
			<tr>
				<td class="label">Name:</td>
				<td class="control"><input name="name" type="text"
					value="${city.name}"></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit" value="Edit City"></td>
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