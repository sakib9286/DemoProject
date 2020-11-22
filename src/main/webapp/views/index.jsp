<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple Demo</title>

<style>
.center {
		
		margin-left: auto;
		margin-right: auto;
		
}


</style>

</head>
<body>
	<div style="text-align:center">

				<h3>User Login</h3>
				
			
				
				<form method="POST" action="/api/login-user">
					
						<label for="email"> Username/ Email : </label>
							<input type="text" name="email" /> <br/><br/>
					
						<label for="password">Password : </label>
							<input type="password"  name="password" /> <br/><br/>
					
						<input type="submit" value="Login" />
				
					</form>
</div>
</body>
</html>