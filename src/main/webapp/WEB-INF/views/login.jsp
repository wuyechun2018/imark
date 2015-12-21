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
}

</style>
</head>
<body class="welcome_body">
<div style="margin-left:20px;padding-bottom:50px;">
<h4 class="text-info">IMark</h4>
</div>

<div style="margin-left:20px;">
<form action="${ctx}/doLogin" method="post">
	<div >
	<label>用户名：</label><input type="text" name="loginAccount"/> <br>
	<label>密码：</label><input type="password" name="loginPwd" /><br>
	<button class="btn  btn-info" type="submit">提交</button>
	<button class="btn  btn-info" type="reset">取消</button>
	</div>
</form>
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