<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>系统信息</title>
	
	<style type="text/css">
	body, div, p, td, th {
	font-family:arial,helvetica,sans-serif;
	font-size:9pt;
}
	
		.jive-table {
    border-color:#CCCCCC;
    border-style:solid;
    border-width:1px 1px 0;
}
.jive-table .c1, fieldset .c1 {
    width:30%;
}
.jive-table th, .jive-table td, .jive-option-table th, .jive-option-table td {
    padding:6px;
}
.jive-table th th, .jive-table td td {
    padding:0;
}
.jive-table td.icon {
    padding:0 5px 0 3px;
}
.jive-table th {
    background-color:#EEEEEE;
    border-bottom:1px solid #CCCCCC;
    font-family:verdana,arial,helvetica,sans-serif;
    font-size:8pt;
    font-weight:bold;
    text-align:left;
}
.jive-table th table th {
    border-bottom:medium none;
    border-right:medium none;
}
.jive-table th table th a {
    color:#000000;
    text-decoration:none;
}
.jive-table tr td {
    border-bottom:1px solid #E3E3E3;
}
.jive-table td {
    font-family:arial,helvetica,sans-serif;
    font-size:10pt;
}
.jive-table .jive-odd td {
    background-color:#FFFFFF;
}
.jive-table .jive-even td {
    background-color:#FBFBFB;
}
.jive-table tfoot td {
    background-color:#EEEEEE;
    border-bottom:1px solid #CCCCCC;
    font-family:verdana,arial,helvetica,sans-serif;
    font-size:8pt;
}
.jive-table td td {
    border-width:0;
}

#jive-main-content {
	-moz-border-radius-bottomleft:4px;
	-moz-border-radius-bottomright:4px;
	-moz-border-radius-topleft:4px;
	-moz-border-radius-topright:4px;
	background:#F5F5F5;
	border:1px solid #DCDCDC;
	margin:15px 0 20px 0;
	padding:18px 20px;
    width: 95%;
}
	
	
	</style>
	
</head>
<body id="jive-body">
<div id="main">
	<table cellpadding="0" cellspacing="0" border="0" width="100%">
	<tbody>
		<tr valign="top">
			<td width="99%" id="jive-content">
				<div id="jive-main-content">
					<p>下面是系统信息列表：</p>

<div class="jive-table">
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<thead>
    <tr>
        <th colspan="2">运行信息</th>
    </tr>
</thead>
<tbody>
    <tr><td class="c1">主机</td><td class="c2">${host}</td></tr>
    <tr><td class="c1">Server URL</td><td class="c2">${serverUrl}</td></tr>
    <tr><td class="c1">服务启动时间</td><td class="c2"><c:out value="${serverStartTime}"/></td></tr>
    <tr><td class="c1">OS Name</td><td class="c2"><c:out value="${osName}"/></td></tr>
    <tr><td class="c1">OS Version</td><td class="c2"><c:out value="${osVersion}"/></td></tr>
    <tr><td class="c1">Java Home</td><td class="c2"><c:out value="${javaHome}"/></td></tr>
    <tr><td class="c1">Java Runtime Name</td><td class="c2"><c:out value="${javaRuntimeName}"/></td></tr>
    <tr><td class="c1">Java Version</td><td class="c2"><c:out value="${javaVersion}"/></td></tr>
    <tr><td class="c1">Java Vendor</td><td class="c2"><c:out value="${javaVendor}"/></td></tr>
    <tr><td class="c1">Java VM Version</td><td class="c2"><c:out value="${javaVmVersion}"/></td></tr>
    <tr><td class="c1">最大内存</td><td class="c2"><c:out value="${maxMemory}"/> MB</td></tr>
    <tr><td class="c1">已用内存</td><td class="c2"><c:out value="${totalMemory}"/> MB</td></tr>
</tbody>
</table>
</div>
<br/><br/>

				</div>
			</td>
		</tr>
	</tbody>
	</table>
</div>
</body>
</html>