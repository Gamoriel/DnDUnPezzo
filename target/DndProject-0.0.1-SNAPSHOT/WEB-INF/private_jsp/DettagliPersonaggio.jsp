<%@page import="java.util.Set"%>
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
<meta charset="ISO-8859-1">
<title>Dettagli Personaggio</title>
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
				<li><a href="TipologieServlet">Tipologie Equipaggiamento</a></li>
			</ul>
		</div>
		<h1>
			Dettagli di
			<%=((Personaggio) request.getAttribute("personaggio")).getNome()%>
		</h1>

		<div class="dettagliPersonaggio">
			<%
			Personaggio personaggio = (Personaggio) request.getAttribute("personaggio");
			Inventario inventario = personaggio.getInventario();
			%>
			<img src="<%=personaggio.getUrlImmagine()%>"
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
					href="DettagliRazzaServlet?idRazza=<%=personaggio.getRazza() != null ? personaggio.getRazza().getId() : -1%>">
					<%=personaggio.getRazza() != null ? personaggio.getRazza().getNome() : "N/A"%>
				</a>
			</p>
			<p>
				<strong>Professione:</strong> <a
					href="DettagliProfessioneServlet?idProfessione=<%=personaggio.getProfessione() != null ? personaggio.getProfessione().getId() : -1%>">
					<%=personaggio.getProfessione() != null ? personaggio.getProfessione().getNome() : "N/A"%>
				</a>
			</p>

			<h2>Statistiche</h2>
			<p>
				<strong>Forza:</strong>
				<%=personaggio.getForza()%></p>
			<p>
				<strong>Destrezza:</strong>
				<%=personaggio.getDestrezza()%></p>
			<p>
				<strong>Costituzione:</strong>
				<%=personaggio.getCostituzione()%></p>
			<p>
				<strong>Intelligenza:</strong>
				<%=personaggio.getIntelligenza()%></p>
			<p>
				<strong>Saggezza:</strong>
				<%=personaggio.getSaggezza()%></p>
			<p>
				<strong>Carisma:</strong>
				<%=personaggio.getCarisma()%></p>
			<p>
				<strong>HP:</strong>
				<%=personaggio.getHp()%></p>

			<h2>Inventario</h2>
			<h2>Gestisci Denaro</h2>
			<form action="AggiornaDenaroServlet" method="post">
				<input type="hidden" name="idPersonaggio"
					value="<%=personaggio.getId()%>"> <label for="denaro">Quantità
					di Denaro:</label> <input type="number" name="denaro"
					value="<%=inventario != null ? inventario.getBerry() : 0%>"
					min="0" required>
				<button type="submit" class="btnUpdate">Aggiorna Denaro</button>
			</form>
			<%
			Set<Oggetto> tuttiOggetti = (Set<Oggetto>) request.getAttribute("tuttiOggetti");
			%>
			<h3>Aggiungi Oggetto all'Inventario</h3>
			<form action="AggiungiOggettoInventarioServlet" method="post">
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
			<form action="RimuoviOggettoInventarioServlet" method="post">
				<input type="hidden" name="idPersonaggio"
					value="<%=personaggio.getId()%>"> <select name="idOggetto">
					<option value="">Seleziona un oggetto</option>
					<%
					for (Oggetto oggetto : inventario.getOggetti()) {
					%>
					<option value="<%=oggetto.getId()%>"><%=oggetto.getNome()%></option>
					<%
					}
					%>
				</select>
				<button type="submit" class="btnRemove">Rimuovi
					dall'Inventario</button>
			</form>

			<h3>Vendi Oggetto</h3>
			<form action="VendiOggettoServlet" method="post">
				<input type="hidden" name="idPersonaggio"
					value="<%=personaggio.getId()%>"> <select name="idOggetto">
					<option value="">Seleziona un oggetto</option>
					<%
					for (Oggetto oggetto : inventario.getOggetti()) {
					%>
					<option value="<%=oggetto.getId()%>"><%=oggetto.getNome()%></option>
					<%
					}
					%>
				</select>
				<button type="submit" class="btnSell">Vendi</button>
			</form>

			<h3>Sposta Oggetto nel Deposito della Nave</h3>
			<form action="SpostaOggettoDepositoServlet" method="post">
				<input type="hidden" name="idPersonaggio"
					value="<%=personaggio.getId()%>"> <select name="idOggetto">
					<option value="">Seleziona un oggetto</option>
					<%
					for (Oggetto oggetto : inventario.getOggetti()) {
					%>
					<option value="<%=oggetto.getId()%>"><%=oggetto.getNome()%></option>
					<%
					}
					%>
				</select>
				<button type="submit" class="btnMove">Sposta nel Deposito</button>
			</form>

			<%
			if (inventario != null && inventario.getOggetti() != null && !inventario.getOggetti().isEmpty()) {
			%>
			<ul>
				<%
				for (Oggetto oggetto : inventario.getOggetti()) {
				%>
				<li><a href="DettagliOggettoServlet?idOggetto=<%=oggetto.getId()%>"> 
					<strong>Nome:</strong> <%=oggetto.getNome()%>
					Quantita: <%=oggetto.getQuantita()%>
				</a>
					<form action="EquipaggiaOggettoServlet" method="post"
						style="display: inline;">
						<input type="hidden" name="idPersonaggio"
							value="<%=personaggio.getId()%>"> <input type="hidden"
							name="idOggetto" value="<%=oggetto.getId()%>">
						<button type="submit" class="btnEquip">Equipaggia</button>
					</form></li>
				<%
				}
				%>
			</ul>
			<%
			} else {
			%>
			<p>Nessun inventario disponibile.</p>
			<%
			}
			%>

			<h2>Ciurma di appartenenza</h2>
			<p>
				<%
				if (personaggio.getCiurma() != null) {
				%>
				<a
					href="DettagliCiurmaServlet?idCiurma=<%=personaggio.getCiurma().getId()%>">Vedi
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
					href="DettagliNaveServlet?idNave=<%=personaggio.getNave() != null ? personaggio.getNave().getId() : -1%>">
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
					href="DettagliFruttoServlet?idFrutto=<%=personaggio.getFrutto() != null ? personaggio.getFrutto().getId() : -1%>">
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
					href="DettagliMappaServlet?idMappa=<%=personaggio.getMappa() != null ? personaggio.getMappa().getId() : -1%>">
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

			<div class="actionButtons">
				<form action="ModificaPersonaggioServlet" method="get">
					<input type="hidden" name="id" value="<%=personaggio.getId()%>">
					<input type="submit" value="Modifica Personaggio" class="buttonMod">
				</form>
				<form action="EliminaOggettoServlet" method="post"
					onsubmit="return confirm('Sei sicuro di voler eliminare questo personaggio?');">
					<input type="hidden" name="id" value="<%=personaggio.getId()%>">
					<input type="submit" value="Elimina Personaggio" class="buttonDel">
				</form>
			</div>

		</div>
	</div>
</body>
</html>
