<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--放置的位置要特别注意,不能放在第三行,否则会有一些样式问题 --%>
<%@ include file="/WEB-INF/views/comm.jsp" %>
<title>IMark</title>
</head>
<body class="welcome_body">

<div style="margin-left:20px;margin-top: 20px;">
	<h3>Web示例</h3>
	<ul>
		<li>1、<a href="${ctx}/views/file/upload">文件上传页面</a></li>
		<li>2、<a href="${ctx}/views/file/upload">文件下载页面</a></li>
	</ul>
</div>



</body>
</html>