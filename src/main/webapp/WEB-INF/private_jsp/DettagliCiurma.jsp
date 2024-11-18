<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Ciurma"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Dettagli Ciurma</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Style.css">
</head>
<body>
	<nav>

		<div id="menuToggle"><input type="checkbox" /> <span></span> <span></span> <span></span>
			<ul id="menu">
				<li><a href="${pageContext.request.contextPath}/MasterPageServlet">Capitoli</a></li>
				<li><a href="${pageContext.request.contextPath}/CiurmaServlet">Ciurma</a></li>
				<li><a href="${pageContext.request.contextPath}/FruttiServlet">Frutti</a></li>
				<li><a href="${pageContext.request.contextPath}/MappeServlet">Mappe</a></li>
				<li><a href="${pageContext.request.contextPath}/NaviServlet">Navi</a></li>
				<li><a href="${pageContext.request.contextPath}/OggettiServlet">Oggetti</a></li>
				<li><a href="${pageContext.request.contextPath}/PersonaggiServlet">Personaggi</a></li>
			<li><a href="${pageContext.request.contextPath}/TaglieServlet">Taglie</a></li>
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
			<li><a href="${pageContext.request.contextPath}/master/TecnicheServlet">Tecniche</a></li>
		</ul></div>
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
			<li><a href="${pageContext.request.contextPath}/TaglieServlet">Taglie</a></li>
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
			<li><a href="${pageContext.request.contextPath}/master/TecnicheServlet">Tecniche</a></li>
		</ul>
	</div>
		<div class="centerBar">
			<h1>Dettagli della Ciurma</h1> <%
 Ciurma ciurma = (Ciurma) request.getAttribute("ciurma");
 List<Personaggio> membri = (List<Personaggio>) request.getAttribute("membri");
 if (ciurma != null) {
 %>
			<h2><%=ciurma.getNome()%></h2> <img src="<%=ciurma.getJollyRoger()%>" alt="Jolly Roger" class="jollyRogerImage">
			<p><strong>Descrizione:</strong> <%=ciurma.getDescrizione()%></p>

			<h3>Membri della Ciurma:</h3> <%
 if (membri != null && !membri.isEmpty()) {
     for (Personaggio membro : membri) {
 %>
			<div><a href="${pageContext.request.contextPath}/DettagliPersonaggioServlet?idPersonaggio=<%=membro.getId()%>"> <%=membro.getNome()%>
			</a></div> <%
 }
 } else {
 %>
			<p>Nessun membro trovato per questa ciurma.</p> <%
 }
 %> <%
 } else {
 %>
			<p>Ciurma non trovata.</p> <%
 }
 %>

			<div class="actionButtons">
				<form action="${pageContext.request.contextPath}/master/ModificaCiurmaServlet" method="get"><input type="hidden" name="idCiurma" value="<%=ciurma.getId()%>">
					<button class="buttonMod" type="submit">Modifica Ciurma</button></form>
				<form action="${pageContext.request.contextPath}/master/EliminaCiurmaServlet" method="post" onsubmit="return confirm('Sei sicuro di voler cancellare questa ciurma?');"><input type="hidden"
					name="idCiurma" value="<%=ciurma.getId()%>">
					<button class="buttonDel" type="submit">Cancella Ciurma</button></form>
		</div>
	</div>
</div>
</body>
</html>