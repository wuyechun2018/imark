<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--放置的位置要特别注意,不能放在第三行,否则会有一些样式问题 --%>
<script type="text/javascript">
var ctx = "${ctx}";
</script>
<script type="text/javascript" charset="utf-8" src="${ctx}/resources/ueditor-1.4.3.1/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/resources/ueditor-1.4.3.1/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${ctx}/resources/ueditor-1.4.3.1/lang/zh-cn/zh-cn.js"></script>
<title>IMark</title>
<script type="text/javascript">
	var ue = UE.getEditor('editor');
</script>
</head>
<body>
 <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
</body>
</html>