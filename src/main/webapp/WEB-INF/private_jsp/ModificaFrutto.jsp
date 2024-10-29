<%@page import="org.prepuzy.model.AbilitaFrutto"%>
<%@ page import="org.prepuzy.model.Tipo"%>
<%@ page import="org.prepuzy.model.Qualita"%>
<%@ page import="org.prepuzy.model.StatusAlterati"%>
<%@ page import="org.prepuzy.model.Resistenza"%>
<%@ page import="org.prepuzy.model.Frutto"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Modifica Frutto</title>
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
			<h1>Modifica Frutto</h1>

			<%
			Frutto frutto = (Frutto) request.getAttribute("frutto");
			List<Tipo> tipi = (List<Tipo>) request.getAttribute("tipi");
			List<Qualita> qualita = (List<Qualita>) request.getAttribute("qualita");
			List<StatusAlterati> status = (List<StatusAlterati>) request.getAttribute("status");
			List<Resistenza> resistenze = (List<Resistenza>) request.getAttribute("resistenze");

			if (frutto != null) {
			%>
			<form action="${pageContext.request.contextPath}/master/ModificaFruttoServlet" method="post">
				<input type="hidden" name="idFrutto" value="<%=frutto.getId()%>">

				<label for="nome">Nome:</label> <input type="text" name="nome"
					value="<%=frutto.getNome()%>" required><br> <label
					for="descrizione">Descrizione:</label>
				<textarea name="descrizione" required><%=frutto.getDescrizione()%></textarea>
				<br> <label for="prezzo">Prezzo:</label> <input type="text"
					name="prezzo" value="<%=frutto.getPrezzo()%>" required><br>

				<label for="tipo">Tipo:</label> <select name="tipo" required>
					<%
					for (Tipo t : tipi) {
					%>
					<option value="<%=t.getId()%>"
						<%=t.getId() == frutto.getTipo().getId() ? "selected" : ""%>>
						<%=t.getTipo()%>
					</option>
					<%
					}
					%>
				</select><br> <label for="qualita">Qualità:</label> <select
					name="qualita" required>
					<%
					for (Qualita q : qualita) {
					%>
					<option value="<%=q.getId()%>"
						<%=q.getId() == frutto.getQualita().getId() ? "selected" : ""%>>
						<%=q.getQualita()%>
					</option>
					<%
					}
					%>
				</select><br> <label>Resistenze:</label>
				<div>
					<%
					for (Resistenza r : resistenze) {
					%>
					<input type="checkbox" name="resistenze" value="<%=r.getId()%>"
						<%=frutto.getResistenza().contains(r) ? "checked" : ""%>>
					<%=r.getNome()%><br>
					<%
					}
					%>
				</div>

				<label>Status Alterati:</label>
				<div>
					<%
					for (StatusAlterati s : status) {
					%>
					<input type="checkbox" name="status" value="<%=s.getId()%>"
						<%=frutto.getStatus().contains(s) ? "checked" : ""%>>
					<%=s.getNome()%><br>
					<%
					}
					%>
				</div>
				<div>
					<label>Abilità Frutto:</label>
					<%
					List<AbilitaFrutto> listaAbilita = (List<AbilitaFrutto>) request.getAttribute("listaAbilita");
					for (AbilitaFrutto abilita : listaAbilita) {
					%>
					<input type="checkbox" name="abilita" value="<%=abilita.getId()%>"
						<%=frutto.getAbilita().contains(abilita) ? "checked" : ""%>>
					<%=abilita.getNome()%><br>
					<%
					}
					%>
				</div>

				<h3>Caratteristiche</h3>
				<label for="forza">Forza:</label> <input type="text" name="forza"
					value="<%=frutto.getForza()%>"><br> <label
					for="destrezza">Destrezza:</label> <input type="text"
					name="destrezza" value="<%=frutto.getDestrezza()%>"><br>

				<label for="costituzione">Costituzione:</label> <input type="text"
					name="costituzione" value="<%=frutto.getCostituzione()%>"><br>

				<label for="intelligenza">Intelligenza:</label> <input type="text"
					name="intelligenza" value="<%=frutto.getIntelligenza()%>"><br>

				<label for="saggezza">Saggezza:</label> <input type="text"
					name="saggezza" value="<%=frutto.getSaggezza()%>"><br>

				<label for="carisma">Carisma:</label> <input type="text"
					name="carisma" value="<%=frutto.getCarisma()%>"><br> <label
					for="hp">HP:</label> <input type="text" name="hp"
					value="<%=frutto.getHp()%>"><br>
				<div class="formGroup">
					<label for="isVisibleToAll">Visibile a tutti:</label> <input
						type="checkbox" id="isVisibleToAll" name="isVisibleToAll">
				</div>
				<button type="submit" class="btnSave">Salva Modifiche</button>
			</form>
			<%
			} else {
			%>
			<p>Frutto non trovato.</p>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>
