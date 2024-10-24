<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Ciurma"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Dettagli Ciurma</title>
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
			<h1>Dettagli della Ciurma</h1>
			<%
			Ciurma ciurma = (Ciurma) request.getAttribute("ciurma");
			List<Personaggio> membri = (List<Personaggio>) request.getAttribute("membri");
			if (ciurma != null) {
			%>
			<h2><%=ciurma.getNome()%></h2>
			<img src="<%=ciurma.getJollyRoger()%>" alt="Jolly Roger"
				class="jollyRogerImage">
			<p>
				<strong>Descrizione:</strong>
				<%=ciurma.getDescrizione()%></p>

			<h3>Membri della Ciurma:</h3>
			<%
			if (membri != null && !membri.isEmpty()) {
				for (Personaggio membro : membri) {
			%>
			<div>
				<a
					href="DettagliPersonaggioServlet?idPersonaggio=<%=membro.getId()%>">
					<%=membro.getNome()%>
				</a>
			</div>
			<%
			}
			} else {
			%>
			<p>Nessun membro trovato per questa ciurma.</p>
			<%
			}
			%>
			<%
			} else {
			%>
			<p>Ciurma non trovata.</p>
			<%
			}
			%>

			<div class="actionButtons">
				<form action="ModificaCiurmaServlet" method="get">
					<input type="hidden" name="idCiurma" value="<%=ciurma.getId()%>">
					<button class="buttonMod" type="submit">Modifica Ciurma</button>
				</form>
				<form action="EliminaCiurmaServlet" method="post"
					onsubmit="return confirm('Sei sicuro di voler cancellare questa ciurma?');">
					<input type="hidden" name="idCiurma" value="<%=ciurma.getId()%>">
					<button class="buttonDel" type="submit">Cancella Ciurma</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>