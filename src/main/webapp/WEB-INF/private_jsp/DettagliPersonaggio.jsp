<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.prepuzy.model.Equipaggiamento"%>
<%@page import="java.util.List"%>
<%@page import="org.prepuzy.model.Oggetto"%>
<%@page import="org.prepuzy.model.Inventario"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page import="org.prepuzy.model.Razza"%>
<%@page import="org.prepuzy.model.Professione"%>
<%@page import="org.prepuzy.model.Ciurma"%>
<%@page import="org.prepuzy.model.Nave"%>
<%@page import="org.prepuzy.model.Frutto"%>
<%@page import="org.prepuzy.model.Mappa"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Dettagli Personaggio</title>
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
			<h1>
				Dettagli di
				<%=((Personaggio) request.getAttribute("personaggio")).getNome()%>
			</h1>
			<%
			Personaggio personaggio = (Personaggio) request.getAttribute("personaggio");
			Inventario inventario = personaggio.getInventario();
			Equipaggiamento equipaggiamento = personaggio.getEquip();
			%>
			<img class="mappaImage" src="<%=personaggio.getUrlImmagine()%>"
				alt="<%=personaggio.getNome()%>" class="personaggioImage" />
			<p>
				<strong>Nome:</strong>
				<%=personaggio.getNome()%></p>
			<p>
				<strong>Soprannome:</strong>
				<%=personaggio.getSoprannome()%></p>
			<p>
				<strong>Descrizione:</strong>
				<%=personaggio.getDescrizione()%></p>
			<p>
				<strong>Taglia:</strong>
				<%=personaggio.getTaglia() != null ? personaggio.getTaglia().toString() : "N/A"%></p>
			<p>
				<strong>Razza:</strong> <a
					href=" ${pageContext.request.contextPath}/DettagliRazzaServlet?idRazza=<%=personaggio.getRazza() != null ? personaggio.getRazza().getId() : -1%>">
					<%=personaggio.getRazza() != null ? personaggio.getRazza().getNome() : "N/A"%>
				</a>
			</p>
			<p>
				<strong>Professione:</strong> <a
					href="${pageContext.request.contextPath}/DettagliProfessioneServlet?idProfessione=<%=personaggio.getProfessione() != null ? personaggio.getProfessione().getId() : -1%>">
					<%=personaggio.getProfessione() != null ? personaggio.getProfessione().getNome() : "N/A"%>
				</a>
			</p>

			<h2>Statistiche</h2>
			<table>
				<tr>
					<th>Statistica</th>
					<th>Valore Base</th>
					<th>Modificatore</th>
				</tr>
				<tr>
					<td>Forza:</td>
					<td><%=personaggio.getForza()%></td>
					<td><%=((personaggio.getForza() - 10) / 2 >= 0) ? "+" + ((personaggio.getForza() - 10) / 2)
		: ((personaggio.getForza() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Destrezza:</td>
					<td><%=personaggio.getDestrezza()%></td>
					<td><%=((personaggio.getDestrezza() - 10) / 2 >= 0) ? "+" + ((personaggio.getDestrezza() - 10) / 2)
		: ((personaggio.getDestrezza() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Costituzione:</td>
					<td><%=personaggio.getCostituzione()%></td>
					<td><%=((personaggio.getCostituzione() - 10) / 2 >= 0) ? "+" + ((personaggio.getCostituzione() - 10) / 2)
		: ((personaggio.getCostituzione() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Intelligenza:</td>
					<td><%=personaggio.getIntelligenza()%></td>
					<td><%=((personaggio.getIntelligenza() - 10) / 2 >= 0) ? "+" + ((personaggio.getIntelligenza() - 10) / 2)
		: ((personaggio.getIntelligenza() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Saggezza:</td>
					<td><%=personaggio.getSaggezza()%></td>
					<td><%=((personaggio.getSaggezza() - 10) / 2 >= 0) ? "+" + ((personaggio.getSaggezza() - 10) / 2)
		: ((personaggio.getSaggezza() - 10) / 2)%></td>
				</tr>
				<tr>
					<td>Carisma:</td>
					<td><%=personaggio.getCarisma()%></td>
					<td><%=((personaggio.getCarisma() - 10) / 2 >= 0) ? "+" + ((personaggio.getCarisma() - 10) / 2)
		: ((personaggio.getCarisma() - 10) / 2)%></td>
				</tr>
			</table>
			<h2>Altre Stat</h2>
			<table>
				<tr>
					<th>Statistica</th>
					<th>Valore Base</th>
					<th>Da Equip</th>
					<th>Totale</th>
				</tr>
				<tr>
					<td>HP:</td>
					<td><%=personaggio.getHp()%></td>
					<td>
						<%
						if(equipaggiamento != null){
						List<Oggetto> oggettiEquip = equipaggiamento.getOggetti();
						int count = 0;
						if (oggettiEquip != null) {
							for (Oggetto o : oggettiEquip) {
								count += o.getHp();
							}
						}
						%> + <%=count%>
						<%} else { %>
						+ 0
						<%}%>
					</td>
					<td>
						<%
						if(equipaggiamento != null){
						List<Oggetto> oggettiEquip = equipaggiamento.getOggetti();
						int count = 0;
						if (oggettiEquip != null) {
							for (Oggetto o : oggettiEquip) {
								count += o.getHp();
							}
						}
						%> <%=personaggio.getHp() + count%> 
						<%} else { %>
						<%=personaggio.getHp()%>
						<%}%>
					</td>
				</tr>
								<tr>
					<td>Classe Armatura:</td>
					<td><%=personaggio.getClasseArmatura()%></td>
					<td>
						<%
						if(equipaggiamento != null){
							List<Oggetto> oggettiEquip = equipaggiamento.getOggetti();
						int countCA = 0;
						if (oggettiEquip != null) {
							for (Oggetto o : oggettiEquip) {
								countCA += o.getClasseArmatura();
							}
						} %> + <%=countCA%>
						<%} else { %>
						 + 0
						 <%} %>
					</td>
					<td>
						<%
						if(equipaggiamento != null){
							List<Oggetto> oggettiEquip = equipaggiamento.getOggetti();
						int countCA = 0;
						if (oggettiEquip != null) {
							for (Oggetto o : oggettiEquip) {
								countCA += o.getClasseArmatura();
							}
						} %> <%=personaggio.getClasseArmatura() + countCA%>
						<%} else { %>
						 <%= personaggio.getClasseArmatura() %>
						 <%} %>
					</td>
				</tr>
			</table>
			<h3>Gestisci Denaro</h3>
			<form action="${pageContext.request.contextPath}/AggiornaDenaroServlet" method="post">
				<input type="hidden" name="idPersonaggio"
					value="<%=personaggio.getId()%>"> <label for="denaro">Quantità
					di Denaro:</label> <input type="number" name="denaro"
					value="<%=inventario != null ? inventario.getBerry() : 0%>" min="0"
					required>
				<button type="submit" class="btnUpdate">Aggiorna Denaro</button>
			</form>
			<%
			List<Oggetto> tuttiOggetti = (List<Oggetto>) request.getAttribute("tuttiOggetti");
			%>
			<h3>Aggiungi Oggetto all'Inventario</h3>
			<form action="${pageContext.request.contextPath}/AggiungiOggettoInventarioServlet" method="post">
				<input type="hidden" name="idPersonaggio"
					value="<%=personaggio.getId()%>"> <select name="idOggetto">
					<option value="">Seleziona un oggetto</option>
					<%
					if (tuttiOggetti != null) {
						for (Oggetto oggetto : tuttiOggetti) {
					%>
					<option value="<%=oggetto.getId()%>"><%=oggetto.getNome()%></option>
					<%
					}
					}
					%>
				</select>
				<button type="submit" class="btnAdd">Aggiungi
					all'inventario</button>
			</form>

			<h3>Rimuovi Oggetto dall'Inventario</h3>
			<form action="${pageContext.request.contextPath}/RimuoviOggettoInventarioServlet" method="post">
				<input type="hidden" name="idPersonaggio"
					value="<%=personaggio.getId()%>"> <select name="idOggetto">
					<option value="">Seleziona un oggetto</option>
					<%
					if (inventario != null && inventario.getOggetti() != null) {
						for (Oggetto oggetto : inventario.getOggetti()) {
					%>
					<option value="<%=oggetto.getId()%>"><%=oggetto.getNome()%></option>
					<%
					}
					} else {
					%>
					<option value="">Inventario vuoto</option>
					<%
					}
					%>
				</select>
				<button type="submit" class="btnAdd">Rimuovi
					dall'Inventario</button>
			</form>

			<h3>Sposta Oggetto nel Deposito della Nave</h3>
			<form action="${pageContext.request.contextPath}/SpostaOggettoDepositoServlet" method="post">
				<input type="hidden" name="idPersonaggio"
					value="<%=personaggio.getId()%>"> <select name="idOggetto">
					<%
					if (inventario != null && inventario.getOggetti() != null) {
						for (Oggetto oggetto : inventario.getOggetti()) {
					%>
					<option value="<%=oggetto.getId()%>"><%=oggetto.getNome()%></option>
					<%
					}
					} else {
					%>
					<option value="">Inventario vuoto</option>
					<%
					}
					%>
				</select>
				<button type="submit" class="btnAdd">Sposta nel Deposito</button>
			</form>

			<h3>Aggiungi Oggetto all'Equipaggiamento</h3>
			<form action="${pageContext.request.contextPath}/EquipaggiaOggettoServlet" method="post">
				<input type="hidden" name="idPersonaggio"
					value="<%=personaggio.getId()%>"> <select name="idOggetto">
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
			<form action="${pageContext.request.contextPath}/RimuoviOggettoEquipServlet" method="post">
				<input type="hidden" name="idPersonaggio"
					value="<%=personaggio.getId()%>"> <select name="idOggetto">
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
				<button type="submit" class="btnAdd">Rimuovi
					dall'Equipaggiamento</button>
			</form>

			<h2>Ciurma di appartenenza</h2>
			<p>
				<%
				if (personaggio.getCiurma() != null) {
				%>
				<a
					href="${pageContext.request.contextPath}/DettagliCiurmaServlet?idCiurma=<%=personaggio.getCiurma().getId()%>">Vedi
					ciurma</a>
				<%
				} else {
				%>
				<span>Nessuna ciurma associata</span>
				<%
				}
				%>
			</p>

			<h2>Nave</h2>
			<p>
				<%
				if (personaggio.getCiurma() != null) {
				%>
				<a
					href="${pageContext.request.contextPath}/DettagliNaveServlet?idNave=<%=personaggio.getNave() != null ? personaggio.getNave().getId() : -1%>">
					<%=personaggio.getNave() != null ? personaggio.getNave().getNome() : "Nessuna nave"%>
				</a>
				<%
				} else {
				%>
				<span>Nessuna nave associata</span>
				<%
				}
				%>
			</p>

			<h2>Frutto</h2>
			<p>
				<%
				if (personaggio.getCiurma() != null) {
				%>
				<a
					href="${pageContext.request.contextPath}/DettagliFruttoServlet?idFrutto=<%=personaggio.getFrutto() != null ? personaggio.getFrutto().getId() : -1%>">
					<%=personaggio.getFrutto() != null ? personaggio.getFrutto().getNome() : "Nessun frutto"%>
				</a>
				<%
				} else {
				%>
				<span>Nessun frutto ingerito</span>
				<%
				}
				%>
			</p>

			<h2>Mappa di appartenenza</h2>
			<p>
				<%
				if (personaggio.getCiurma() != null) {
				%>
				<a
					href="${pageContext.request.contextPath}/DettagliMappaServlet?idMappa=<%=personaggio.getMappa() != null ? personaggio.getMappa().getId() : -1%>">
					<%=personaggio.getMappa() != null ? personaggio.getMappa().getNome() : "Nessuna mappa"%>
				</a>
				<%
				} else {
				%>
				<span>Nessuna mappa associata</span>
				<%
				}
				%>
			</p>

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
				<li><a href="${pageContext.request.contextPath}/DettagliOggettoServlet?id=<%=oggetto.getId()%>">
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
				<li><a href="${pageContext.request.contextPath}/DettagliOggettoServlet?id=<%=oggetto.getId()%>">
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
			%>
			<div class="actionButtons">
				<form action="${pageContext.request.contextPath}/ModificaPersonaggioServlet" method="get">
					<input type="hidden" name="idPersonaggio" value="<%=personaggio.getId()%>">
					<input type="submit" value="Modifica Personaggio" class="buttonMod">
				</form>
				<form action="${pageContext.request.contextPath}/EliminaPersonaggioServlet" method="post"
					onsubmit="return confirm('Sei sicuro di voler eliminare questo personaggio?');">
					<input type="hidden" name="idPersonaggio" value="<%=personaggio.getId()%>">
					<input type="submit" value="Elimina Personaggio" class="buttonDel">
				</form>
			</div>
		</div>
	</div>
</body>
</html>
