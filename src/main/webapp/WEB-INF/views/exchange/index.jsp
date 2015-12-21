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
<title>安全审计日志列表</title>

<script type="text/javascript">
	var dgXzxk;
	$(function(){
		//行政许可
		dgSafeAudit=$('#list_tb').datagrid({    
			method: "post",
		    url:'${ctx}/log/getSafeLogs',
		    queryParams: {
		    	userName:'',
		    	startDate:'',
		    	endDate:''
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
				{field:'ORGANIZATION_NAME',title:'所属单位名称'},  
				{field:'USER_NAME',title:'用户名'},
				{field:'TERMINAL_ID',title: '登录IP' },
				{field:'SESSIONID',title: '会话ID' },
				{field:'OPERATE_TIME',title:'时间'},
				{field:'OPERATE_TYPE',title:'操作类型',
                    formatter:function(val,rec){
                    	var type = "";
                    	if(val=='0') {
                    		type="登录日志"
                    	}
						if(val=='1') {
                    		type="查询日志";
                    	}
						if(val=='2') {
							type="新增日志";
						}
						if(val=='3') {
							type="修改日志";
						}
						if(val=='4') {
							type="删除日志";
						}
                        return type;
                  }  
                },
				{field:'OPERATE_CONDITION',title:'操作内容',sortable:true,
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
		
		//查询
		$("#search").click(function(){
			var options = $("#list_tb").datagrid("options");
			options.queryParams.startDate= $("#startDate").val();
	        options.queryParams.endDate = $("#endDate").val();
	        options.queryParams.userName = $("#userName").val();
	        $("#list_tb").datagrid(options);
		});
	});
	
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
	<div class="easyui-layout" fit="false">
				<div class="container">
						<div class="block">
							<div class="head">
								<div class="toggle" title="收起"></div>
								<h2>
									<i class="head-icon icon-query"></i>安全审计日志查询
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
																<input id="startDate" style="width:40%" class="text" type="text" onFocus="var endDate=$dp.$('endDate');WdatePicker({onpicked:function(){endDate.focus();},maxDate:'#F{$dp.$D(\'endDate\')}', readOnly:true})"/>
																<span style="padding-left:5px; padding-right:10px;">~</span>
																<input id="endDate" style="width:40%" class="text" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}', readOnly:true})"/>
															</span>
														</div>
													</td>
													<th>用户名：</th>
													<td>
														<div class="form-control">
															<span class="r"></span> <span class="l"></span> <span
																class="c"><input type="text" id="userName" name="userName" class="text" maxlength="50" /></span>
														</div>
													</td>
												</tr>
												<tr>
													<td colspan="4" class="text-right">
														<a class="btn btn-primary" id="queryBtn" href="javascript:;"> 
															<span class="l"> </span><span id="search" class="c"><i class="icon icon-query"></i>查询</span><span class="r"></span>
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
								<i class="head-icon icon-list"></i>安全审计日志列表
							</h2>
							<div class="btns">
								
							</div>
							
							<div class="arc arc-tl"></div>
							<div class="arc arc-tr"></div>
						</div>
				       <table id="list_tb" data-options="toolbar:'#toolBar'"></table>
				  </div>
			</div>
		</div>
	</div>



<script type="text/javascript" src="${ctx}/resources/My97DatePicker/WdatePicker.js" defer="defer"></script> 

</body>
</html>