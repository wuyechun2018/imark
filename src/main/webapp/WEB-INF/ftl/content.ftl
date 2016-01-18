<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>讯飞开放平台</title>
<link rel="stylesheet" href="/imark/resources/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="/imark/resources/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript" src="/imark/resources/ztree/jquery.ztree.core-3.5.js"></script>
<!-- http://localhost:5678/imark/resources/data/demo.html -->

<style type="text/css">
body{
margin: 0px;
padding: 0px;

}

a{
text-decoration: none;
}

a:VISITED{
	text-decoration: none;
}

a:HOVER{
	color: RGB(0,149,226);
}

li {list-style-type:none;}

.ihead{
	background: #1f2738;
	height: 35px;

}

.ititle{
	margin-left:75px;
	color: #FFF;
	line-height: 35px;
	font-size: 12px;
}

.isystem{
	float:right;
	margin-right: 40px;
	
}

.imenu{
	padding-left: 40px;
}

.imenu .iul{
	float:right;
	line-height: 60px;
} 

.imenu .iul a{
	float:left;
	font-family: Microsoft YaHei;
	width:92px;
	cursor: pointer;
}

.imenu_content_title{
	font-size: 20px;
	color:#171717;
	line-height:51px;
	font-family: Microsoft YaHei;
	padding-left: 5px;
	background-color: RGB(247,247,247);
	width: 100%;
}

.icontent{
	width: 100%;
}

.ibottom{
text-align: center;
font-size:12px;
color:#7e8187;
margin-top: 5px;
}

.ihot_img{
	width: 76px;
	height: 76px;
}

.ilink{
	text-align: center;
	width:982px;
	margin:0 auto;
	padding-right: 0px;
}

.ilink a{
	text-decoration: none;
	font-size:14px;
	padding:0 10px;
	color:#7e8187;
}

</style>

<script type="text/javascript">
var setting = {
		view: {
			showIcon: showIconForTree,
			showLine:true
		},
		data: {
			simpleData: {
				enable: true
			}
		}
	};

	var zNodes =[
		{ id:1, pId:0, name:"平台概述", open:true},
		{ id:11, pId:1, name:"平台介绍",url:"/imark/editor/showArticle?articleId=40286f8151e8f03e0151ece7eb150001", target:"showFrame"},
		{ id:12, pId:1, name:"服务协议",url:"/imark/editor/showArticle?articleId=40286f8151e8f03e0151eceb203a0003", target:"showFrame"},
		{ id:2, pId:0, name:"开发集成"},
		{ id:21, pId:2, name:"Android平台", open:true},
		{ id:22, pId:2, name:"IOS平台"},
		{ id:23, pId:2, name:"Windows平台"},
		{ id:231, pId:2, name:"Linux平台"},
		{ id:232, pId:2, name:"Java平台"},
		{ id:3, pId:0, name:"新手指南", isParent:false},
		{ id:4, pId:0, name:"语音服务", isParent:true},
		{ id:5, pId:0, name:"硬件服务", isParent:true}
	];

	function showIconForTree(treeId, treeNode) {
		//return !treeNode.isParent;
		return false;
	};

	$(document).ready(function(){
		$.fn.zTree.init($("#imenuTree"), setting, zNodes);
	});




</script>



</head>
<body>

<div class="ihead">
	<div class="ititle">
		<span>我们致力于为开发者打造最优的智能交互服务平台！</span>
		<div class="isystem">
				<a>登录</a>
				&nbsp; &nbsp;&nbsp;
				<a>注册</a>
		</<div>
	</div>
</div>


<div style="width:100%;height:1px;margin:0px auto;padding:0px;background-color:#555555;overflow:hidden;"></div>

<div class="imenu">
	<img  src="http://www.xfyun.cn/img/default/logo.gif?version=20150325">
	<div class="iul">
			<a>关于讯飞</a>
			<a>自主产品</a>
			<a>解决方案</a>
			<a>互联网+</a>
			<a>服务支持</a>
			<a>
				<div>企业文化</div>
			</a>
	</div>
</div>



<div class="icontent">
	<div style="width:1200px;margin:0 auto;border: 1px solid #ccc;">
		<table>
			<tr>
				<td width="200px;" style="padding:5px 0px " valign="top">
					<h2 class="imenu_content_title">关于讯飞</h2>
					<div>
						<ul id="imenuTree" class="ztree"></ul>
					</div>
					
					
				</td>
				
				<td>
					<iframe name="showFrame" style="border-left:#ccc 1px solid;"  src="http://localhost:5678/imark/editor/showArticle?articleId=40286f8151e8f03e0151ece7eb150001" width="966px;" height="500px;" frameborder="0" ></iframe>
				</td>
			
			</tr>
		</table>
		
	
	</div>


</div>

<div>
<hr style="height:1px;border:none;border-top:1px solid #555555;width:100%;" />
</div>

<div class="ilink">
	<a href="">联系我们</a>|
	<a href="">校园招聘</a>|
	<a href="">法律条款</a>|
	<a href="">站点地图</a>
</div>
<div class="ibottom">
	(C)COPYRIGHT 2013, IFLYTEK SOFTWARE ALL RIGHTS RESERVED. 版权所有 © 科大讯飞股份有限公司 皖ICP备05001217号
</div>


</body>
</html>