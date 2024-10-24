<%@ page import="java.util.Set" %>
<%@ page import="org.prepuzy.model.Resistenza" %>
<%@ page import="org.prepuzy.model.Razza" %>
<%@ page import="org.prepuzy.model.Professione" %>
<%@ page import="org.prepuzy.model.StatusAlterati" %>
<%@ page import="org.prepuzy.model.Tipologia" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Aggiungi Oggetto</title>
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
            </ul>
        </div>

        <div class="centerBar">
            <h1>Aggiungi Nuovo Oggetto</h1>

            <form action="AggiungiOggettoServlet" method="post">
                <div>
                    <label for="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" required>
                </div>
                <div>
                    <label for="descrizione">Descrizione:</label>
                    <textarea id="descrizione" name="descrizione" rows="4" required></textarea>
                </div>
                <div>
                    <label for="prezzo">Prezzo:</label>
                    <input type="number" id="prezzo" name="prezzo" required>
                </div>

                <div>
                    <label for="forza">Forza:</label>
                    <input type="number" id="forza" name="forza" required>
                </div>
                <div>
                    <label for="destrezza">Destrezza:</label>
                    <input type="number" id="destrezza" name="destrezza" required>
                </div>
                <div>
                    <label for="costituzione">Costituzione:</label>
                    <input type="number" id="costituzione" name="costituzione" required>
                </div>
                <div>
                    <label for="intelligenza">Intelligenza:</label>
                    <input type="number" id="intelligenza" name="intelligenza" required>
                </div>
                <div>
                    <label for="saggezza">Saggezza:</label>
                    <input type="number" id="saggezza" name="saggezza" required>
                </div>
                <div>
                    <label for="carisma">Carisma:</label>
                    <input type="number" id="carisma" name="carisma" required>
                </div>
                <div>
                    <label for="hp">HP:</label>
                    <input type="number" id="hp" name="hp" required>
                </div>
                <div>
                    <label for="peso">Peso:</label>
                    <input type="number" id="peso" name="peso" required>
                </div>
                
                <div>
                    <label for="tipologia">Seleziona Tipologia:</label>
                    <select id="tipologia" name="tipologia" required>
                        <%
                        Set<Tipologia> listaTipologie = (Set<Tipologia>) request.getAttribute("listaTipologie");
                        if (listaTipologie != null && !listaTipologie.isEmpty()) {
                            for (Tipologia tipologia : listaTipologie) {
                        %>
                        <option value="<%= tipologia.getId() %>"><%= tipologia.getNome() %></option>
                        <%
                            }
                        } else {
                        %>
                        <option value="">Nessuna tipologia disponibile</option>
                        <%
                        }
                        %>
                    </select>
                </div>

                <div>
                    <label>Resistenze:</label>
                    <%
                    Set<Resistenza> listaResistenze = (Set<Resistenza>) request.getAttribute("listaResistenze");
                    if (listaResistenze != null && !listaResistenze.isEmpty()) {
                        for (Resistenza resistenza : listaResistenze) {
                    %>
                    <input type="checkbox" name="resistenze" value="<%= resistenza.getId() %>"> <%= resistenza.getNome() %><br>
                    <%
                        }
                    }
                    %>
                </div>

                <div>
                    <label>Razze compatibili:</label>
                    <%
                    Set<Razza> listaRazze = (Set<Razza>) request.getAttribute("listaRazze");
                    if (listaRazze != null && !listaRazze.isEmpty()) {
                        for (Razza razza : listaRazze) {
                    %>
                    <input type="checkbox" name="razze" value="<%= razza.getId() %>"> <%= razza.getNome() %><br>
                    <%
                        }
                    }
                    %>
                </div>

                <div>
                    <label>Professioni compatibili:</label>
                    <%
                    Set<Professione> listaProfessioni = (Set<Professione>) request.getAttribute("listaProfessioni");
                    if (listaProfessioni != null && !listaProfessioni.isEmpty()) {
                        for (Professione professione : listaProfessioni) {
                    %>
                    <input type="checkbox" name="professioni" value="<%= professione.getId() %>"> <%= professione.getNome() %><br>
                    <%
                        }
                    }
                    %>
                </div>

                <div>
                    <label>Status Alterati:</label>
                    <%
                    Set<StatusAlterati> listaStatus = (Set<StatusAlterati>) request.getAttribute("listaStatus");
                    if (listaStatus != null && !listaStatus.isEmpty()) {
                        for (StatusAlterati status : listaStatus) {
                    %>
                    <input type="checkbox" name="status" value="<%= status.getId() %>"> <%= status.getNome() %><br>
                    <%
                        }
                    }
                    %>
                </div>

                <div>
                    <input type="submit" value="Aggiungi Oggetto">
                </div>
            </form>
        </div>
    </div>
</body>
</html>
