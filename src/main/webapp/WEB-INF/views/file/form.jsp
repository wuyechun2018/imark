<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--放置的位置要特别注意,不能放在第三行,否则会有一些样式问题 --%>
<%@ include file="/WEB-INF/views/comm.jsp" %>
<title>IMark</title>

<script type="text/javascript">

function submitForm(){
	$.ajax({
		cache: true,
		type: "POST",
		url:ctx+"/file/indexSubmit",
		data:$("#imark_form").serializeArray(),	
		async: false,
	    error: function(request) {
	        alert("Connection error");
	    },
	    success: function(data) {
	    	alert(data);
	    }
	});
}

</script>

</head>
<body>

<h3>演示表单提交 ,多实体，List</h3>

<div style="margin-top:10px;margin-left:10px;">
<form id="imark_form" action="${ctx}/file/indexSubmit">
<table>
	<tr>
		<td>1用户名：</td>
		<td>
			<input name="formList[0].username" />
		</td>
	</tr>
	
	<tr>
		<td>1联系方式：</td>
		<td >
		
			<input name="formList[0].lixifangshi" />
		</td>
	</tr>
	
	<tr>
		<td >1备注：</td>
		<td>
			<input name="formList[0].beizhu" />
		</td>
	</tr>
	
	
	<tr>
		<td>2用户名：</td>
		<td>
			<input name="formList[1].username" />
		</td>
	</tr>
	
	<tr>
		<td>2联系方式：</td>
		<td >
		
			<input name="formList[1].lixifangshi" />
		</td>
	</tr>
	
	<tr>
		<td >2备注：</td>
		<td>
			<input name="formList[1].beizhu" />
		</td>
	</tr>
	
	
	
	
	<tr>
		<td ><button type="button" onclick="submitForm()">提交</button></td>
		<td>
			<input type="reset" value="取消"/>
		</td>
	</tr>

</table>


</form>
<div />


</body>
</html>