<%@page import="org.prepuzy.controller.frutto.FruttiServlet"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page import="org.prepuzy.model.Razza"%>
<%@page import="org.prepuzy.model.Professione"%>
<%@page import="org.prepuzy.model.Ciurma"%>
<%@page import="org.prepuzy.model.Nave"%>
<%@page import="org.prepuzy.model.Frutto"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Modifica Personaggio</title>
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
			<h1>Modifica Personaggio</h1>

			<%
			Personaggio personaggio = (Personaggio) request.getAttribute("personaggio");
			List<Razza> razze = (List<Razza>) request.getAttribute("razze");
			List<Professione> professioni = (List<Professione>) request.getAttribute("professioni");
			List<Ciurma> ciurme = (List<Ciurma>) request.getAttribute("ciurme");
			List<Nave> navi = (List<Nave>) request.getAttribute("navi");
			List<Frutto> frutti = (List<Frutto>) request.getAttribute("frutti");
			%>

			<form action="${pageContext.request.contextPath}/master/ModificaPersonaggioServlet" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="id" value="<%=personaggio.getId()%>">

				<label for="nome">Nome:</label> <input type="text" id="nome"
					name="nome" value="<%=personaggio.getNome()%>" required><br>

				<label for="soprannome">Soprannome:</label> <input type="text"
					id="soprannome" name="soprannome"
					value="<%=personaggio.getSoprannome()%>" required><br>
				<label for="descrizione">Descrizione:</label>
				<textarea id="descrizione" name="descrizione" required><%=personaggio.getDescrizione()%></textarea>
				<br> <label for="taglia">Taglia:</label> <input type="number"
					id="taglia" name="taglia"
					value="<%=personaggio.getTaglia() != null ? personaggio.getTaglia().toString() : ""%>"><br>

				<label for="razza">Razza:</label> <select id="razza" name="razza">
					<option value="">Seleziona Razza</option>
					<%
					for (Razza razza : razze) {
					%>
					<option value="<%=razza.getId()%>"
						<%=personaggio.getRazza() != null && personaggio.getRazza().getId() == razza.getId() ? "selected" : ""%>>
						<%=razza.getNome()%>
					</option>
					<%
					}
					%>
				</select><br> <label for="professione">Professione:</label> <select
					id="professione" name="professione">
					<option value="">Seleziona Professione</option>
					<%
					for (Professione professione : professioni) {
					%>
					<option value="<%=professione.getId()%>"
						<%=personaggio.getProfessione() != null && personaggio.getProfessione().getId() == professione.getId()
		? "selected"
		: ""%>>
						<%=professione.getNome()%>
					</option>
					<%
					}
					%>
				</select><br> <label for="ciurma">Ciurma:</label> <select id="ciurma"
					name="ciurma">
					<option value="">Seleziona Ciurma</option>
					<%
					for (Ciurma ciurma : ciurme) {
					%>
					<option value="<%=ciurma.getId()%>"
						<%=personaggio.getCiurma() != null && personaggio.getCiurma().getId() == ciurma.getId() ? "selected" : ""%>>
						<%=ciurma.getNome()%>
					</option>
					<%
					}
					%>
				</select><br> <label for="nave">Nave:</label> <select id="nave"
					name="nave">
					<option value="">Seleziona Nave</option>
					<%
					for (Nave nave : navi) {
					%>
					<option value="<%=nave.getId()%>"
						<%=personaggio.getNave() != null && personaggio.getNave().getId() == nave.getId() ? "selected" : ""%>>
						<%=nave.getNome()%>
					</option>
					<%
					}
					%>
				</select><br> <label for="nave">Frutto:</label> <select id="nave"
					name="nave">
					<option value="">Seleziona Nave</option>
					<%
					for (Frutto frutto : frutti) {
					%>
					<option value="<%=frutto.getId()%>"
						<%=personaggio.getNave() != null && personaggio.getNave().getId() == frutto.getId() ? "selected" : ""%>>
						<%=frutto.getNome()%>
					</option>
					<%
					}
					%>
				</select><br> <label for="frutto">Frutto:</label> <select id="frutto"
					name="frutto">
					<option value="">Seleziona Frutto</option>
					<%
					for (Frutto frutto : frutti) {
					%>
					<option value="<%=frutto.getId()%>"
						<%=personaggio.getFrutto() != null && personaggio.getFrutto().getId() == frutto.getId() ? "selected" : ""%>>
						<%=frutto.getNome()%>
					</option>
					<%
					}
					%>
				</select><br>
				<div class="upload-container">
					<label for="immagine">Carica Immagine:</label> <input type="file"
						id="immagine" name="immagine" accept="image/*" required>
					<button type="button" class="upload-button"
						onclick="document.getElementById('immagine').click();">
						Seleziona Immagine</button>
					<div class="file-name" id="fileName">Nessun file selezionato</div>
				</div>

				<h2>Statistiche</h2>
				<label for="forza">Forza:</label> <input type="number" id="forza"
					name="forza" value="<%=personaggio.getForza()%>" required><br>

				<label for="destrezza">Destrezza:</label> <input type="number"
					id="destrezza" name="destrezza"
					value="<%=personaggio.getDestrezza()%>" required><br>

				<label for="costituzione">Costituzione:</label> <input type="number"
					id="costituzione" name="costituzione"
					value="<%=personaggio.getCostituzione()%>" required><br>

				<label for="intelligenza">Intelligenza:</label> <input type="number"
					id="intelligenza" name="intelligenza"
					value="<%=personaggio.getIntelligenza()%>" required><br>

				<label for="saggezza">Saggezza:</label> <input type="number"
					id="saggezza" name="saggezza"
					value="<%=personaggio.getSaggezza()%>" required><br> <label
					for="carisma">Carisma:</label> <input type="number" id="carisma"
					name="carisma" value="<%=personaggio.getCarisma()%>" required><br>

				<label for="hp">HP:</label> <input type="number" id="hp" name="hp"
					value="<%=personaggio.getHp()%>" required><br> <label
					for="classeArmatura">Classe Armatura:</label> <input type="number"
					id="classeArmatura" name="classeArmatura"
					value="<%=personaggio.getClasseArmatura()%>" required><br>

				<div class="formGroup">
					<label for="isVisibleToAll">Visibile a tutti:</label> <input
						type="checkbox" id="isVisibleToAll" name="isVisibleToAll">
				</div>
				<div class="formGroup">
					<label for="isMercante">Mercante:</label> <input type="checkbox"
						id="isMercante" name="isMercante">
				</div>
				<button type="submit" class="btnSave">Salva Modifiche</button>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		document.getElementById('immagine').addEventListener(
				'change',
				function() {
					const fileName = this.files[0] ? this.files[0].name
							: 'Nessun file selezionato';
					document.getElementById('fileName').textContent = fileName;
				});
	</script>
</body>
</html>
