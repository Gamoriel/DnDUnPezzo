<%@ page import="org.prepuzy.model.Professione" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Aggiungi Professione</title>
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
            <h1>Aggiungi Nuova Professione</h1>

            <form action="AggiungiProfessioneServlet" method="post">
                <div>
                    <label for="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" required>
                </div>

                <div>
                    <label for="descrizione">Descrizione:</label>
                    <textarea id="descrizione" name="descrizione" rows="4" required></textarea>
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
                    <input type="submit" value="Aggiungi Professione">
                </div>
            </form>
        </div>
    </div>
</body>
</html>
