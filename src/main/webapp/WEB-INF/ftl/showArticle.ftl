<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>imark</title>

<style type="text/css">
.title{
	font-size:30px;
	font-weight:bold;
	font-family:'Microsoft YaHei';
	color:#333333;
}

.info{
	color:#898989;
	font-size:12px;
	font-family:'Microsoft YaHei';
}

.info_span{
margin-left:10px;
margin-right:10px;
}

.info_desc{
	font-size:12px;
	color:#333333;
	font-family:'楷体';
}

.info_content{
font-size:15px;
font-family:'宋体';
}

.info_sep{
height:30px;
text-align:center;
border-bottom:1px #dcdcdc solid;
}


</style>
</head>
<body>
<a href="../views/system/article">返回</a>
<div style="TEXT-ALIGN:center" class="title">${article.articleTitle!''}</div>
<br>
<div style="TEXT-ALIGN:center" class="info" >
	<span class="info_span">创建人：${article.createUserId!'管理员'}</span>
	<span class="info_span"> 创建时间：${article.createDate!''}</span>
</div>
<div class="info_sep"></div>
<div class="info_desc">${article.articleDesc!''}</div>
<div class="info_content">${article.articleContent!''}</div>
<div class="info_sep"></div>

</body>
</html>