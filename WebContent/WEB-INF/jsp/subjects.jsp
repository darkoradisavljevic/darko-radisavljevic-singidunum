<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<h2>List all subjects</h2>
	<p class="validation">
		<%
			if (request.getAttribute("message") != null) {
		%>
		<%=request.getAttribute("message")%>
		<%
			}
		%>
	</p>
	<table class="formtable bordered">
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Year of Study</th>
			<th>Semester</th>
			<th>Maintenance date</th>
			<th>Update</th>
			<th>Delete</th>
			<th>All Professors</th>
		</tr>
		<c:forEach var="subject" items="${subjects}">
			<tr>
				<td><c:out value="${subject.name}" /></td>
				<td><c:out value="${subject.description}" /></td>
				<td><c:out value="${subject.yearOfStudy}" /></td>
				<td><c:out value="${subject.semester}" /></td>
				<td><c:out value="${subject.maintenanceDate}" /></td>
				<td><a
					href="${pageContext.request.contextPath }/edit-subject/${subject.subjectId}">Update</a>
				</td>
				<td><a
					href="${pageContext.request.contextPath }/deletesubject/${subject.subjectId}">Delete</a>
				</td>
				<td><a
					href="${pageContext.request.contextPath }/subject/professors/${subject.subjectId}">All
						Professors</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>

	<p>
		<a class="text-decoration button"
			href="${pageContext.request.contextPath }/">Home page</a> <a
			class="text-decoration button"
			href="${pageContext.request.contextPath }/createsubject">Create
			subject</a>
	</p>
	<br>
	<%@ include file="footer.jsp"%>
</body>
</html>