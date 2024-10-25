<%@page import="java.util.List"%>
<%@ page import="org.prepuzy.model.Razza"%>
<%@ page import="org.prepuzy.model.Professione"%>
<%@ page import="org.prepuzy.model.Ciurma"%>
<%@ page import="org.prepuzy.model.Nave"%>
<%@ page import="org.prepuzy.model.Mappa"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Aggiungi Personaggio</title>
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
				<li><a href="${pageContext.request.contextPath}/QualitaServlet">Qualità Frutti</a></li>
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
				<li><a href="${pageContext.request.contextPath}/QualitaServlet">Qualità Frutti</a></li>
				<li><a href="${pageContext.request.contextPath}/master/TipologieServlet">Tipologie Equipaggiamento</a></li>
				<li><a href="${pageContext.request.contextPath}/MercantiServlet">Mercanti</a></li>
				<li><a href="${pageContext.request.contextPath}/master/AbilitaFruttoServlet">Abilita Frutti</a></li>
				<li><a href="${pageContext.request.contextPath}/master/AbilitaProfessioneServlet">Abilita Professioni</a></li>
			</ul>
		</div>

		<div class="centerBar">
			<h1>Aggiungi Nuovo Personaggio</h1>

			<form action="master/AggiungiPersonaggioServlet" method="post"
				enctype="multipart/form-data">
				<div class="formGroup">
					<label for="nome">Nome:</label> <input type="text" id="nome"
						name="nome" required>
				</div>
				<div class="formGroup">
					<label for="soprannome">Soprannome:</label> <input type="text"
						id="soprannome" name="soprannome" required>
				</div>
				<div>
					<label for="descrizione">Descrizione:</label>
					<textarea id="descrizione" name="descrizione" rows="4" required></textarea>
				</div>
				<div class="upload-container">
					<label for="immagine">Carica Immagine:</label> <input type="file"
						id="immagine" name="immagine" accept="image/*" required>
					<button type="button" class="upload-button"
						onclick="document.getElementById('immagine').click();">
						Seleziona Immagine</button>
					<div class="file-name" id="fileName">Nessun file selezionato</div>
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
				<div class="formGroup">
					<label for="classeArmatura">Classe Armatura</label> <input
						type="number" id="classeArmatura" name="classeArmatura" required>
				</div>
				<div class="formGroup">
					<label for="abilita">Descrizione:</label>
					<textarea id="abilita" name="abilita" rows="4" required></textarea>
				</div>
				<div>
					<label for="razza">Seleziona Razza:</label> <select id="razza"
						name="razza">
						<%
						List<Razza> listaRazze = (List<Razza>) request.getAttribute("listaRazze");
						if (listaRazze != null && !listaRazze.isEmpty()) {
							for (Razza razza : listaRazze) {
						%>
						<option value="<%=razza.getId()%>"><%=razza.getNome()%></option>
						<%
						}
						} else {
						%>
						<option value="">Nessuna razza disponibile</option>
						<%
						}
						%>
					</select>
				</div>

				<div>
					<label for="professione">Seleziona Professione:</label> <select
						id="professione" name="professione">
						<%
						List<Professione> listaProfessioni = (List<Professione>) request.getAttribute("listaProfessioni");
						if (listaProfessioni != null && !listaProfessioni.isEmpty()) {
							for (Professione professione : listaProfessioni) {
						%>
						<option value="<%=professione.getId()%>"><%=professione.getNome()%></option>
						<%
						}
						} else {
						%>
						<option value="">Nessuna professione disponibile</option>
						<%
						}
						%>
					</select>
				</div>

				<div>
					<label>Seleziona Ciurma:</label> <select id="ciurma" name="ciurma">
						<%
						List<Ciurma> listaCiurme = (List<Ciurma>) request.getAttribute("listaCiurme");
						if (listaCiurme != null && !listaCiurme.isEmpty()) {
							for (Ciurma ciurma : listaCiurme) {
						%>
						<option value="<%=ciurma.getId()%>"><%=ciurma.getNome()%></option>
						<%
						}
						} else {
						%>
						<option value="">Nessuna ciurma disponibile</option>
						<%
						}
						%>
					</select>
				</div>
				<div>
					<label for="nave">Seleziona Nave:</label> <select id="nave"
						name="nave">
						<%
						List<Nave> listaNavi = (List<Nave>) request.getAttribute("listaNavi");
						if (listaNavi != null && !listaNavi.isEmpty()) {
							for (Nave nave : listaNavi) {
						%>
						<option value="<%=nave.getId()%>"><%=nave.getNome()%></option>
						<%
						}
						} else {
						%>
						<option value="">Nessuna nave disponibile</option>
						<%
						}
						%>
					</select>
				</div>

				<div>
					<label for="mappa">Seleziona Mappa:</label> <select id="mappa"
						name="mappa">
						<%
						List<Mappa> listaMappe = (List<Mappa>) request.getAttribute("listaMappe");
						if (listaMappe != null && !listaMappe.isEmpty()) {
							for (Mappa mappa : listaMappe) {
						%>
						<option value="<%=mappa.getId()%>"><%=mappa.getNome()%></option>
						<%
						}
						} else {
						%>
						<option value="">Nessuna mappa disponibile</option>
						<%
						}
						%>
					</select>
				</div>

				<div class="formGroup">
					<label for="isVisibleToAll">Visibile a tutti:</label> <input
						type="checkbox" id="isVisibleToAll" name="isVisibleToAll">
				</div>
				<div class="formGroup">
					<label for="isMercante">Mercante:</label> <input type="checkbox"
						id="isMercante" name="isMercante">
				</div>
				<div class="formGroup">
					<button type="submit" class="btnAdd">Aggiungi Personaggi</button>
				</div>
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
