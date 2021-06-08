<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<h2>List of all students</h2>
	<table class="formtable bordered">
		<tr>
			<th>Index</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>City</th>
			<th>Phone</th>
			<th>Current year of study</th>
			<th>Update</th>
			<th>Delete</th>

		</tr>
		<c:forEach var="student" items="${students}">
			<tr>
				<td><c:out value="${student.student_index}" /></td>
				<td><c:out value="${student.firstName}" /></td>
				<td><c:out value="${student.lastName}" /></td>
				<td><c:out value="${student.email}" /></td>
				<td><c:out value="${student.address}" /></td>
				<td><c:forEach var="city" items="${cities }">
						<c:if test="${city.id == student.city.id}">
							<c:out value="${city.name}" />
						</c:if>
					</c:forEach></td>
				<td><c:out value="${student.phone}" /></td>
				<td><c:out value="${student.currentYear}" /></td>
				<td><a
					href="${pageContext.request.contextPath }/edit-student/${student.id}">Update</a>
				</td>
				<td><a
					href="${pageContext.request.contextPath }/deletestudent/${student.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>

	<p>
		<a class="text-decoration button"
			href="${pageContext.request.contextPath }/">Home page</a> <a
			class="text-decoration button"
			href="${pageContext.request.contextPath }/createstudent">Create
			student</a>
	</p>
	<br>
	<%@ include file="footer.jsp"%>
</body>
</html>