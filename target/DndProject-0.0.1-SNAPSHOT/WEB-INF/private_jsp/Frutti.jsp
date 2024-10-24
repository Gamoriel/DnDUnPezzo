<%@page import="java.util.Set"%>
<%@page import="org.prepuzy.model.Frutto"%>
<%@page import="org.prepuzy.model.Tipo"%>
<%@page import="org.prepuzy.model.Qualita"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Frutti</title>
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
		<h1>Lista Frutti</h1>
			<%
            Set<Frutto> frutti = (Set<Frutto>) request.getAttribute("frutti");
            if (frutti != null && !frutti.isEmpty()) {
                for (Frutto frutto : frutti) {
            %>
			<div class="fruttoCard">
				<h2><%=frutto.getNome()%></h2>
				<p>
					Tipo:
					<%=frutto.getTipo() != null ? frutto.getTipo().getTipo() : "N/A"%></p>
				<p>
					Qualità:
					<%=frutto.getQualita() != null ? frutto.getQualita().getQualita() : "N/A"%></p>
				<form action="DettagliFruttoServlet" method="get">
					<input type="hidden" name="idFrutto" value="<%=frutto.getId()%>">
					<button type="submit" class="buttonMod">Dettagli</button>
				</form>
			</div>
			<%
                }
            } else {
            %>
			<p>Nessun frutto disponibile</p>
			<%
            }
            %>

			<div class="addNew">
				<form action="AggiungiFruttoServlet" method="get">
					<button type="submit" class="btnAdd">Aggiungi Frutto</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
