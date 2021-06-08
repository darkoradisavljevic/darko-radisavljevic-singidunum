<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Subject</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<form action="${pageContext.request.contextPath }/updatesubject"
		method="post">
		<h2>Edit subject</h2>
		<input name="subjectId" type="hidden" value="${subject.subjectId}">
		<table class="formtable">
			<tr>
				<td class="label">Name:</td>
				<td class="control"><input name="name" type="text"
					value="${subject.name}"></td>
			</tr>
			<tr>
				<td class="label">Description:</td>
				<td class="control"><input name="description" type="text"
					value="${subject.description}"></td>
			</tr>
			<tr>
				<td class="label">Year of study:</td>
				<td class="control"><select name="yearOfStudy">
						<option
							<c:if test="${subject.yearOfStudy == 1}">
								 	<c:out value="selected"/>
								</c:if>
							value="1">I</option>
						<option
							<c:if test="${subject.yearOfStudy == 2}">
								 	<c:out value="selected"/>
								</c:if>
							value="2">II</option>
						<option
							<c:if test="${subject.yearOfStudy == 3}">
								 	<c:out value="selected"/>
								</c:if>
							value="3">III</option>
						<option
							<c:if test="${subject.yearOfStudy == 4}">
								 	<c:out value="selected"/>
								</c:if>
							value="4">IV</option>
				</select></td>
			</tr>
			<tr>
				<td class="label">Semester:</td>
				<td class="control radio-control"><input
					<c:if test="${subject.semester == 'Winter'}">
								 	<c:out value="checked"/>
								</c:if>
					name="semester" id="semester" type="radio" value="Winter"><span>Winter</span>
					<br /> <input
					<c:if test="${subject.semester == 'Summer'}">
								 	<c:out value="checked"/>
								</c:if>
					name="semester" id="semester" type="radio" value="Summer"><span>Summer</span>
				</td>
			</tr>

			<tr>
				<td class="label">Maintenance date:</td>
				<td class="control"><input name="maintenanceDate" type="date"
					value="${subject.maintenanceDate}"></td>
			</tr>

			<tr>
				<td class="label"></td>
				<td class="control edit-button"><input type="submit"
					value="Edit Subject"></td>
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