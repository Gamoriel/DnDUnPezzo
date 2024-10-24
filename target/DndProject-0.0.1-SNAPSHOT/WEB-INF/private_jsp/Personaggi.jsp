<%@page import="org.prepuzy.model.Personaggio"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco Personaggi</title>
<link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
	<nav>
		<div class="navBar"></div>
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
			</ul>
		</div>

		<div class="centerBar">
			<h1>Elenco Personaggi</h1>

			<div class="personaggi-container">
				<%
				Set<Personaggio> personaggi = (Set<Personaggio>) request.getAttribute("personaggi");

				if (personaggi != null && !personaggi.isEmpty()) {
					for (Personaggio personaggio : personaggi) {
				%>
				<div class="personaggio-card">
					<img
						src="<%=personaggio.getUrlImmagine() != null ? personaggio.getUrlImmagine() : "Resources/img/default.jpg"%>"
						alt="Immagine <%=personaggio.getNome()%>">

					<h3><%=personaggio.getNome()%></h3>

					<form action="DettagliPersonaggioServlet" method="get">
						<input type="hidden" name="idPersonaggio"
							value="<%=personaggio.getId()%>">
						<button class="buttonDettagli" type="submit">Dettagli</button>
					</form>
				</div>
				<%
				}
				} else {
				%>
				<p>Nessun personaggio trovato.</p>
				<%
				}
				%>
				<div class="addNew">
					<form action="AggiungiPersonaggioServlet" method="get">
						<button type="submit" class="btnAdd">Aggiungi Personaggio</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
