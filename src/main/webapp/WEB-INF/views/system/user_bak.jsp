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

var dgMenu;

$(function(){
	dgMenu=$('#dgMenu').datagrid({  
		//url:ctx+'/resources/data/datagrid_data.json',
		url:ctx+'/sysLoginUser/list',
		method:'post',
	    queryParams: {
	    	loginAccount:'',
	    	sex:''
		},
		//title:"用户管理",
		fit:true,
		fitColumns:true,
		striped: true,//奇偶行是否区分
		singleSelect:true,
		pagination: true,  
		rownumbers: true,  
		columns:[[
		          {field:'loginAccount',title: '登录名',align: 'center',width: 100},
		          {field:'sex',title: '性别',align: 'center',width: 100, formatter:function(val,rec){
		        	  if(val=='0'){
		        		  return "女";
		        	  }else{
		        		  return "男";
		        	  }
		          }}, 
		          {field:'userAlias',title: '昵称',align: 'center',width: 100}, 
		          {field:'userEmail',title: '邮箱地址',align: 'center',width: 100}, 
		          {field:'userState',title: '用户状态',align: 'center',width: 50, formatter:function(val,rec){
		        	  if(val=='U'){
		        		  return "在用";
		        	  }else if(val=='R'){
		        		  return "已注册";
		        	  }else if(val=='L'){
		        		  return "锁定";
		        	  }
		          }},
		          {field:'userId',title: '操作',align: 'center',width: 100, formatter:function(val,rec){
		        	  return "<span ><a href='javascript:void(0)' onclick=editFun('"+val+"') class='btn_a_edit'>编辑</a></span><span>&nbsp;&nbsp;<a href='javascript:void(0)' onclick=deleteFun('"+val+"') class='btn_a_delete'>删除</a></span>";
		          }}
		]],
		toolbar:$('#c_tb')
		//,footer:$('#ft')

		})

		//$('#menu_tb').datagrid('getPanel').removeClass('lines-both lines-no lines-right lines-bottom').addClass('lines-both');

	
		//监听查询按钮点击事件
		$("#search").click(function(){
			doQuery();
		});
		
			
		$("#add").click(function(){
			add();
		});
	
	
	})
	
	/**
	[
		     {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {

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
	
	**/
	
	function doQuery(){
		var options = $("#dgMenu").datagrid("options");
		//设置参数
		options.queryParams.loginAccount= $("#account").val();
	    options.queryParams.sex =$('#sex').combobox('getValue');;
	    $("#dgMenu").datagrid(options);
	}
	
	
	
	//新增
	function add(){
		$('#addWin').window('open');
		$('#addForm').form('clear');
		$('#radio_sex_m').prop('checked', 'checked');
	}
	
	//清理表单
	function clearForm(){
		$('#addForm').form('clear');
		$('#addWin').window('close');
	}
	
	//提交表单
	function submitForm(){
		/**$('#addForm').form('submit',{
			url:'${ctx}/sysLoginUser/save',
			method:'post',
            onSubmit:function(op){
            	return $(this).form('validate');
            },
            success:function(data){
            	var obj=eval('('+ data+ ')');
            	$.messager.alert('提示',obj.msg);
            }
          });**/
		$.ajax({
			cache: true,
			type: "POST",
			url:'${ctx}/sysLoginUser/save',
			data:{
				userId:$('#userId').val(),
				loginAccount:$('#loginAccount').val(),
				userAlias:$('#userAlias').val(),
				sex:$('input[name="sex"]:checked').val(),
				userEmail:$('#userEmail').val(),
				userState:$('#userState').combobox('getValue')
			},
			async: false,
		    error: function(request) {
		        alert("Connection error");
		    },
		    success: function(data) {
		    	//$.messager.alert('提示信息',data.msg);
		    	$('#addWin').window('close');
		    	//刷新列表
		    	//doQuery();
		    	$("#dgMenu").datagrid('reload');
		    }
		
		})
	}
	
	//编辑
	function editFun(id) {
		 var rows = $("#dgMenu").datagrid('getData').rows;
         var length = rows.length;
         var rowindex;
         for (var i = 0; i < length; i++) {
             if (rows[i]['userId'] == id) {
                 rowindex = i;
                 break;
             }
         }
         var row=$('#dgMenu').datagrid('getData').rows[rowindex];
		
         $('#addWin').window('open');
         
         $('#addForm').form('load',{
        	 	userId:row.userId,
        	 	loginAccount:row.loginAccount,
        	 	userAlias:row.userAlias,
        	 	userEmail:row.userEmail,
        	 	sex:row.sex,
        	 	userState:row.userState
			});
         
		
	}
	
	//删除
	function deleteFun(id){
		$.ajax({
			cache: true,
			type: "POST",
			url:'${ctx}/sysLoginUser/delete',
			data:{
				userId:id
			},
			async: false,
		    error: function(request) {
		        alert("Connection error");
		    },
		    success: function(data) {
		    	$.messager.alert('提示信息',data.msg);
		    	$("#dgMenu").datagrid('reload');
		    }
		
		})
	}
	
	
	
	
</script>



</head>
<body>

<div class="easyui-layout" fit="true">
		<table id="dgMenu" >
		</table>
</div>
	
	<div id="tb">
	    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:alert('Add')">Add</a>
	    <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="javascript:alert('Cut')">Cut</a>
	    <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:alert('Save')">Save</a>
	</div>

	<div id="c_tb" style="padding:10px; height: auto">
		<div>
			<%--
				Date From: <input class="easyui-datebox" style="width:110px">
			To: <input class="easyui-datebox" style="width:110px">
			Language: 
			<select class="easyui-combobox" panelHeight="auto" style="width:100px">
				<option value="java">Java</option>
				<option value="c">C</option>
				<option value="basic">Basic</option>
				<option value="perl">Perl</option>
				<option value="python">Python</option>
			</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a> --%>
		
		
			<table>
				<tr>
					<%-- 
					<td>Date From:</td>
					<td><input class="easyui-datebox" style="width:210px"></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>To:</td>
					<td><input class="easyui-datebox" style="width:210px"></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					--%>
					<td>登录名:</td>
					<td><input  id="account" name="loginAccount" style="width:150px"></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>性别:</td>
					<td>
						<select data-options="panelHeight:'auto'" class="easyui-combobox" id="sex" name="sex"  style="width:110px">
							<option value="1">男</option>
							<option value="0">女</option>
							<option value="3" selected = "selected">全部</option>
						</select>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td></td>
					<td><a href="#" id="search" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
					<td>&nbsp;&nbsp;</td>
					<td><a href="#" id="add" class="easyui-linkbutton" iconCls="icon-add">添加</a></td>
				</tr>
				
				
			</table>
		</div>
		
		<%-- 
		<div style="margin-bottom: 5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add"
				plain="true"></a> <a href="#" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true"></a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-save" plain="true"></a> <a
				href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove"
				plain="true"></a>
		</div>
		--%>
		
	</div>
	
	
	<div id="ft" style="padding:2px 5px;">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
	</div>
	
	<div id="addWin" class="easyui-window" title="&nbsp;添加用户" data-options="collapsible:false,maximizable:false,minimizable:false,iconCls:'icon-add',resizable:false,closed:true" style="width:450px;height:340px;padding:10px;">
	<div style="padding:1px 60px 5px 60px">
	    <form id="addForm" method="post">
	    	<table cellpadding="5">
	    	
	    		<tr>
	    			<td>登录名:</td>
	    			<td>
	    				<input type="hidden" id="userId" name="userId" ></input>
	    				<input style="width:180px;"  class="easyui-textbox" type="text" id="loginAccount" name="loginAccount" data-options="required:true"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>昵称:</td>
	    			<td><input style="width:180px;" class="easyui-textbox" type="text" id="userAlias" name="userAlias" data-options="required:false"></input></td>
	    		</tr>
	    		
	    		<tr>
	    			<td>邮箱:</td>
	    			<td><input style="width:180px;" class="easyui-textbox" type="text" id="userEmail" name="userEmail" data-options="required:true,validType:'email'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>性别：</td>
 					<td>
	 					<input  type="radio" id="radio_sex_m" name="sex" value="1" checked="checked" />
						<label for="radio_sex_m" >男</label>
						<input  type="radio" id="radio_sex_f" name="sex" value="0" />
						<label for="radio_sex_f">女</label>
 					</td>
	    		</tr>
	    		<tr>
	    			<td>当前状态:</td>
	    			<td>
	    				<select class="easyui-combobox" id="userState" name="userState" style="width:180px;">
		    				<option value="R">注册</option>
		    				<option value="U">在用</option>
		    				<option value="L">锁定</option>
		    				<option value="D">删除</option>
	    				</select>
	    			</td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" iconCls="icon-save" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    	<a href="javascript:void(0)" iconCls="icon-cancel"  class="easyui-linkbutton" onclick="clearForm()">取消</a>
	    </div>
	    </div>
		
	</div>
	


</body>
</html>