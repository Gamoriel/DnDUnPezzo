<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Mappa"%>
<%@page import="org.prepuzy.businesslogic.BusinessLogic"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Aggiungi Nuova Mappa</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Style.css">
<script>
	function updateFileName() {
		const fileInput = document.getElementById('immagine');
		const fileNameDisplay = document.getElementById('fileName');
		const uploadButton = document.querySelector('.upload-button');

		if (fileInput.files.length > 0) {
			const fileName = fileInput.files[0].name;
			fileNameDisplay.textContent = '';
			uploadButton.textContent = fileName
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
			<h1>Aggiungi Nuova Mappa</h1>

			<form action="${pageContext.request.contextPath}/master/AggiungiMappaServlet" method="post" enctype="multipart/form-data">
				<div>
					<label for="nome">Nome:</label> <input type="text" id="nome"
						name="nome" required>
				</div>
				<div>
					<label for="descrizione">Descrizione:</label>
					<textarea id="descrizione" name="descrizione" rows="5" cols="40"
						required></textarea>
				</div>
				<div class="upload-container">
					<label for="immagine">Carica Immagine:</label> <input type="file"
						id="immagine" name="immagine" accept="image/*" required
						onchange="updateFileName();">
					<button type="button" class="upload-button"
						onclick="document.getElementById('immagine').click();">
						Seleziona Immagine</button>
					<div class="file-name" id="fileName">Nessun file selezionato</div>
				</div>
				<div>
					<label for="mappaPadre">Seleziona Mappa Padre:</label>
					<select id="mappaPadre" name="mappaPadre">
					    <option value="">Nessuna</option>
					    <%
					    List<Mappa> listaMappePadri = (List<Mappa>) request.getAttribute("listaMappePadri");
					    if (listaMappePadri != null && !listaMappePadri.isEmpty()) {
					        for (Mappa mappa : listaMappePadri) {
					    %>
					    <option value="<%= mappa.getId() %>"><%= mappa.getNome() %></option>
					    <%
					        }
					    } else {
					    %>
					    <option disabled>Nessuna mappa padre trovata.</option>
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
					<button type="submit" class="btnAdd">Aggiungi Mappa</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
