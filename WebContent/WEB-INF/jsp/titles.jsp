<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Titles</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">

</head>
<body>
	<%@ include file="header.jsp"%>
	<h2>List all titles</h2>
	<table class="formtable bordered">
		<tr>
			<th>Name</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="title" items="${titles}">
			<tr>
				<td><c:out value="${title.name}" /></td>
				<td><a
					href="${pageContext.request.contextPath }/edit-title/${title.id}">Update</a></td>
				<td><a
					href="${pageContext.request.contextPath }/deletetitle/${title.id}">Delete</a>
				</td>
			</tr>

		</c:forEach>
	</table>
	<br>

	<p>
		<a class="text-decoration button"
			href="${pageContext.request.contextPath }/">Home page</a> <a
			class="text-decoration button"
			href="${pageContext.request.contextPath }/createtitle">Create
			title</a>
	</p>
	<%@ include file="footer.jsp"%>
</body>
</html>