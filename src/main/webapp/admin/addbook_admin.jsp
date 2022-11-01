<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>add</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<body>
<br/>
<br/><br/>
<form method="post" action="${pageContext.request.contextPath}/book?opera=addbook" enctype="multipart/form-data" accept="image/*">
    <div class="container">
    <h3>图书添加</h3>
    <div class="form-group">
      <label for="ISBN">ISBN：</label>

      <input type="text" name="ISBN" id="ISBN"
             class="form-control"
             placeholder="请输入ISBN..." required="required"/>
    </div>
    <div class="form-group">
      <label for="bookname">书名：</label>
      <!-- 文本输入框，h5新特性placeholder属性 -->
      <input type="text" name="bookname" id="bookname"
             class="form-control"
             placeholder="请输入书名..." required="required"/>
    </div>
    <div class="form-group">
      <label for="price">价格：</label>
      <input type="number" name="price" id="price"
             class="form-control"
             placeholder="请输入价格..." required="required"/>
    </div>

    <div class="form-group">
      <label for="press">出版社：</label>
      <input type="text" name="press" id="press"
             class="form-control"
             placeholder="请输入出版社..." required="required"/>
    </div>

    <div class="form-group">
      <label for="author">作者：</label>
      <input type="text" name="author" id="author"
             class="form-control"
             placeholder="请输入作者..." required="required"/>
    </div>

    <div class="form-group">
      <label for="description">描述：</label>
      <input type="text" style="height: auto"   name="description" id="description"
             class="form-control"
             placeholder="请输入描述..." required="required"/>
    </div>

    <div class="form-group">
        <label for="imageFile">图片文件：</label>
        <input type="file"  name="imageFile" id="imageFile"
               class="form-control"
               placeholder="请输入路径..." required="required"/>
    </div>

    <div class="form-group">
        <label for="categoryID">类别：</label>
        <input type="number"  name="categoryID" id="categoryID"
               class="form-control"
               placeholder="请输入类别..." required="required"/>
    </div>
    <button type="submit" class="btn btn-default">提交</button>
    </div>
</form>


</body>
</html>