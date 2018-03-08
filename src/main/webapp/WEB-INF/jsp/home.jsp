<%--
  Created by IntelliJ IDEA.
  User: Дима
  Date: 08.03.2018
  Time: 2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная</title>
</head>
<body>
<form action="FrontController" method="get">
    <input type="hidden" name="pageNumber" value="1">
    <input type="hidden" name="action" value="parse">
    <button type="submit" name="parserType" value="sax">
        SAX
    </button>
    <button type="submit" name="parserType" value="stax">
        StAX
    </button>
    <button type="submit" name="parserType" value="dom">
        DOM
    </button>

    <p><b>Количество элементов на странице:</b></p>
    <p><input name="itemsPerPage" type="radio" value="3"> 3</p>
    <p><input name="itemsPerPage" type="radio" value="5" checked> 5</p>
    <p><input name="itemsPerPage" type="radio" value="7"> 7</p>
</form>
</body>
</html>
