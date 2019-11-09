<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
</head>
<body>
<form action="/Shopping/member/doAddMember" method="get" style="width: 400px;margin: 150px 0px 0px 600px;">
    <span class="text-danger">*</span><span class="text-info">账号：</span><input type="text" class="form-control" name="loginName" placeholder="默认ID与账号相同" value="">
	<br>
    <span class="text-danger">*</span><span class="text-info">密码：</span><input type="text" class="form-control" name="pwd"  value="">
	<br>
    <span class="text-info">年龄：</span><input type="text" class="form-control" name="age"  value="">
    <br>
    <span class="text-danger">*</span>
    <span class="text-info">权限：</span>
	<select class="form-control" name="nickName" >
		<option >管理员</option>
		<option >普通员工</option>
		<option >访客</option>
	</select>
	<br>
	<button type="submit" class="btn btn-primary" style="float: right">创建</button>
</form>
</body>
</html>