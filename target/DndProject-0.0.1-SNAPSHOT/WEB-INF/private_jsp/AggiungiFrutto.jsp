<%@ page import="java.util.Set"%>
<%@ page import="org.prepuzy.model.StatusAlterati"%>
<%@ page import="org.prepuzy.model.Qualita"%>
<%@ page import="org.prepuzy.model.Tipo"%>
<%@ page import="org.prepuzy.model.Resistenza"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi Frutto</title>
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
			<h1>Aggiungi Nuovo Frutto</h1>

			<form action="AggiungiFruttoServlet" method="post">
				<div class="formGroup">
					<label for="nome">Nome:</label> <input type="text" id="nome"
						name="nome" required>
				</div>
				<div class="formGroup">
					<label for="descrizione">Descrizione:</label>
					<textarea id="descrizione" name="descrizione" rows="4" required></textarea>
				</div>
				<div class="formGroup">
					<label for="prezzo">Prezzo:</label> <input type="number"
						id="prezzo" name="prezzo" required>
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
					<label for="tipo">Seleziona Tipo:</label> <select id="tipo"
						name="tipo">
						<%
						Set<Tipo> listaTipi = (Set<Tipo>) request.getAttribute("listaTipi");
						for (Tipo tipo : listaTipi) {
						%>
						<option value="<%=tipo.getId()%>"><%=tipo.getTipo()%></option>
						<%
						}
						%>
					</select>
				</div>

				<div>
					<label for="qualita">Seleziona Qualità:</label> <select
						id="qualita" name="qualita">
						<%
						Set<Qualita> listaQualita = (Set<Qualita>) request.getAttribute("listaQualita");
						for (Qualita qualita : listaQualita) {
						%>
						<option value="<%=qualita.getId()%>"><%=qualita.getQualita()%></option>
						<%
						}
						%>
					</select>
				</div>
				<div>
					<label>Status Alterati:</label>
					<%
					Set<StatusAlterati> listaStatus = (Set<StatusAlterati>) request.getAttribute("listaStatus");
					for (StatusAlterati status : listaStatus) {
					%>
					<input type="checkbox" name="status" value="<%=status.getId()%>">
					<%=status.getNome()%><br>
					<%
					}
					%>
				</div>
				<div>
					<label>Resistenze:</label>
					<%
					Set<Resistenza> listaResistenze = (Set<Resistenza>) request.getAttribute("listaResistenze");
					for (Resistenza resistenza : listaResistenze) {
					%>
					<input type="checkbox" name="resistenze"
						value="<%=resistenza.getId()%>">
					<%=resistenza.getNome()%><br>
					<%
					}
					%>
				</div>

				<div>
					<input type="submit" value="Aggiungi Frutto">
				</div>
			</form>
		</div>
	</div>
</body>
</html>
