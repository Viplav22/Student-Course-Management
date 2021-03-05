<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Choose Course</title>
</head>
<body>
	<div class="jumbotron container-fluids text-center">
		<h4>Courses Offered</h4>
		<table class="table"
			style="background-color: lightgrey; margin: auto;">
			<thead>
				<tr>
					<th>Course Name</th>
					<th>Admit Student</th>
					<th>Delete Course</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${requestScope.all_courses}">
					<tr>
						<td>${c.title}</td>
						<td><a class="btn btn-outline-primary"
							href="<spring:url value='/student/admit?cid=${c.id}'/>">Admit
								Student</a></td>
						<td><a class="btn btn-outline-primary"
							href="<spring:url value='/course/delete?cid=${c.id}'/>">Delete
								Course</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h5 align="center" style="color: red;">${requestScope.message}</h5>
	</div>
</body>
</html>