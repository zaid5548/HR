<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Upload Employee Details</title>
<style>
.head {
	margin-left: 5px
}

.container {
	margin-top: 40px
}

.bord {
	background-color: rgb(195, 166, 255);
}

form {
	margin: 10px
}

.user {
	position: absolute;
	right: 150px;
}
</style>
</head>
<body>



	<div class="container">
		<div>
			<div >
				<div class="page-header row head bord">
					<div>
						<h2>Header goes here</h2>
					</div>
					<div class="user">
					<h3>Welcome User</h3>
					</div>
				</div>
			</div>
			<form action="add" method="post">

				<div class="form-group row">
					<label for="inputId3" class="col-sm-2 col-form-label">Employee
						Id</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" s id="inputId3"
							placeholder="Employee Id" name="emp_Id">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputCode3" class="col-sm-2 col-form-label">Employee
						Code</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" s id="inputCode3"
							placeholder="Employee Code" name="emp_Code">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputName3" class="col-sm-2 col-form-label">Employee
						Name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputName3"
							placeholder="Employee Name" minlength="0" maxlength="10"
							name="emp_Name">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputLocation3" class="col-sm-2 col-form-label">Employee
						Location</label>
					<div class="col-sm-10">
						<textarea type="text" class="form-control" id="inputLocation3"
							placeholder="Employee Location" maxlength="500" rows="4"
							cols="50" name="location"></textarea>
					</div>
				</div>

				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inputEmail3"
							placeholder="Employee Email" maxlength="100" name="email">
					</div>
				</div>
				<div class="form-group row">
					<label for="inputDOB3" class="col-sm-2 col-form-label">Date
						Of Birth</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" id="inputDOB3"
							placeholder="Date Of Birth" name="dob">
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-10">
						<button type="submit" value="update" class="btn btn-primary">Save</button>
					</div>
				</div>
			</form>
			<div class="page-header row head bord">
				<h2>Footer goes here</h2>
			</div>
		</div>
	</div>
	<!-- <h2>Employee Update Page...</h2>  -->

</body>
</html>