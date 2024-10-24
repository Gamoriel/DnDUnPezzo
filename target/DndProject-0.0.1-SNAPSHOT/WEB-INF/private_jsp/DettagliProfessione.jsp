<%@page import="org.prepuzy.model.Professione"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettagli Professione</title>
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
		Professione professione = (Professione) request.getAttribute("professione");
		if (professione != null) {
		%>
		<h2><%=professione.getNome()%></h2>
		<p>
			<strong>Descrizione:</strong>
			<%=professione.getDescrizione()%></p>
		<p>
			<strong>Altre Informazioni:</strong>
		</p>
		<ul>
			<li>Forza: <%=professione.getForza()%></li>
			<li>Destrezza: <%=professione.getDestrezza()%></li>
			<li>Costituzione: <%=professione.getCostituzione()%></li>
			<li>Intelligenza: <%=professione.getIntelligenza()%></li>
			<li>Saggezza: <%=professione.getSaggezza()%></li>
			<li>Carisma: <%=professione.getCarisma()%></li>
			<li>HP: <%=professione.getHp()%></li>
		</ul>
		<form action="ProfessioniServlet" method="get">
			<button type="submit">Torna alla lista professioni</button>
		</form>
		<%
		} else {
		%>
		<p>Professione non trovata.</p>
		<%
		}
		%>
		<div class="actionButtons">
			<form action="ModificaProfessioneServlet" method="get">
				<input type="hidden" name="idCiurma"
					value="<%=professione.getId()%>">
				<button class="buttonMod" type="submit">Modifica Ciurma</button>
			</form>
			<form action="EliminaProfessioneServlet" method="post"
				onsubmit="return confirm('Sei sicuro di voler cancellare questa ciurma?');">
				<input type="hidden" name="idCiurma"
					value="<%=professione.getId()%>">
				<button class="buttonDel" type="submit">Cancella Ciurma</button>
			</form>
		</div>
	</div>
</body>
</html>
