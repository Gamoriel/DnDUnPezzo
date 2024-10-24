<%@page import="org.prepuzy.model.Mappa"%>
<%@page import="org.prepuzy.model.Capitolo"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
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
			<h1>Lista Capitoli</h1>
			<%
			Set<Capitolo> listaCapitoli = (Set<Capitolo>) request.getAttribute("listaCapitoli");
			if (listaCapitoli != null && !listaCapitoli.isEmpty()) {
				for (Capitolo c : listaCapitoli) {
			%>
			<div class="chapCard">
				<div class="mapImage"
					style="background-image: url(<%=c.getMappa().getImmagine()%>)">
					<span><%=c.getTitolo()%></span>
					<form style="width: 100%;" action="MasterLogicServlet"
						method="post">
						<input type="hidden" name="portaACapitolo" value="<%=c.getId()%>" />
						<button class="btnGoToChap" type="submit" name="action"
							value="portaACapitolo">Vai a capitolo</button>
					</form>
				</div>
			</div>
			<%
			}
			} else {
			%>
			<p>Nessuna ciurma trovata.</p>
			<%
			}
			%>
						<div class="addCapitoloBtn">
				<form action="AggiungiCapitoloServlet" method="get">
					<button type="submit" class="btnAdd">Aggiungi Nuovo
						Capitolo</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>