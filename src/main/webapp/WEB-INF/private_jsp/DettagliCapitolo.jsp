<%@page import="org.prepuzy.model.Mappa"%>
<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Capitolo"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Dettagli Capitolo</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
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
				<li><a href="${pageContext.request.contextPath}/NPCorGiocatoreServlet">Personaggi</a></li>
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
				<li><a href="${pageContext.request.contextPath}/NPCorGiocatoreServlet">Personaggi</a></li>
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
			<%
			Capitolo capitolo = (Capitolo) request.getAttribute("capitoloSelezionato");
			if (capitolo != null) {
			    if (capitolo.getMappa().getImmagine() != null) {
			%>
			<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner" style="height: 40vh">
					<%
					if (capitolo.getMappa() != null && capitolo.getMappa().getMappe() != null) {
					    List<Mappa> mappe = capitolo.getMappa().getMappe();
					    boolean isActive = true;
					    for (Mappa mappa : mappe) {
						String imageUrl = mappa.getImmagine();
					%>
					<div class="carousel-item <%=isActive ? "active" : ""%>"><img class="d-block w-100 img-fluid" src="<%=imageUrl%>" alt="Slide" style="object-fit: contain; max-height: 40vh;"></div> <%
 isActive = false;
 }
 } else {
 %>
					<p>Nessuna immagine disponibile per questo capitolo.</p> <%
 }
 %>
			</div> <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev" style="position: absolute"> <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="sr-only">Precedente</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next" style="position: absolute"> <span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="sr-only">Successivo</span>
			</a>
		</div> <%
 } else {
 %>
			<p>Nessuna Immagine per questo Capitolo</p> <%
 }
 %>
			<h1>Dettagli Capitolo: <%=capitolo.getTitolo()%></h1>
			<p><strong>Descrizione:</strong> <%=capitolo.getTesto()%></p>

			<div class="actionButtons">
				<form action="${pageContext.request.contextPath}/master/ModificaCapitoloServlet" method="get"><input type="hidden" name="idCapitolo" value="<%=capitolo.getId()%>">
					<button type="submit" class="buttonMod">Modifica Capitolo</button></form>
				<form action="${pageContext.request.contextPath}/master/EliminaCapitoloServlet" method="post" onsubmit="return confirm('Sei sicuro di voler eliminare questo capitolo?');"><input
					type="hidden" name="idCapitolo" value="<%=capitolo.getId()%>">
					<button type="submit" class="buttonDel">Elimina Capitolo</button></form>
		</div> <%
 } else {
 %>
			<p>Capitolo non trovato.</p> <%
 }
 %>
	</div>
</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
