<%@page import="org.prepuzy.model.Razza"%>
<%@page import="org.prepuzy.model.Personaggio"%>
<%@page import="java.util.Set"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Dettagli Razza</title>
    <link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
    <nav>
        <div class="navBar">
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
    </nav>

    <div class="container">
        <div class="leftBar">
            <h2>Dettagli Razza</h2>
            <%
                Razza razza = (Razza) request.getAttribute("razza");
                if (razza != null) {
            %>
            <div class="razzaDettagli">
                <h1><%= razza.getNome() %></h1>
                <p><strong>Descrizione:</strong> <%= razza.getDescrizione() %></p>

                <h3>Personaggi appartenenti a questa razza:</h3>
                <%
                    Set<Personaggio> personaggi = razza.getPersonaggi();
                    if (personaggi != null && !personaggi.isEmpty()) {
                %>
                <ul>
                    <%
                        for (Personaggio personaggio : personaggi) {
                    %>
                    <li>
                        <strong>Nome:</strong> <%= personaggio.getNome() %><br>
                        <a href="DettagliPersonaggioServlet?idPersonaggio=<%= personaggio.getId() %>">Visualizza Dettagli</a>
                    </li>
                    <%
                        }
                    %>
                </ul>
                <%
                    } else {
                %>
                <p>Nessun personaggio appartiene a questa razza.</p>
                <%
                    }
                %>
            </div>
            <%
                } else {
            %>
            <p>Razza non trovata.</p>
            <%
                }
            %>
        </div>

        <div class="addNew">
            <form action="ModificaRazzaServlet" method="get">
                <input type="hidden" name="idRazza" value="<%= razza != null ? razza.getId() : "" %>">
                <button type="submit" class="btnEdit">Modifica Razza</button>
            </form>

            <form action="EliminaRazzaServlet" method="post">
                <input type="hidden" name="idRazza" value="<%= razza != null ? razza.getId() : "" %>">
                <button type="submit" class="btnDelete" onclick="return confirm('Sei sicuro di voler eliminare questa razza?');">Elimina Razza</button>
            </form>
        </div>
    </div>
</body>
</html>
