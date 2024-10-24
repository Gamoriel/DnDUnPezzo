<%@page import="org.prepuzy.businesslogic.BusinessLogic"%>
<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Capitolo"%>
<%@page import="org.prepuzy.model.Mappa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Modifica Capitolo</title>
<link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
	<nav>
		
		<div id="menuToggle">
			<input type="checkbox" /> <span></span> <span></span> <span></span>
			<ul id="menu">
				<li><a href="MasterPageServlet">Capitoli</a></li>
				<li><a href="CiurmaServlet">Ciurma</a></li>
				<li><a href="FruttiServlet">Frutti</a></li>
				<li><a href="MappeServlet">Mappe</a></li>
				<li><a href="NaviServlet">Navi</a></li>
				<li><a href="OggettiServlet">Oggetti</a></li>
				<li><a href="PersonaggiServlet">Personaggi</a></li>
				<li><a href="ProfessioniServlet">Professioni</a></li>
				<li><a href="RazzaServlet">Razze</a></li>
				<li><a href="ResistenzeServlet">Resistenze</a></li>
				<li><a href="StatusAlteratiServlet">Status Alterati</a></li>
				<li><a href="TipiServlet">Tipo Frutti</a></li>
				<li><a href="QualitaServlet">Qualità Frutti</a></li>
				<li><a href="TipologieServlet">Tipologie Equipaggiamento</a></li>
				<li><a href="MercantiServlet">Mercanti</a></li>
				<li><a href="AbilitaFruttoServlet">Abilita Frutti</a></li>
				<li><a href="AbilitaProfessioneServlet">Abilita Professioni</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="leftBar">
			<h2>Collegamenti</h2>
			<ul>
				<li><a href="MasterPageServlet">Capitoli</a></li>
				<li><a href="CiurmaServlet">Ciurma</a></li>
				<li><a href="FruttiServlet">Frutti</a></li>
				<li><a href="MappeServlet">Mappe</a></li>
				<li><a href="NaviServlet">Navi</a></li>
				<li><a href="OggettiServlet">Oggetti</a></li>
				<li><a href="PersonaggiServlet">Personaggi</a></li>
				<li><a href="ProfessioniServlet">Professioni</a></li>
				<li><a href="RazzaServlet">Razze</a></li>
				<li><a href="ResistenzeServlet">Resistenze</a></li>
				<li><a href="StatusAlteratiServlet">Status Alterati</a></li>
				<li><a href="TipiServlet">Tipo Frutti</a></li>
				<li><a href="QualitaServlet">Qualità Frutti</a></li>
				<li><a href="TipologieServlet">Tipologie Equipaggiamento</a></li>
				<li><a href="MercantiServlet">Mercanti</a></li>
				<li><a href="AbilitaFruttoServlet">Abilita Frutti</a></li>
				<li><a href="AbilitaProfessioneServlet">Abilita Professioni</a></li>
			</ul>
		</div>

		<div class="centerBar">
			<h1>Modifica Capitolo</h1>
			<%
			Capitolo capitolo = (Capitolo) request.getAttribute("capitolo");
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
						List<Mappa> mappe = BusinessLogic.listaMappe();
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
		</div>
	</div>
</body>
</html>