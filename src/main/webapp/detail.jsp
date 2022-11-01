
<%@ page import="java.util.List" %>
<%@ page import="edu.bzu.fdick.entity.Book" %>

<%--  Created by IntelliJ IDEA.--%>
<%--  User: FU--%>
<%--  Date: 2022/10/20--%>
<%--  Time: 12:15--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>detail</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<body>
<h1>Book Detail</h1>
   <div style="float: left;width: 260px;display:inline-block ">
       <img src="${bookdetail.imageFile}" height="350" width="250" class="pic">
       <br>
  <h3>    <a href="${pageContext.request.contextPath}/download?address=${bookdetail.imageFile}">下载封面</a></h3>
   </div>
<div style="float: left" class="jumbotron">
       <h5>ISBN: ${bookdetail.ISBN}</h5>
        <h5>书名：${bookdetail.bookName}></h5>
        <h5>价格：${bookdetail.price}</h5>
         <h5>出版社：${bookdetail.press}</h5>
         <h5>作者：${bookdetail.author}</h5>
         <textarea readonly style="width: 902px; height: 109px;">描述：${bookdetail.description}</textarea>

       <div class="btn-group btn-group-xs">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/purchaseServlet?id=${bookdetail.ISBN}">添加购物车</a>
             </div>
</div>
  </body>
</html>
