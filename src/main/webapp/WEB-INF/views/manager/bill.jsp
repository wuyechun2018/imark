<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--放置的位置要特别注意,不能放在第三行,否则会有一些样式问题 --%>
<%@ include file="/WEB-INF/views/easyui.jsp" %>
<link href="${ctx}/resources/styles/iflat.css" rel="stylesheet" media="screen">
<style type="text/css">
.itable{border:1px solid #A8CFEB;border-collapse: collapse;margin-bottom:5px;}
.itable th{ padding-left:10px;padding-right:5px;padding-top:5px;padding-bottom:5px;height:23px;width: 150px;border: 1px solid silver;background-color:#F1F6FF;}
.itable td{ padding-left:10px;padding-right:5px;padding-top:5px;padding-bottom:5px;height:23px;width: 150px;border: 1px solid silver;background-color:#FAFCFF;}
</style>

<title>IMark</title>

<script type="text/javascript">
var dgMenu;
$(function(){
	dgMenu=$('#dgMenu').datagrid({  
		url:ctx+'/bizBill/list',
		method:'post',
	    queryParams: {
	    	loginAccount:'',
	    	sex:''
		},
		//title:"用户管理",
		fit:false,
		height: $(window).height()-85,
		fitColumns:true,
		striped: true,//奇偶行是否区分
		singleSelect:true,
		pagination: true,  
		rownumbers: true,  
		columns:[[
		          {field:'BILL_DATE',title: '入账时间',align: 'center',width: 100},
		          {field:'BILL_TYPE',title: '账单类型',align: 'center',width: 100, formatter:function(val,rec){
		        	  if(val=='1'){
		        		  return "入账";
		        	  }else{
		        		  return "出账";
		        	  }
		          }}, 
		          {field:'BILL_NAME',title: '账单名称',align: 'center',width: 100}, 
		          {field:'AMOUNT',title: '金额',align: 'center',width: 100}, 
		          {field:'EARNINGS',title: '收益',align: 'center',width: 50},
		          {field:'EARNINGS_RATIO',title: '收益比例',align: 'center',width: 50},
		          {field:'UPDATE_USER',title: '更新人',align: 'center',width: 50},
		          {field:'UPDATE_DATE',title: '更新时间',align: 'center',width: 50},
		          {field:'DIS_ORDER',title: '排序',align: 'center',width: 50},
		          {field:'ID',title: '操作',align: 'center',width: 100, formatter:function(val,rec){
		        	  return "<span ><a href='javascript:void(0)' onclick=editFun('"+val+"') class='btn_a_edit'>编辑</a></span><span>&nbsp;&nbsp;<a href='javascript:void(0)' onclick=deleteFun('"+val+"') class='btn_a_delete'>删除</a></span>";
		          }}
		]]
		,toolbar:$('#tb')
		//,footer:$('#ft')

		})
		
		//监听查询按钮点击事件
		$("#search").click(function(){
			doQuery();
		});
			
		$("#add").click(function(){
			add();
		});
	})
	
	
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
		//Radio默认选中
		$('#radio_bill_type_r').prop('checked', 'checked');
		//默认时间
		var nowTime=new Date().format("yyyy-MM-dd hh:mm:ss");
		$('#billDate').val(nowTime);
	}
	
	//清理表单
	function clearForm(){
		$('#addForm').form('clear');
		$('#addWin').window('close');
	}
	
	//提交表单
	function submitForm(){
		if($("#addForm").form('validate')){
			$.ajax({
				cache: true,
				type: "POST",
				url:'${ctx}/sysLoginUser/save',
				data:{
					id:$('#id').val(),
					billName:$('#billName').val(),
					userAlias:$('#userAlias').val(),
					//单选框
					billType:$('input[name="billType"]:checked').val(),
					billDate:$('#billDate').val(),
					amount:$('#amount').val()
					
					//下拉框
					//userState:$('#userState').combobox('getValue')
				},
				async: false,
			    error: function(request) {
			        alert("Connection error");
			    },
			    success: function(data) {
			    	$('#addWin').window('close');
			    	//刷新列表
			    	$("#dgMenu").datagrid('reload');
			    }
			})
		}
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
		$.messager.confirm("删除确认", "您确认删除选定的记录吗？", function (action) {
            if (action) {
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
            })
     	}		
	
</script>
</head>
<body>

<div class="easyui-layout" fit="false">
		<fieldset>
            <legend>信息查询</legend>
            <table>
				<tr>
					<td>账单名称:</td>
					<td><input  id="billName" name="billName" style="width:150px"></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>账单类型:</td>
					<td>
						<select data-options="panelHeight:'auto'" class="easyui-combobox" id="billType" name="billType"  style="width:110px">
							<option value="1">入账</option>
							<option value="2">出账</option>
							<option value="3" selected = "selected">全部</option>
						</select>
					</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td></td>
					<td><a href="#" id="search" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
					<%-- 
					<td>&nbsp;&nbsp;</td>
					<td><a href="#" id="add" class="easyui-linkbutton" iconCls="icon-add">添加</a></td>--%>
				</tr>
			</table>
        </fieldset>

		<table id="dgMenu" >
		</table>
</div>
	
	<div id="tb">
	    <a href="#" id="add" class="easyui-linkbutton" plain="true"  iconCls="icon-add">添加</a>
	    <%-- 
	    <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="javascript:alert('Cut')">Cut</a>
	    <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:alert('Save')">Save</a>
	    --%>
	</div>
	
	<%--新增窗口以及表单 --%>
	<div id="addWin" class="easyui-window" title="&nbsp;添加" data-options="collapsible:false,maximizable:false,minimizable:false,iconCls:'icon-add',resizable:true,closed:true" style="width:588px;height:320px;padding:10px;">
	    <form id="addForm" method="post">
	    	<table  class="itable">
	    		<tr>
	    			<td>账单名称：</td>
	    			<td>
	    				<%-- 隐藏字段，主键 --%>
	    				<input type="hidden" id="id" name="id" ></input>
	    				<input style="width:180px;"  class="easyui-textbox" type="text" id="billName" name="billName" data-options="required:true"></input>
	    			</td>
	    			<td>账单类型：</td>
	    			<td>
	 					<input  type="radio" id="radio_bill_type_c" name="billType" value="1" checked="checked" />
						<label for="radio_bill_type_c" >入账</label>
						<input  type="radio" id="radio_bill_type_r" name="billType" value="2" />
						<label for="radio_bill_type_r">出账</label>
 					</td>
	    		</tr>
	    		
	    		
	    		<tr>
	    			<td>入账时间：</td>
 					<td>
	 					<input style="width:180px;"  type="text" id="billDate" name="billDate" data-options="required:true" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
 					</td>
	    			<td>总额：</td>
	    			<td><input style="width:180px;" class="easyui-textbox" type="text" id="amount" name="amount" data-options="required:true"></input></td>
	    			
	    		</tr>
	    		
	    		
	    		
	    		<tr>
	    			<td>收益：</td>
	    			<td><input style="width:180px;" class="easyui-textbox" type="text" id="earnings" name="earnings" data-options="required:true"></input></td>
	    			<td>收益比例：</td>
 					<td>
	 					<input style="width:180px;" class="easyui-textbox" type="text" id="earningsRatio" name="earningsRatio" data-options="required:true">
 					</td>
	    		</tr>
	    		
	    	
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" iconCls="icon-save" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    	<a href="javascript:void(0)" iconCls="icon-cancel"  class="easyui-linkbutton" onclick="clearForm()">取消</a>
	    </div>
	</div>
	
<script type="text/javascript" src="${ctx}/resources/My97DatePicker/WdatePicker.js" defer="defer"></script>
<script type="text/javascript" src="${ctx}/resources/js/dateformat.js"></script>
</body>
</html>