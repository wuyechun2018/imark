<#assign ctx=rc.contextPath />
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<base id="base" href="${ctx}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${ctx}/resources/images/nl.ico" type="image/x-icon" rel="icon">                        
<LINK href="${ctx}/imark/resources/images/nl.ico" type="image/x-icon" rel="shortcut icon">
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.9.1.js"></script>
<title>南陵520！南陵我爱你！芜湖~南陵</title>

<style type="text/css">

body{
	width: 100%; 
	height: 100%;
	margin: 0;
	color:#333;
	font-family: "Microsoft YaHei";

}

ul,li,div{
	margin: 0;
	padding: 0;
}


.ihead{
	background-image: url("${ctx}/resources/images/nl-top.gif");
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
	padding: 0;
	overflow:hidden;
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
	width: 615px;
    padding: 15px 14px;
    margin-bottom: 20px;
    overflow: hidden;
    background: #fff;
    border-radius: 3px;
    border: 1px #eee solid;
}

.imessage{
	border-radius:3px;
	padding：15px 0;
	width:298px;
	margin-bottom:20px;
	border:1px #eee solid;
}

.imessage h2{
	 width: 270px;
    height: 20px;
    padding: 0 15px 0 10px;
    border-left: 5px #f90 solid;
    line-height: 20px;
    font-weight: normal;
    font-size: 14px;
    letter-spacing: 1px;
    margin-bottom: 20px;

}



.irank {
    width: 270px;
    overflow: hidden;
    margin: 0 auto;
    background: url("${ctx}/resources/images/rank.png") 0 0 no-repeat;
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


.ibottom{
	width:963px;
	border-radius:3px 3px 0 0;
	border:1px #eee solid;
	color:#666;
	font-size:12px;
	border-bottom:0;
	padding:20px 0;
	margin:0 auto;
	line-height:26px;
	text-align:center;
	background:#f9f9f9;
	
}


.a-img{
	 float: left;
    width: 222px;
    height: 148px;
    overflow: hidden;
    margin-right: 15px;
    position: relative;
}


.a-content{
	float: left;
    width: 378px;
    height: 148px;
    overflow: hidden;

}

.a-content h1 {
    width: 378px;
    font-size: 18px;
    font-weight: 500;
    margin-bottom: 15px;
    height: 22px;
    line-height: 22px;
    letter-spacing: 1px;
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
}


a:link, a:visited {
    color: #333;
    text-decoration:none;
}

.a-img-div{
 position: absolute;
    left: 0px;
    top: 0px;
    padding: 2px 6px;
    background: #000;
    text-align: center;
    color: #fff;
    border-radius: 0 0 3px 0;
    opacity: 0.3;
}

.a-img img{
 width: 222px;
 height: 148px;
}

.a-content-info{
    width: 378px;
    height: 20px;
    line-height: 20px;
    font-size: 12px;
    overflow: hidden;
    margin-bottom: 10px;
    color: #aaa;
}


.a-content-auth{
    float:left;
    margin-right: 15px;
}

.a-img-div .a-link{
	color:#fff;
	font-size:10px;

}

.a-summary {
    width: 378px;
    height: 25px;
    line-height: 22px;
    font-size: 14px;
    margin-bottom: 15px;
    color: #777;
    overflow: hidden;
}


.a-data {
    width: 378px;
    height: 20px;
    overflow: hidden;
    color: #aaa;
    font-size: 12px;
    line-height: 20px;
}

.a-data-left {
    float: left;
}

.a-data-text {
    float: left;
    height: 20px;
    margin-right: 12px;
}

.a-data-right {
    float: right;
}

.imenu .iselected{
	color:#f90;
}



</style>



<script type="text/javascript">
function setBgColor(color){
	document.bgColor=color;
}



function display(obj,articleType){
	//alert(articleType);
	if(obj){
		$('.imenu a').removeClass("iselected");
		$(obj).addClass("iselected");
		
	}
	$.ajax({
    type:"POST",
    url:"${ctx}/html/getArticleListByType?articleType="+articleType,
    success:function(data, textStatus) {
    		$('#icenter-left').html('');
    		var contentHTML='';
    	 	for(var i=0;i<data.length;i++){
    	 	contentHTML+=	'<div class="iarticle">'
			contentHTML+=			'<div class="a-img">'
			contentHTML+=				'<a href="${ctx}/html/showContent?articleId='+data[i].ARTICLE_ID+'" >'
			contentHTML+=					'<img alt="点击进入" src="${ctx}/resources/images/xwz.jpg">'
			contentHTML+=				'</a>'
			contentHTML+=				'<div class="a-img-div"><a class="a-link" href="javascript:void(0)" target="_blank">南陵印象</a></div>'
			contentHTML+=			'</div>'
			contentHTML+=			'<div class="a-content">'
			contentHTML+=				'<h1><a href="${ctx}/html/showContent?articleId='+data[i].ARTICLE_ID+'" >'+data[i].ARTICLE_TITLE+'</a></h1>'
			contentHTML+=				'<div class="a-content-info">'
			contentHTML+=					'<div class="a-content-auth">作者：<a class="link4" href="javascript:void(0)" >wuyechun</a></div>'
			contentHTML+=				'</div>'
			contentHTML+=				'<div class="a-summary">'+data[i].ARTICLE_DESC+'</div>'
			contentHTML+=				'<div class="a-data">'
			contentHTML+=					'<div class="a-data-left">'
			contentHTML+=						'<div class="a-data-text">推荐于：2016-03-09</div>'
			contentHTML+=					'</div>'
			contentHTML+=					'<div class="a-data-right">浏览：15621 / 评论：3</div>'
			contentHTML+=				'</div>'
			contentHTML+=			'</div>'
			contentHTML+=		'</div>'
    	 }
    	$('#icenter-left').append(contentHTML);
    },
    error:function() {
    	
    }
	});


}


//开始函数
$(function(){

	//alert('${curType}');
	
	<#if curType??>
		display(null,'${curType}');	
	<#else>
		<#list typeList as item>
			<#if item_index == 0>
				display(null,'${item.id?if_exists}');
			 </#if>
		</#list>
	</#if>
	
	
	
	

	
	/**
	var contentHTML='';
	<#list list as item>
			contentHTML+=	'<div class="iarticle">'
			contentHTML+=			'<div class="a-img">'
			contentHTML+=				'<a href="${ctx}/html/showContent?articleId=${item.ARTICLE_ID?if_exists}" target="_blank">'
			contentHTML+=					'<img alt="点击进入" src="${ctx}/resources/images/xwz.jpg">'
			contentHTML+=				'</a>'
			contentHTML+=				'<div class="a-img-div"><a class="a-link" href="javascript:void(0)" target="_blank">南陵印象</a></div>'
			contentHTML+=			'</div>'
			contentHTML+=			'<div class="a-content">'
			contentHTML+=				'<h1><a href="${ctx}/html/showContent?articleId=${item.ARTICLE_ID?if_exists}" target="_blank">${item.ARTICLE_TITLE?if_exists}</a></h1>'
			contentHTML+=				'<div class="a-content-info">'
			contentHTML+=					'<div class="a-content-auth">作者：<a class="link4" href="javascript:void(0)" >wuyechun</a></div>'
			contentHTML+=				'</div>'
			contentHTML+=				'<div class="a-summary">${item.ARTICLE_DESC?if_exists}</div>'
			contentHTML+=				'<div class="a-data">'
			contentHTML+=					'<div class="a-data-left">'
			contentHTML+=						'<div class="a-data-text">推荐于：2016-03-09</div>'
			contentHTML+=					'</div>'
			contentHTML+=					'<div class="a-data-right">浏览：15621 / 评论：3</div>'
			contentHTML+=				'</div>'
			contentHTML+=			'</div>'
			contentHTML+=		'</div>'
		</#list> 	
	
	
	//alert(contentHTML);
	
	$('#icenter-left').append(contentHTML);
	**/
	
	
})
</script>

</head>
<body>
	<div class="ihead">
		<div class="ihead-content">
			<div class="ilogo">
				<a>
					<!-- <img alt="520" src="http://static.u148.net/images/logo.gif"> -->
					<img alt="520" src="${ctx}/resources/images/inanling2.png">
				</a>
			</div>
			
			<div class="imenu">
				<#list typeList as item>
					<#if item.id == curType>
						<a id='${item.id?if_exists}' href="javascript:void(0)" onclick="display(this,'${item.id?if_exists}')" class="iselected">${item.text?if_exists}</a>
						<#else>
						<a id='${item.id?if_exists}' href="javascript:void(0)" onclick="display(this,'${item.id?if_exists}')">${item.text?if_exists}</a>
					 </#if>
				</#list>
			
				<#-- 
				<a href="javascript:void(0)" class="iselected">南陵印象</a>
				<a href="javascript:void(0)">小城大事</a>
				<a href="javascript:void(0)">疯玩地图</a>
				<a href="javascript:void(0)">吃货宝典</a>
				<a href="javascript:void(0)">购物指南</a>
				 -->
				
			</div>
		</div>
	</div>
	
	<div class="icenter">
			<div class="icenter-left" id="icenter-left">
			<#--
			<#list list as item>
					<div class="iarticle">
						<div class="a-img">
							<a href="${ctx}/html/showContent?articleId=${item.ARTICLE_ID?if_exists}" target="_blank">
								<img alt="点击进入" src="${ctx}/resources/images/xwz.jpg">
							</a>
							<div class="a-img-div"><a class="a-link" href="javascript:void(0)" target="_blank">南陵印象</a></div>
						</div>
						<div class="a-content">
							<h1><a href="${ctx}/html/showContent?articleId=${item.ARTICLE_ID?if_exists}" target="_blank">${item.ARTICLE_TITLE?if_exists}</a></h1>
							<div class="a-content-info">
								<div class="a-content-auth">作者：<a class="link4" href="javascript:void(0)" >wuyechun</a></div>
							</div>
							
							<div class="a-summary">${item.ARTICLE_DESC?if_exists}</div>
							
							<div class="a-data">
								<div class="a-data-left">
									<div class="a-data-text">推荐于：2016-03-09</div>
								</div>
								<div class="a-data-right">浏览：15621 / 评论：3</div>
							</div>
							
						</div>
					</div>
				</#list> 
				-->	
					
			</div>

        <!--
            <div class="icenter-right">
                <div class="imessage">
                    <h2 >月排行榜</h2>
                    <div class="irank">
                        <ul>
                            <li>
                                <a>梦中水乡,南陵印象</a>
                            </li>

                        </ul>

                    </div>

                </div>
            </div>
        -->

	     <#include "inc/page-right.ftl"/>

	</div>


	<!--
    <div class="ibottom">

        <div>关于我们　隐私政策　广告投放　联系我们　友情链接　帮助中心</div>
        <div>有时候,简单也是一种美丽！</div>
        <div>© 我爱南陵 所有  皖ICP备16003309号  340223198808230010  违法不良信息举报</div>


    </div>
   -->
	<#include "inc/page-bottom.ftl"/>


</body>
</html>