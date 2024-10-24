<%@page import="org.prepuzy.model.Capitolo"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettagli Capitolo</title>
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

		<div class="capitoloDetails">
			<%
			Capitolo capitolo = (Capitolo) request.getAttribute("capitolo");
			if (capitolo != null) {
			%>
			<h1>Dettagli Capitolo: <%= capitolo.getTitolo() %></h1>
			<img src="<%= capitolo.getMappa().getImmagine() %>" alt="Immagine di <%= capitolo.getTitolo() %>" width="300" height="300">
			<p><strong>Descrizione:</strong> <%= capitolo.getTesto() %></p>
			
			<div class="actions">
				<form action="ModificaCapitoloServlet" method="get">
					<input type="hidden" name="idCapitolo" value="<%= capitolo.getId() %>">
					<button type="submit" class="buttonMod">Modifica Capitolo</button>
				</form>		
				<form action="EliminaCapitoloServlet" method="post" onsubmit="return confirm('Sei sicuro di voler eliminare questo capitolo?');">
					<input type="hidden" name="idCapitolo" value="<%= capitolo.getId() %>">
					<button type="submit" class="buttonDelete">Elimina Capitolo</button>
				</form>
			</div>
			<%
			} else {
			%>
			<p>Capitolo non trovato.</p>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>
