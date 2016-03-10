<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="http://localhost:5678/imark/resources/images/favicon.ico" type="image/x-icon" rel="icon">                        
<LINK href="http://localhost:5678/imark/resources/images/favicon.ico" type="image/x-icon" rel="shortcut icon">
<script type="text/javascript" src="http://localhost:5678/imark/resources/jquery/jquery-1.9.1.js"></script>
<title>520</title>

<style type="text/css">

body{
	width: 100%; 
	height: 100%;
	margin: 0;
	color:#333;
	font-family: "Microsoft YaHei";

}

ul,li{
	margin: 0;
	padding: 0;
}


.ihead{
	background-image: url("http://localhost:5678/imark/resources/images/nl-top.gif");
	height: 90px;
}

.ihead-content{
	width:965px;
	height:90px;
	margin: 0 auto;
}

.ilogo{
	height: 60px;
	margin:18px 20px 17px 0;
	widht:165px;
	float:left;
}

.imenu{
	float:left;
	margin:35px 0;
	height:28px;
	line-height:26px;
	font-size:14px;
}

.imenu a{
	float:left;
	margin:0 0 0 30px;
	padding:0 3px;
	font-size: 14px;
	text-decoration:none;
	color:#333;

}

.icenter{
	width:965px;
	margin: 0 auto;

}

.icenter-left{
	float:left;
	width:645px;
}


.icenter-right{
	float:right;
	width:300px;
}

.iarticle{
	padding:15px 14px;
	background:#fff;
	border-radius:3px;
	border:1px #eee solid;
	width:615px;
	margin-bottom:20px;
}

.imessage{
	border-radius:3px;
	padding：15px 0;
	width:298px;
	margin-bottom:20px;
	border:1px #eee solid;
}

.imessage h2{
	width:270px;
	height:20px;
	font-size:14px;
	border-left:5px #f90 solid;
	line-height:20px;
	margin-bottom:20px;
	letter-spacing:1px;

}

.irank{
	width:270px;
	margin:0 auto;

}

ul{
list-style:none;

}

.irank ul li{
	width: 240px;
	height: 36px;
	padding-left: 30px;
	font-size:13px;
	vertical-align:top;
	white-space:nowrap;
	text-overflow:ellipsis;

}


</style>



<script type="text/javascript">
function setBgColor(color){
	document.bgColor=color;
}

//开始函数
$(function(){
	
})
</script>

</head>
<body>
	<div class="ihead">
		<div class="ihead-content">
			<div class="ilogo">
				<a>
					<img alt="520" src="http://static.u148.net/images/logo.gif">
				</a>
			</div>
			
			<div class="imenu">
				<a href="#">小城大事</a>
				<a href="#">疯玩地图</a>
				<a href="#">吃货宝典</a>
				<a href="#">购物指南</a>
				<a href="#">城南旧事</a>
			</div>
		</div>
	</div>
	
	<div class="icenter">
			<div class="icenter-left">
					<div class="iarticle">
						${article.articleContent!''}
					</div>
			</div>
			<div class="icenter-right">
				<div class="imessage">
					<h2 >月排行榜</h2>
					<div class="irank">
						<ul>
							<li>
								<a>hello</a>
							</li>
						
						</ul>
					
					</div>
				
				</div>
			</div>
	</div>

</body>
</html>