<%@page import="org.prepuzy.model.Qualita"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Aggiungi Qualità</title>
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
        <div class="centerBar">
            <h1>Aggiungi Qualità</h1>
            <form action="AggiungiQualitaServlet" method="post">
                <div>
                    <label for="nome">Nome Qualità:</label>
                    <input type="text" id="nome" name="nome" required>
                </div>
                <div>
                    <label for="descrizione">Descrizione:</label>
                    <textarea id="descrizione" name="descrizione" required></textarea>
                </div>
                <div class="addNew">
                    <button type="submit" class="btnAdd">Aggiungi Qualità</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
