<%@page import="com.nagarro.entities.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Available</title>
<style>
.container {
	margin: 80px;
}

.table {
	width: 100%;
	border: 1px solid;
	border-collapse: collapse;
	border: 1px solid;
}

th, td, table {
	text-align: center;
	border: 1px solid;
	border-collapse: collapse;
	border: 1px solid;
	padding: 15px;
	margin: 10px;
}

header {
	padding: 15px;
	text-align: right;
	height: 150px;
	background-color: rgb(166, 231, 255);
	margin: 10px;
	width: 100%;
}

.upload {
	display: inline-block;
	margin-bottom: 20px;
}

.user {
	display: inline;
}

.btton {
	border-radius: 7px;
	padding: 5px;
	margin: 10px;
}
</style>
</head>
<body>


	<div class="container">
		<header>
			<div class="user">
				<h3>Welcome ${userName}</h3>
			</div>
			<form action="signout">
				<div class="user">
					<input style="border-radius: 7px; padding: 5px" type="submit"
						value="Signout">
				</div>
			</form>
				<div class="upload">
				<form action="upload">
					<button type="submit" class="btn btn-success btton">Upload
						Employee Details</button>
				</form>
			</div>


			<div class="upload">
				<!-- <button type="button" class="btn btn-success btton">Download
						Employee Details</button> -->
				<a href="/hrmanagement/downloadEmployee"><button class="btn0">Download
						Employee Details</button> </a>

			</div>

		</header>
		<h1></h1>
		<div>

			<table class="table">
				<tr>
					<th>Employee Id</th>
					<th>Employee Code</th>
					<th>Employee Name</th>
					<th>Location</th>
					<th>Email</th>
					<th>Date Of Birth</th>
					<th>Test Header</th>
					<th>Action</th>
				</tr>

				<c:forEach var="employee" items="${employeeList }">
					<tr>
						<td>${employee.getId()}</td>
						<td>${employee.getEmp_Code() }</td>
						<td>${employee.getEmp_Name() }</td>
						<td>${employee.getLocation() }</td>
						<td>${employee.getEmail() }</td>
						<td>${employee.getDob() }</td>
						<td>
							<!-- <a href="uploademployee.jsp"
								class="btn btn-outline-info a-btn-slide-text">Edit</a> -->

							<form method="post" action="edit">
								<input type="hidden" value="${employee.getId()}" name="emp_Id" />
								<input type="hidden" value="${employee.getEmp_Code() }"
									name="emp_Code" /> <input type="hidden"
									value="${employee.getEmp_Name() }" name="emp_Name" /> <input
									type="hidden" value="${employee.getLocation() }"
									name="location" /> <input type="hidden"
									value="${employee.getEmail() }" name="email" /> <input
									type="hidden" value="${employee.getDob() }" name="dob" /> <input
									type="submit" value="EDIT">
							</form>

						</td>
					</tr>

				</c:forEach>


				<!-- <tr>
						<td>100</td>
						<td>Zaid Khan</td>
						<td>Ghaziabad</td>
						<td>zaid@gmail.com</td>
						<td>17-08-1999</td>
						<td><a href="uploademployee.jsp"
							class="btn btn-outline-info a-btn-slide-text">Edit</a></td>
					</tr>

					<tr>
						<td>100</td>
						<td>Zaid Khan</td>
						<td>Ghaziabad</td>
						<td>zaid@gmail.com</td>
						<td>17-08-1999</td>
						<td><a href="uploademployee.jsp"
							class="btn btn-outline-info a-btn-slide-text">Edit</a></td>
					</tr> -->

			</table>

		</div>
	</div>



</body>
</html>
