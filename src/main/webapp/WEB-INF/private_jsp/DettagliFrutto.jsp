<%@page import="org.prepuzy.model.AbilitaFrutto"%>
<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Frutto"%>
<%@page import="org.prepuzy.model.StatusAlterati"%>
<%@page import="org.prepuzy.model.Resistenza"%>
<%@page import="org.prepuzy.model.Tipo"%>
<%@page import="org.prepuzy.model.Qualita"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Dettagli Frutto</title>
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
				 <li><a href="${pageContext.request.contextPath}/master/QualitaServlet">Qualità Frutti</a></li>  
				<li><a href="${pageContext.request.contextPath}/master/TipologieServlet">Tipologie Equipaggiamento</a></li>
				<li><a href="${pageContext.request.contextPath}/MercantiServlet">Mercanti</a></li>
				<li><a href="${pageContext.request.contextPath}/master/AbilitaFruttoServlet">Abilita Frutti</a></li>
				<li><a href="${pageContext.request.contextPath}/master/AbilitaProfessioneServlet">Abilita Professioni</a></li>
			</ul>
		</div>
		<%
		Frutto frutto = (Frutto) request.getAttribute("frutto");
		%>

		<div class="centerBar">
			<h1>
				Dettagli del Frutto:
				<%=frutto.getNome()%></h1>

			<p><%=frutto.getDescrizione()%></p>

			<h2>Altre Abilità</h2>
			<ul>
				<%
				List<AbilitaFrutto> abilitaVisibili = (List<AbilitaFrutto>) request.getAttribute("abilitaVisibili");
				for (AbilitaFrutto abilita : abilitaVisibili) {
				%>
				<li><strong><%=abilita.getNome()%></strong>: <%=abilita.getDescrizione()%></li>
				<%
				}
				%>
			</ul>
			<h2>Tipo</h2>
			<p>
				<strong>Tipo di frutto:</strong>
				<%=frutto.getTipo() != null ? frutto.getTipo().getTipo() : "Nessun tipo associato"%></p>

			<h2>Qualità</h2>
			<p>
				<strong>Qualità del frutto:</strong>
				<%=frutto.getQualita() != null ? frutto.getQualita().getQualita() : "Nessuna qualità associata"%></p>

			<h2>Status Alterati</h2>
			<ul>
				<%
				if (frutto.getStatus() != null && !frutto.getStatus().isEmpty()) {
					for (StatusAlterati status : frutto.getStatus()) {
				%>
				<li><%=status.getNome()%></li>
				<%
				}
				} else {
				%>
				<li>Nessun status alterato associato</li>
				<%
				}
				%>
			</ul>

			<h2>Resistenze</h2>
			<ul>
				<%
				if (frutto.getResistenza() != null && !frutto.getResistenza().isEmpty()) {
					for (Resistenza resistenza : frutto.getResistenza()) {
				%>
				<li><%=resistenza.getNome()%></li>
				<%
				}
				} else {
				%>
				<li>Nessuna resistenza associata</li>
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
					<td><%=frutto.getForza()%></td>
					<td><%=((frutto.getForza() - 10) / 2 >= 0) ? "+" + ((frutto.getForza() - 10) / 2) : ((frutto.getForza() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Destrezza:</td>
					<td><%=frutto.getDestrezza()%></td>
					<td><%=((frutto.getDestrezza() - 10) / 2 >= 0) ? "+" + ((frutto.getDestrezza() - 10) / 2)
		: ((frutto.getDestrezza() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Costituzione:</td>
					<td><%=frutto.getCostituzione()%></td>
					<td><%=((frutto.getCostituzione() - 10) / 2 >= 0) ? "+" + ((frutto.getCostituzione() - 10) / 2)
		: ((frutto.getCostituzione() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Intelligenza:</td>
					<td><%=frutto.getIntelligenza()%></td>
					<td><%=((frutto.getIntelligenza() - 10) / 2 >= 0) ? "+" + ((frutto.getIntelligenza() - 10) / 2)
		: ((frutto.getIntelligenza() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Saggezza:</td>
					<td><%=frutto.getSaggezza()%></td>
					<td><%=((frutto.getSaggezza() - 10) / 2 >= 0) ? "+" + ((frutto.getSaggezza() - 10) / 2)
		: ((frutto.getSaggezza() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Carisma:</td>
					<td><%=frutto.getCarisma()%></td>
					<td><%=((frutto.getCarisma() - 10) / 2 >= 0) ? "+" + ((frutto.getCarisma() - 10) / 2)
		: ((frutto.getCarisma() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>HP:</td>
					<td><%=frutto.getHp()%></td>
					<td></td>
				</tr>
			</table>
			<p>
				<strong>Prezzo:</strong>
				<%=frutto.getPrezzo()%>
				Berry
			</p>


			<div class="actionButtons">
				<form action="${pageContext.request.contextPath}/master/ModificaFruttoServlet" method="get"
					style="display: inline;">
					<input type="hidden" name="idFrutto" value="<%=frutto.getId()%>">
					<button type="submit" class="buttonMod">Modifica Frutto</button>
				</form>
				<form action="${pageContext.request.contextPath}/master/EliminaFruttoServlet" method="post"
					style="display: inline;"
					onsubmit="return confirm('Sei sicuro di voler cancellare questo frutto?');">
					<input type="hidden" name="idFrutto" value="<%=frutto.getId()%>">
					<button type="submit" class="buttonDel">Cancella Frutto</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
