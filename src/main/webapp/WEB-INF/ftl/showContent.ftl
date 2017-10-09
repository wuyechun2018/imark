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
<title>${appTitle}</title>

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


.icenter-left .content {
    width: 585px;
    padding: 30px 29px 20px;
    margin-bottom: 20px;
    overflow: hidden;
    border-radius: 3px;
    border: 1px #eee solid;
}


.content h1 {
    width: 585px;
    font-size: 22px;
    font-weight: 700;
    margin-bottom: 15px;
    height: 26px;
    line-height: 26px;
    letter-spacing: 1px;
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
    text-align: center;
}


.content .article-info {
    width: 585px;
    margin-bottom: 20px;
    line-height: 26px;
    overflow: hidden;
    font-family: Arial,Verdana,Helvetica,sans-serif;
    font-size: 12px;
    color: #999;
    text-align: center;
}

.content .article-info a {
    color: #999;
}

.content .article-info .space {
    padding: 0 5px;
}

.content .article-info .level4 {
    width: 73px;
}

.content .article-info .star {
    display: inline-block;
    height: 13px;
    background: url("${ctx}/resources/images/stars.png") 0 1px no-repeat;
}


.content .declare {
    width: 585px;
    font-size: 14px;
    padding: 7px 0;
    text-align: center;
    background: #f9f9f9;
    color: #999;
    overflow: hidden;
    margin-bottom: 20px;
}

.content .status {
    width: 585px;
    height: 20px;
    margin: 0 0 20px;
    color: #999;
    font-family: Verdana, Geneva, sans-serif;
    font-size: 12px;
}

.content .status span {
    float: right;
}

a.link4:link, a.link4:visited {
    color: #3498db;
}



.icenter-right{
	float:right;
	width:300px;
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

.mainbar {
    width: 643px;
    padding: 15px 0;
    margin-bottom: 20px;
    overflow: hidden;
    background: #fff;
    border-radius: 3px;
    border: 1px #eee solid;
}

.mainbar h2 {
    width: 613px;
    height: 20px;
    padding: 0 15px 0 10px;
    border-left: 5px #f90 solid;
    line-height: 20px;
    font-weight: normal;
    font-size: 14px;
    letter-spacing: 1px;
    margin-bottom: 20px;
}


.post-comments {
    width: 585px;
    font-size: 14px;
    padding: 15px;
    background: #f6f6f6;
    border-radius: 3px;
    margin: 0 auto 15px;
    font-family: Arial,Verdana,Helvetica,sans-serif;
    overflow: hidden;
}

.post-comments input {
    width: 120px;
    height: 30px;
    line-height: 26px;
    font-size: 12px;
    text-align: center;
    background: #65b916;
    border: 0;
    color: #fff;
}

.post-comments textarea {
    width: 563px;
    height: 90px;
    line-height: 22px;
    font-size: 12px;
    border: 1px #f9f9f9 solid;
    overflow: auto;
    padding: 5px 10px;
}

.comments {
    width: 643px;
    margin: 0 auto;
    overflow: hidden;
}


.comments ul {
    width: 613px;
    overflow: hidden;
    padding: 25px 15px;
    border-top: 1px solid #eee;
}

.comments ul li {
    width: 613px;
}


.comments ul li .reply .operate a {
    color: #999;
}


.comments ul li .reply .operate {
    font-size: 12px;
    margin-top: 15px;
    font-family: Verdana,Arial,Helvetica,sans-serif;
    text-align: right;
}


.post-comments span {
    font-size: 12px;
    color: #bbb;
    line-height: 26px;
}


.comments ul li .reply .comments-info {
    font-size: 12px;
    margin-bottom: 15px;
    height: 20px;
    line-height: 12px;
    color: #999;
    font-family: Verdana,Arial,Helvetica,sans-serif;
}

.comments ul li .reply {
    float: right;
    text-align: left;
    width: 535px;
    font-size: 14px;
    line-height: 26px;
    word-break: break-all;
    word-wrap: break-word;
}

.comments ul li .reply span {
    color: #999;
    padding: 0 5px;
}


.comments ul li .user-avatar {
    float: left;
    width: 60px;
    height: 60px;
}



.comments ul li .user-avatar img {
    width: 60px;
    height: 60px;
}





</style>



<script type="text/javascript">
function setBgColor(color){
	document.bgColor=color;
}

//开始函数
$(function(){
	//alert('${ctx}');
	
})
</script>

</head>
<body>
	<div class="ihead">
		<div class="ihead-content">
			<div class="ilogo">
				<a>
					<!-- <img alt="520" src="http://static.u148.net/images/logo.gif"> -->
					<img alt="520" src="${ctx}/resources/images/${appLogo}">
				</a>
			</div>
			
			<div class="imenu">
			
				<#list typeList as item>
						<#if item.id == article.articleType >
						<a id='${item.id?if_exists}' href="${ctx}/html/index?curType=${item.id?if_exists}" class="iselected" >${item.text?if_exists}</a>
						<#else>
						<a id='${item.id?if_exists}' href="${ctx}/html/index?curType=${item.id?if_exists}" >${item.text?if_exists}</a>
						 </#if>
				</#list>
			
				<!--
				<a href="javascript:void(0)" class="iselected">南陵印象</a>
				<a href="${ctx}/html/index">小城大事</a>
				<a href="javascript:void(0)">疯玩地图</a>
				<a href="javascript:void(0)">吃货宝典</a>
				<a href="javascript:void(0)">购物指南</a>
				-->
			</div>
		</div>
	</div>
	
	<div class="icenter">
			<div class="icenter-left">
			
				
				
				
				<div class="content">
				<h1>${article.articleTitle!''}</h1>
				<div class="article-info">
					关键词：<a href="javascript:void(0)">${article.keyWord!''}</a>  <font class="space">丨</font>
					<a href="javascript:void(0)" rel="category">南陵印象</a><font class="space">丨</font>
					<span class="star level4"></span><font class="space">丨</font>
					来自：<a href="javascript:void(0)" >${article.createUserId!'理想之翼'}</a><font class="space">丨</font>
					<a id="btn_favourite" href="javascript:void(0)">收藏</a>
					<a id="btn_article_edit" style="display: none;" href="#">编辑</a>
					<div id="article_info" style="display: none;">文章状态：[ 通过审核 ] [ 首页 ]<font class="space">丨</font>高级：<a class="link4" id="btn_article_edit1" href="#">编辑</a> / <a class="link5" id="btn_article_edit2" href="javascript:void(0)">设置</a></div>
				</div>
				<div class="declare">本文为原创内容，未经许可，禁止转载；合作请联系QQ：904261233</div>
				<div class="contents">
					${article.articleContent!''}
				</div>
				<div class="declare">欢迎同学们转载但请注明出处及链接，媒体、微信请获得授权，联系QQ：904261233。</div>
				<div class="status"><span><a class="link4" id="btn_feedback" href="javascript:void(0)">举报&amp;反馈</a></span>2016-03-01 10:17:03 发布 丨 8722 人浏览</div>
			
				
			
			
			
			</div>
				<div class="mainbar" id="floors">
				<h2>本文评论</h2>
				<div class="post-comments" id="review_post"><span id="article_review_touser"></span><textarea id="article_review_contents"></textarea><div align="right"><span>顶，让你眼中精彩的回复亮起来！</span> <input class="input_submit" id="btn_article_review_post" type="button" value="发表神回复"></div></div>
				<div class="comments">
					<ul id="floor_728276">
						<li>
							<div class="user-avatar">
								<img class="uhead" src="${ctx}/resources/images/32.jpg">
							</div>
							<div class="reply">
								<div class="comments-info">
									<font>1#</font><a class="link4" href="/u/jane8627" target="_blank">岁月流年</a><span></span>2016-03-24 17:22<span>丨</span>60.216.*.*
								</div>
								<div id="review_contents_728276">很多事情，求而不得的爱情，反而是我们心底最心心念念的。及时各自有了家庭，可是有些感情依旧会埋在心底的某个角落，不轻易碰触，因为太疼……</div>
								<div class="operate">
									<font id="review_ctrl_728276">
										<a name="btn_review_manage" style="display: none;" href="javascript:void(0)" target="_blank" data="id:728276">管理</a>　
										<a name="btn_review_delete" style="display: none;" href="javascript:void(0)" data="id:728276" uid="377064">删除</a> <span>丨</span>
										<a name="btn_review_ding" href="javascript:void(0)" data="id:728276">赞</a> <font name="review_support_728276">(0)</font><span>丨</span>
										<a name="btn_review_citation" href="javascript:void(0)" data="id:728276,nickname:'岁月流年'">回复</a>
									</font>
								</div>
							</div>
						</li>
					</ul>
					<ul id="floor_728281">
						<li>
							<div class="user-avatar">
								<img class="uhead" src="${ctx}/resources/images/12.jpg">
							</div>
							<div class="reply">
								<div class="comments-info">
									<font>2#</font><a class="link4" href="/u/178337" target="_blank">无缘</a><span></span>2016-03-25 00:54<span>丨</span>175.15.*.*丨来自Android客户端
								</div>
								<div id="review_contents_728281">断了线的风筝，总是令人怀念</div>
								<div class="operate">
									<font id="review_ctrl_728281">
										<a name="btn_review_manage" style="display: none;" href="javascript:void(0)" target="_blank" data="id:728281">管理</a>　
										<a name="btn_review_delete" style="display: none;" href="javascript:void(0)" data="id:728281" uid="178337">删除</a> <span>丨</span>
										<a name="btn_review_ding" href="javascript:void(0)" data="id:728281">赞</a> <font name="review_support_728281">(0)</font><span>丨</span>
										<a name="btn_review_citation" href="javascript:void(0)" data="id:728281,nickname:'无缘'">回复</a>
									</font>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
					
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
			</div>-->



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