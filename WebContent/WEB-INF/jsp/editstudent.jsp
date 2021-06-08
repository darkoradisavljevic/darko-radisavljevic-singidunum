<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Student</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<form action="${pageContext.request.contextPath }/updatestudent"
		method="post">
		<input name="id" type="hidden" value="${student.id}">

		<h2>Edit student</h2>
		<table class="formtable">
			<tr>
				<td class="label">Number of index:</td>
				<td class="control"><input name="student_index" type="text"
					value="${student.student_index}"></td>
			</tr>
			<tr>
				<td class="label">First name:</td>
				<td class="control"><input name="firstName" type="text"
					value="${student.firstName}"></td>
			</tr>
			<tr>
				<td class="label">Last name:</td>
				<td class="control"><input name="lastName" type="text"
					value="${student.lastName}"></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td class="control"><input name="email" type="email"
					value="${student.email}"></td>
			</tr>
			<tr>
				<td class="label">Address:</td>
				<td class="control"><input name="address" type="text"
					value="${student.address}"></td>
			</tr>
			<tr>
				<td class="label">City:</td>
				<td class="control"><select name="city.id">
						<c:forEach var="city" items="${cities }">
							<option
								<c:if test="${city.id == student.city.id}">
								 	<c:out value="selected"/>
								</c:if>
								value="${city.id}">${city.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="label">Phone:</td>
				<td class="control"><input name="phone" type="text"
					value="${student.phone}"></td>
			</tr>
			<tr>
				<td class="label">Current year of study:</td>
				<td class="control"><select name="currentYear">
						<option
							<c:if test="${student.currentYear == 1}">
								 	<c:out value="selected"/>
								</c:if>
							value="1">I</option>
						<option
							<c:if test="${student.currentYear == 2}">
								 	<c:out value="selected"/>
								</c:if>
							value="2">II</option>
						<option
							<c:if test="${student.currentYear == 3}">
								 	<c:out value="selected"/>
								</c:if>
							value="3">III</option>
						<option
							<c:if test="${student.currentYear == 4}">
								 	<c:out value="selected"/>
								</c:if>
							value="4">IV</option>
				</select></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit" value="Edit Student"></td>
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