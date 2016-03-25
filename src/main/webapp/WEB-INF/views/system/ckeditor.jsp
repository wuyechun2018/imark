<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--放置的位置要特别注意,不能放在第三行,否则会有一些样式问题 --%>
<%@ include file="/WEB-INF/views/easyui.jsp" %>
<script type="text/javascript" src="${ctx}/resources/ckeditor-4.5.6/ckeditor.js"></script>

 <%
 	//接收传入该页面的参数
 	//文章Id
 	String articleId=request.getParameter("articleId");
 %>
 
 


<style type="text/css">
.itable label{
	font-size: 12px;
	font-family: 'Microsoft YaHei';
}

.l_td{
	width:8%;
}

.w_td{
width:40%;
}

.itable td input{
	width:89%;
}

.itable td label{
	float:right;
}

.itable td select{
	width:90%;
}

</style>

<script type="text/javascript">

$(function(){
	$('#articleTitle').focus();
	//根据字典类型,获取字典id
	$.ajax({
    type:"POST",
    url:"${ctx}/sysDic/getDicByCode?dicCode=ARTICLE_TYPE",
    beforeSend:function(XMLHttpRequest) {
    	
    },
    success:function(data, textStatus) {
    	$('#articleType').combotree({
    		url : '${ctx}/sysDic/getChildList?pid='+data.id,
    		onBeforeExpand : function(node, param) {
    			   //$('#articleType').combotree('options').url = ctx+ "/sysDic/getChildList?pid=" + node.id;
    			   $('#articleType').combotree("tree").tree("options").url =ctx+ "/sysDic/getChildList?pid=" + node.id;
    			},
    		width:docWidth*0.5-160,
    	    required: true,
    	    onLoadSuccess : function(node, data) {
    	    	$('#articleType').combotree("tree").tree('expandAll');
			}
    	});
    	
    	$('#articleType').combotree('setValue', '${article.articleType}');  
    	
    },
    complete:function(XMLHttpRequest, textStatus) {
    	
    },
    error:function() {
    	
    }
	});
})



function formSumbit(){
	if($("#ckForm").form('validate')){ 
		
		var data = CKEDITOR.instances.editor.getData();
		$('#ckForm').submit();
		
		//设置值
		//CKEDITOR.instances.editor.setData(data+"<h1>hello</h1>");
		
		//保存附件方法
		/*****/
		$('#attachForm').form('submit',{
			url:'${ctx}/editor/saveAttach',
	        onSubmit:function(op){
	        	//return $(this).form('validate');
	        	return true;
	        },
	        success:function(data){
	        	var obj=eval('('+ data+ ')');
	        	$.messager.alert('提示',obj.msg);
	        }
	      });
		}
	
}


</script>


<title>IMark</title>
<script type="text/javascript">
</script>
</head>
<body>
		<fieldset class="ifieldset">
			
			<br>
            <legend>文本编辑</legend>
		 		<form id="ckForm" action="${ctx}/editor/saveArticle" method="post">
					<table style="width: 100%" class="itable">
						
						<tr>
							<td class="l_td">
								<INPUT TYPE="hidden" NAME="articleId" VALUE="${article.articleId}">
								<label>文章标题：</label>
							</td>
							<td class="w_td"><input name="articleTitle" id="articleTitle" value="${article.articleTitle}"></td>
							<td class="l_td"><label>类别：</label></td>
							<td class="w_td">
								<input name="articleType" id="articleType">
								<%--
								<select name="articleType" id="articleType">
									  <option value="1" <c:if test="${article.articleType == '1'}">selected</c:if>>个人随想</option>  
									 <option value="2" <c:if test="${article.articleType == '2'}">selected</c:if>>网上摘录</option> 
									 <option value="3" <c:if test="${article.articleType == '3'}">selected</c:if>>我爱南陵</option> 
								</select>
								 --%>
							</td>
						</tr>
						
						<tr>
							<td class="l_td"><label>描述信息：</label></td>
							<td class="w_td"><input name="articleDesc" value="${article.articleDesc}" /></td>
							<td class="l_td"><label>关键字：</label></td>
							<td class="w_td"><input name="keyWord" value="${article.keyWord}"/></td>
						</tr>
						
						<tr>
							<td class="l_td"><label>文章排序：</label></td>
							<td class="w_td"><input name="dispOrder" value="${article.dispOrder}" class="easyui-validatebox" data-options="required:true,validType:'integer'" /></td>
							<td class="l_td">&nbsp;</td>
							<td class="w_td">&nbsp;</td>
						</tr>
						
						<tr>
							<td colspan="4"></td>
						</tr>
						
						<tr>
							<td colspan="4">	
									<textarea name="articleContent" id="editor" rows="8" cols="80">
				               			${article.articleContent}
				           			 </textarea>
				           	</td>
						</tr>
							<tr>
					</tr>
					</table>
		        </form>
		        
		        <form id="attachForm" method="post" enctype="multipart/form-data" method="post" action="">
		        	<table>
		        		<tr>
		        		<td>
		        		<INPUT TYPE="hidden" NAME="articleId" VALUE="${article.articleId}">
		        		<span style="font-family:宋体；">添加附件：</span>
		        		</td>
						<td><input class="easyui-filebox " name="file" id="filebox"
							data-options="buttonText:'选择文件'" style="width: 100%"></td>
		        		</tr>
		        		<tr>
							<td>
								<a style="float:right;margin-right:10px;" href="javascript:void(0)"  onclick="formSumbit()" class="btn_a_add">提交</a>
								
							</td>
							
							<td>
								<a style="font-size:14px;" href="${ctx}/views/system/article">返回</a>
							</td>
						</tr>
		        	</table>
		        
		        </form>
		        

	</fieldset>
		 <script>
				CKEDITOR
						.replace(
								'editor',
								{
									customConfig : '${ctx}/resources/ckeditor-4.5.6/config.js?v='
											+ Math.random()
								});
			</script>
</body>
</html>