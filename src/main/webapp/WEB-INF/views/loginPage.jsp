<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Login Page | Website</title>
	<!-- <base href="${pageContext.request.contextPath}">-->	<!-- Commented out because it causes errors in link -->
	<link rel="stylesheet" type="text/css" href="res/css/loginPage.css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link href="https://fonts.googleapis.com/css2?family=Afacad&display=swap" rel="stylesheet">
</head>

<body>
	<div class="login-box-container">
		<div class="login-header-container">
			<h1 class="login-text">Account Login</h1>
			<p class = "login-description">If you are a member, you can use your registered username and password to login.</p>
		</div>
		
		<form class = "form-container" action="<%=request.getContextPath()%>/login" method="post">
			<div class="userpass-container">
				<p class="label-header">Username</p>
				<input id = "username" class="input-container" type="text" name="username"/> 
			</div>
			
			<div class="userpass-container">
				<p class="label-header">Password</p>
				<input id="password" class="input-container" type="password" name="password"/>
			</div>
			
			<div class="login-failed-container">
				<p class="login-failed-text">${message}</p>
			</div>
			
			<div class="submit-button-container">
				<input class = "submit-button" type="submit" value="LOGIN"/>
			</div>
		</form>

	</div>
	
</body>
</html>