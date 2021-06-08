<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new subject</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<form action="${pageContext.request.contextPath }/docreate-subject"
		method="post">

		<h2>Create new subject</h2>
		<table class="formtable">
			<tr>
				<td class="label">Name:</td>
				<td class="control"><input name="name" id="name" type="text" required="required"></td>
			</tr>
			<tr>
				<td class="label">Description:</td>
				<td class="control"><input name="description" id="description"
					type="text"></td>
			</tr>
			<tr>
				<td class="label">Year of study:</td>
				<td class="control"><select name="yearOfStudy">
						<option value="1">I</option>
						<option value="2">II</option>
						<option value="3">III</option>
						<option value="4">IV</option>
				</select></td>
			</tr>
			<tr>
				<td class="label">Semester:</td>
				<td class="control radio-control"><input name="semester"
					id="semester" type="radio" value="Winter">Winter <input
					name="semester" id="semester" type="radio" value="Summer">Summer</td>
			</tr>
			<tr>
				<td class="label">Maintenance date:</td>
				<td class="control"><input name="maintenanceDate"
					id="maintenanceDate" type="date" required="required"></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td class="control"><input type="submit"
					value="Create new Subject"></td>
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