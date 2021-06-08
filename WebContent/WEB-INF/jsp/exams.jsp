<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exam registration</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<h2>Welcome ${object.firstName} ${object.lastName}</h2>
	<form action="${pageContext.request.contextPath }/docreate-exam"
		method="post">
		<input type="hidden" name="indexI" value="${indexI }" />
		<table class="formtable">
			<tr>
				<td class="label">Student:</td>
				<td class="control"><select name="id">
						<c:forEach var="student" items="${students }">
							<option
								<c:if test="${student.id == object.id}">
								 	<c:out value="selected"/>
								</c:if>
								value=${student.id }>${student.firstName }
								${student.lastName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="label">Subject:</td>
				<td class="control"><select name="subjectId">
						<c:forEach var="subject" items="${subjects }">
							<option value=${subject.subjectId }>${subject.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="label">Professor:</td>
				<td class="control"><select name="professorId">
						<c:forEach var="professor" items="${professors }">
							<option value=${professor.professorId }>${professor.firstName }
								${professor.lastName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td class="control edit-button"><input type="submit"
					value="Registration"></td>
			</tr>
		</table>
		<p class="validation">
			<%
				if (request.getAttribute("message") != null) {
			%>
			<%=request.getAttribute("message")%>
			<%
				}
			%>
		</p>

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