<%@ page import="org.prepuzy.model.Resistenza" %>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Modifica Resistenza</title>
    <link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
    <nav>
        <div class="navBar"></div>
    </nav>

    <div class="container">
        <h1>Modifica Resistenza</h1>

        <%
        Resistenza resistenza = (Resistenza) request.getAttribute("resistenza");
        if (resistenza != null) {
        %>

        <form action="ModificaResistenzaServlet" method="post">
            <input type="hidden" name="idResistenza" value="<%= resistenza.getId() %>">

            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="<%= resistenza.getNome() %>" required><br>

            <label for="descrizione">Descrizione:</label>
            <textarea id="descrizione" name="descrizione" required><%= resistenza.getDescrizione() %></textarea><br>

            <button type="submit" class="btnSave">Salva Modifiche</button>
        </form>

        <%
        } else {
        %>
        <p>Resistenza non trovata.</p>
        <%
        }
        %>
    </div>
</body>
</html>
