<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add or Delete Professors in subject</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<h2>Edit professor for subject</h2>
	<p>Professors for subject ${subject.name} are:</p>
	<br />
	<table class="formtable">
		<tr>
			<th>Professor Name</th>
			<th>Delete Professor</th>
		</tr>
		<c:forEach var="subprofessor" items="${subProfessors}">
			<tr>
				<td><c:out
						value="${subprofessor.firstName} ${subprofessor.lastName}" /></td>
				<td><a class="text-decoration"
					href="${pageContext.request.contextPath }/subject/deleteprofessor/${subject.subjectId}/${subprofessor.professorId}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>



	<form
		action="${pageContext.request.contextPath}/subject/updateprofessors"
		method="post">
		<input type="hidden" name="subjectId" value="${subject.subjectId }" />
		<table class="formtable">
			<tr>
				<td>Add Professor</td>
				<td><select name="professorId">

						<c:forEach var="professor" items="${professors}">
							<option value="${professor.professorId}">${professor.firstName}
								${professor.lastName}</option>
						</c:forEach>

				</select></td>
			</tr>
			<tr>
				<td><input class="button" type="submit" value="Save edit" /></td>
			</tr>
		</table>
	</form>
	<%@ include file="footer.jsp"%>
</body>
</html>