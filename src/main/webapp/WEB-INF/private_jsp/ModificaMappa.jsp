<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page import="org.prepuzy.model.Mappa"%>
<%@page import="org.prepuzy.model.Capitolo"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page import="org.prepuzy.model.Mappa"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Modifica Mappa</title>
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
			<h1>Modifica Mappa</h1>

			<%
			Mappa mappa = (Mappa) request.getAttribute("mappa");
			List<Personaggio> personaggiDisponibili = (List<Personaggio>) request.getAttribute("personaggiDisponibili");
			List<Mappa> mappeDisponibili = (List<Mappa>) request.getAttribute("mappeDisponibili");
			List<Capitolo> capitoliDisponibili = (List<Capitolo>) request.getAttribute("capitoliDisponibili");
			List<Personaggio> personaggiAssociati = mappa.getPersonaggi();
			%>

			<form action="master/ModificaMappaServlet" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="idMappa" value="<%=mappa.getId()%>">

				<label for="nome">Nome Mappa:</label> <input type="text" name="nome"
					value="<%=mappa.getNome()%>"><br> <br> <label
					for="descrizione">Descrizione:</label>
				<textarea name="descrizione" rows="4" cols="50"><%=mappa.getDescrizione()%></textarea>
				<br> <br>
				<div class="upload-container">
					<label for="immagine">Carica Immagine:</label> <input type="file"
						id="immagine" name="immagine" accept="image/*" required
						onchange="updateFileName();">
					<button type="button" class="upload-button"
						onclick="document.getElementById('immagine').click();">
						Seleziona Immagine</button>
					<div class="file-name" id="fileName">Nessun file selezionato</div>
				</div>
				<br>
				<p>Immagine attuale:</p>
				<img src="<%=mappa.getImmagine()%>" alt="Immagine della mappa"
					width="200"><br> <br> <label for="personaggi">Personaggi
					associati:</label><br>
				<%
				for (Personaggio p : personaggiDisponibili) {
					boolean isChecked = personaggiAssociati.contains(p);
				%>
				<input type="checkbox" name="personaggi" value="<%=p.getId()%>"
					<%=isChecked ? "checked" : ""%>>
				<%=p.getNome()%><br>
				<%
				}
				%>

				<label for="capitolo">Capitolo associato:</label> <select
					name="capitolo">
					<option value="-1">Nessun capitolo associato</option>
					<%
					for (Capitolo c : capitoliDisponibili) {
						boolean isSelected = (mappa.getCapitolo() != null && mappa.getCapitolo().getId() == c.getId());
					%>
					<option value="<%=c.getId()%>" <%=isSelected ? "selected" : ""%>><%=c.getTitolo()%></option>
					<%
					}
					%>
				</select><br> <br> <label for="mappe">Mappe associate:</label><br>
				<%
				for (Mappa m : mappeDisponibili) {
					boolean isChecked = mappa.getMappe().contains(m);
				%>
				<input type="checkbox" name="mappe" value="<%=m.getId()%>"
					<%=isChecked ? "checked" : ""%>>
				<%=m.getNome()%><br>
				<%
				}
				%>
				<div class="formGroup">
					<label for="isVisibleToAll">Visibile a tutti:</label> <input
						type="checkbox" id="isVisibleToAll" name="isVisibleToAll">
				</div>
				<br>
				<button type="submit" class="btnSave">Salva Modifiche</button>
			</form>
		</div>
	</div>
</body>
</html>
