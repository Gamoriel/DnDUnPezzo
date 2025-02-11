<%@page import="org.prepuzy.model.AbilitaProfessione"%>
<%@page import="java.util.List"%>
<%@ page import="org.prepuzy.model.Professione"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Aggiungi Professione</title>
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
			<h1>Aggiungi Nuova Professione</h1>

			<form action="${pageContext.request.contextPath}/master/AggiungiProfessioneServlet" method="post">
				<div class="formGroup">
					<label for="nome">Nome:</label> <input type="text" id="nome"
						name="nome" required>
				</div>

				<div class="formGroup">
					<label for="descrizione">Descrizione:</label>
					<textarea id="descrizione" name="descrizione" rows="4" required></textarea>
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
					<label>Abilità:</label>
					<%
					List<AbilitaProfessione> listaAbilita = (List<AbilitaProfessione>) request.getAttribute("listaAbilita");
					for (AbilitaProfessione abilita : listaAbilita) {
					%>
					<input type="checkbox" name="abilita" value="<%=abilita.getId()%>">
					<%=abilita.getNome()%><br>
					<%
					}
					%>
				</div>
				<div>
					<input type="submit" value="Aggiungi Professione">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
