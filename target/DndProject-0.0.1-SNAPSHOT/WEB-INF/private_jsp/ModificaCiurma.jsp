<%@ page import="org.prepuzy.model.Ciurma"%>
<%@ page import="org.prepuzy.model.Personaggio"%>
<%@ page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Ciurma</title>
<link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
	<nav>
		<div class="navBar"></div>
	</nav>

	<div class="container">
		<h1>Modifica Ciurma</h1>

		<%
		Ciurma ciurma = (Ciurma) request.getAttribute("ciurma");
		Set<Personaggio> allPersonaggi = (Set<Personaggio>) request.getAttribute("allPersonaggi");
		if (ciurma != null) {
		%>
		<form action="ModificaCiurmaServlet" method="post"
			enctype="multipart/form-data">
			<input type="hidden" name="idCiurma" value="<%=ciurma.getId()%>">

			<label for="nome">Nome:</label> <input type="text" name="nome"
				value="<%=ciurma.getNome()%>" required><br> <label
				for="jollyRoger">Jolly Roger:</label> <input type="file"
				name="jollyRoger" accept="image/*" required><br> <img
				src="<%=ciurma.getJollyRoger()%>" alt="Jolly Roger"
				style="width: 100px; height: auto;"><br> <label
				for="descrizione">Descrizione:</label>
			<textarea name="descrizione" required><%=ciurma.getDescrizione()%></textarea>
			<br>

			<h3>Personaggi nella Ciurma</h3>
			<div>
				<%
				Set<Personaggio> personaggiCiurma = ciurma.getPersonaggi();
				if (personaggiCiurma != null && !personaggiCiurma.isEmpty()) {
					for (Personaggio p : personaggiCiurma) {
				%>
				<div>
					<input type="checkbox" name="personaggiDaRimuovere"
						value="<%=p.getId()%>">
					<%=p.getNome()%>
					(Soprannome:
					<%=p.getSoprannome()%>)
				</div>
				<%
				}
				} else {
				%>
				<p>Nessun personaggio attualmente nella ciurma.</p>
				<%
				}
				%>
			</div>

			<h3>Aggiungi Personaggi alla Ciurma</h3>
			<div>
				<%
				if (allPersonaggi != null && !allPersonaggi.isEmpty()) {
					for (Personaggio p : allPersonaggi) {
						boolean isInCiurma = personaggiCiurma.stream().anyMatch(pc -> pc.getId() == p.getId());
						if (!isInCiurma) {
				%>
				<div>
					<input type="checkbox" name="personaggiDaAggiungere"
						value="<%=p.getId()%>">
					<%=p.getNome()%>
					(Soprannome:
					<%=p.getSoprannome()%>)
				</div>
				<%
				}
				}
				} else {
				%>
				<p>Nessun personaggio disponibile da aggiungere.</p>
				<%
				}
				%>
			</div>

			<button type="submit" class="btnSave">Salva Modifiche</button>
		</form>
		<%
		} else {
		%>
		<p>Ciurma non trovata.</p>
		<%
		}
		%>
	</div>
</body>
</html>