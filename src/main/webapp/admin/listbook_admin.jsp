<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.bzu.fdick.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <!-- 强转成一个用户，拿到用户名字 -->
       <h3><p>尊贵的管理员${user.userName}</p></h3>
        <a href="${pageContext.request.contextPath}/carServlet">购物车</a>
        <a href="${pageContext.request.contextPath}/orderAServlet">订单管理</a>
    </div>
</div>
<a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/addbook_admin.jsp">添加</a>
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
            <td>${book.price}</td>
            <td>${book.author}</td>
            <td>${book.press}</td>
            <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/purchaseServlet?id=${book.ISBN}">加入购物车</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book?opera=deleteBook&&id=${book.ISBN}">删除</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book?opera=searchone&&id=${book.ISBN}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
