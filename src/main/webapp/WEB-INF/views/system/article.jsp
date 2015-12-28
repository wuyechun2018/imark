<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--放置的位置要特别注意,不能放在第三行,否则会有一些样式问题 --%>
<%@ include file="/WEB-INF/views/easyui.jsp" %>
<%-- 
<link href="${ctx}/resources/styles/easyui-flat.css" rel="stylesheet" media="screen">--%>
<title>IMark</title>

<script type="text/javascript">

function showArticle(id){
	location.href=ctx+"/editor/showArticle?articleId="+id;
}



$(function(){
	$('#grid').datagrid({  
		url:ctx+'/editor/list',
		method:'post',
		title:"管理",
		height: 380,
        //width: function () { return document.body.clientWidth * 0.8 -50},
		fit:false,
		fitColumns:true,
		striped: true,//奇偶行是否区分
		singleSelect:true,
		pageSize: 10,
        pageList: [10,20,30],
		pagination: true,  
		rownumbers: true,  
		columns:[[
		          {field:'ARTICLE_ID',title: 'ARTICLE_ID',align: 'center',width: 100,hidden:true},
		          {field:'ARTICLE_TITLE',title: '文章标题',align: 'center',width: 100,formatter:function(value,row,index){
		          		 //return "<span ><a onclick=showArticle('"+row.ARTICLE_ID+"') href='javascript:void(0)'"+value+"</a></span>";
		          		 return "<a onclick=showArticle('"+row.ARTICLE_ID+"') href='javascript:void(0)'>"+value+"</a>";
		           }
		          }, 
		          {field:'ARTICLE_TYPE',title: '文章类型',align: 'center',width: 100}, 
		          {field:'ARTICLE_DESC',title: '简介',align: 'center',width: 100}, 
		          {field:'KEY_WORD',title: '关键字',align: 'center',width: 100}, 
		          {field:'UPDATE_USER_ID',title: '更新人',align: 'center',width: 100}, 
		          {field:'UPDATE_DATE',title: '更新时间',align: 'center',width: 100}
		]],
		toolbar:[{
						text : '增加',
						iconCls : 'icon-add',
						handler : function() {
							location.href=ctx+"/views/system/ckeditor";
						}
					}, '-',{
						text : '删除',
						iconCls : 'icon-remove',
						handler : function() {

						}
					},'-', {
						text : '修改',
						iconCls : 'icon-edit',
						handler : function() {

						}
					}, '-',{
						text : '查询',
						iconCls : 'icon-search',
						handler : function() {

						}
					} ]
			

		})

		

	})
	
	
	
	
	
</script>



</head>
<body>

 <div class="easyui-layout"  fit="false">
        <!-------------------------------搜索框----------------------------------->
        <fieldset>
            <legend>信息查询</legend>
            <form id="ffSearch" method="post">
		        <div style="margin-bottom:5px">
                    <label for="txtSystemType_ID">文章类型：</label>
                    <input class="easyui-combobox" type="text" ID="articleType" name="articleType" style="width:150px"  />&nbsp;&nbsp;&nbsp;

                    <label for="txtLoginName">关键字：</label>
                    <input type="text" ID="keyword" name="keyword" style="width:150px"  />&nbsp;&nbsp;&nbsp;

                   
                </div>
		        <div>
                    <label for="txtLastUpdated">开始时间：</label>
                    <input class="easyui-datebox" type="text" ID="updateDate_start" name="updateDate_start" style="width:150px"  />&nbsp;&nbsp;&nbsp;

                    <label for="txtLastUpdated2">结束时间：</label>
                    <input class="easyui-datebox" type="text" ID="updateDate_end" name="updateDate_end" style="width:150px"  />&nbsp;&nbsp;&nbsp;

                    <a href="#" class="easyui-linkbutton" iconcls="icon-search" id="btnSearch">查询</a>
                </div>
            </form>
        </fieldset>
                
        <!-------------------------------详细信息展示表格----------------------------------->
        <table id="grid"   >
            
        </table>
    </div>

</body>
</html>