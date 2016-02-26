<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--放置的位置要特别注意,不能放在第三行,否则会有一些样式问题 --%>
<%@ include file="/WEB-INF/views/comm.jsp" %>
<title>imark</title>
<style type="text/css">
body{
	background-color: rgb(244,251,251);
	font-family: 'Microsoft YaHei';
	font-size:13px;
	color:#444;
	-moz-background-size:100% 100%;
	-o-background-size:100% 100%;
	
	
}
.loginForm{
	margin-top:20px;
	padding:26px 24px 46px;
	-webkit-box-shadow:0 1px 3px rgba(0, 0, 0, .13);
	background:rgba(255, 255, 255, 0.6);
	border-radius:2px;
}

label{
	color:#000;
	font-size:14px;
}

.loginForm input{
	background:#fbfbfb;
	padding:3px;
	margin:2px 6px 16px 0;
	width:100%;
	font-size:24px;
	border:1px solid #ddd;
	/* transition:50ms border-color ease-in-out; */
	box-shadow:0px 0px 2px rgba(30,140,190,0.8);
	border-color:#5b9dd9;
	border-radius:0;
	height: 28px;
}

.link{
	margin:24px 20 0;
	padding-left:30px;
}

.link a{
	text-decoration: none;
}

</style>
</head>
<body class="welcome_body">
<div style="margin-left:20px;padding-bottom:50px;">
</div>


<div style="margin:auto;width: 320px;padding:6% 0 0;"> 
	<div style="margin-left:25px;font-family: STXingkai;font-size:50px;color:RGB(76,178,208)">IMark</div> 
	<%-- <img src="${ctx}/resources/images/imark002.png" style="vertical-align:middle"> --%>
	<br>
	<form action="${ctx}/doLogin" method="post" class="loginForm">
		<label >用户名</label><input type="text" value="admin" name="loginAccount"/> <br>
		<label >密码</label><input type="password" value="123" name="loginPwd" /><br>
		<!-- <label>
			<input name="rememberme" id="rememberme" type="checkbox" value="forever"></input>
			记住我的登录信息
		</label> -->
		<button class="btn  btn-info" type="submit">登录</button>
		<!-- <button class="btn  btn-info" type="reset">取消</button> -->
	</form>
	<p  class="link">
		<a href="#">注册</a>&nbsp;&nbsp;
		<a href="#">忘记密码?</a>
	</p>
	<p class="text-error">${ERROR_MSG}</p>
</div>

<%-- 
<form class="form-horizontal" >
	<div class="control-group">
		<label class="control-label" for="loginAccount">用户名</label>
		<div class="controls">
			<input type="text" name="loginAccount">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="loginPwd">密码</label>
		<div class="controls">
			<input type="password" id="loginPwd">
		</div>
	</div>

	<div class="control-group">
		<div class="controls">
			<button class="btn  btn-info" type="submit">提交</button>
			<button class="btn  btn-info" type="reset">取消</button>
		</div>
	</div>
</form>
--%>

</body>
</html>