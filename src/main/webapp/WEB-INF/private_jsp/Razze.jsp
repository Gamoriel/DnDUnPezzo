<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Razza"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Lista Razze</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Style.css">
</head>
<body>
	<nav>
		<div class="addNew">
			<form action="${pageContext.request.contextPath}/master/AggiungiRazzaServlet" method="get">
				<button type="submit" class="btnAdd">Aggiungi Razza</button>
			</form>
		</div>
		<div id="menuToggle">
			<input type="checkbox" /> <span></span> <span></span> <span></span>
			<ul id="menu">
				<li><a href="${pageContext.request.contextPath}/MasterPageServlet">Capitoli</a></li>
				<li><a href="${pageContext.request.contextPath}/CiurmaServlet">Ciurma</a></li>
				<li><a href="${pageContext.request.contextPath}/FruttiServlet">Frutti</a></li>
				<li><a href="${pageContext.request.contextPath}/MappeServlet">Mappe</a></li>
				<li><a href="${pageContext.request.contextPath}/NaviServlet">Navi</a></li>
				<li><a href="${pageContext.request.contextPath}/OggettiServlet">Oggetti</a></li>
				<li><a href="${pageContext.request.contextPath}/NPCorGiocatoreServlet">Personaggi</a></li><li><a href="${pageContext.request.contextPath}/TaglieServlet">Taglie</a></li>
				<li><a href="${pageContext.request.contextPath}/ProfessioniServlet">Professioni</a></li>
				<li><a href="${pageContext.request.contextPath}/RazzaServlet">Razze</a></li>
				<li><a href="${pageContext.request.contextPath}/ResistenzeServlet">Resistenze</a></li>
				<li><a href="${pageContext.request.contextPath}/StatusAlteratiServlet">Status Alterati</a></li>
				<li><a href="${pageContext.request.contextPath}/master/TipiServlet">Tipo Frutti</a></li>
				 <li><a href="${pageContext.request.contextPath}/master/QualitaServlet">Qualità Frutti</a></li>  
				<li><a href="${pageContext.request.contextPath}/master/TipologieServlet">Tipologie Equipaggiamento</a></li>
				<li><a href="${pageContext.request.contextPath}/MercantiServlet">Mercanti</a></li>
				<li><a href="${pageContext.request.contextPath}/master/AbilitaFruttoServlet">Abilita Frutti</a></li>
				<li><a href="${pageContext.request.contextPath}/master/AbilitaProfessioneServlet">Abilita Professioni</a></li><li><a href="${pageContext.request.contextPath}/master/TecnicheServlet">Tecniche</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="leftBar">
			<h2>Collegamenti</h2>
			<ul>
				<li><a href="${pageContext.request.contextPath}/MasterPageServlet">Capitoli</a></li>
				<li><a href="${pageContext.request.contextPath}/CiurmaServlet">Ciurma</a></li>
				<li><a href="${pageContext.request.contextPath}/FruttiServlet">Frutti</a></li>
				<li><a href="${pageContext.request.contextPath}/MappeServlet">Mappe</a></li>
				<li><a href="${pageContext.request.contextPath}/NaviServlet">Navi</a></li>
				<li><a href="${pageContext.request.contextPath}/OggettiServlet">Oggetti</a></li>
				<li><a href="${pageContext.request.contextPath}/NPCorGiocatoreServlet">Personaggi</a></li><li><a href="${pageContext.request.contextPath}/TaglieServlet">Taglie</a></li>
				<li><a href="${pageContext.request.contextPath}/ProfessioniServlet">Professioni</a></li>
				<li><a href="${pageContext.request.contextPath}/RazzaServlet">Razze</a></li>
				<li><a href="${pageContext.request.contextPath}/ResistenzeServlet">Resistenze</a></li>
				<li><a href="${pageContext.request.contextPath}/StatusAlteratiServlet">Status Alterati</a></li>
				<li><a href="${pageContext.request.contextPath}/master/TipiServlet">Tipo Frutti</a></li>
				 <li><a href="${pageContext.request.contextPath}/master/QualitaServlet">Qualità Frutti</a></li>  
				<li><a href="${pageContext.request.contextPath}/master/TipologieServlet">Tipologie Equipaggiamento</a></li>
				<li><a href="${pageContext.request.contextPath}/MercantiServlet">Mercanti</a></li>
				<li><a href="${pageContext.request.contextPath}/master/AbilitaFruttoServlet">Abilita Frutti</a></li>
				<li><a href="${pageContext.request.contextPath}/master/AbilitaProfessioneServlet">Abilita Professioni</a></li><li><a href="${pageContext.request.contextPath}/master/TecnicheServlet">Tecniche</a></li>
			</ul>
		</div>

		<div class="centerBar">
			<h1>Lista Razze</h1>
			<div class="cardContainerNoImg">
				<%
				List<Razza> razze = (List<Razza>) request.getAttribute("listaRazze");
				if (razze != null && !razze.isEmpty()) {
					for (Razza razza : razze) {
				%>
				<div class="listCard">
					<h2><%=razza.getNome()%></h2>
					<div class="formContainer">
						<form action="${pageContext.request.contextPath}/DettagliRazzaServlet" method="get">
							<input type="hidden" name="idRazza" value="<%=razza.getId()%>">
							<button type="submit" class="buttonMod">Dettagli</button>
						</form>
					</div>
				</div>
				<%
				}
				} else {
				%>
				<p>Nessuna razza disponibile</p>
				<%
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>
