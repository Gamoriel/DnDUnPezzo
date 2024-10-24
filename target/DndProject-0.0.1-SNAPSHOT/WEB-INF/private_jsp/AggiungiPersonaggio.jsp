<%@page import="org.prepuzy.model.Oggetto"%>
<%@ page import="java.util.Set"%>
<%@ page import="org.prepuzy.model.Razza"%>
<%@ page import="org.prepuzy.model.Professione"%>
<%@ page import="org.prepuzy.model.Ciurma"%>
<%@ page import="org.prepuzy.model.Nave"%>
<%@ page import="org.prepuzy.model.Mappa"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi Personaggio</title>
<link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
	<nav>
		<div class="navBar"></div>
	</nav>

	<div class="container">
		<div class="leftBar">
			<h2>Collegamenti</h2>
			<ul>
				<li><a href="MasterPageServlet">Capitoli</a></li>
				<li><a href="CiurmaServlet">Ciurma</a></li>
				<li><a href="FruttiServlet">Frutti</a></li>
				<li><a href="MappeServlet">Mappe</a></li>
				<li><a href="NaviServlet">Navi</a></li>
				<li><a href="OggettiServlet">Oggetti</a></li>
				<li><a href="PersonaggiServlet">Personaggi</a></li>
				<li><a href="ProfessioniServlet">Professioni</a></li>
				<li><a href="RazzaServlet">Razze</a></li>
				<li><a href="ResistenzeServlet">Resistenze</a></li>
				<li><a href="StatusAlteratiServlet">Status Alterati</a></li>
				<li><a href="TipiServlet">Tipo Frutti</a></li>
				<li><a href="QualitaServlet">Qualità Frutti</a></li>
			</ul>
		</div>

		<div class="centerBar">
			<h1>Aggiungi Nuovo Personaggio</h1>

			<form action="AggiungiPersonaggioServlet" method="post"
				enctype="multipart/form-data">
				<div>
					<label for="nome">Nome:</label> <input type="text" id="nome"
						name="nome" required>
				</div>
				<div>
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
				<div>
					<label for="forza">Forza:</label> <input type="number" id="forza"
						name="forza" required>
				</div>
				<div>
					<label for="destrezza">Destrezza:</label> <input type="number"
						id="destrezza" name="destrezza" required>
				</div>
				<div>
					<label for="costituzione">Costituzione:</label> <input
						type="number" id="costituzione" name="costituzione" required>
				</div>
				<div>
					<label for="intelligenza">Intelligenza:</label> <input
						type="number" id="intelligenza" name="intelligenza" required>
				</div>
				<div>
					<label for="saggezza">Saggezza:</label> <input type="number"
						id="saggezza" name="saggezza" required>
				</div>
				<div>
					<label for="carisma">Carisma:</label> <input type="number"
						id="carisma" name="carisma" required>
				</div>
				<div>
					<label for="hp">HP:</label> <input type="number" id="hp" name="hp"
						required>
				</div>

				<div>
					<label for="razza">Seleziona Razza:</label> <select id="razza"
						name="razza" required>
						<%
						Set<Razza> listaRazze = (Set<Razza>) request.getAttribute("listaRazze");
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
						id="professione" name="professione" required>
						<%
						Set<Professione> listaProfessioni = (Set<Professione>) request.getAttribute("listaProfessioni");
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
						Set<Ciurma> listaCiurme = (Set<Ciurma>) request.getAttribute("listaCiurme");
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
					<label>Seleziona Oggetto per l'Inventario:</label> <select
						id="oggetto" name="oggetto">
						<%
						Set<Oggetto> listaOggetti = (Set<Oggetto>) request.getAttribute("listaOggetti");
						if (listaOggetti != null && !listaOggetti.isEmpty()) {
							for (Oggetto oggetto : listaOggetti) {
						%>
						<option value="<%=oggetto.getId()%>"><%=oggetto.getNome()%></option>
						<%
						}
						} else {
						%>
						<option value="">Nessun oggetto disponibile</option>
						<%
						}
						%>
					</select> <label for="quantita">Quantità:</label> <input type="number"
						id="quantita" name="quantita" required>
				</div>

				<div>
					<label for="nave">Seleziona Nave:</label> <select id="nave"
						name="nave">
						<%
						Set<Nave> listaNavi = (Set<Nave>) request.getAttribute("listaNavi");
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
						Set<Mappa> listaMappe = (Set<Mappa>) request.getAttribute("listaMappe");
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

				<div>
					<input type="submit" value="Aggiungi Personaggio">
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
