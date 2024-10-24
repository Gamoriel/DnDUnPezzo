<%@page import="org.prepuzy.model.Oggetto"%>
<%@page import="org.prepuzy.model.Resistenza"%>
<%@page import="org.prepuzy.model.Razza"%>
<%@page import="org.prepuzy.model.Professione"%>
<%@page import="org.prepuzy.model.StatusAlterati"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettagli Oggetto</title>
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
		<%
		Oggetto oggetto = (Oggetto) request.getAttribute("oggetto");
		%>
		<h1>
			Dettagli di
			<%=oggetto.getNome()%></h1>

		<div class="dettagliOggetto">
			<p>
				<strong>Nome:</strong>
				<%=oggetto.getNome()%></p>
			<p>
				<strong>Descrizione:</strong>
				<%=oggetto.getDescrizione()%></p>
			<p>
				<strong>Prezzo:</strong>
				<%=oggetto.getPrezzo()%>
				berry
			</p>
			<p>
				<strong>Peso:</strong>
				<%=oggetto.getPeso()%>
			</p>


			<h2>Statistiche</h2>
			<p>
				<strong>Forza:</strong>
				<%=oggetto.getForza()%></p>
			<p>
				<strong>Destrezza:</strong>
				<%=oggetto.getDestrezza()%></p>
			<p>
				<strong>Costituzione:</strong>
				<%=oggetto.getCostituzione()%></p>
			<p>
				<strong>Intelligenza:</strong>
				<%=oggetto.getIntelligenza()%></p>
			<p>
				<strong>Saggezza:</strong>
				<%=oggetto.getSaggezza()%></p>
			<p>
				<strong>Carisma:</strong>
				<%=oggetto.getCarisma()%></p>
			<p>
				<strong>HP:</strong>
				<%=oggetto.getHp()%></p>

			<h2>Resistenze</h2>
			<ul>
				<%
				if (oggetto.getResistenze() != null && !oggetto.getResistenze().isEmpty()) {
					for (Resistenza resistenza : oggetto.getResistenze()) {
				%>
				<li><a
					href="DettagliResistenzaServlet?idResistenza=<%=resistenza.getId()%>"><%=resistenza.getNome()%></a></li>
				<%
				}
				} else {
				%>
				<li>Nessuna resistenza associata</li>
				<%
				}
				%>
			</ul>

			<h2>Razze</h2>
			<ul>
				<%
				if (oggetto.getRazze() != null && !oggetto.getRazze().isEmpty()) {
					for (Razza razza : oggetto.getRazze()) {
				%>
				<li><a href="DettagliRazzaServlet?idRazza=<%=razza.getId()%>"><%=razza.getNome()%></a></li>
				<%
				}
				} else {
				%>
				<li>Nessuna razza associata</li>
				<%
				}
				%>
			</ul>

			<h2>Professioni</h2>
			<ul>
				<%
				if (oggetto.getProfessioni() != null && !oggetto.getProfessioni().isEmpty()) {
					for (Professione professione : oggetto.getProfessioni()) {
				%>
				<li><a
					href="DettagliProfessioneServlet?idProfessione=<%=professione.getId()%>"><%=professione.getNome()%></a></li>
				<%
				}
				} else {
				%>
				<li>Nessuna professione associata</li>
				<%
				}
				%>
			</ul>

			<h2>Status Alterati</h2>
			<ul>
				<%
				if (oggetto.getStatus() != null && !oggetto.getStatus().isEmpty()) {
					for (StatusAlterati status : oggetto.getStatus()) {
				%>
				<li><a
					href="DettagliStatusAlteratiServlet?idStatus=<%=status.getId()%>"><%=status.getNome()%></a></li>
				<%
				}
				} else {
				%>
				<li>Nessuno status alterato associato</li>
				<%
				}
				%>
			</ul>


			<div class="actionButtons">
				<form action="ModificaOggettoServlet" method="get"
					style="display: inline;">
					<input type="hidden" name="idOggetto" value="<%=oggetto.getId()%>">
					<button type="submit" class="buttonMod">Modifica Oggetto</button>
				</form>
				<form action="EliminaOggettoServlet" method="post"
					style="display: inline;"
					onsubmit="return confirm('Sei sicuro di voler cancellare questo oggetto?');">
					<input type="hidden" name="idOggetto" value="<%=oggetto.getId()%>">
					<button type="submit" class="buttonDel">Cancella Oggetto</button>
				</form>
			</div>
		</div>

		<a href="OggettiServlet" class="buttonMod">Torna alla lista
			oggetti</a>
	</div>
</body>
</html>
