<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--import spring suppiled JSP tag lib for URL rewriting --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%--import for the form binding tech, spring supplied form tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
<title>Student Admission Form</title>
</head>
<body>
	<div class="jumbotron container-fluids text-center">

		<h5 align="center" style="color: blue;">Selected Course :
			${sessionScope.selected_course.title}</h5>

		<h4 align="center">Enter Student Details</h4>

		<form:form method="post" modelAttribute="student">
			<table class="table"
				style="background-color: lightgrey; margin: auto;">
				<tbody>
					<tr>
						<td>Name</td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><form:input path="address" /></td>
					</tr>
					<tr>
						<td>Dob</td>
						<td><form:input path="dob" type="date" /></td>
					</tr>
					<tr>
						<td>CGPA</td>
						<td><form:input path="cgpa" /></td>
					</tr>
				</tbody>
			</table>
			<h5 align="center">
				<input class="btn btn-primary" type="submit" value="Admit Student" />
			</h5>
		</form:form>
		<h5 align="center" style="color: red;">${requestScope.message}</h5>
	</div>
</body>
</html>