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
<script type="text/javascript" src="../statics/scripts/jquery/jquery-1.7.1.js"></script>
<link href="../statics/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="../statics/style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../statics/scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="../statics/scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="../statics/scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="../statics/style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>
<title>信息管理系统</title>
<script type="text/javascript">
function search(){
	  var keyWord= document.getElementById("keyWord").value;
	  window.location.href = "keyWord?keyWord="+keyWord;	
}

function del(fyID){
	// 非空判断
	if(fyID == '') return;
	if(confirm("您确定要删除吗？")){
		window.location.href = "delete?id="+fyID;	
	}
}

var xmlhttp;
function keyWord(){
    var keyWord= document.getElementById("keyWord").value;
    alert(keyWord);
	var url = "/Shopping/wares/keyWord?keyWord="+keyWord;
    // xmlhttp =new XMLHttpRequest();
    //  xmlhttp.onreadystatechange=keyWordResult; //响应函数
    //  xmlhttp.open("GET",url,true);   //设置访问的页面
    //  xmlhttp.send(null);  //执行访问

    $.get(
        url,
        function(data) {
            /* alert(data); */
        });
}
function keyWordResult(){

     if (xmlhttp.readyState==4 && xmlhttp.status==200)
        var a=xmlhttp.response;
         alert(a);
         removeTags("tr","del");
}
function removeTags(tagName,tagClass){
    var tagElements = document.getElementsByTagName( tagName );
    for( var m = 0 ; m < tagElements.length ; m++ ){
        if( tagElements[m].className == tagClass ){
            tagElements[m].parentNode.removeChild( tagElements[m] );
        }
    }
}

	</script>
<style>
	.alt td{ background:black !important;}
</style>
</head>
<body>
<div class="well" style="text-align:center">
	<span class="	glyphicon glyphicon-search text-info" style="font-size: 20px;"></span>
	<input style="width: 400px;display: inline-block;height: 40px" type="text" class="form-control"   id="keyWord" value="">
	<input type="button" class = "sourch btn btn-primary""  id = "search" value="搜索" onclick=search()>
</div>
<form id="submitForm" name="submitForm" action="" method="post">
		<input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>
		<input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>
		<div id="container">
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th width="30"><input type="checkbox" id="all" onclick="selectOrClearAllCheckbox(this);" />
							</th>
							<th>ID</th>
							<th>商品名称</th>
							<th>商品出场日期</th>
							<th>商品出产地</th>
							<th>商品金额</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${mapList}" var="um">
						<tr class="del">
							<td><input type="checkbox" name="IDCheck" value="14458579642011" class="acb" /></td>
							<td>${um.value.id}</td>
							<td>${um.value.wareName}</td>
							<td>${um.value.wareDate}</td>
							<td>${um.value.wareWhere}</td>
							<td>${um.value.wareMoney}</td>
							<td>
								<a href="/Shopping/wares/get?id=${um.value.id}&wareName=${um.value.wareName}&wareDate=${um.value.wareDate}&wareWhere=${um.value.wareWhere}&wareMoney=${um.value.wareMoney}" class="edit">编辑</a>
								<a href="javascript:del('${um.value.id}');">删除</a>
							</td>
						</tr>

					</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>