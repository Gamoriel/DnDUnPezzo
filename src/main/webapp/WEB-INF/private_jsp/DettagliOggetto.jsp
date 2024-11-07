<%@page import="org.prepuzy.model.Oggetto"%>
<%@page import="org.prepuzy.model.Resistenza"%>
<%@page import="org.prepuzy.model.Razza"%>
<%@page import="org.prepuzy.model.Professione"%>
<%@page import="org.prepuzy.model.StatusAlterati"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Dettagli Oggetto</title>
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
				<li><a href="${pageContext.request.contextPath}/master/AbilitaProfessioneServlet">Abilita Professioni</a></li><li><a href="${pageContext.request.contextPath}/master/TecnicheServlet">Tecniche</a></li>
			</ul>
		</div>
		<div class="centerBar">
			<%
			Oggetto oggetto = (Oggetto) request.getAttribute("oggetto");
			%>
			<h1>
				Dettagli di
				<%=oggetto.getNome()%></h1>

			<div class="dettagliOggetto">
				<p>
					<strong>Nome:</strong>
					<%=oggetto.getNome()%></p>
				<p>
					<strong>Descrizione:</strong>
					<%=oggetto.getDescrizione()%></p>
				<p>
					<strong>Prezzo:</strong>
					<%=oggetto.getPrezzo()%>
					berry
				</p>
				<p>
					<strong>Peso:</strong>
					<%=oggetto.getPeso()%>
				</p>


				<h2>Statistiche</h2>
				<table>
					<tr>
						<th>Statistica</th>
						<th>Valore</th>
						<th>Modificatore</th>
					</tr>
					<tr>
						<td>Forza:</td>
						<td><%=oggetto.getForza()%></td>
						<td><%=((20 - 10) / 2 >= 0) ? "+" + ((20 - 10) / 2) : ((20 - 10) / 2)%></td>
					</tr>
					<tr>
						<td>Destrezza:</td>
						<td><%=oggetto.getDestrezza()%></td>
						<td><%=((14 - 10) / 2 >= 0) ? "+" + ((14 - 10) / 2) : ((14 - 10) / 2)%></td>
					</tr>
					<tr>
						<td>Costituzione:</td>
						<td><%=oggetto.getCostituzione()%></td>
						<td><%=((12 - 10) / 2 >= 0) ? "+" + ((12 - 10) / 2) : ((12 - 10) / 2)%></td>
					</tr>
					<tr>
						<td>Intelligenza:</td>
						<td><%=oggetto.getIntelligenza()%></td>
						<td><%=((8 - 10) / 2 >= 0) ? "+" + ((8 - 10) / 2) : ((8 - 10) / 2)%></td>
					</tr>
					<tr>
						<td>Saggezza:</td>
						<td><%=oggetto.getSaggezza()%></td>
						<td><%=((18 - 10) / 2 >= 0) ? "+" + ((18 - 10) / 2) : ((18 - 10) / 2)%></td>
					</tr>
					<tr>
						<td>Carisma:</td>
						<td><%=oggetto.getCarisma()%></td>
						<td><%=((16 - 10) / 2 >= 0) ? "+" + ((16 - 10) / 2) : ((16 - 10) / 2)%></td>
					</tr>
					<tr>
						<td>Classe Armatura:</td>
						<td><%=oggetto.getClasseArmatura()%></td>
						<td></td>
					</tr>
					<tr>
						<td>HP:</td>
						<td><%=oggetto.getHp()%></td>
						<td></td>
					</tr>
				</table>


				<h2>Resistenze</h2>
				<ul>
					<%
					if (oggetto.getResistenze() != null && !oggetto.getResistenze().isEmpty()) {
						for (Resistenza resistenza : oggetto.getResistenze()) {
					%>
					<li><a
						href="DettagliResistenzaServlet?idResistenza=<%=resistenza.getId()%>"><%=resistenza.getNome()%></a></li>
					<%
					}
					} else {
					%>
					<li>Nessuna resistenza associata</li>
					<%
					}
					%>
				</ul>

				<h2>Razze</h2>
				<ul>
					<%
					if (oggetto.getRazze() != null && !oggetto.getRazze().isEmpty()) {
						for (Razza razza : oggetto.getRazze()) {
					%>
					<li><a href="DettagliRazzaServlet?idRazza=<%=razza.getId()%>"><%=razza.getNome()%></a></li>
					<%
					}
					} else {
					%>
					<li>Nessuna razza associata</li>
					<%
					}
					%>
				</ul>

				<h2>Professioni</h2>
				<ul>
					<%
					if (oggetto.getProfessioni() != null && !oggetto.getProfessioni().isEmpty()) {
						for (Professione professione : oggetto.getProfessioni()) {
					%>
					<li><a
						href="DettagliProfessioneServlet?idProfessione=<%=professione.getId()%>"><%=professione.getNome()%></a></li>
					<%
					}
					} else {
					%>
					<li>Nessuna professione associata</li>
					<%
					}
					%>
				</ul>

				<h2>Status Alterati</h2>
				<ul>
					<%
					if (oggetto.getStatus() != null && !oggetto.getStatus().isEmpty()) {
						for (StatusAlterati status : oggetto.getStatus()) {
					%>
					<li><a
						href="DettagliStatusAlteratiServlet?idStatus=<%=status.getId()%>"><%=status.getNome()%></a></li>
					<%
					}
					} else {
					%>
					<li>Nessuno status alterato associato</li>
					<%
					}
					%>
				</ul>


				<div class="actionButtons">
					<form action="${pageContext.request.contextPath}/master/ModificaOggettoServlet" method="get"
						style="display: inline;">
						<input type="hidden" name="idOggetto" value="<%=oggetto.getId()%>">
						<button type="submit" class="buttonMod">Modifica Oggetto</button>
					</form>
					<form action="${pageContext.request.contextPath}/master/EliminaOggettoServlet" method="post"
						style="display: inline;"
						onsubmit="return confirm('Sei sicuro di voler cancellare questo oggetto?');">
						<input type="hidden" name="idOggetto" value="<%=oggetto.getId()%>">
						<button type="submit" class="buttonDel">Cancella Oggetto</button>
					</form>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
