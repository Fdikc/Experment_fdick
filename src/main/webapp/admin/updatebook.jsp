
<%--  Created by IntelliJ IDEA.--%>
<%--  User: FU--%>
<%--  Date: 2022/10/21--%>
<%--  Time: 13:04--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>update</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</head>

<body>


<form action="${pageContext.request.contextPath}/book" method="post" enctype="multipart/form-data">
    <div class="container">
    <h3>图书修改</h3>
    <input type="hidden" name="opera" value="updateBook">

    <div class="form-group">
    <span>ISBN:</span><input type="text"  class="form-control" name="ISBN" readonly value="${book.ISBN}">
    </div>
    <div class="form-group">
    <span>书名:</span><input type="text"  class="form-control" name="bookname"  value="${book.bookName}">
        </div>
    <div class="form-group">
    <span>价格:</span><input type="number"  class="form-control" name="price"  value="${book.price}">
        </div>
    <div class="form-group">
    <span>图片:</span><img src="${book.imageFile}" height="200" width="100">
        <input type="file"  class="form-control" name="imageFile">
        </div>
    <div class="form-group">
    <span>出版社:</span><input type="text" class="form-control" name="press"  value="${book.press}">
        </div>
    <div class="form-group">
    <span>作者:</span><input type="text" class="form-control" name="author"  value="${book.author}">
        </div>
    <div class="form-group">
    <span>描述:</span><input type="text" class="form-control" name="description"  value="${book.description}">
        </div>
    <div class="form-group">
    <span>类别:</span><input type="number" class="form-control" name="categoryID" readonly value="${book.categoryID}">
    </div>
   <input type="submit" value="提交">
    </div>
</form>

</body>
</html>
