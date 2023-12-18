<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Login Page | Website</title>
	<!-- <base href="${pageContext.request.contextPath}">-->	<!-- Commented out because it causes errors in link -->
	<link rel="stylesheet" type="text/css" href="res/css/loginRegister.css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link href="https://fonts.googleapis.com/css2?family=Afacad&display=swap" rel="stylesheet">
</head>

<body>
	<div class="content-box-container">
		<div class="content-header-container">
			<h1 class="content-text">Account Login</h1>
			<p class = "content-description">If you are a member, you can use your registered username and password to login.</p>
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
			
			<div class="action-failed-container">
				<p class="action-failed-text">${message}</p>
			</div>
			
			<div class="submit-button-container">
				<input class = "submit-button  submit-button-v1" type="submit" value="LOGIN"/>
			</div>
		</form>
		
		<form class="redirect-button-container" action="<%=request.getContextPath()%>/register" method="get">
			<input class = "redirect-button" type="submit" value = "New user? Sign up here!"/>
		</form>

	</div>
	
</body>
</html>