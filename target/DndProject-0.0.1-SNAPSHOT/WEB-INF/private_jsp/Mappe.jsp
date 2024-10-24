<%@page import="org.prepuzy.model.Mappa"%>
<%@page import="java.util.Set"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista delle Mappe</title>
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
			<h1>Lista delle Mappe</h1>
			<%
			Set<Mappa> listaMappe = (Set<Mappa>) request.getAttribute("listaMappe");
			if (listaMappe != null && !listaMappe.isEmpty()) {
			%>
			<%
			for (Mappa mappa : listaMappe) {
			%>
			<div class="mappaCard">
				<h2><%=mappa.getNome()%></h2>
				<img src="<%=mappa.getImmagine()%>" alt="Immagine di <%=mappa.getNome()%>" width="200" height="200">
				<p><strong>Descrizione:</strong> <%=mappa.getDescrizione()%></p>
				<form action="DettagliMappaServlet" method="get">
					<input type="hidden" name="idMappa" value="<%=mappa.getId()%>">
					<button type="submit" class="buttonMod">Visualizza Dettagli</button>
				</form>
			</div>
			<%
			}
			} else {
			%>
			<p>Nessuna mappa disponibile.</p>
			<%
			}
			%>

			<div class="addNew">
				<form action="AggiungiMappaServlet" method="get">
					<button type="submit" class="btnAdd">Aggiungi Mappa</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
