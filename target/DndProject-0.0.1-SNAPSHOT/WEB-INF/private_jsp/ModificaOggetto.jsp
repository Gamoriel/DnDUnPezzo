<%@page import="java.util.Set"%>
<%@page import="org.prepuzy.model.Oggetto"%>
<%@page import="org.prepuzy.model.Resistenza"%>
<%@page import="org.prepuzy.model.Razza"%>
<%@page import="org.prepuzy.model.Professione"%>
<%@page import="org.prepuzy.model.StatusAlterati"%>
<%@page import="org.prepuzy.model.Tipologia"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Modifica Oggetto</title>
    <link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
    <nav>
        <div class="navBar">
        </div>
    </nav>

    <div class="container">
    <%Oggetto oggetto = (Oggetto) request.getAttribute("oggetto"); %>
        <h1>Modifica Oggetto</h1>

        <form action="ModificaOggettoServlet" method="post">
            <input type="hidden" name="idOggetto" value="<%= oggetto.getId() %>">

            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="<%= oggetto.getNome() %>" required>

            <label for="descrizione">Descrizione:</label>
            <textarea id="descrizione" name="descrizione" required><%= oggetto.getDescrizione() %></textarea>

            <label for="prezzo">Prezzo:</label>
            <input type="number" id="prezzo" name="prezzo" value="<%= oggetto.getPrezzo() %>" required>
            
            <label for="peso">Peso:</label>
            <input type="text" id="peso" name="peso" value="<%= oggetto.getPeso()%>">

            <h2>Resistenze</h2>
            <div>
                <% 
                Set<Resistenza> resistenzeOggetto = oggetto.getResistenze();
                Set<Resistenza> tutteLeResistenze = (Set<Resistenza>) request.getAttribute("listaResistenze");
                for (Resistenza resistenza : tutteLeResistenze) { 
                %>
                    <label>
                        <input type="checkbox" name="resistenze" value="<%= resistenza.getId() %>"
                            <%= resistenzeOggetto.contains(resistenza) ? "checked" : "" %>>
                        <%= resistenza.getNome() %>
                    </label>
                <% } %>
            </div>

            <h2>Razze</h2>
            <div>
                <% 
                Set<Razza> razzeOggetto = oggetto.getRazze();
                Set<Razza> tutteLeRazze = (Set<Razza>) request.getAttribute("listaRazze");
                for (Razza razza : tutteLeRazze) { 
                %>
                    <label>
                        <input type="checkbox" name="razze" value="<%= razza.getId() %>"
                            <%= razzeOggetto.contains(razza) ? "checked" : "" %>>
                        <%= razza.getNome() %>
                    </label>
                <% } %>
            </div>

            <h2>Professioni</h2>
            <div>
                <% 
                Set<Professione> professioniOggetto = oggetto.getProfessioni();
                Set<Professione> tutteLeProfessioni = (Set<Professione>) request.getAttribute("listaProfessioni");
                for (Professione professione : tutteLeProfessioni) { 
                %>
                    <label>
                        <input type="checkbox" name="professioni" value="<%= professione.getId() %>"
                            <%= professioniOggetto.contains(professione) ? "checked" : "" %>>
                        <%= professione.getNome() %>
                    </label>
                <% } %>
            </div>

            <h2>Status Alterati</h2>
            <div>
                <% 
                Set<StatusAlterati> statusOggetto = oggetto.getStatus();
                Set<StatusAlterati> tuttiGliStatus = (Set<StatusAlterati>) request.getAttribute("listaStatus");
                for (StatusAlterati status : tuttiGliStatus) { 
                %>
                    <label>
                        <input type="checkbox" name="status" value="<%= status.getId() %>"
                            <%= statusOggetto.contains(status) ? "checked" : "" %>>
                        <%= status.getNome() %>
                    </label>
                <% } %>
            </div>

            <h2>Tipologia</h2>
            <select name="tipologia">
                <% 
                Tipologia tipologiaOggetto = oggetto.getTipologia();
                Set<Tipologia> tutteLeTipologie = (Set<Tipologia>) request.getAttribute("listaTipologie");
                for (Tipologia tipologia : tutteLeTipologie) { 
                %>
                    <option value="<%= tipologia.getId() %>"
                        <%= tipologiaOggetto.getId() == tipologia.getId() ? "selected" : "" %>>
                        <%= tipologia.getNome() %>
                    </option>
                <% } %>
            </select>


            <button type="submit" class="btnSave">Salva Modifiche</button>
        </form>
    </div>
</body>
</html>