<%@page import="org.prepuzy.model.AbilitaFrutto"%>
<%@page import="java.util.List"%>
<%@ page import="org.prepuzy.model.StatusAlterati"%>
<%@ page import="org.prepuzy.model.Qualita"%>
<%@ page import="org.prepuzy.model.Tipo"%>
<%@ page import="org.prepuzy.model.Resistenza"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Aggiungi Frutto</title>
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
			<h1>Aggiungi Nuovo Frutto</h1>

			<form action="${pageContext.request.contextPath}/master/AggiungiFruttoServlet" method="post">
				<div class="formGroup">
					<label for="nome">Nome:</label> <input type="text" id="nome"
						name="nome" required>
				</div>
				<div class="formGroup">
					<label for="descrizione">Descrizione:</label>
					<textarea id="descrizione" name="descrizione" rows="4" required></textarea>
				</div>
				<div class="formGroup">
					<label for="prezzo">Prezzo:</label> <input type="number"
						id="prezzo" name="prezzo" required>
				</div>

				<div class="formGroup">
					<label for="forza">Forza:</label> <input type="number" id="forza"
						name="forza" required>
				</div>
				<div class="formGroup">
					<label for="destrezza">Destrezza:</label> <input type="number"
						id="destrezza" name="destrezza" required>
				</div>
				<div class="formGroup">
					<label for="costituzione">Costituzione:</label> <input
						type="number" id="costituzione" name="costituzione" required>
				</div>
				<div class="formGroup">
					<label for="intelligenza">Intelligenza:</label> <input
						type="number" id="intelligenza" name="intelligenza" required>
				</div>
				<div class="formGroup">
					<label for="saggezza">Saggezza:</label> <input type="number"
						id="saggezza" name="saggezza" required>
				</div>
				<div class="formGroup">
					<label for="carisma">Carisma:</label> <input type="number"
						id="carisma" name="carisma" required>
				</div>
				<div class="formGroup">
					<label for="hp">HP:</label> <input type="number" id="hp" name="hp"
						required>
				</div>

				<div>
					<label for="tipo">Seleziona Tipo:</label> <select id="tipo"
						name="tipo" required>
						<%
						List<Tipo> listaTipi = (List<Tipo>) request.getAttribute("listaTipi");
						for (Tipo tipo : listaTipi) {
						%>
						<option value="<%=tipo.getId()%>"><%=tipo.getTipo()%></option>
						<%
						}
						%>
					</select>
				</div>

				<div>
					<label for="qualita">Seleziona Qualità:</label> <select
						id="qualita" name="qualita" required>
						<%
						List<Qualita> listaQualita = (List<Qualita>) request.getAttribute("listaQualita");
						for (Qualita qualita : listaQualita) {
						%>
						<option value="<%=qualita.getId()%>"><%=qualita.getQualita()%></option>
						<%
						}
						%>
					</select>
				</div>
				<div>
					<label>Status Alterati:</label>
					<%
					List<StatusAlterati> listaStatus = (List<StatusAlterati>) request.getAttribute("listaStatus");
					for (StatusAlterati status : listaStatus) {
					%>
					<input type="checkbox" name="status" value="<%=status.getId()%>">
					<%=status.getNome()%><br>
					<%
					}
					%>
				</div>
				<div>
					<label>Resistenze:</label>
					<%
					List<Resistenza> listaResistenze = (List<Resistenza>) request.getAttribute("listaResistenze");
					for (Resistenza resistenza : listaResistenze) {
					%>
					<input type="checkbox" name="resistenze"
						value="<%=resistenza.getId()%>">
					<%=resistenza.getNome()%><br>
					<%
					}
					%>
				</div>
				<div>
					<label>Abilità:</label>
					<%
					List<AbilitaFrutto> listaAbilita = (List<AbilitaFrutto>) request.getAttribute("listaAbilita");
					for (AbilitaFrutto abilita : listaAbilita) {
					%>
					<input type="checkbox" name="abilita" value="<%=abilita.getId()%>">
					<%=abilita.getNome()%><br>
					<%
					}
					%>
				</div>
				<div class="formGroup">
					<label for="isVisibleToAll">Visibile a tutti:</label> <input
						type="checkbox" id="isVisibleToAll" name="isVisibleToAll">
				</div>
				<div class="formGroup">
					<button type="submit" class="btnAdd">Aggiungi Frutto</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
