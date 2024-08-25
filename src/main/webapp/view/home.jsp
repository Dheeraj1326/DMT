<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<title>Home</title>
</head>
<body>
	<div class="bg-primary text-center text-white display-4"
		style="height: 90px;">Student List</div>

	<div class=" d-grid  justify-content-end mx-5 mt-5">
		<div >
			<a href="/addStudent">
				<button class="btn btn-primary ">Add Student</button>
			</a> <a href="/logout">
				<button class="btn btn-warning ">Logout</button>
			</a>
		</div>
	</div>

	<div class="mt-2 d-flex justify-content-center">
		<div class="card" style="width: 90%">
			<div class="card-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<td>Srno</td>
							<td>Name</td>
							<td>DOB</td>
							<td>Address</td>
							<td>Email</td>
							<td>Action</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="std" items="${studentList}" varStatus="loop">
							<tr>
								<td>${loop.index+1}</td>
								<td>${std.name}</td>
								<td>${std.dob}</td>
								<td>${std.address}</td>
								<td>${std.email}</td>
								<td><a href="/edit/${std.id}">
										<button class="btn btn-primary ">Edit</button>
								</a> <a href="/delete/${std.id}">
										<button class="btn btn-danger">Delete</button>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>