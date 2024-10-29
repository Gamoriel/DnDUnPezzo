<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Style.css">
<style type="text/css">
.bg-video {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	object-fit: cover;
	z-index: -1;
}
</style>
</head>
<body>
	<%
	String username = "";
	String password = "";
	%>
	<video class="bg-video" autoplay loop>
		<source src="resources/img/Untitled.mp4" type="video/mp4">
	</video>
	<div class="loginContainer">
		<div class="loginFormWrapper">
			<h1 class="loginTitle">DnD OP</h1>
			<form class="loginForm" action="LoginLogicServlet" method="post">
				<div class="form-control">
					<input type="text" value="<%=username%>" name="username" id="username" required> 
						<label for="username">
						<span style="transition-delay: 0ms">U</span>
						<span style="transition-delay: 50ms">s</span>
						<span style="transition-delay: 100ms">e</span>
						<span style="transition-delay: 150ms">r</span>
						<span style="transition-delay: 200ms">n</span>
						<span style="transition-delay: 250ms">a</span>
						<span style="transition-delay: 300ms">m</span>
						<span style="transition-delay: 350ms">e</span> 
						</label>
				</div>
				<div class="form-control">
					<input type="password" value="<%=password%>" id="password" name="password" required> 
						<label for="password">
						<span style="transition-delay: 0ms">P</span>
						<span style="transition-delay: 50ms">a</span>
						<span style="transition-delay: 100ms">s</span>
						<span style="transition-delay: 150ms">s</span>
						<span style="transition-delay: 200ms">w</span>
						<span style="transition-delay: 250ms">o</span>
						<span style="transition-delay: 300ms">r</span>
						<span style="transition-delay: 350ms">d</span> 
						</label>
				</div>
				<input type="hidden" name="action" id="action" value="">
				<div class="formActions">
					<button type="submit" value="Accedi" class="btnLogin"
						onclick="document.getElementById('action').value = 'Accedi'">Accedi</button>
					<button type="button" class="btnRegister"
						onclick="submitForm('Registrati')">Registrati</button>
				</div>
				<%
				String errore = (String) request.getAttribute("errorMsg");
				if (errore != null) {
				%>
				<p class="errorMsg"><%=errore%></p>
				<%
				}
				%>
			</form>
		</div>
	</div>
	<script>
		function submitForm(actionValue) {
			document.getElementById('action').value = actionValue;
			document.querySelector('.loginForm').submit();
		}
	</script>
</body>
</html>
