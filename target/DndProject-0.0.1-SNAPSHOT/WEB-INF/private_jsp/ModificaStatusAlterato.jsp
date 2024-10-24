<%@ page import="org.prepuzy.model.StatusAlterati" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Modifica Status Alterato</title>
    <link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
    <nav>
        <div class="navBar"></div>
    </nav>

    <div class="container">
        <h1>Modifica Status Alterato</h1>

        <%
        StatusAlterati statusAlterato = (StatusAlterati) request.getAttribute("statusAlterato");
        if (statusAlterato != null) {
        %>
        <form action="ModificaStatusAlteratoServlet" method="post">
            <input type="hidden" name="idStatusAlterato" value="<%= statusAlterato.getId() %>">
            
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="<%= statusAlterato.getNome() %>" required><br><br>
            
            <label for="descrizione">Descrizione:</label>
            <textarea id="descrizione" name="descrizione" required><%= statusAlterato.getDescrizione() %></textarea><br><br>
            
            <button type="submit" class="btnSave">Salva Modifiche</button>
        </form>
        <%
        } else {
        %>
        <p>Status alterato non trovato.</p>
        <%
        }
        %>
    </div>
</body>
</html>
