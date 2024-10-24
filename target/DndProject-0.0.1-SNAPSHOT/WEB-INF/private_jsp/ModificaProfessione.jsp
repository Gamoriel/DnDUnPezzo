<%@page import="org.prepuzy.model.Professione"%>
<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Modifica Professione</title>
    <link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
    <nav>
        <div class="navBar"></div>
    </nav>

    <div class="container">
        <h1>Modifica Professione</h1>
        <%
            // Recupera l'oggetto Professione passato dal servlet
            Professione professione = (Professione) request.getAttribute("professione");
        %>
        
        <form action="ModificaProfessioneServlet" method="post">
            <input type="hidden" name="id" value="<%= professione.getId() %>">
            
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="<%= professione.getNome() %>" required>

            <label for="descrizione">Descrizione:</label>
            <textarea id="descrizione" name="descrizione" required><%= professione.getDescrizione() %></textarea>

            <label for="forza">Forza:</label>
            <input type="number" id="forza" name="forza" value="<%= professione.getForza() %>" required>

            <label for="destrezza">Destrezza:</label>
            <input type="number" id="destrezza" name="destrezza" value="<%= professione.getDestrezza() %>" required>

            <label for="costituzione">Costituzione:</label>
            <input type="number" id="costituzione" name="costituzione" value="<%= professione.getCostituzione() %>" required>

            <label for="intelligenza">Intelligenza:</label>
            <input type="number" id="intelligenza" name="intelligenza" value="<%= professione.getIntelligenza() %>" required>

            <label for="saggezza">Saggezza:</label>
            <input type="number" id="saggezza" name="saggezza" value="<%= professione.getSaggezza() %>" required>

            <label for="carisma">Carisma:</label>
            <input type="number" id="carisma" name="carisma" value="<%= professione.getCarisma() %>" required>

            <label for="hp">HP:</label>
            <input type="number" id="hp" name="hp" value="<%= professione.getHp() %>" required>

            <button type="submit" class="btnSave">Salva Modifiche</button>
        </form>
    </div>
</body>
</html>
