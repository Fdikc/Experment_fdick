<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <title>商品列表</title>
</head>
<body>
<div class="jumbotron">
    <div class="container">
        <h1>欢迎光临SuperMarket</h1>
       <h3><p>尊贵的${user.userName}</p></h3>
        <a href="${pageContext.request.contextPath}/car.jsp">购物车</a>
    </div>
</div>
<fmt:setBundle basename="book"/>
<table class="table table-hover">
    <tr>
        <th>
            <fmt:message key="B_ISBN"/>
        </th>
        <th>
            <fmt:message key="B_BookName"/>
        </th>
        <th>
            <fmt:message key="B_Price"/>
        </th>
        <th>
            <fmt:message key="B_Author"/>
        </th>
        <th>
            <fmt:message key="B_press"/>
        </th>
        <th>
            <fmt:message key="B_Operator"/>
        </th>
    </tr>
    <c:forEach items="${books}" var="book">
    <tr onclick="location.href='book?opera=detial&&id=${book.ISBN}';">
            <td>${book.ISBN}</td>
            <td>${book.bookName}</td>

<%--        货币格式化--%>
            <td><fmt:formatNumber value="${book.price}" type="currency" currencySymbol="￥"/></td>
<%--            <td>${book.price}</td>--%>
            <td>${book.author}</td>
            <td>${book.press}</td>
            <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/purchaseServlet?id=${book.ISBN}">加入购物车</a></td>
        </tr>
    </c:forEach>
</table>


<div style="text-align: center">
<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
</div>
</body>
</html>