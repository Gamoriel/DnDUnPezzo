<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi Nuova Ciurma</title>
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
				<li><a href="TipologieServlet">Tipologie Equipaggiamento</a></li>
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
						accept="image/*" required>
					<button type="button" class="upload-button"
						onclick="document.getElementById('immagine').click();">
						Seleziona Immagine</button>
					<div class="file-name" id="fileName">Nessun file selezionato</div>
				</div>


				<div class="formGroup">
					<label for="descrizione">Descrizione:</label>
					<textarea id="descrizione" name="descrizione" rows="5" cols="40"
						required></textarea>
				</div>

				<div class="formGroup">
					<button type="submit" class="btnAdd">Aggiungi Ciurma</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
