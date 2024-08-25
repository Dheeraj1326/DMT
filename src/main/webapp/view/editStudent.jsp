<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Student</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
	integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<script type="text/javascript">
	function toggle() {
		const eye = document.getElementById("eye");
		const pass = document.getElementById("password");

		if (pass.type === "password") {
			pass.type = "text";
			eye.className = "fa fa-eye-slash";
		} else {
			pass.type = "password";
			eye.className = "fa fa-eye";
		}
	}
</script>
<body>

	<div class="bg-primary display-4 text-white text-center"
		style="height: 70px;">Add Student Form</div>

	<div class=" d-flex justify-content-center mt-5">
		<form:form action="/edit/${student.id}" method="post" modelAttribute="student">
			<div class="card" style="width: 35rem;">
			<div class="text-danger text-center mt-2">${error}</div>
				<div class="card-body">
					<div class="form-floating mb-3">
						<form:input path="name" class="form-control" type="text" id="name"
							placeholder="Enter full name" /> <label for="name">Enter
							Name</label>
					</div>
					<div class="form-floating mb-3">
						<form:input path="dob" class="form-control" type="date" id="dob"
							placeholder="Enter Your DOB" /> <label for="dob">DOB</label>
					</div>
					<div class="form-floating mb-3">
						<form:input path="address" class="form-control" type="text" id="address"
							placeholder="Enter address" /> <label for="address">Enter
							Address</label>
					</div>
					<div class="form-floating mb-3">
						<form:input path="email" class="form-control" type="email" id="email"
							placeholder="Enter email id" /> <label for="email">Enter
							Email</label>
					</div>

					<div class="form-floating mb-3">
						<form:input path="password" class="form-control" type="password" id="password"
							placeholder="Enter password" /> <label for="password">Enter
							Password</label> <span class="btn"
							style="margin-top: -90px; margin-left: 480px;" onclick="toggle()">
							<span class="fa fa-eye" id="eye"> </span>
						</span>
					</div>

					<button class="btn btn-primary d-grid mx-auto" type="submit">Update</button>
				</div>
			</div>
		</form:form>

	</div>
</body>
</html>