<%@ page import="org.prepuzy.model.Razza"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Razza</title>
<link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
	<nav>
		<div class="navBar"></div>
	</nav>

	<div class="container">
		<h1>Modifica Razza</h1>

		<%
		Razza razza = (Razza) request.getAttribute("razza");
		if (razza != null) {
		%>

		<form action="ModificaRazzaServlet" method="post">
			<input type="hidden" name="idRazza" value="<%=razza.getId()%>">

			<div class="formGroup">
				<label for="nome">Nome Razza:</label> <input type="text" id="nome"
					name="nome" value="<%=razza.getNome()%>" required>
			</div>

			<div class="formGroup">
				<label for="descrizione">Descrizione:</label>
				<textarea id="descrizione" name="descrizione" rows="5" required><%=razza.getDescrizione()%></textarea>
			</div>

			<div class="formGroup">
				<button type="submit" class="btnSave">Salva Modifiche</button>
				<a href="RazzeServlet" class="btnCancel">Annulla</a>
			</div>
		</form>

		<%
		} else {
		%>
		<p>Errore: razza non trovata.</p>
		<%
		}
		%>
	</div>
</body>
</html>
