<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
	<%
	String username = "";
	String password = "";
	%>

	<div class="loginContainer">
		<div class="loginFormWrapper">
			<h1 class="loginTitle">D&D OP</h1>
			<form class="loginForm" action="LoginLogicServlet" method="post">
				<div class="formGroup">
					<label for="username">Username</label> <input type="text"
						value="<%=username%>" name="username" id="username"
						placeholder="Inserisci Username..." required>
				</div>
				<div class="formGroup">
					<label for="password">Password</label> <input type="password"
						value="<%=password%>" id="password" name="password"
						placeholder="Inserisci Password..." required>
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
