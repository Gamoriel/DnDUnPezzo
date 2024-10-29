<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Oggetto"%>
<%@page import="org.prepuzy.model.Resistenza"%>
<%@page import="org.prepuzy.model.Razza"%>
<%@page import="org.prepuzy.model.Professione"%>
<%@page import="org.prepuzy.model.StatusAlterati"%>
<%@page import="org.prepuzy.model.Tipologia"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Modifica Oggetto</title>
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
			<%
			Oggetto oggetto = (Oggetto) request.getAttribute("oggetto");
			%>
			<h1>Modifica Oggetto</h1>

			<form action="${pageContext.request.contextPath}/master/ModificaOggettoServlet" method="post">
				<input type="hidden" name="idOggetto" value="<%=oggetto.getId()%>">

				<label for="nome">Nome:</label> 
				<input type="text" id="nome" name="nome" value="<%=oggetto.getNome()%>" required> 
				<label for="descrizione">Descrizione:</label>
				<textarea id="descrizione" name="descrizione" required><%=oggetto.getDescrizione()%></textarea>

				<label for="prezzo">Prezzo:</label> 
				<input type="number" id="prezzo" name="prezzo" value="<%=oggetto.getPrezzo()%>" required> 
				<label for="peso">Peso:</label> 
				<input type="text" id="peso" name="peso" value="<%=oggetto.getPeso()%>"> 
				<label for="forza">Forza:</label>
				<input type="number" id="forza" name="forza" value="<%=oggetto.getForza()%>" required> 
				<label for="destrezza">Destrezza:</label> 
				<input type="number" id="destrezza" name="destrezza" value="<%=oggetto.getDestrezza()%>" required> 
				<label for="costituzione">Costituzione:</label> 
				<input type="number" id="costituzione" name="costituzione" value="<%=oggetto.getCostituzione()%>" required> 
				<label for="intelligenza">Intelligenza:</label> 
				<input type="number" id="intelligenza" name="intelligenza" value="<%=oggetto.getIntelligenza()%>" required> 
				<label for="saggezza">Saggezza:</label> 
				<input type="number" id="saggezza" name="saggezza" value="<%=oggetto.getSaggezza()%>" required>
				<label for="carisma">Carisma:</label> 
				<input type="number" id="carisma" name="carisma" value="<%=oggetto.getCarisma()%>" required> 
				<label for="hp">HP:</label> 
				<input type="number" id="hp" name="hp" value="<%=oggetto.getHp()%>" required>
				<label for="classeArmatura">Classe Armatura:</label> 
				<input type="number" id="classeArmatura" name="classeArmatura" value="<%=oggetto.getHp()%>" required>


				<h2>Resistenze</h2>
				<div>
					<%
					List<Resistenza> resistenzeOggetto = oggetto.getResistenze();
					List<Resistenza> tutteLeResistenze = (List<Resistenza>) request.getAttribute("resistenze");
					for (Resistenza resistenza : tutteLeResistenze) {
					%>
					<label> <input type="checkbox" name="resistenze"
						value="<%=resistenza.getId()%>"
						<%=resistenzeOggetto.contains(resistenza) ? "checked" : ""%>>
						<%=resistenza.getNome()%>
					</label>
					<%
					}
					%>
				</div>

				<h2>Razze</h2>
				<div>
					<%
					List<Razza> razzeOggetto = oggetto.getRazze();
					List<Razza> tutteLeRazze = (List<Razza>) request.getAttribute("razze");
					for (Razza razza : tutteLeRazze) {
					%>
					<label> <input type="checkbox" name="razze"
						value="<%=razza.getId()%>"
						<%=razzeOggetto.contains(razza) ? "checked" : ""%>> <%=razza.getNome()%>
					</label>
					<%
					}
					%>
				</div>

				<h2>Professioni</h2>
				<div>
					<%
					List<Professione> professioniOggetto = oggetto.getProfessioni();
					List<Professione> tutteLeProfessioni = (List<Professione>) request.getAttribute("professioni");
					for (Professione professione : tutteLeProfessioni) {
					%>
					<label> <input type="checkbox" name="professioni"
						value="<%=professione.getId()%>"
						<%=professioniOggetto.contains(professione) ? "checked" : ""%>>
						<%=professione.getNome()%>
					</label>
					<%
					}
					%>
				</div>

				<h2>Status Alterati</h2>
				<div>
					<%
					List<StatusAlterati> statusOggetto = oggetto.getStatus();
					List<StatusAlterati> tuttiGliStatus = (List<StatusAlterati>) request.getAttribute("status");
					for (StatusAlterati status : tuttiGliStatus) {
					%>
					<label> <input type="checkbox" name="status"
						value="<%=status.getId()%>"
						<%=statusOggetto.contains(status) ? "checked" : ""%>> <%=status.getNome()%>
					</label>
					<%
					}
					%>
				</div>

				<h2>Tipologia</h2>
				<select name="tipologia">
					<%
					Tipologia tipologiaOggetto = oggetto.getTipologia();
					List<Tipologia> tutteLeTipologie = (List<Tipologia>) request.getAttribute("tipologie");
					for (Tipologia tipologia : tutteLeTipologie) {
					%>
					<option value="<%=tipologia.getId()%>"
						<%=tipologiaOggetto.getId() == tipologia.getId() ? "selected" : ""%>>
						<%=tipologia.getNome()%>
					</option>
					<%
					}
					%>
				</select>

				<div class="formGroup">
					<label for="isVisibleToAll">Visibile a tutti:</label><input
						type="checkbox" id="isVisibleToAll" name="isVisibleToAll"
						<%=oggetto.isVisibleToAll() ? "checked" : ""%>>
				</div>
				<button type="submit" class="btnSave">Salva Modifiche</button>
			</form>
		</div>
	</div>
</body>
</html>