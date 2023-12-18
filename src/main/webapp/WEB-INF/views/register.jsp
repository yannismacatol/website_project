<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Register | Website</title>
	<link rel="stylesheet" type="text/css" href="res/css/loginRegister.css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link href="https://fonts.googleapis.com/css2?family=Afacad&display=swap" rel="stylesheet">
</head>

<body>
	<div class="content-box-container">
		<div class="content-header-container">
			<h1 class="content-text">Create Account</h1>
			<p class = "content-description">If you are a new user, please create your account!</p>
		</div>
		
		<form class = "form-container" action="<%=request.getContextPath()%>/register" method="post">
			<div class="userpass-container">
				<p class="label-header">Username</p>
				<input id = "username" class="input-container" type="text" name="username"/> 
			</div>
			
			<div class="userpass-container">
				<p class="label-header">Password</p>
				<input id="password" class="input-container" type="password" name="password"/>
			</div>
			
			<div class="action-failed-container">
				<p class="action-failed-text">${message}</p>
			</div>
			
			<div class="submit-button-container">
				<input class = "submit-button submit-button-v2" type="submit" value="SIGN UP"/>
			</div>
		</form>
		
		<form class="redirect-button-container" action="<%=request.getContextPath()%>/login" method="get">
			<input class = "redirect-button" type="submit" value = "Go back to Login Page."/>
		</form>

	</div>
</body>

</html>