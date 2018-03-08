<%--
  Created by IntelliJ IDEA.
  User: Дима
  Date: 05.03.2018
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Меню</title>
</head>
<body>

<table border='1' cellpadding='4' width='60%'>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <c:forEach var="food" items="${menu}">
        <tr>
            <td>${food.id}</td>
            <td>${food.name}</td>
            <td>${food.price}</td>
        </tr>
    </c:forEach>
</table>
<%--For displaying Previous link except for the 1st page --%>
<c:if test="${pageNumber != 1}">
    <td><a href="FrontController?pageNumber=${pageNumber - 1}&parserType=${parserType}&action=${action}&itemsPerPage=${itemsPerPage}">Предыдущая</a></td>
</c:if>

<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <c:forEach begin="1" end="${countOfPages}" var="i">
            <c:choose>
                <c:when test="${pageNumber eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="FrontController?pageNumber=${i}&parserType=${parserType}&action=${action}&itemsPerPage=${itemsPerPage}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<%--For displaying Next link --%>
<c:if test="${pageNumber lt countOfPages}">
    <td><a href="FrontController?pageNumber=${pageNumber + 1}&parserType=${parserType}&action=${action}&itemsPerPage=${itemsPerPage}">Следующая</a></td>
</c:if>

<td><a href="FrontController?action=home">На главную</a></td>
</body>
</html>