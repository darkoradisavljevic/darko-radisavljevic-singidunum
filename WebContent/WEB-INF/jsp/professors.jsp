<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Professors</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<h2>List of all professors</h2>
	<table class="formtable bordered">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>City</th>
			<th>Phone</th>
			<th>Title</th>
			<th>Re-election date</th>
			<th>Update</th>
			<th>Delete</th>

		</tr>
		<c:forEach var="professor" items="${professors}">
			<tr>
				<td><c:out value="${professor.firstName}" /></td>
				<td><c:out value="${professor.lastName}" /></td>
				<td><c:out value="${professor.email}" /></td>
				<td><c:out value="${professor.address}" /></td>
				<td><c:forEach var="city" items="${cities }">
						<c:if test="${city.id == professor.city.id}">
							<c:out value="${city.name}" />
						</c:if>
					</c:forEach></td>
				<td><c:out value="${professor.phone}" /></td>
				<td><c:forEach var="title" items="${titles }">
						<c:if test="${title.id == professor.title.id}">
							<c:out value="${title.name}" />
						</c:if>
					</c:forEach></td>
				<td><c:out value="${professor.reelectionDate}" /></td>
				<td><a
					href="${pageContext.request.contextPath }/edit-professor/${professor.professorId}">Update</a>
				</td>
				<td><a
					href="${pageContext.request.contextPath }/deleteprofessor/${professor.professorId}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>

	<p>
		<a class="text-decoration button"
			href="${pageContext.request.contextPath }/">Home page</a> <a
			class="text-decoration button"
			href="${pageContext.request.contextPath }/createprofessor">Create
			professor</a>
	</p>
	<br>
	<%@ include file="footer.jsp"%>
</body>
</html>