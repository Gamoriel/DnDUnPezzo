<%@page import="org.prepuzy.businesslogic.BusinessLogic"%>
<%@page import="java.util.Set"%>
<%@page import="org.prepuzy.model.Capitolo"%>
<%@page import="org.prepuzy.model.Mappa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Capitolo</title>
<link rel="stylesheet" href="../resources/css/Style.css">
</head>
<body>
	<nav>
		<div class="navBar"></div>
	</nav>

	<div class="container">
		<h1>Modifica Capitolo</h1>

		<%
		Capitolo capitolo = (Capitolo) request.getAttribute("capitolo");
		if (capitolo != null) {
		%>

		<form action="ModificaCapitoloServlet" method="post">
			<input type="hidden" name="idCapitolo" value="<%=capitolo.getId()%>" />

			<div>
				<label for="nuovoTitolo">Titolo del Capitolo:</label> <input
					type="text" id="nuovoTitolo" name="nuovoTitolo"
					value="<%=capitolo.getTitolo()%>" required />
			</div>

			<div>
				<label for="nuovoTesto">Testo del Capitolo:</label>
				<textarea id="nuovoTesto" name="nuovoTesto" rows="10" cols="50"
					required><%=capitolo.getTesto()%></textarea>
			</div>

			<div>
				<label for="nuovaMappa">Seleziona la Mappa:</label> <select
					id="nuovaMappa" name="nuovaMappa" required>
					<option value="<%=capitolo.getMappa().getId()%>">Mappa
						Corrente:
						<%=capitolo.getMappa().getDescrizione()%></option>
					<%
					Set<Mappa> mappe = BusinessLogic.listaMappe();
					for (Mappa m : mappe) {
						if (m.getId() != capitolo.getMappa().getId()) {
					%>
					<option value="<%=m.getId()%>"><%=m.getNome()%></option>
					<%
					}
					}
					%>
				</select>
			</div>
			<button type="submit" class="btnSave">Salva Modifiche</button>
		</form>

		<%
		} else {
		%>
		<p>
			Errore: Capitolo non trovato. <a href="CapitoliServlet">Torna
				alla lista dei capitoli</a>
		</p>
		<%
		}
		%>
	</div>
</body>
</html>