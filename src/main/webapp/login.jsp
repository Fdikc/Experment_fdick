<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

  <style>
  .errorMsg{
    text-align: center;
    display:block;
    color: red;
  }
</style>
</head>
<body>
<br/>
<br/><br/>

<form class="form-inline" action="user?opera=login" method="post" style="text-align:center;" >
  <div class="form-group">
    <label class="sr-only" for="exampleInputEmail3">姓名</label>
    <input type="text" class="form-control" name="username" id="exampleInputEmail3" placeholder="姓名">
  </div>
  <br/>
  <br/>
  <div class="form-group">
    <label class="sr-only" for="exampleInputPassword3">Password</label>
    <input type="password" class="form-control" name="password" id="exampleInputPassword3" placeholder="Password">
  </div>
  <br/>
  <br/>
  <button type="submit" class="btn btn-default">登录</button>
</form>
<br/>

<div class="form-group" style="text-align:center;">
  <a href="Regist.jsp">还没账号? 点击注册</a>
</div>
<%--<%=request.getAttribute("Info")%>--%>
<span class="errorMsg" align="center">
<h3>
  ${requestScope.Info}

</h3>


</span>

</body>
</html>