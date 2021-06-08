<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body class="home">
	<h2>Hello</h2>
	<p>
		<a class="text-decoration button home"
			href="${pageContext.request.contextPath }/students"> Show all
			students</a>
	</p>
	<p>
		<a class="text-decoration button home"
			href="${pageContext.request.contextPath }/cities"> Show all
			cities</a>
	</p>
	<p>
		<a class="text-decoration button home"
			href="${pageContext.request.contextPath }/subjects"> Show all
			subjects</a>
	</p>
	<p>
		<a class="text-decoration button home"
			href="${pageContext.request.contextPath }/titles"> Show all
			titles</a>
	</p>
	<p>
		<a class="text-decoration button home"
			href="${pageContext.request.contextPath }/professors"> Show all
			professors</a>
	</p>
	<p>
		<a class="text-decoration button home"
			href="${pageContext.request.contextPath }/login"> Login</a>
	</p>
	<%@ include file="footer.jsp"%>
</body>
</html>