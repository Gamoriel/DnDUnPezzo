<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <title>Errore</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da;
            color: #721c24;
            padding: 50px;
        }
        .error-container {
            border: 1px solid #f5c6cb;
            background-color: #f8d7da;
            padding: 20px;
            border-radius: 5px;
            text-align: center;
        }
        h1 {
            color: #721c24;
        }
        p {
            margin: 15px 0;
        }
        .btn-back {
            padding: 10px 20px;
            background-color: #721c24;
            color: white;
            border: none;
            border-radius: 5px;
            text-decoration: none;
        }
        .btn-back:hover {
            background-color: #f5c6cb;
            color: #721c24;
        }
    </style>
</head>
<body>

    <div class="error-container">
        <h1>Errore</h1>
        <p><%= request.getAttribute("messaggioErrore") %></p>
        <a href="${pageContext.request.contextPath}/MasterPageServlet" class="btn-back">Torna alla Home</a>
    </div>

</body>
</html>
