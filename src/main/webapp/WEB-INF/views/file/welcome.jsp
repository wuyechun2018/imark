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

<div style="margin-left:20px;">
<h3 class="text-success">登录成功! ${CURRENT_USER.loginAccount} 欢迎您!</h3> 
</div>
<%--
<marquee width="300px" height="22px" Behaviour="Alternate" 
direction="up" scrollamount="2" onmouseover="this.stop()" onmouseout="this.start()">
</marquee>
--%>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<h3 class="text-info">
				IMark
			</h3>
			<p>
				<em>IMark</em>，使用<strong>Maven</strong>构建的web项目，使用Spring+SpringMvc+SpringJdbcTemplate。
			</p>
			<ul>
				<li>
					<a href="${ctx}/webDemo" >Web示例</a>
				</li>
				<li>
					<a href="${ctx}/main" >管理系统</a>
				</li>
			</ul>
		</div>
	</div>
</div>


</body>
</html>