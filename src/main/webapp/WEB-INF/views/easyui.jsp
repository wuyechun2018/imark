<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<LINK href="${ctx}/resources/images/favicon.ico" type="image/x-icon" rel="icon">                        
<LINK href="${ctx}/resources/images/favicon.ico" type="image/x-icon" rel="shortcut icon">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="${ctx}/resources/styles/base.css" rel="stylesheet" media="screen">
<%--
<link href="${ctx}/resources/jquery-easyui-1.4.3/themes/default/easyui.css" rel="stylesheet" media="screen">
 --%>
<link href="${ctx}/resources/jquery-easyui-1.4.3/themes/metro/easyui.css" rel="stylesheet" media="screen">
<link href="${ctx}/resources/jquery-easyui-1.4.3/themes/icon.css" rel="stylesheet" media="screen">
<link href="${ctx}/resources/icons/icon-all.css" rel="stylesheet" media="screen">
<link href="${ctx}/resources/aicons/css/aicons.css" rel="stylesheet" media="screen">
<link href="${ctx}/resources/styles/flat.css" rel="stylesheet" media="screen">

</head>
<body>

<script type="text/javascript">

var ctx = "${ctx}";

var docWidth=0;
var docHeight=0;

if(document.documentElement.clientWidth == 0){
	if(document.body){
		docWidth=document.body.clientWidth;
	}
}else{
	docWidth=document.documentElement.clientWidth;
}

if(document.documentElement.clientWidth == 0){
	if(document.body){
		docHeight=document.body.clientHeight;
	}
}else{
	docHeight= document.documentElement.clientHeight;
}

</script>

<script type="text/javascript" src="${ctx}/resources/jquery-easyui-1.4.3/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/resources/jquery-easyui-1.4.3/jquery.easyui.iplugin.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/dateformat.js"></script>
</body>
</html>