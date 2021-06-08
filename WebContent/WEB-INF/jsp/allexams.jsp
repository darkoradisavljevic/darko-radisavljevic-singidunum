<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of exams</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<h2>List all exams</h2>
	<table class="formtable bordered">
		<tr>
			<th>Student</th>
			<th>Subject</th>
			<th>Professor</th>
			<th>Maintenance Date</th>
			<th>Date of application</th>
			<th>Delete</th>

		</tr>
		<c:forEach var="e" items="${allExams}">
			<tr>
				<td><c:forEach var="student" items="${students}">

						<c:if test="${student.id == e.student.id}">
							<c:out value="${student.firstName } ${student.lastName }" />
						</c:if>

					</c:forEach></td>
				<td><c:forEach var="subject" items="${subjects}">

						<c:if test="${subject.subjectId == e.subject.subjectId}">
							<c:out value="${subject.name }" />
						</c:if>

					</c:forEach></td>
				<td><c:forEach var="professor" items="${professors}">

						<c:if test="${professor.professorId == e.professor.professorId}">
							<c:out value="${professor.firstName } ${professor.lastName }" />
						</c:if>

					</c:forEach></td>
				<td><c:forEach var="subject" items="${subjects}">

						<c:if test="${subject.subjectId == e.subject.subjectId}">
							<c:out value="${subject.maintenanceDate }" />
						</c:if>

					</c:forEach></td>
				<td><c:out value="${e.dateOfApplication}" /></td>
				<td><a
					href="${pageContext.request.contextPath }/deleteexam/${e.examId}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>

	<p>
		<a class="text-decoration button"
			href="${pageContext.request.contextPath }/">Home page</a>
	</p>
	<%@ include file="footer.jsp"%>
</body>
</html>