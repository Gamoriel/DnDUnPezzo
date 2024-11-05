<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registrazione</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Style.css">
</head>
<body>
	<div class="registerContainer">
		<div class="registerFormWrapper">
			<h1 class="registerTitle">DnD OP</h1>
			<form class="registerForm" action="${pageContext.request.contextPath}/RegisterLogicServlet" method="POST">
				<div class="form-control">
					<input type="text" name="usernameFormInput" id="usernameFormInput" required> 
						<label for="usernameFormInput">
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
					<input type="password" name="passwordFormInput" id="passwordFormInput" required> 
						<label for="passwordFormInput">
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
					<button type="button" class="btnRegister"
						onclick="submitForm('registrati')">Registrati</button>
					<button type="button" class="btnLogin"
						onclick="submitForm('login')">Ho già un account</button>
				</div>
				<%
				String message = (String) request.getAttribute("errorMsg");
				if (message != null) {
				%>
				<p class="errorMsg"><%=message%></p>
				<%
				}
				%>
			</form>
		</div>
	</div>

	<script>
		function submitForm(actionValue) {
			document.getElementById('action').value = actionValue;
			document.querySelector('.registerForm').submit();
		}
	</script>
</body>
</html>
