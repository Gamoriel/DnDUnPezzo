<%@page import="org.prepuzy.model.Personaggio"%>
<%@page import="org.prepuzy.model.Razza"%>
<%@page import="org.prepuzy.model.Professione"%>
<%@page import="org.prepuzy.model.Ciurma"%>
<%@page import="org.prepuzy.model.Nave"%>
<%@page import="java.util.Set"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Modifica Personaggio</title>
    <link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
    <nav>
        <div class="navBar"></div>
    </nav>

    <div class="container">
        <h1>Modifica Personaggio</h1>

        <%
            Personaggio personaggio = (Personaggio) request.getAttribute("personaggio");
            Set<Razza> razze = (Set<Razza>) request.getAttribute("razze");
            Set<Professione> professioni = (Set<Professione>) request.getAttribute("professioni");
            Set<Ciurma> ciurme = (Set<Ciurma>) request.getAttribute("ciurme");
            Set<Nave> navi = (Set<Nave>) request.getAttribute("navi");
        %>

        <form action="ModificaPersonaggioServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="<%= personaggio.getId() %>">
            
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="<%= personaggio.getNome() %>" required><br>

            <label for="soprannome">Soprannome:</label>
            <input type="text" id="soprannome" name="soprannome" value="<%= personaggio.getSoprannome() %>"><br>

            <label for="descrizione">Descrizione:</label>
            <textarea id="descrizione" name="descrizione" required><%= personaggio.getDescrizione() %></textarea><br>

            <label for="taglia">Taglia:</label>
            <input type="number" id="taglia" name="taglia" value="<%= personaggio.getTaglia() != null ? personaggio.getTaglia().toString() : "" %>"><br>

            <label for="razza">Razza:</label>
            <select id="razza" name="razza">
                <option value="">Seleziona Razza</option>
                <%
                    for (Razza razza : razze) {
                %>
                    <option value="<%= razza.getId() %>" <%= personaggio.getRazza() != null && personaggio.getRazza().getId() == razza.getId() ? "selected" : "" %> >
                        <%= razza.getNome() %>
                    </option>
                <%
                    }
                %>
            </select><br>

            <label for="professione">Professione:</label>
            <select id="professione" name="professione">
                <option value="">Seleziona Professione</option>
                <%
                    for (Professione professione : professioni) {
                %>
                    <option value="<%= professione.getId() %>" <%= personaggio.getProfessione() != null && personaggio.getProfessione().getId() == professione.getId() ? "selected" : "" %> >
                        <%= professione.getNome() %>
                    </option>
                <%
                    }
                %>
            </select><br>

            <label for="ciurma">Ciurma:</label>
            <select id="ciurma" name="ciurma">
                <option value="">Seleziona Ciurma</option>
                <%
                    for (Ciurma ciurma : ciurme) {
                %>
                    <option value="<%= ciurma.getId() %>" <%= personaggio.getCiurma() != null && personaggio.getCiurma().getId() == ciurma.getId() ? "selected" : "" %> >
                        <%= ciurma.getNome() %>
                    </option>
                <%
                    }
                %>
            </select><br>

            <label for="nave">Nave:</label>
            <select id="nave" name="nave">
                <option value="">Seleziona Nave</option>
                <%
                    for (Nave nave : navi) {
                %>
                    <option value="<%= nave.getId() %>" <%= personaggio.getNave() != null && personaggio.getNave().getId() == nave.getId() ? "selected" : "" %> >
                        <%= nave.getNome() %>
                    </option>
                <%
                    }
                %>
            </select><br>

            <label for="urlImmagine">URL Immagine:</label>
            <input type="file" id="urlImmagine" name="urlImmagine" accept="image/*"><br>

            <h2>Statistiche</h2>
            <label for="forza">Forza:</label>
            <input type="number" id="forza" name="forza" value="<%= personaggio.getForza() %>" required><br>

            <label for="destrezza">Destrezza:</label>
            <input type="number" id="destrezza" name="destrezza" value="<%= personaggio.getDestrezza() %>" required><br>

            <label for="costituzione">Costituzione:</label>
            <input type="number" id="costituzione" name="costituzione" value="<%= personaggio.getCostituzione() %>" required><br>

            <label for="intelligenza">Intelligenza:</label>
            <input type="number" id="intelligenza" name="intelligenza" value="<%= personaggio.getIntelligenza() %>" required><br>

            <label for="saggezza">Saggezza:</label>
            <input type="number" id="saggezza" name="saggezza" value="<%= personaggio.getSaggezza() %>" required><br>

            <label for="carisma">Carisma:</label>
            <input type="number" id="carisma" name="carisma" value="<%= personaggio.getCarisma() %>" required><br>

            <label for="hp">HP:</label>
            <input type="number" id="hp" name="hp" value="<%= personaggio.getHp() %>" required><br>

            <button type="submit" class="btnSave">Salva Modifiche</button>
        </form>
    </div>
</body>
</html>
