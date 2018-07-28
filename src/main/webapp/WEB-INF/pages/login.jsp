<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">






  </head>
  <body>


${msg}
${error}


<div>

<!-- Login Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#loginModal">
  Click here to login
</button>

</div>

<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    
    <form  method="POST" action="/store/login" class="needs-validation" novalidate id="loginForm">
    
      <div class="modal-header">
        <h5 class="modal-title" id="loginModalLabel">Login</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      
      <div class="modal-body">
		
				
	
		
		<div class="form-group">
			<label for="username">Username</label> 
			<input type="text" class="form-control" id="username" name='username' placeholder="Enter username" required> 
			<div class="invalid-feedback">Please provide a valid username</div>
		</div>
		
		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" class="form-control" name='password' id="password" placeholder="Password" required>
			<div class="invalid-feedback">Please provide a valid password.</div>
		</div>
		<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
	
      </div>
      
      <div class="modal-footer">
			<button type="submit" class="btn btn-primary">Login </button>
			<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
      
      </form>
      
    </div>
  </div>
</div>


<!-- SignUp Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#signupModal">
  Click here to SignUp
</button>

<!-- Modal -->
<div class="modal fade" id="signupModal" tabindex="-1" role="dialog" aria-labelledby="#signupModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    
    <form  method="POST" action="/store/signup" class="needs-validation" novalidate id="signupForm">
    
      <div class="modal-header">
        <h5 class="modal-title" id="#signupModalLabel">Sign Up</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      
      <div class="modal-body">
		
				
	
		
		<div class="form-group">
			<label for="username">Username</label> 
			<input type="text" class="form-control" id="username" name='username' placeholder="Enter username" required> 
		</div>
		
		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" class="form-control" name='password' id="password" placeholder="Password" required>
		</div>
		
		<div class="form-group">
			<label for="repassword">Confirm Password</label> 
			<input type="password" class="form-control" name='repassword' id="repassword" placeholder="Re-enter Password" required >
		</div>
		
		<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
	
      </div>
      
      <div class="modal-footer">
			<button type="submit" class="btn btn-primary">Sign Up </button>
			<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
      
      </form>
      
    </div>
  </div>
</div>







	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
  </body>
</html>