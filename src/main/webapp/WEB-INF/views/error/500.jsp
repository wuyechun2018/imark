<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<%response.setStatus(200);%>

<!DOCTYPE html>
<html>
<head>
	<title>404 - 页面不存在</title>
	<style type="text/css">
	body{
		background-color: #D4E0F2;	
	
	}
	
	</style>
	
</head>

<body>
	<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="660" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="bottom"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
      	<%--
        <td height="40"><img src="${ctx}/static/images/logo404.png" width="288" height="44" /></td>
         --%>
      </tr>
      <tr>
        <td><h2>很抱歉，服务器出现错误了。</h2></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
      <%--
    <td><img src="${ctx}/static/images/robot.png" width="171" height="213" /></td> --%>
  </tr>
  <tr>
    <td colspan="2" valign="middle" style=" font-size:14px; line-height:22px; padding-left:25px; "><p><strong>可能因为以下原因</strong>：<br />
	  1.系统过于繁忙，请点击浏览器的&quot;刷新&quot;按钮，或稍后再试<br />
      2.请检查您输入的网址是否正确。<br />
      3.此页面已经删除，请访问其他页面。 <br />
      <br />
    </p></td>
  </tr>
</table>
</body>
</html>