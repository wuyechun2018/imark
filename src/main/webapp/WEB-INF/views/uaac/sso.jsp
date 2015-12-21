<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--
<LINK href="${ctx}/resources/images/favicon.ico" type="image/x-icon" rel="icon">                        
<LINK href="${ctx}/resources/images/favicon.ico" type="image/x-icon" rel="shortcut icon">
 --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--放置的位置要特别注意,不能放在第三行,否则会有一些样式问题 --%>
<%@ include file="/WEB-INF/views/easyui.jsp" %>
<link href="${ctx}/resources/styles/easyui-flat.css" rel="stylesheet" media="screen">
<link href="${ctx}/resources/styles/uaac.css" rel="stylesheet" media="screen">
<title>单点登录日志列表</title>

<script type="text/javascript">
	var dgSso;
	$(function(){
		
		//单点登录日志
		dgSso=$('#list_tb').datagrid({    
			method: "post",
		    url:'${ctx}/log/getSsoLogs',
		    queryParams: {
		    	startDate:'',  //开始时间
		    	endDate:'',	//结束时间
		    	userName:'', //用户名
		    	organizationName:'', //单位名称
		    	operateUrl:''//平台地址
			},
		    fit : false,
		    height:480,
		    fitColumns : true,
			border : true,
			striped:false,
			//idField : 'id',
			rownumbers:true,
			pagination:true,
			pageNumber:1,
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			pagePosition:'bottom',
			singleSelect:true,
		    columns:[[    
				{field:'ORGANIZATION_NAME',title:'所属单位名称',width:120,align:'left'},  
				{field:'USER_NAME',title:'用户名',width:120,align:'left'},
				{field:'OPERATE_URL',title:'应用平台地址',width:160,align:'left'},
				{field:'TERMINAL_ID',title: '登录IP',width:100,align:'left' },
				{field:'SESSIONID',title: '会话ID',width:260,align:'left' },
				{field:'OPERATE_TIME',title:'时间',width:120,align:'left'},
				{field:'OPERATE_TYPE',title:'标志',width:100,align:'center',
                    formatter:function(val,rec){
                    	var type = "";
                    	if(val=='0') {
                    		type="登录"
                    	}
						if(val=='1') {
                    		type="查询";
                    	}
						if(val=='2') {
							type="新增";
						}
						if(val=='3') {
							type="修改";
						}
						if(val=='4') {
							type="删除";
						}
						if(val=='10') {
							type="退出";
						}
                        return type;
                  }  
                },
				{field:'OPERATE_CONDITION',title:'操作内容',sortable:true,hidden:true,
                    formatter:function(val,rec){  
                        return val + "(" + rec.OPERATE_NAME + ")";
                  }  
                }
		    ]],
		    //toolbar:'#tb',
		    enableHeaderClickMenu: false,
		    enableHeaderContextMenu: false,
		    enableRowContextMenu: false
		});
		
		//监听查询按钮点击事件
		$("#search").click(function(){
			var options = $("#list_tb").datagrid("options");
			//设置参数
			options.queryParams.startDate= $("#startDate").val();
	        options.queryParams.endDate = $("#endDate").val();
	        options.queryParams.userName = $("#userName").val();
	        options.queryParams.organizationName = $("#organizationName").val();
	        options.queryParams.operateUrl=$("#operateUrl").val();
	        
	        $("#list_tb").datagrid(options);
		});
		
		
	})
	
	
	/***
	var p = $('#list_tb').datagrid('getPager');  
    p.pagination({  
        pageSize : 10,// 每页显示的记录条数，默认为20  
       pageList : [ 10, 20, 30 ],// 可以设置每页记录条数的列表  
        beforePageText : '第',// 页数文本框前显示的汉字  
        afterPageText : '页    共 {pages} 页',  
        displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'   
    });  ***/

	

</script>

</head>
<body >
	<%-- --%>
	<div class="easyui-layout" fit="false">
				<div class="container">
						<div class="block">
							<div class="head">
								<div class="toggle" title="收起"></div>
								<h2>
									<i class="head-icon icon-query"></i>单点登录日志查询
								</h2>
								<div class="arc arc-tl"></div>
								<div class="arc arc-tr"></div>
							</div>
	
							<div class="body">
								<div class="body-form">
									<form id="queryForm" action="" method="post">
									
										<table class="table-form">
											<thead>
												<tr class="col-width">
													<th class="td-tit"></th>
													<td></td>
													<th class="td-tit"></th>
													<td></td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<th>查询日期：</th>
													<td>
														<div class="form-control">
															<span class="r"></span> <span class="l"></span>
															 <span class="c">
																<input id="startDate" style="width:40%" class="text" type="text" onFocus="var d5222=$dp.$('endDate');WdatePicker({onpicked:function(){},maxDate:'#F{$dp.$D(\'endDate\')}', readOnly:true})"/>
																<span style="padding-left:5px; padding-right:10px;">~</span>
																<input id="endDate" style="width:40%" class="text" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}', readOnly:true})"/>
															</span>
														</div>
													</td>
													<th>用户名：</th>
													<td>
														<div class="form-control">
															<span class="r"></span> <span class="l"></span> <span
																class="c"><input type="text" name="userName" id="userName" class="text" maxlength="50" /></span>
														</div>
													</td>
												</tr>
												<tr>
													<th>单位名称：</th>
													<td>
														<div class="form-control">
															<span class="r"></span> <span class="l"></span> <span
																class="c"><input type="text" name="organizationName" id="organizationName" class="text" maxlength="50" /></span>
														</div>
													</td>
													<th>平台地址：</th>
													<td>
														<div class="form-control">
															<span class="r"></span> <span class="l"></span> <span
																class="c"><input type="text" name="operateUrl"  id="operateUrl" class="text" maxlength="50" /></span>
														</div>
													</td>
												</tr>
												
												<tr>
													<td colspan="4" class="text-right">
														<a class="btn btn-primary"
															id="queryBtn" href="javascript:;"> <span class="l"></span>
															<span class="c" id="search" style="color:#333"><i class="icon icon-query"></i>查询</span><span
																class="r"></span>
														</a>
													</td>
												</tr>
											</tbody>
										</table>
										
									</form>
								</div>
							</div>
		</div>
						
						
						<div class="block">
			<div class="head">
				<h2>
					<i class="head-icon icon-list"></i>单点登录日志列表
				</h2>
				<div class="btns">
					
				</div>
				
				<div class="arc arc-tl"></div>
				<div class="arc arc-tr"></div>
			</div>
				<%--
				<div class="body">
					<table id="list_tb"></table>
				</div>
				
				 --%>
				<table id="list_tb"></table>
			</div>
		</div>
		</div>



	<script type="text/javascript" src="${ctx}/resources/My97DatePicker/WdatePicker.js" defer="defer"></script>

</body>
</html>