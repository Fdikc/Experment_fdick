<%--
  Created by IntelliJ IDEA.
  User: FU
  Date: 2022/11/10
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">--%>
<%--    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>--%>
<%--    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>--%>
<%--    <!--可无视-->--%>
    <link href="css/main.css" rel="stylesheet" type="text/css" />

    <!--必要样式-->
    <link href="css/city-picker.css" rel="stylesheet" type="text/css" />
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/city-picker.data.js"></script>
    <script src="js/city-picker.js"></script>
    <script src="js/main.js"></script>

    <title>结算</title>
</head>
<body>


<form id="stuForm" method="post" action="orderServlet">
    <div class="container">
        <h3>收获地址</h3>

        <div class="form-group">
            <!-- lable标签 for属性光标定位，点击后可以对应id的框 -->
            <label for="price">价格：</label>
            <!-- 文本输入框，h5新特性placeholder属性 -->
            <input type="text" name="price" id="price"
                   class="form-control"
                    required="required" value="${total}" readonly/>
        </div>

<%--        <div class="form-group">--%>
<%--            <label for="pass">收货地址：</label>--%>
<%--            <!-- 文本输入框，h5新特性placeholder属性 -->--%>
<%--            <input type="text" name="receiverAddress" id="pass"--%>
<%--                   class="form-control"--%>
<%--                   placeholder="收获地址..." required="required"/>--%>
<%--        </div>--%>

                <div class="form-group">
                    <div style="position: relative;">
                        <label for="city-picker3">收获地址：</label>
                        <input id="city-picker3"  name="receiveraddress" class="form-control" readonly type="text" value="山东省/滨州市/滨城区" data-toggle="city-picker">
                    </div>
                </div>
                <div class="form-group">
                    <button class="btn btn-warning" id="reset" type="button">重置</button>
                    <button class="btn btn-danger" id="destroy" type="button">确定</button>
                </div>


        <div class="form-group">
            <label for="receiverName">收货人：</label>
            <input type="text" name="receiverName" id="receiverName"
                   class="form-control"
                   placeholder="请输入姓名..." required="required"/>
        </div>

        <div class="form-group">
            <label for="receiverPhone">手机号：</label>
            <input type="number" name="receiverPhone" id="receiverPhone"
                   class="form-control"
                   placeholder="请输入手机号..." required="required"/>
        </div>

        <button type="submit" class="btn btn-default">提交</button>

    </div>
</form>

</body>
</html>
