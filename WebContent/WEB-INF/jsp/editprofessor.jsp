<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Professor</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<form action="${pageContext.request.contextPath }/updateprofessor"
		method="post">
		<h2>Edit Professor</h2>
		<input name="professorId" type="hidden"
			value="${professor.professorId}">
		<table class="formtable">
			<tr>
				<td class="label">First name:</td>
				<td class="control"><input name="firstName" type="text"
					value="${professor.firstName}"></td>
			</tr>
			<tr>
				<td class="label">Last name:</td>
				<td class="control"><input name="lastName" type="text"
					value="${professor.lastName}"></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td class="control"><input name="email" type="email"
					value="${professor.email}" maxlength="30"></td>
			</tr>
			<tr>
				<td class="label">Address:</td>
				<td class="control"><input name="address" type="text"
					value="${professor.address}"></td>
			</tr>
			<tr>
				<td class="label">City:</td>
				<td class="control"><select name="city.id">
						<c:forEach var="city" items="${cities }">
							<option
								<c:if test="${city.id == professor.city.id}">
								 	<c:out value="selected"/>
								</c:if>
								value="${city.id}">${city.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="label">Phone:</td>
				<td class="control"><input name="phone" type="text"
					value="${professor.phone}"></td>
			</tr>
			<tr>
				<td class="label">Title:</td>
				<td class="control"><select name="title.id">
						<c:forEach var="title" items="${titles }">
							<option
								<c:if test="${title.id == professor.title.id}">
								 	<c:out value="selected"/>
								</c:if>
								value="${title.id}">${title.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="label">Re-election date:</td>
				<td class="control"><input name="reelectionDate" type="date"
					value="${professor.reelectionDate}"></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit" value="Edit Professor"></td>
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