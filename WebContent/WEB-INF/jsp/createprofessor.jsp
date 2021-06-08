<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new professor</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<p class="validation">
		<%
			if (request.getAttribute("message") != null) {
		%>
		<%=request.getAttribute("message")%>
		<%
			}
		%>
	</p>
	<form action="${pageContext.request.contextPath }/docreate-professor"
		method="post">
		<h2>Create new professor</h2>
		<table class="formtable">
			<tr>
				<td class="label">First name:</td>
				<td class="control"><input name="firstName" id="firstName"
					type="text" required="required"></td>

			</tr>
			<tr>
				<td class="label">Last Name:</td>
				<td class="control"><input name="lastName" id="lastName"
					type="text" required="required"></td>
			</tr>
			<tr>
				<td class="label">Email:</td>
				<td class="control"><input name="email" id="email" type="email"
					required="required"></td>
			</tr>
			<tr>
				<td class="label">Address:</td>
				<td class="control"><input name="address" id="address"
					type="text" required="required"></td>
			</tr>
			<tr>
				<td class="label">City:</td>
				<td class="control"><select name="city.id">
						<c:forEach var="city" items="${cities }">
							<option value="${city.id}">${city.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="label">Phone:</td>
				<td class="control"><input name="phone" id="phone" type="text"
					required="required" value="06"></td>
			</tr>
			<tr>
				<td class="label">Title:</td>
				<td class="control"><select name="title.id">
						<c:forEach var="title" items="${titles }">
							<option value="${title.id}">${title.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="label">Re-election date:</td>
				<td class="control"><input name="reelectionDate"
					id="reelectionDate" type="date" required="required"></td>

			</tr>

			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit"
					value="Create new Professor"></td>
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