<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  </head>
  <script type="text/javascript">
  	function toggle(){
  		const pass = document.getElementById("pass");
  		const eye = document.getElementById("eye");
  		
  		if(pass.type === "password"){
  			pass.type = "text";
  			eye.className = "fa fa-eye-slash";
  		}
  		else{
  			pass.type = "password";
  			eye.className = "fa fa-eye";
  		}
  	}
  </script>
<body>
	<div class="bg-primary d-flex justify-content-center display-4 text-white" style="height: 75px;">
		Login
	</div>
	<div class="d-flex justify-content-center mt-5">
		<div class="card" style="width: 32rem;">
		<form:form action="/login" method="post" modelAttribute="student">
		<div class="card-body">
			<div class="text-danger">${error}</div>
			<div class="form-floating mb-3">
				<form:input path="email" class="form-control" type="email" id="email" placeholder="email" />
				<label for="email">Email</label>
			</div>
			<div class="form-floating mb-3">
				<form:input path="password" class="form-control" type="password" id="pass" placeholder="password" />
				<label for="pass">Password</label>
				<span class="btn" style="margin-top: -90px; margin-left:430px "
						onclick="toggle()" 
				>
					<span class="fa fa-eye" id="eye"></span>
				</span>
			</div>
			<button class="btn btn-primary d-grid mx-auto" type="submit">
				Submit
			</button>
			
		</div>
		</form:form>
	</div>
	</div>
</body>
</html>