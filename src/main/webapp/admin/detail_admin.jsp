
<%--
  Created by IntelliJ IDEA.
  User: FU
  Date: 2022/11/12
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>xijie</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
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
      购买图书ISBN
    </th>
  </tr>

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
          <c:forEach items="${orderandisbn}" var="orderand">
              ${orderand.bookISBN} <br>
          </c:forEach>
      </td>
    </tr>
</table>



  </body>
</html>
