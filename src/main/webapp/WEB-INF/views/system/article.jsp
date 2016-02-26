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

function doQuery(){
	var options = $("#grid").datagrid("options");
	//设置参数
	options.queryParams.articleType=$('#articleType').combobox('getValue');
    options.queryParams.keyWord =$('#keyword').val();
    options.queryParams.startDate =$('#updateDate_start').datebox("getValue");
    options.queryParams.endDate =$('#updateDate_end').datebox("getValue");
    $("#grid").datagrid(options);
}

$(function(){
	//加载文章类型
	$('#articleType').combobox({ 
		url : '${ctx}/resources/data/article-type.json',
		method : 'get',
		valueField : 'id',
		textField : 'text',
		filter : function(q, row) {
			var opts = $(this).combobox('options');
			return row[opts.textField].toLowerCase()
					.indexOf(q.toLowerCase()) > -1;
			}
		});
	
	//监听查询按钮点击事件
	$("#btnSearch").click(function(){
		doQuery();
	});
	
	
	$('#grid').datagrid({  
		url:ctx+'/editor/list',
		method:'post',
		title:"管理",
		//height: 380,
		height: $(window).height()-100,
		queryParams: {
				articleType:'',
				keyWord:'',
				startDate:'',
				endDate:''
			},
        //width: function () { return document.body.clientWidth * 0.8 -50},
		fit:false,
		fitColumns:true,
		striped: true,//奇偶行是否区分
		singleSelect:false,
		pageSize: 10,
        pageList: [10,20,30],
		pagination: true,  
		rownumbers: true,  
		columns:[[
				  { field: 'ck', checkbox: true, width: '30' },  //复选框
		          {field:'ARTICLE_ID',title: 'ARTICLE_ID',align: 'center',width: 100,hidden:true},
		          {field:'ARTICLE_TITLE',title: '文章标题',align: 'center',width: 100,formatter:function(value,row,index){
		          		 //return "<span ><a onclick=showArticle('"+row.ARTICLE_ID+"') href='javascript:void(0)'"+value+"</a></span>";
		          		 return "<a onclick=showArticle('"+row.ARTICLE_ID+"') href='javascript:void(0)'>"+value+"</a>";
		           }
		          }, 
		          {field:'ARTICLE_TYPE',title: '文章类型',align: 'center',width: 100,formatter:function(value,row,index){
		          		 if(value=="1"){
		          			 return "个人随想";
		          		 }else if(value=="2"){
		          			return "网上摘录";
		          		 } else{
		          			return "我爱南陵";
		          		 }
		           }}, 
		          {field:'ARTICLE_DESC',title: '简介',align: 'center',width: 100}, 
		          {field:'KEY_WORD',title: '关键字',align: 'center',width: 100}, 
		          {field:'UPDATE_USER_ID',title: '更新人',align: 'center',width: 100}, 
		          {field:'UPDATE_DATE',title: '更新时间',align: 'center',width: 100}
		]],
		toolbar:[{
						text : '增加',
						//iconCls : 'icon-add',
						iconCls : 'Applicationadd',
						handler : function() {
							//location.href=ctx+"/views/system/ckeditor";
							location.href=ctx+"/editor/addArticle";
						}
					}, '-',{
						text : '删除',
						//iconCls : 'icon-remove',
						iconCls : 'Applicationdelete',
						handler : function() {
							var rows = $("#grid").datagrid('getSelections');
							if (rows.length > 0) {
								 //提示是否删除
								 $.messager.confirm("删除确认", "您确认删除选定的记录吗？", function (action) {
							            if (action) {
							            	
							            	var codes=new Array();
			                                for (var i = 0; i < rows.length; i++) {
			                                    codes.push(rows[i].ARTICLE_ID);
			                                }
			                                //alert(codes.join(','));
			                                
			                                $.ajax({
			                        			cache: true,
			                        			type: "POST",
			                        			url:'${ctx}/editor/delete',
			                        			data:{
			                        				ids:codes.join(',')
			                        			},
			                        			async: false,
			                        		    error: function(request) {
			                        		        alert("Connection error");
			                        		    },
			                        		    success: function(data) {
			                        		    	$.messager.alert('提示信息',data.msg);
			                        		    	$("#grid").datagrid('reload');
			                        		    }
			                        		
			                        		})
			                                
							            }
							            })
								
							}else{
								 $.messager.alert("操作提示", "操作失败！","error");  
							}
							
						}
					},'-', {
						text : '修改',
						iconCls : 'icon-edit',
						//iconCls : 'Applicationedit',
						handler : function() {
							var rows = $("#grid").datagrid('getSelections');
							if (rows.length==1) {
								var articleId=rows[0].ARTICLE_ID
								//location.href=ctx+"/views/system/ckeditor?articleId="+articleId;
								location.href=ctx+"/editor/editArticle?articleId="+articleId;
							}else{
								 $.messager.alert("操作提示", "操作失败！","error");  
							}
							
							
							
							
						}
					} ]
			

		})

		

	})
	
	
	
	
	
</script>



</head>
<body>

 <div class="easyui-layout"  fit="false">
        <!-------------------------------搜索框----------------------------------->
        <fieldset style="margin: 0">
            <legend>信息查询</legend>
            <form id="ffSearch" method="post">
		        <div style="margin-bottom:5px">
                    <label for="txtSystemType_ID">文章类型：</label>
                    <%--
                    <input class="easyui-combobox" type="text" ID="articleType" name="articleType" style="width:150px"  />&nbsp;&nbsp;&nbsp;
					 --%>
					 
					<input id="articleType" name="articleType" data-options="editable:false,panelHeight:'auto'"  > 

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