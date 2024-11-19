<%@page import="org.prepuzy.model.AbilitaProfessione"%>
<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Professione"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Dettagli Professione</title>
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
			<h2>Collegamenti</h2>
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
			<%
			Professione professione = (Professione) request.getAttribute("professione");
			if (professione != null) {
			%>
			<h1>
				Dettagli del Frutto:
				<%=professione.getNome()%></h1>
			<p>
				<strong>Descrizione:</strong>
			</p>
			<p><%=professione.getDescrizione()%></p>	

			<h2>Altre Abilità</h2>
			<ul>
				<%
				List<AbilitaProfessione> abilitaVisibili = (List<AbilitaProfessione>) request.getAttribute("abilitaVisibili");
				for (AbilitaProfessione abilita : abilitaVisibili) {
				%>
				<li><strong><%=abilita.getNome()%></strong>: <%=abilita.getDescrizione()%></li>
				<%
				}
				%>
			</ul>
			<h2>Statistiche</h2>
			<table>
				<tr>
					<th>Statistica</th>
					<th>Valore</th>
					<th>Modificatore</th>
				</tr>
				<tr>
					<td>Forza:</td>
					<td><%=professione.getForza()%></td>
					<td><%=((professione.getForza() - 10) / 2 >= 0) ? "+" + ((professione.getForza() - 10) / 2)
		: ((professione.getForza() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Destrezza:</td>
					<td><%=professione.getDestrezza()%></td>
					<td><%=((professione.getDestrezza() - 10) / 2 >= 0) ? "+" + ((professione.getDestrezza() - 10) / 2)
		: ((professione.getDestrezza() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Costituzione:</td>
					<td><%=professione.getCostituzione()%></td>
					<td><%=((professione.getCostituzione() - 10) / 2 >= 0) ? "+" + ((professione.getCostituzione() - 10) / 2)
		: ((professione.getCostituzione() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Intelligenza:</td>
					<td><%=professione.getIntelligenza()%></td>
					<td><%=((professione.getIntelligenza() - 10) / 2 >= 0) ? "+" + ((professione.getIntelligenza() - 10) / 2)
		: ((professione.getIntelligenza() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Saggezza:</td>
					<td><%=professione.getSaggezza()%></td>
					<td><%=((professione.getSaggezza() - 10) / 2 >= 0) ? "+" + ((professione.getSaggezza() - 10) / 2)
		: ((professione.getSaggezza() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Carisma:</td>
					<td><%=professione.getCarisma()%></td>
					<td><%=((professione.getCarisma() - 10) / 2 >= 0) ? "+" + ((professione.getCarisma() - 10) / 2)
		: ((professione.getCarisma() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>HP:</td>
					<td><%=professione.getHp()%></td>
					<td></td>
				</tr>
			</table>
			<%
			} else {
			%>
			<p>Professione non trovata.</p>
			<%
			}
			%>
			<div class="actionButtons">
				<form action="${pageContext.request.contextPath}/master/ModificaProfessioneServlet" method="get">
					<input type="hidden" name="idProfessione"
						value="<%=professione.getId()%>">
					<button class="buttonMod" type="submit">Modifica
						Professione</button>
				</form>
				<form action="${pageContext.request.contextPath}/master/EliminaProfessioneServlet" method="post"
					onsubmit="return confirm('Sei sicuro di voler cancellare questa professione?');">
					<input type="hidden" name="idProfessione"
						value="<%=professione.getId()%>">
					<button class="buttonDel" type="submit">Cancella
						Professione</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
