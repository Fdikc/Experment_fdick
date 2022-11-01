<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

  <script>
    //表单验证
    function check(){
      var ids = document.getElementsByName("hobby");
      var flag = false ;
      for(var i=0;i<ids.length;i++){
        if(ids[i].checked){
          flag = true ;
          break ;
        }
      }
      if(!flag){
        alert("爱好请最少选择一项！");
        return false ;
      }
    }
  </script>

</head>
<body>
<br/>
<br/><br/>




<form id="stuForm" method="post" action="user?opera=register" onsubmit="return check();">
  <div class="container">
    <h3>学生信息注册</h3>


    <div class="form-group">
      <!-- lable标签 for属性光标定位，点击后可以对应id的框 -->
      <label for="name">姓名：</label>
      <!-- 文本输入框，h5新特性placeholder属性 -->
      <input type="text" name="name" id="name"
             class="form-control"
             placeholder="请输入姓名..." required="required"/>
    </div>
    <div class="form-group">

      <label for="pass">密码：</label>
      <!-- 文本输入框，h5新特性placeholder属性 -->
      <input type="password" name="password" id="pass"
             class="form-control"
             placeholder="请输入密码..." required="required"/>
    </div>

    <div class="form-group">
      <label for="age">年龄：</label>
      <input type="number" name="age" id="age"
             class="form-control"
             placeholder="请输入年龄..." required="required"/>
    </div>

    <div class="form-group">
      <label for="sex">性别：（单选框）</label>
      <!-- radio互斥，同名会只能选择一个 -->
      <label class="radio-inline">
        <input type="radio" name="sex"  checked="checked" value="男"/> 男
      </label>
      <label class="radio-inline">
        <input type="radio" name="sex" id="sex" value="女"/> 女
      </label>
    </div>

    <div class="form-group">
      <label for="hobby">爱好：（多选）</label>
      <label class="checkbox-inline">
        <input type="checkbox" checked="checked" name="hobby"  value="乒乓球"/> 乒乓球
      </label>
      <label class="checkbox-inline">
        <input type="checkbox" name="hobby"  value="爬山"/> 爬山
      </label>
      <label class="checkbox-inline">
        <input type="checkbox" name="hobby"  value="唱歌"/> 唱歌
      </label>
      <label class="checkbox-inline">
        <input type="checkbox" name="hobby" id="hobby" value="睡觉"/> 睡觉
      </label>
    </div>

    <button type="submit" class="btn btn-default">提交</button>

  </div>
</form>

<div class="form-group" style="text-align:center;">
<a href="login.jsp">已有账号? 点击登录</a>
</div>



</body>

</html>