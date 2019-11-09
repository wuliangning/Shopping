<%--
  Created by IntelliJ IDEA.
  User: qq11232025606
  Date: 2019/10/22
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="width: 1200px">
    <form action="/Shopping/member/doUpdateMember" method="get" >
        <table class="table" style="margin: 100px 200px 150px 200px">
            <tbody>
            <tr>
                <td><span  class="text-info">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ID:</span><input style="display: inline-block;width: 350px" type="text"  class="form-control"  readonly="readonly" name="id" value="${member.id}"></td>
                <td><span  class="text-info">登录名:</span><input style="display: inline-block;width: 350px" type="text" class="form-control" name="loginName" value="${member.loginName}"></td>
            </tr>
            <tr>
                <td><span  class="text-info">登录密码:</span><input style="display: inline-block;width: 350px" type="text" class="form-control" name="pwd" value="${member.pwd}"></td>
                <td><span  class="text-info">&nbsp;&nbsp;&nbsp;昵称:</span><input style="display: inline-block;width: 350px" type="text" class="form-control" name="nickName" value="${member.nickName}"></td>
            </tr>
            <tr  >
                <td><span  class="text-info">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年龄:</span><input style="display: inline-block;width: 350px" type="text" class="form-control" name="age" value="${member.age}"></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-primary">提交</button></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
