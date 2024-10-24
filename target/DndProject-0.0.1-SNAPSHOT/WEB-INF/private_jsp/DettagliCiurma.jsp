<%@page import="java.util.Set"%>
<%@page import="org.prepuzy.model.Ciurma"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettagli Ciurma</title>
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
		<h1>Dettagli della Ciurma</h1>
		<%
		Ciurma ciurma = (Ciurma) request.getAttribute("ciurma");
		Set<Personaggio> membri = (Set<Personaggio>) request.getAttribute("membri");
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
		<a href="CiurmaServlet">Torna alla lista delle ciurme</a>
		<%
		} else {
		%>
		<p>Ciurma non trovata.</p>
		<a href="CiurmaServlet">Torna alla lista delle ciurme</a>
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
</body>
</html>