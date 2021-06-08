<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Professors for this Subject</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<h2>List of all professors for subject</h2>
	<table class="formtable bordered">
		<tr>
			<th>Subject</th>
			<th>All Professors</th>
			<th>Edit Professors</th>
		<tr>
			<td>${subject.name}</td>
			<td><c:forEach var="professor" items="${subject.professors}">
					<table>
						<tr>
							<c:out value="${professor.firstName } ${professor.lastName }" />
						</tr>
					</table>
				</c:forEach></td>

			<td><a
				href="${pageContext.request.contextPath }/subject/edit-professors/${subject.subjectId}">Edit</a>
			</td>
		</tr>
	</table>
	<br>

	<p>
		<a class="text-decoration button"
			href="${pageContext.request.contextPath }/">Home page</a>
	</p>
	<br>
	<%@ include file="footer.jsp"%>
</body>
</html>