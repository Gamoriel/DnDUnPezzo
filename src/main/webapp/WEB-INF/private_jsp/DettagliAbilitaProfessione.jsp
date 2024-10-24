<%@page import="org.prepuzy.model.AbilitaProfessione"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Dettaglio Abilità</title>
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
			<h1>Dettaglio Abilità</h1>
			<%
			AbilitaProfessione abilita = (AbilitaProfessione) request.getAttribute("abilita");
			if (abilita != null) {
			%>
			<h2>
				Nome:
				<%=abilita.getNome()%></h2>
			<p>
				<strong>Descrizione:</strong>
				<%=abilita.getDescrizione()%></p>
			<p>
				<strong>Frutto Associato:</strong>
				<%=abilita.getProfessione().getNome()%></p>
			<div class="actionButtons">
				<form action="ModificaAbilitaProfessioneServlet" method="get">
					<input type="hidden" name="idAbilita" value="<%=abilita.getId()%>">
					<button type="submit" class="buttonMod">Modifica Abilità</button>
				</form>
				<form action="EliminaAbilitaProfessioneServlet" method="post"
					onsubmit="return confirm('Sei sicuro di voler eliminare questa abilita?');">
					<input type="hidden" name="idAbilita" value="<%=abilita.getId()%>">
					<button type="submit" class="buttonDel">Elimina Capitolo</button>
				</form>
			</div>
			<%
			} else {
			%>
			<p>Abilità non trovata.</p>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>
