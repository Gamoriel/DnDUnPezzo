<%@page import="java.util.Set"%>
<%@page import="org.prepuzy.model.Mappa"%>
<%@page import="org.prepuzy.businesslogic.BusinessLogic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi Capitolo</title>
<link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
	<nav>
		<div class="navBar">
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
			</ul>
		</div>

		<div class="centerBar">
			<h1>Aggiungi Nuovo Capitolo</h1>

			<form action="AggiungiCapitoloServlet" method="post">
				<div class="formGroup">
					<label for="titolo">Titolo:</label>
					<input type="text" id="titolo" name="titolo" required>
				</div>

				<div class="formGroup">
					<label for="testo">Testo:</label>
					<textarea id="testo" name="testo" rows="5" cols="40" required></textarea>
				</div>

				<div class="formGroup">
					<label for="mappa">Seleziona Mappa:</label>
					<select id="mappa" name="mappa">
						<%
						Set<Mappa> listaMappe = BusinessLogic.listaMappe();
						if (listaMappe != null && !listaMappe.isEmpty()) {
							for (Mappa mappa : listaMappe) {
						%>
						<option value="<%=mappa.getId()%>"><%=mappa.getNome()%></option>
						<%
							}
						} else {
						%>
						<option value="">Nessuna mappa disponibile</option>
						<%
						}
						%>
					</select>
				</div>

				<div class="formGroup">
					<button type="submit" class="btnAdd">Aggiungi Capitolo</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
