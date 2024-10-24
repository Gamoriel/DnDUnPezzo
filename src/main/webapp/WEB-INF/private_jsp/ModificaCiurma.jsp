<%@ page import="org.prepuzy.model.Ciurma"%>
<%@ page import="org.prepuzy.model.Personaggio"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Modifica Ciurma</title>
<link rel="stylesheet" href="resources/css/Style.css">
<script>
	function updateFileName() {
		const fileInput = document.getElementById('jollyRoger');
		const fileNameDisplay = document.getElementById('fileName');
		const uploadButton = document.querySelector('.upload-button');

		if (fileInput.files.length > 0) {
			const fileName = fileInput.files[0].name;
			fileNameDisplay.textContent = '';
			uploadButton.textContent = fileName;
		} else {
			fileNameDisplay.textContent = 'Nessun file selezionato';
			uploadButton.textContent = 'Seleziona Immagine';
		}
	}
</script>
</head>
<body>
	<nav>
		
		<div id="menuToggle">
			<input type="checkbox" /> <span></span> <span></span> <span></span>
			<ul id="menu">
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
				<li><a href="TipologieServlet">Tipologie Equipaggiamento</a></li>
				<li><a href="MercantiServlet">Mercanti</a></li>
				<li><a href="AbilitaFruttoServlet">Abilita Frutti</a></li>
				<li><a href="AbilitaProfessioneServlet">Abilita Professioni</a></li>
			</ul>
		</div>
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
				<li><a href="TipologieServlet">Tipologie Equipaggiamento</a></li>
				<li><a href="MercantiServlet">Mercanti</a></li>
				<li><a href="AbilitaFruttoServlet">Abilita Frutti</a></li>
				<li><a href="AbilitaProfessioneServlet">Abilita Professioni</a></li>
			</ul>
		</div>
		<div class="centerBar">
			<h1>Modifica Ciurma</h1>

			<%
			Ciurma ciurma = (Ciurma) request.getAttribute("ciurma");
			List<Personaggio> allPersonaggi = (List<Personaggio>) request.getAttribute("allPersonaggi");
			if (ciurma != null) {
			%>
			<form action="ModificaCiurmaServlet" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="idCiurma" value="<%=ciurma.getId()%>">

				<label for="nome">Nome:</label> <input type="text" name="nome"
					value="<%=ciurma.getNome()%>" required><br> <label
					for="jollyRoger">Jolly Roger:</label>

				<div class="upload-container">
					<label for="jollyRoger" class="upload-label">Carica
						Immagine:</label> <input type="file" id="jollyRoger" name="jollyRoger"
						accept="image/*" required onchange="updateFileName()">
					<button type="button" class="upload-button"
						onclick="document.getElementById('jollyRoger').click();">
						Seleziona Immagine</button>
					<div class="file-name" id="fileName">Nessun file selezionato</div>
				</div>

				<label for="descrizione">Descrizione:</label>
				<textarea name="descrizione" required><%=ciurma.getDescrizione()%></textarea>
				<br>

				<h3>Personaggi nella Ciurma</h3>
				<div>
					<%
					List<Personaggio> personaggiCiurma = ciurma.getPersonaggi();
					if (personaggiCiurma != null && !personaggiCiurma.isEmpty()) {
						for (Personaggio p : personaggiCiurma) {
					%>
					<div>
						<input type="checkbox" name="personaggiDaRimuovere"
							value="<%=p.getId()%>">
						<%=p.getNome()%>
						(Soprannome:
						<%=p.getSoprannome()%>)
					</div>
					<%
					}
					} else {
					%>
					<p>Nessun personaggio attualmente nella ciurma.</p>
					<%
					}
					%>
				</div>

				<h3>Aggiungi Personaggi alla Ciurma</h3>
				<div>
					<%
					if (allPersonaggi != null && !allPersonaggi.isEmpty()) {
						for (Personaggio p : allPersonaggi) {
							boolean isInCiurma = false;
							if (personaggiCiurma != null) {
						for (Personaggio pc : personaggiCiurma) {
							if (pc.getId() == p.getId()) {
								isInCiurma = true;
								break;
							}
						}
							}

							if (!isInCiurma) {
					%>
					<div>
						<input type="checkbox" name="personaggiDaAggiungere"
							value="<%=p.getId()%>">
						<%=p.getNome()%>
						(Soprannome:
						<%=p.getSoprannome()%>)
					</div>
					<%
					}
					}
					} else {
					%>
					<p>Nessun personaggio disponibile da aggiungere.</p>
					<%
					}
					%>
				</div>
				<div class="formGroup">
					<label for="isVisibleToAll">Visibile a tutti:</label> <input
						type="checkbox" id="isVisibleToAll" name="isVisibleToAll">
				</div>
				<button type="submit" class="btnSave">Salva Modifiche</button>
			</form>
			<%
			} else {
			%>
			<p>Ciurma non trovata.</p>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>