<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page import="org.prepuzy.model.Ciurma"%>
<%@page import="org.prepuzy.model.Nave"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Modifica Nave</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Style.css">
<script>
	function updateFileName() {
		const fileInput = document.getElementById('imgNave');
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

		<div id="menuToggle"><input type="checkbox" /> <span></span> <span></span> <span></span>
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
				<li><a href="${pageContext.request.contextPath}/master/TecnicheServlet">Tecniche</a></li>
		</ul></div>
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
				<li><a href="${pageContext.request.contextPath}/master/TecnicheServlet">Tecniche</a></li>
		</ul>
	</div>

		<div class="centerBar">
			<h1>Modifica Nave</h1> <%
 Nave nave = (Nave) request.getAttribute("nave");
 List<Ciurma> listaCiurme = (List<Ciurma>) request.getAttribute("ciurme");
 %>

			<form action="${pageContext.request.contextPath}/master/ModificaNaveServlet" method="post" enctype="multipart/form-data"><input type="hidden" name="idNave" value="<%=nave.getId()%>">
				<label for="nome">Nome Nave:</label> <input type="text" name="nome" value="<%=nave.getNome()%>" required><br> <br> <label for="descrizione">Descrizione:</label> <textarea
				name="descrizione" rows="4" cols="50" required><%=nave.getDescrizione()%></textarea> <br> <label for="hp">HP:</label> <input type="number" name="hp" value="<%=nave.getHp()%>" required><br>
				<label for="hp">Classe Armatura:</label> <input type="number" name="classeArmatura" value="<%=nave.getClasseArmatura()%>" required><br> <label for="ciurma">Ciurma:</label> <select
				name="ciurma">
					<option value="">Seleziona una ciurma</option>
					<%
					for (Ciurma ciurma : listaCiurme) {
					    String selected = (nave.getCiurma() != null && nave.getCiurma().getId() == ciurma.getId()) ? "selected" : "";
					%>
					<option value="<%=ciurma.getId()%>" <%=selected%>><%=ciurma.getNome()%></option>
					<%
					}
					%>
			</select> <br>
				<div class="upload-container"><label for="imgNave" class="upload-label">Carica Immagine:</label> <input type="file" id="imgNave" name="imgNave" accept="image/*" onchange="updateFileName()">
					<button type="button" class="upload-button" onclick="document.getElementById('imgNave').click();">Seleziona Immagine</button>
					<div class="file-name" id="fileName">Nessun file selezionato</div></div>
				<div class="formGroup"><label for="isVisibleToAll">Visibile a tutti:</label> <input type="checkbox" id="isVisibleToAll" name="isVisibleToAll" <%=nave.isVisibleToAll() ? "checked" : ""%>>
			</div> <br>
				<button type="submit" class="btnSave">Salva Modifiche</button></form>
	</div>
</div>
</body>
</html>
