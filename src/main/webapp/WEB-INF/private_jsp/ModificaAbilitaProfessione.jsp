<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page import="org.prepuzy.model.AbilitaProfessione"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Modifica Abilità Professione</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Style.css">
</head>
<body>
	<nav>
		
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
				<li><a href="${pageContext.request.contextPath}/master/AbilitaProfessioneServlet">Abilita Professioni</a></li><li><a href="${pageContext.request.contextPath}/master/TecnicheServlet">Tecniche</a></li>
			</ul>
		</div>

		<div class="centerBar">
			<h1>Modifica Abilità Professione</h1>

			<%
			AbilitaProfessione abilita = (AbilitaProfessione) request.getAttribute("abilita");
			List<Personaggio> listaPersonaggi = (List<Personaggio>) request.getAttribute("listaPersonaggi");
			%>

			<form action="${pageContext.request.contextPath}/master/ModificaAbilitaProfessioneServlet" method="post">
				<input type="hidden" name="idAbilita" value="<%=abilita.getId()%>">

				<label for="nome">Nome Abilità:</label> <input type="text"
					name="nome" value="<%=abilita.getNome()%>" required><br>
				<br> <label for="descrizione">Descrizione:</label>
				<textarea name="descrizione" rows="4" cols="50" required><%=abilita.getDescrizione()%></textarea>
				<br>
				<br>

				<h3>Personaggi che possono vedere questa abilità:</h3>
				<%
				for (Personaggio personaggio : listaPersonaggi) {
					boolean isVisible = abilita.getVisibileAPersonaggio().contains(personaggio);
				%>
				<input type="checkbox" name="personaggiVisibili"
					value="<%=personaggio.getId()%>"
					<%=isVisible ? "checked" : ""%>> <label><%=personaggio.getNome()%></label><br>
				<%
				}
				%>
				<br>
				<button type="submit" class="btnSave">Salva Modifiche</button>
			</form>
		</div>
	</div>
</body>
</html>