<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Mappa"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Dettagli Mappa</title>
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
			<h1>Dettagli della Mappa</h1>

			<%
			Mappa mappa = (Mappa) request.getAttribute("mappa");
			List<Personaggio> personaggi = (List<Personaggio>) request.getAttribute("personaggi");
			if (mappa != null) {
			%>
			<h2><%=mappa.getNome()%></h2>
			<img src="<%=mappa.getImmagine()%>" alt="Immagine della Mappa"
				class="mappaImage">
			<p>
				<strong>Descrizione:</strong>
				<%=mappa.getDescrizione()%></p>

			<h3>Personaggi associati alla mappa:</h3>
			<%
			if (personaggi != null && !personaggi.isEmpty()) {
				for (Personaggio personaggio : personaggi) {
			%>
			<div>
				<a
					href="DettagliPersonaggioServlet?idPersonaggio=<%=personaggio.getId()%>">
					<%=personaggio.getNome()%>
				</a>
			</div>
			<%
			}
			} else {
			%>
			<p>Nessun personaggio associato a questa mappa.</p>
			<%
			}
			%>

			<div class="actionButtons">
				<form action="ModificaMappaServlet" method="get">
					<input type="hidden" name="idMappa" value="<%=mappa.getId()%>">
					<button class="buttonMod" type="submit">Modifica Mappa</button>
				</form>
				<form action="EliminaMappaServlet" method="post"
					onsubmit="return confirm('Sei sicuro di voler cancellare questa mappa?');">
					<input type="hidden" name="idMappa" value="<%=mappa.getId()%>">
					<button class="buttonDel" type="submit">Cancella Mappa</button>
				</form>
			</div>
			<%
			} else {
			%>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>
