<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Aggiungi Nuova Ciurma</title>
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
			<h1>Aggiungi Nuova Ciurma</h1>

			<form action="AggiungiCiurmaServlet" method="post"
				enctype="multipart/form-data">
				<div class="formGroup">
					<label for="nome">Nome:</label> <input type="text" id="nome"
						name="nome" required>
				</div>

				<div class="upload-container">
					<label for="jollyRoger" class="upload-label">Carica
						Immagine:</label> <input type="file" id="jollyRoger" name="jollyRoger"
						accept="image/*" required onchange="updateFileName()">
					<button type="button" class="upload-button"
						onclick="document.getElementById('jollyRoger').click();">
						Seleziona Immagine</button>
					<div class="file-name" id="fileName">Nessun file selezionato</div>
				</div>

				<div class="formGroup">
					<label for="descrizione">Descrizione:</label>
					<textarea id="descrizione" name="descrizione" rows="5" cols="40"
						required></textarea>
				</div>
				<div class="formGroup">
					<label for="isVisibleToAll">Visibile a tutti:</label> <input
						type="checkbox" id="isVisibleToAll" name="isVisibleToAll">
				</div>
				<div class="formGroup">
					<button type="submit" class="btnAdd">Aggiungi Ciurma</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
