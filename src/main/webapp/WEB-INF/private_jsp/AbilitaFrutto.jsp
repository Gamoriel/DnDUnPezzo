<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page import="org.prepuzy.model.AbilitaFrutto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Abilità Frutto</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Style.css">
</head>
<body>
	<nav>
		<div class="addNew">
			<form action="${pageContext.request.contextPath}/master/AggiungiAbilitaFruttoServlet" method="get">
				<button type="submit" class="btnAdd">Aggiungi Abilità Frutto</button>
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
				<li><a href="${pageContext.request.contextPath}/PersonaggiServlet">Personaggi</a></li>
				<li><a href="${pageContext.request.contextPath}/ProfessioniServlet">Professioni</a></li>
				<li><a href="${pageContext.request.contextPath}/RazzaServlet">Razze</a></li>
				<li><a href="${pageContext.request.contextPath}/ResistenzeServlet">Resistenze</a></li>
				<li><a href="${pageContext.request.contextPath}/StatusAlteratiServlet">Status Alterati</a></li>
				<li><a href="${pageContext.request.contextPath}/master/TipiServlet">Tipo Frutti</a></li>
				 <li><a href="${pageContext.request.contextPath}/master/QualitaServlet">Qualità Frutti</a></li>  
				<li><a href="${pageContext.request.contextPath}/master/TipologieServlet">Tipologie Equipaggiamento</a></li>
				<li><a href="${pageContext.request.contextPath}/MercantiServlet">Mercanti</a></li>
				<li><a href="${pageContext.request.contextPath}/master/AbilitaFruttoServlet">Abilita Frutti</a></li>
				<li><a href="${pageContext.request.contextPath}/master/AbilitaProfessioneServlet">Abilita Professioni</a></li>
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
				<li><a href="${pageContext.request.contextPath}/PersonaggiServlet">Personaggi</a></li>
				<li><a href="${pageContext.request.contextPath}/ProfessioniServlet">Professioni</a></li>
				<li><a href="${pageContext.request.contextPath}/RazzaServlet">Razze</a></li>
				<li><a href="${pageContext.request.contextPath}/ResistenzeServlet">Resistenze</a></li>
				<li><a href="${pageContext.request.contextPath}/StatusAlteratiServlet">Status Alterati</a></li>
				<li><a href="${pageContext.request.contextPath}/master/TipiServlet">Tipo Frutti</a></li>
				 <li><a href="${pageContext.request.contextPath}/master/QualitaServlet">Qualità Frutti</a></li>  
				<li><a href="${pageContext.request.contextPath}/master/TipologieServlet">Tipologie Equipaggiamento</a></li>
				<li><a href="${pageContext.request.contextPath}/MercantiServlet">Mercanti</a></li>
				<li><a href="${pageContext.request.contextPath}/master/AbilitaFruttoServlet">Abilita Frutti</a></li>
				<li><a href="${pageContext.request.contextPath}/master/AbilitaProfessioneServlet">Abilita Professioni</a></li>
			</ul>
		</div>

		<div class="centerBar">
			<h1>Lista Abilità per Frutto</h1>
				<%
				Map<String, List<AbilitaFrutto>> abilitaPerFrutto = (Map<String, List<AbilitaFrutto>>) request.getAttribute("abilitaPerFrutto");
				if (abilitaPerFrutto != null && !abilitaPerFrutto.isEmpty()) {
					for (Map.Entry<String, List<AbilitaFrutto>> entry : abilitaPerFrutto.entrySet()) {
						String nomeFrutto = entry.getKey();
						List<AbilitaFrutto> abilitaList = entry.getValue();
				%>
			<h2><%=nomeFrutto%></h2>
			<div class="cardContainer">
					<%
					for (AbilitaFrutto abilita : abilitaList) {
					%>
					<div class="listCard">
						<h2><%=abilita.getNome()%></h2>
						<p>
							<strong>Descrizione:</strong>
							<%=abilita.getDescrizione()%></p>
						<div class="formContainer">
							<form action="DettagliAbilitaFruttoServlet" method="get">
								<input type="hidden" name="idAbilita"
									value="<%=abilita.getId()%>">
								<button class="buttonMod" type="submit">Dettagli
									Abilità</button>
							</form>
						</div>
					</div>
					<%
					}
					%>
				</div>
				<%
				}
				} else {
				%>
				<p>Nessuna abilità trovata.</p>
				<%
				}
				%>
		</div>
	</div>
</body>
</html>
