<%@page import="java.util.Set"%>
<%@page import="org.prepuzy.model.Razza"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Razze</title>
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
		<h1>Lista Razze</h1>
			<%
            Set<Razza> razze = (Set<Razza>) request.getAttribute("listaRazze");
            if (razze != null && !razze.isEmpty()) {
                for (Razza razza : razze) {
            %>
			<div class="razzaCard">
				<h2><%=razza.getNome()%></h2>
				<p>
					Descrizione: <%=razza.getDescrizione() != null ? razza.getDescrizione() : "N/A" %>
				</p>
				<form action="DettagliRazzaServlet" method="get">
					<input type="hidden" name="idRazza" value="<%=razza.getId()%>">
					<button type="submit" class="buttonMod">Dettagli</button>
				</form>
			</div>
			<%
                }
            } else {
            %>
			<p>Nessuna razza disponibile</p>
			<%
            }
            %>
			<div class="addNew">
				<form action="AggiungiRazzaServlet" method="get">
					<button type="submit" class="btnAdd">Aggiungi Razza</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
