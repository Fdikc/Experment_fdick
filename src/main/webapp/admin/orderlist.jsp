<%--
  Created by IntelliJ IDEA.
  User: FU
  Date: 2022/11/12
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
  <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>

<div class="jumbotron">
  <div class="container">
    <h1>欢迎光临SuperMarket</h1>
    <!-- 强转成一个用户，拿到用户名字 -->
    <h3><p>尊贵的管理员${user.userName}</p></h3>
    <a href="${pageContext.request.contextPath}/carServlet">购物车</a>
  </div>
</div>

<table class="table table-hover">
  <tr>
    <th>
      订单ID
    </th>

    <th>
      下单用户
    </th>
    <th>
     订单金额
    </th>
    <th>
     收货地址
    </th>
    <th>
      收货人
    </th>
    <th>
      收货手机号
    </th>
    <th>
      下单时间
    </th>
    <th>
      操作
    </th>
  </tr>
  <c:forEach items="${orders}" var="order">
    <tr>
      <td>${order.id}</td>
      <td>${order.userid}</td>
      <td>${order.money}</td>
      <td>${order.receiveraddress}</td>
      <td>${order.receivername}</td>
      <td>${order.receiverphone}</td>
      <td>
        <fmt:formatDate value="${order.ordertime}" pattern="yyyy年MM月dd日"></fmt:formatDate>
      </td>
      <td>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/orderAServlet?opera=del&&id=${order.id}">删除</a>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/orderAServlet?opera=detail&&id=${order.id}">详情</a>

      </td>
    </tr>
  </c:forEach>
</table>




  </body>
</html>
