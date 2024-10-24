<%@page import="java.util.Set"%>
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
    <meta charset="ISO-8859-1">
    <title>Dettagli Nave</title>
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

        <%
        Nave nave = (Nave) request.getAttribute("nave");
        if (nave != null) {
        %>
            <h2><%= nave.getNome() %></h2>
            <p><strong>Descrizione:</strong> <%= nave.getDescrizione() %></p>
            <p><strong>Forza:</strong> <%= nave.getForza() %></p>
            <p><strong>Destrezza:</strong> <%= nave.getDestrezza() %></p>
            <p><strong>Costituzione:</strong> <%= nave.getCostituzione() %></p>
            <p><strong>Intelligenza:</strong> <%= nave.getIntelligenza() %></p>
            <p><strong>Saggezza:</strong> <%= nave.getSaggezza() %></p>
            <p><strong>Carisma:</strong> <%= nave.getCarisma() %></p>
            <p><strong>HP:</strong> <%= nave.getHp() %></p>

            <h3>Inventario:</h3>
            <%
            Inventario inventario = nave.getDeposito();
            if (inventario != null) {
            %>
                <p><strong>Berry:</strong> <%= inventario.getBerry() %></p>
                <h4>Oggetti:</h4>
                <%
                List<Oggetto> oggetti = inventario.getOggetti();
                if (oggetti != null && !oggetti.isEmpty()) {
                    for (Oggetto oggetto : oggetti) {
                %>
                    <div>
                        <a href="DettagliOggettoServlet?idOggetto=<%= oggetto.getId() %>">
                            <%= oggetto.getNome() %>
                        </a>
                    </div>
                <%
                    }
                } else {
                %>
                    <p>Nessun oggetto trovato nell'inventario.</p>
                <%
                }
                %>
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
                <a href="DettagliCiurmaServlet?idCiurma=<%= ciurma.getId() %>">
                    <%= ciurma.getNome() %>
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
            Set<Personaggio> personaggi = nave.getPersonaggi();
            if (personaggi != null && !personaggi.isEmpty()) {
                for (Personaggio personaggio : personaggi) {
            %>
                <div>
                    <a href="DettagliPersonaggioServlet?idPersonaggio=<%= personaggio.getId() %>">
                        <%= personaggio.getNome() %>
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
            <div class="actionButtons">
                <form action="ModificaNaveServlet" method="get">
                    <input type="hidden" name="idNave" value="<%= nave.getId() %>">
                    <button class="buttonMod" type="submit">Modifica Nave</button>
                </form>
                <form action="EliminaNaveServlet" method="post" 
                      onsubmit="return confirm('Sei sicuro di voler cancellare questa nave?');">
                    <input type="hidden" name="idNave" value="<%= nave.getId() %>">
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
        <a href="NaviServlet">Torna alla lista delle navi</a>
    </div>
</body>
</html>
