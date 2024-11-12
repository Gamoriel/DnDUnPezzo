<%@page import="org.prepuzy.model.Equipaggiamento"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Nave"%>
<%@page import="org.prepuzy.model.Ciurma"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page import="org.prepuzy.model.Inventario"%>
<%@page import="org.prepuzy.model.Oggetto"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Dettagli Nave</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Style.css">
</head>
<body>
	<nav>

		<div id="menuToggle">
			<input type="checkbox" /> <span></span> <span></span> <span></span>
			<ul id="menu">
				<li><a
					href="${pageContext.request.contextPath}/MasterPageServlet">Capitoli</a></li>
				<li><a href="${pageContext.request.contextPath}/CiurmaServlet">Ciurma</a></li>
				<li><a href="${pageContext.request.contextPath}/FruttiServlet">Frutti</a></li>
				<li><a href="${pageContext.request.contextPath}/MappeServlet">Mappe</a></li>
				<li><a href="${pageContext.request.contextPath}/NaviServlet">Navi</a></li>
				<li><a href="${pageContext.request.contextPath}/OggettiServlet">Oggetti</a></li>
				<li><a
					href="${pageContext.request.contextPath}/PersonaggiServlet">Personaggi</a></li>
				<li><a
					href="${pageContext.request.contextPath}/ProfessioniServlet">Professioni</a></li>
				<li><a href="${pageContext.request.contextPath}/RazzaServlet">Razze</a></li>
				<li><a
					href="${pageContext.request.contextPath}/ResistenzeServlet">Resistenze</a></li>
				<li><a
					href="${pageContext.request.contextPath}/StatusAlteratiServlet">Status
						Alterati</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/TipiServlet">Tipo
						Frutti</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/QualitaServlet">Qualità
						Frutti</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/TipologieServlet">Tipologie
						Equipaggiamento</a></li>
				<li><a
					href="${pageContext.request.contextPath}/MercantiServlet">Mercanti</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/AbilitaFruttoServlet">Abilita
						Frutti</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/AbilitaProfessioneServlet">Abilita
						Professioni</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/TecnicheServlet">Tecniche</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="leftBar">
			<h2>Collegamenti</h2>
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/MasterPageServlet">Capitoli</a></li>
				<li><a href="${pageContext.request.contextPath}/CiurmaServlet">Ciurma</a></li>
				<li><a href="${pageContext.request.contextPath}/FruttiServlet">Frutti</a></li>
				<li><a href="${pageContext.request.contextPath}/MappeServlet">Mappe</a></li>
				<li><a href="${pageContext.request.contextPath}/NaviServlet">Navi</a></li>
				<li><a href="${pageContext.request.contextPath}/OggettiServlet">Oggetti</a></li>
				<li><a
					href="${pageContext.request.contextPath}/PersonaggiServlet">Personaggi</a></li>
				<li><a
					href="${pageContext.request.contextPath}/ProfessioniServlet">Professioni</a></li>
				<li><a href="${pageContext.request.contextPath}/RazzaServlet">Razze</a></li>
				<li><a
					href="${pageContext.request.contextPath}/ResistenzeServlet">Resistenze</a></li>
				<li><a
					href="${pageContext.request.contextPath}/StatusAlteratiServlet">Status
						Alterati</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/TipiServlet">Tipo
						Frutti</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/QualitaServlet">Qualità
						Frutti</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/TipologieServlet">Tipologie
						Equipaggiamento</a></li>
				<li><a
					href="${pageContext.request.contextPath}/MercantiServlet">Mercanti</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/AbilitaFruttoServlet">Abilita
						Frutti</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/AbilitaProfessioneServlet">Abilita
						Professioni</a></li>
				<li><a
					href="${pageContext.request.contextPath}/master/TecnicheServlet">Tecniche</a></li>
			</ul>
		</div>
		<div class="centerBar">
			<%
			Nave nave = (Nave) request.getAttribute("nave");
			Equipaggiamento equipaggiamento = nave.getEquip();
			if (nave != null) {
			%>
			<h2><%=nave.getNome()%></h2>
			<div class="imgDiv" style="background-image: url('<%=nave.getImmagine()%>');">
			</div>
			<h2>Statistiche</h2>
			<table>
				<tr>
					<th>Statistica</th>
					<th>Valore</th>
				</tr>
				<tr>
					<td>HP:</td>
					<td><%=nave.getHp()%></td>
				</tr>
				<tr>
					<td>Classe Armatura:</td>
					<td><%=nave.getClasseArmatura()%></td>
				</tr>
			</table>

			<h3>Berry nel deposito:</h3>
			<%
			Inventario inventario = nave.getDeposito();
			if (inventario != null) {
			%>
			<form
				action="${pageContext.request.contextPath}/ModificaBerryNaveServlet"
				method="post">
				<label for="berry">Berry:</label> <input type="number" id="berry"
					name="berry" value="<%=inventario.getBerry()%>" min="0" required>
				<input type="hidden" name="idNave" value="<%=nave.getId()%>">
				<button type="submit" class="buttonMod">Aggiorna Berry</button>
			</form>
			<%
			}
			%>
			<h3>Aggiungi Oggetto all'Equipaggiamento</h3>
			<form
				action="${pageContext.request.contextPath}/ModificaEquipaggiamentoNaveServlet"
				method="post">
				<input type="hidden" name="idNave"
					value="<%=nave.getId()%>"> <select name="idOggetto">
					<option value="">Seleziona un oggetto dall'inventario</option>
					<%
					if (inventario != null && inventario.getOggetti() != null) {
						for (Oggetto oggetto : inventario.getOggetti()) {
					%>
					<option value="<%=oggetto.getId()%>"><%=oggetto.getNome()%></option>
					<%
					}
					}
					%>
				</select>
				<button type="submit" class="btnAdd">Aggiungi
					all'Equipaggiamento</button>
			</form>

			<h3>Rimuovi Oggetto dall'Equipaggiamento</h3>
			<form
				action="${pageContext.request.contextPath}/RimuoviOggEquipNaveServlet"
				method="post">
				<input type="hidden" name="idNave"
					value="<%=nave.getId()%>"> <select name="idOggetto">
					<option value="">Seleziona un oggetto dall'equipaggiamento</option>
					<%
					if (equipaggiamento != null && equipaggiamento.getOggetti() != null) {
						for (Oggetto oggetto : equipaggiamento.getOggetti()) {
					%>
					<option value="<%=oggetto.getId()%>"><%=oggetto.getNome()%></option>
					<%
					}
					}
					%>
				</select>
				<button type="submit" class="btnAdd">Rimuovi dall'Equipaggiamento</button>
			</form>
			<h2>Inventario</h2>
			<%
			if (inventario != null && inventario.getOggetti() != null && !inventario.getOggetti().isEmpty()) {
				Map<Oggetto, Integer> oggettiConContatore = new HashMap<>();

				for (Oggetto oggetto : inventario.getOggetti()) {
					if (oggettiConContatore.containsKey(oggetto)) {
				oggettiConContatore.put(oggetto, oggettiConContatore.get(oggetto) + 1);
					} else {
				oggettiConContatore.put(oggetto, 1);
					}
				}
			%>
			<ul>
				<%
				for (Map.Entry<Oggetto, Integer> entry : oggettiConContatore.entrySet()) {
					Oggetto oggetto = entry.getKey();
					int quantita = entry.getValue();
				%>
				<li><a
					href="${pageContext.request.contextPath}/DettagliOggettoServlet?id=<%=oggetto.getId()%>">
						<%=oggetto.getNome()%> (x<%=quantita%>)
				</a></li>
				<%
				}
				%>
			</ul>
			<%
			} else {
			%>
			<p>Inventario vuoto</p>
			<%
			}
			%>

			<h2>Equipaggiamento</h2>
			<%
			if (equipaggiamento != null && equipaggiamento.getOggetti() != null && !equipaggiamento.getOggetti().isEmpty()) {
				Map<Oggetto, Integer> oggettiConContatore = new HashMap<>();

				for (Oggetto oggetto : equipaggiamento.getOggetti()) {
					if (oggettiConContatore.containsKey(oggetto)) {
				oggettiConContatore.put(oggetto, oggettiConContatore.get(oggetto) + 1);
					} else {
				oggettiConContatore.put(oggetto, 1);
					}
				}
			%>
			<ul>
				<%
				for (Map.Entry<Oggetto, Integer> entry : oggettiConContatore.entrySet()) {
					Oggetto oggetto = entry.getKey();
					int quantita = entry.getValue();
				%>
				<li><a
					href="${pageContext.request.contextPath}/DettagliOggettoServlet?id=<%=oggetto.getId()%>">
						<%=oggetto.getNome()%> (x<%=quantita%>)
				</a></li>
				<%
				}
				%>
			</ul>
			<%
			} else {
			%>
			<p>Non hai oggetti equipaggiati</p>
			<%
			}
			}
			%>
		</div>
	</div>
</body>
</html>
