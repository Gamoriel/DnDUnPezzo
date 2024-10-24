<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Nave"%>
<%@page import="org.prepuzy.model.Ciurma"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page import="org.prepuzy.model.Inventario"%>
<%@page import="org.prepuzy.model.Oggetto"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Dettagli Nave</title>
<link rel="stylesheet" href="resources/css/Style.css">
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
			<%
			Nave nave = (Nave) request.getAttribute("nave");
			if (nave != null) {
			%>
			<h2><%=nave.getNome()%></h2>

			<h2>Statistiche</h2>
			<table>
				<tr>
					<th>Statistica</th>
					<th>Valore</th>
					<th>Modificatore</th>
				</tr>
				<tr>
					<td>HP:</td>
					<td><%=nave.getHp()%></td>
					<td></td>
				</tr>
			</table>


			<%
			Inventario inventario = nave.getDeposito();
			if (inventario != null) {
			%>
			<p>
				<strong>Berry:</strong>
				<%=inventario.getBerry()%></p>
			<%
			} else {
			%>
			<p>Inventario non trovato.</p>
			<%
			}
			%>

			<h3>Ciurma:</h3>
			<%
			Ciurma ciurma = nave.getCiurma();
			if (ciurma != null) {
			%>
			<a href="DettagliCiurmaServlet?idCiurma=<%=ciurma.getId()%>"> <%=ciurma.getNome()%>
			</a>
			<%
			} else {
			%>
			<p>Nessuna ciurma associata.</p>
			<%
			}
			%>

			<h3>Personaggi:</h3>
			<%
			List<Personaggio> personaggi = nave.getPersonaggi();
			if (personaggi != null && !personaggi.isEmpty()) {
				for (Personaggio personaggio : personaggi) {
			%>
			<div>
				<a
					href="DettagliPersonaggioServlet?idPersonaggio=<%=personaggio.getId()%>">
					<%=personaggio.getNome()%>
				</a>
			</div>
			<%
			}
			} else {
			%>
			<p>Nessun personaggio trovato per questa nave.</p>
			<%
			}
			%>

			<h3>Deposito:</h3>
			<%
			List<Oggetto> oggettiDeposito = nave.getDeposito().getOggetti();
			if (oggettiDeposito != null && !oggettiDeposito.isEmpty()) {
				Map<Oggetto, Integer> oggettiConContatore = new HashMap<>();

				for (Oggetto oggetto : oggettiDeposito) {
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
				<li><a href="DettagliOggettoServlet?id=<%=oggetto.getId()%>">
						<%=oggetto.getNome()%> (x<%=quantita%>)
				</a></li>
				<%
				}
				%>
			</ul>
			<%
			} else {
			%>
			<p>Nessun oggetto trovato nel deposito.</p>
			<%
			}
			%>
			<div class="actionButtons">
				<form action="ModificaNaveServlet" method="get">
					<input type="hidden" name="idNave" value="<%=nave.getId()%>">
					<button class="buttonMod" type="submit">Modifica Nave</button>
				</form>
				<form action="EliminaNaveServlet" method="post"
					onsubmit="return confirm('Sei sicuro di voler cancellare questa nave?');">
					<input type="hidden" name="idNave" value="<%=nave.getId()%>">
					<button class="buttonDel" type="submit">Cancella Nave</button>
				</form>
			</div>

			<%
			} else {
			%>
			<p>Nave non trovata.</p>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>
