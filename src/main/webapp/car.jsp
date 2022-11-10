<%--
  Created by IntelliJ IDEA.
  User: FU
  Date: 2022/10/28
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
  <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
  <title>car</title>
</head>
<body>

<h1>购物车</h1>
<div class="container">
    <h1>购物车</h1>
  <c:if test="${empty cart}">
    <h1>购物车为空</h1>
  </c:if>
    <c:if test="${!empty cart}">
        <table class="table table-hover">
        <tr>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>商品作者</th>
            <th>出版社</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${cart}" var="carone">
            <tr>
            <td>${carone.value.bookName}</td>
            <td>${carone.value.price}</td>
            <td>${carone.value.author}</td>
            <td>${carone.value.press}</td>
            <td>
                <a href="removeCar?id=${carone.value.ISBN}">删除</a>
            </td>
            </tr>
        </c:forEach>

        </table>
    </c:if>

<%--    购物车总金额--%>
    <c:if test="${!empty total}">
        <h3>总金额：${total}</h3>
    </c:if>

    <c:if test="${!empty cart}">
        <a href="buyCar.jsp" class="btn btn-primary">结算</a>
    </c:if>
    <a href="book?opera=findAll">返回书籍列表</a>
</div>

  </body>
</html>
