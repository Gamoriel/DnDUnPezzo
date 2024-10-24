<%@page import="org.prepuzy.model.StatusAlterati"%>
<%@page import="java.util.Set"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Lista Status Alterati</title>
    <link rel="stylesheet" href="resources/css/Style.css">
</head>
<body>
    <nav>
        <div class="navBar"></div>
    </nav>

    <div class="container">
        <div class="leftBar">
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

        <div class="centerBar">
            <h1>Lista degli Status Alterati</h1>
            <%
                Set<StatusAlterati> statusAlterati = (Set<StatusAlterati>) request.getAttribute("statusAlterati");
                if (statusAlterati != null && !statusAlterati.isEmpty()) {
                    for (StatusAlterati status : statusAlterati) {
            %>
            <div class="statusCard">
                <h2><%= status.getNome() %></h2>
                <p><strong>Descrizione:</strong> <%= status.getDescrizione() %></p>
                <form action="DettagliStatusAlteratiServlet" method="get">
                    <input type="hidden" name="idStatusAlterati" value="<%= status.getId() %>">
                    <button type="submit" class="buttonMod">Dettagli</button>
                </form>
            </div>
            <%
                    }
                } else {
            %>
            <p>Nessun status alterato disponibile</p>
            <%
                }
            %>
            <div class="addNew">
                <form action="AggiungiStatusAlteratiServlet" method="get">
                    <button type="submit" class="btnAdd">Aggiungi Nuovo Status Alterato</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
