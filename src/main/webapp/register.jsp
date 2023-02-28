<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register</title>
<%@ include file="./includes/styles.html"%>
</head>
<body>
	<%@ include file="./includes/adminNav.html"%>
	<div class="d-flex justify-content-center align-items-center mt-3">
	<div class="col-4 my-3">
		<form action="register" method="post">
			<div class="form-outline mb-4">
				<label class="form-label" for="usersSelect">User Type</label> <select
					class="form-control form-control-lg" id="usersSelect" name="type">
					<option value="Student">Student</option>
					<option value="Faculty">Faculty</option>
					<option value="Admin">Admin</option>
				</select>
			</div>
			<!-- Email input -->
			<div class="form-outline mb-4">
				<label class="form-label" for="form3Example3">Id</label> <input
					type="text" id="form3Example3" name="id"
					class="form-control form-control-lg"
					placeholder="Enter a valid email address" />
			</div>
			<div class="form-outline mb-4">
				<label class="form-label" for="form3Example3">Email Address</label> <input
					type="email" id="form3Example3" name="email"
					class="form-control form-control-lg"
					placeholder="Enter a valid email address" />
			</div>
			<div class="form-outline mb-4">
				<label class="form-label" for="form3Example3">Name</label> <input
					type="text" id="form3Example3" name="name"
					class="form-control form-control-lg"
					placeholder="Enter a valid email address" />
			</div>

			<!-- Password input -->
			<div class="form-outline mb-3">
				<label class="form-label" for="form3Example4">Password</label> <input
					type="password" id="form3Example4" name="password"
					class="form-control form-control-lg" placeholder="Enter password" />

			</div>
				
			<div class="text-center text-lg-start mt-4 pt-2">
				<button type="submit" class="btn btn-primary btn-lg"
					style="padding-left: 2.5rem; padding-right: 2.5rem;">Register</button>
			</div>
		</form>
		</div>
	</div>
	<%@ include file="./includes/scripts.html"%>
</body>
</html>