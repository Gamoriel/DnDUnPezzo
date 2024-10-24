<%@page import="org.prepuzy.model.Frutto"%>
<%@page import="org.prepuzy.model.StatusAlterati"%>
<%@page import="org.prepuzy.model.Resistenza"%>
<%@page import="org.prepuzy.model.Tipo"%>
<%@page import="org.prepuzy.model.Qualita"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dettagli Frutto</title>
    <link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
    <nav>
        <div class="navBar">
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
			</ul>
		</div>
        <% 
            Frutto frutto = (Frutto) request.getAttribute("frutto");
        %>
        
        <h1>Dettagli del Frutto: <%= frutto.getNome() %></h1>

        <div class="dettagliFrutto">
            <p><strong>Nome:</strong> <%= frutto.getNome() %></p>
            <p><strong>Descrizione:</strong> <%= frutto.getDescrizione() %></p>
            <p><strong>Prezzo:</strong> <%= frutto.getPrezzo() %> monete</p>

            <h2>Tipo</h2>
            <p><strong>Tipo di frutto:</strong> <%= frutto.getTipo() != null ? frutto.getTipo().getTipo() : "Nessun tipo associato" %></p>

            <h2>Qualità</h2>
            <p><strong>Qualità del frutto:</strong> <%= frutto.getQualita() != null ? frutto.getQualita().getQualita() : "Nessuna qualità associata" %></p>

            <h2>Status Alterati</h2>
            <ul>
                <% 
                if (frutto.getStatus() != null && !frutto.getStatus().isEmpty()) {
                    for (StatusAlterati status : frutto.getStatus()) { 
                %>
                    <li><%= status.getNome() %></li>
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
                    <li><%= resistenza.getNome() %></li>
                <% 
                    }
                } else { 
                %>
                    <li>Nessuna resistenza associata</li>
                <% 
                } 
                %>
            </ul>

            <h2>Statistiche del Frutto</h2>
            <p><strong>Forza:</strong> <%= frutto.getForza() %></p>
            <p><strong>Destrezza:</strong> <%= frutto.getDestrezza() %></p>
            <p><strong>Costituzione:</strong> <%= frutto.getCostituzione() %></p>
            <p><strong>Intelligenza:</strong> <%= frutto.getIntelligenza() %></p>
            <p><strong>Saggezza:</strong> <%= frutto.getSaggezza() %></p>
            <p><strong>Carisma:</strong> <%= frutto.getCarisma() %></p>
            <p><strong>HP:</strong> <%= frutto.getHp() %></p>

            <div class="actionButtons">
                <form action="ModificaFruttoServlet" method="get" style="display:inline;">
                    <input type="hidden" name="idFrutto" value="<%= frutto.getId() %>">
                    <button type="submit" class="buttonMod">Modifica Frutto</button>
                </form>
                <form action="EliminaFruttoServlet" method="post" style="display:inline;" onsubmit="return confirm('Sei sicuro di voler cancellare questo frutto?');">
                    <input type="hidden" name="idFrutto" value="<%= frutto.getId() %>">
                    <button type="submit" class="buttonDel">Cancella Frutto</button>
                </form>
            </div>
        </div>

        <a href="ListaFruttiServlet" class="buttonBack">Torna alla lista frutti</a>
    </div>
</body>
</html>
