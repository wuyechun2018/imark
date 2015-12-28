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
<%@ include file="/WEB-INF/views/easyui.jsp"%>
<title>信用芜湖-7天双公示</title>

<script type="text/javascript">
	var dgXzxk;
	var dgXzcf;
	var statistics;//statistics  统计
	var statement;//statement	报表
	$(function() {
		//部门数据加载
		$('#dept')
				.combobox(
						{
							url : '${ctx}/resources/data/combobox.json',
							method : 'get',
							valueField : 'id',
							textField : 'text',
							//panelHeight:'auto',
							filter : function(q, row) {
								var opts = $(this).combobox('options');
								return row[opts.textField].toLowerCase()
										.indexOf(q.toLowerCase()) > -1;
							},
							onSelect : function(rec) {
								//alert(rec.id);

								//行政许可
								var queryParams = $('#xzxk_tb').datagrid(
										'options').queryParams;
								;
								queryParams.bizId = rec.id;
								queryParams.type = 'xzxk';
								dgXzxk.datagrid('reload');

								//行政处罚
								var queryXzcf = $('#xzcf_tb').datagrid(
										'options').queryParams;
								;
								queryXzcf.bizId = rec.id;
								queryXzcf.type = 'xzcf';
								dgXzcf.datagrid('reload');
							}
						});

		//文件类型 单选框绑定事件
		$("input[name='bizType']").click(function() {
			var id = $(this).attr("id");
			//行政许可
			if (id == 'xzxk') {
				$('#tips').tabs('select', 0);
				$('#dg_list').tabs('select', 0);

			} else {
				$('#tips').tabs('select', 1);
				$('#dg_list').tabs('select', 1);
			}

		});

		//行政许可
		dgXzxk = $('#xzxk_tb')
				.datagrid(
						{
							method : "post",
							url : '${ctx}/markLog/list',
							queryParams : {
								bizId : $("input[name='bizType']").attr("id") == null ? '0'
										: $("input[name='bizType']").attr("id"),
								bizType : 'xzxk'
							},
							fit : false,
							fitColumns : true,
							border : true,
							striped : true,
							//idField : 'id',
							pagination : false,
							rownumbers : true,
							//pageNumber:1,
							//pageSize : 20,
							//pageList : [ 10, 20, 30, 40, 50 ],
							singleSelect : true,
							columns : [ [ {
								field : 'ID',
								title : 'ID',
								hidden : true
							}, {
								field : 'BIZ_ID',
								title : '部门',
								sortable : true,
								hidden : true,
								width : 0
							}, {
								field : 'BIZ_DESC',
								title : '文件名称',
								width : 100,
								formatter : function(val, rec) {
									//return "<a href='${ctx}/file/download?path="+rec.BIZ_PARAM+"'>"+val+"</a>";  
									return val;
								}
							}, {
								field : 'BIZ_PARAM',
								title : 'FTP路径',
								sortable : false,
								width : 100
							}, {
								field : 'OP_DATE',
								title : '上传时间',
								sortable : true,
								width : 100
							} ] ],
							//toolbar:'#tb',
							enableHeaderClickMenu : false,
							enableHeaderContextMenu : false,
							enableRowContextMenu : false
						});

		//行政处罚
		dgXzcf = $('#xzcf_tb')
				.datagrid(
						{
							method : "post",
							url : '${ctx}/markLog/list',
							queryParams : {
								bizId : $("input[name='bizType']").attr("id") == null ? '0'
										: $("input[name='bizType']").attr("id"),
								bizType : 'xzcf'
							},
							fit : false,
							fitColumns : true,
							border : true,
							striped : true,
							//idField : 'id',
							pagination : false,
							rownumbers : true,
							//pageNumber:1,
							//pageSize : 20,
							//pageList : [ 10, 20, 30, 40, 50 ],
							singleSelect : true,
							columns : [ [ {
								field : 'ID',
								title : 'ID',
								hidden : true
							}, {
								field : 'BIZ_ID',
								title : '部门',
								sortable : true,
								hidden : true,
								width : 0
							}, {
								field : 'BIZ_DESC',
								title : '文件名称',
								width : 100,
								formatter : function(val, rec) {
									// return "<a href='${ctx}/file/download?path="+rec.BIZ_PARAM+"'>"+val+"</a>"; 
									return val;
								}
							}, {
								field : 'BIZ_PARAM',
								title : 'FTP路径',
								sortable : false,
								width : 100
							}, {
								field : 'OP_DATE',
								title : '上传时间',
								sortable : true,
								width : 100
							} ] ],
							//toolbar:'#tb',
							enableHeaderClickMenu : false,
							enableHeaderContextMenu : false,
							enableRowContextMenu : false
						});

		//报表统计
		statistics = $('#stat_bb').datagrid({
			method : "post",
			url : '${ctx}/markLog/statList',
			queryParams : {

			},
			fit : false,
			fitColumns : true,
			border : true,
			striped : true,
			//idField : 'id',
			pagination : false,
			rownumbers : true,
			//pageNumber:1,
			//pageSize : 20,
			//pageList : [ 10, 20, 30, 40, 50 ],
			singleSelect : true,
			columns : [ [ {
				field : 'ID',
				title : 'ID',
				hidden : true
			}, {
				field : 'BIZ_ID',
				title : '部门',
				sortable : true,
				hidden : true,
				width : 0
			}, {
				field : 'BIZ_DESC',
				title : '文件名称',
				width : 120,
				formatter : function(val, rec) {
					// return "<a href='${ctx}/file/download?path="+rec.BIZ_PARAM+"'>"+val+"</a>"; 
					return val;
				}
			}, {
				field : 'BIZ_PARAM',
				title : 'FTP路径',
				sortable : false,
				width : 160
			}, {
				field : 'OP_DATE',
				title : '上传时间',
				sortable : true,
				width : 100
			}, {
				field : 'MARK_TYPE',
				title : '文件类型',
				sortable : true,
				width : 20
			} ] ],
			//toolbar:'#tb',
			enableHeaderClickMenu : false,
			enableHeaderContextMenu : false,
			enableRowContextMenu : false
		});
		
		//数据报表
		statement = $('#stat_tj').datagrid({
			method : "post",
			url : '${ctx}/markLog/statList1',
			queryParams : {

			},
			fit : false,
			fitColumns : true,
			border : true,
			striped : true,
			//idField : 'id',
			pagination : false,
			rownumbers : true,
			//pageNumber:1,
			//pageSize : 20,
			//pageList : [ 10, 20, 30, 40, 50 ],
			singleSelect : true,
			columns : [ [  {
				field : 'BIZ_ID',
				title : '部门',
				sortable : true,
				rowspan : 2,
				width : 240,
				align:'center'
				
			}, {
				//field : 'BIZ_XZXK',
				title : '行政许可',
				colspan : 4	,
				align:'center'
			}, {
				//field : 'BIZ_XZCF',
				title : '行政处罚',
				colspan : 4,
				align:'center'
			}, {
				//field : 'BIZ_XZKH',
				title : '行政考核',
				colspan : 3,
				align:'center'
			}
			],[
			   {
				   title:'公开',  
                   field:'XZXK_GK',  
                   width:109,  
                   align:'center'  
			   },{
				   title:'暂缓公开',  
                   field:'XZXK_ZH',  
                   width:109,  
                   align:'center'
			   },{
				   title:'不公开',  
                   field:'XZXK_BGK',  
                   width:109,  
                   align:'center'
			   },{
				   title:'合计',  
                   field:'XZXK_HJ',  
                   width:109,  
                   align:'center'
			   },
			   
			   {
				   title:'公开',  
                   field:'XZCF_GK',  
                   width:109,  
                   align:'center'  
			   },{
				   title:'暂缓公开',  
                   field:'XZCF_ZH',  
                   width:109,  
                   align:'center'
			   },{
				   title:'不公开',  
                   field:'XZCF_BGK',  
                   width:109,  
                   align:'center'
			   },{
				   title:'合计',  
                   field:'XZCF_HJ',  
                   width:109,  
                   align:'center'
			   },{
				   title:'准时',  
                   field:'XZKH_ZS',  
                   width:109,  
                   align:'center'
			   },{
				   title:'超时',  
                   field:'XZKH_CS',  
                   width:109,  
                   align:'center'
			   },{
				   title:'合计',  
                   field:'XZKH_HJ',  
                   width:109,  
                   align:'center'
			   }
			   ]],
			//toolbar:'#tb',
			enableHeaderClickMenu : false,
			enableHeaderContextMenu : false,
			enableRowContextMenu : false
		});
	})
	//下载
	function exportExcel() {
		window.location.href="${ctx}/markLog/statList2";
	}
</script>

</head>
<body>

	<div class="easyui-layout" fit="true">
		<div data-options="region:'center'">
			<%-- easyui-panel --%>
			<div class="easyui-tabs">
				<div title="&nbsp;信用芜湖—7天双公示数据上报" style="width: 1020px;"
					data-options="iconCls:'icon-print'">
					<div style="padding: 10px 60px 20px 60px">
						<form id="uploadForm" method="post" enctype="multipart/form-data"
							action="${ctx}/system/permission/${action}" method="post">
							<table cellpadding="5">
								<tr>
									<td>请选择部门：</td>
									<td><select
										data-options="required:true,missingMessage:'请选择一个部门'"
										id="dept" name="dept" style="width: 200px;">
									</td>
									<td><span class="bz">(输入关键字模糊查询)</span></td>
								</tr>
								<tr>
									<td>文件类型：</td>
									<td><input type="radio" id="xzxk" name="bizType"
										value="xzxk" checked="checked" /><label for="xzsp">行政许可</label>
										<input type="radio" id="xzcf" name="bizType" value="xzcf" /><label
										for="xzcf">行政处罚</label>
									<td><span class="bz"></span></td>
									</td>
								</tr>
								<tr>
									<td>请选择要上传的文件：</td>
									<td><input class="easyui-filebox " name="file"
										id="filebox" data-options="buttonText:'选择文件'"
										style="width: 100%"></td>
									<td><span class="bz">(请上传 xls,xlsx格式文件,文件大小不超过 20M)</span>
									</td>
								</tr>
							</table>
						</form>
						<div style="text-align: center; padding: 5px;">
							<a href="javascript:void(0)" class="easyui-linkbutton"
								data-options="iconCls:'icon-ok'" onclick="submitForm()">提交</a> <span
								width="80px">&nbsp;&nbsp;&nbsp;</span> <a
								href="javascript:void(0)" class="easyui-linkbutton"
								data-options="iconCls:'icon-reload'" onclick="clearForm()">取消</a>
						</div>
					</div>

					<div class="easyui-tabs" id="tips">
						<div title="行政许可" style="padding-left: 10px">
							<p style="font-size: 14px; font-weight: bold;">注意事项:</p>
							<ul>
								<li>1、“决定书文号”填写行政许可批复文号或证书号</li>
								<li>2、“公文原文”填写批复内容或证书内容</li>
								<li>3、“设定依据”填写法定依据</li>
								<li>4、“审批类别”填写“行政许可”</li>
								<li>5、“行政相对人统一社会信用代码”填写组织机构代码/居民身份证号码/“三证合一”营业执照社会信用代码</li>
								<li>6、“生效日期”填写行政许可生效日期</li>
								<li>7、“决定时效”填写行政许可的有效期</li>
								<li>8、“办理结果”填写“办结”（无发件）/“发放批复”/“发放证书”/“其他”</li>
								<li>9、“许可对象”填写“个人”/“企业”/“其他组织”</li>
								<li>10、各填表单位负责对除“行政相对人统一社会信用代码”以外其他栏目涉及不予公开内容的信息进行技术处理</li>
								<li>11、“行政相对人统一社会信用代码”为身份证号码的，由社会信用服务中心在上传“信用中国”前，隐去其年月
									日6位数字</li>
								<li>12、上传文件名要严格按照表格标题命名为“XXX行政许可事项信息归集表” （XXX为单位名称），以便汇总</li>
							</ul>
							<p style="font-size: 14px; font-weight: bold;">模板下载:</p>
							<ul>
								<li>1、<a
									href="${ctx}/file/download?path=/7days/demo/行政许可事项信息归集表（第二批）.xlsx">行政许可事项信息归集表（第二批）.xlsx</a>
								</li>
							</ul>
						</div>
						<div title="行政处罚" style="padding-left: 10px">
							<p style="font-size: 14px; font-weight: bold;">注意事项:</p>
							<ul>
								<li>1、“决定书文号”填写行政处罚文号</li>
								<li>2、“公文原文”填写处罚内容</li>
								<li>3、“执法依据”填写法定依据</li>
								<li>4、“行政相对人统一社会信用代码”填写组织机构代码/居民身份证号码/“三证合一”营业执照社会信用代码</li>
								<li>5、“处罚结果”填写“完成”/“未完成”</li>
								<li>6、“处罚履行方式”填写警告、罚款、拘留等方式</li>
								<li>7、“生效日期”填写行政处罚生效日期</li>
								<li>8、“处罚期限”填写多少日内完成处罚工作，或处罚持续多久等</li>
								<li>9、“处罚对象”填写“个人”/“企业”/“其他组织”</li>
								<li>10、各填表单位负责对除“行政相对人统一社会信用代码”以外其他栏目涉及不予公开内容的信息进行技术处理</li>
								<li>11、“行政相对人统一社会信用代码”为身份证号码的，由社会信用服务中心在上传“信用中国”前，隐去其年月
									日6位数字</li>
								<li>12、上传文件名要严格按照表格标题命名为“XXXX行政处罚事项信息归集表”（XXXX为单位名称），以便汇总</li>
							</ul>
							<p style="font-size: 14px; font-weight: bold;">模板下载:</p>
							<ul>
								<li>1、<a
									href="${ctx}/file/download?path=/7days/demo/行政处罚事项信息归集表（第二批）.xlsx">行政处罚事项信息归集表（第二批）.xlsx</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="easyui-tabs" id="dg_list">
						<div title="行政许可"
							style="padding-left: 10px; padding-bottom: 10px;">
							<%--
							<p style="font-size: 14px; font-weight: bold;">已上传文件:</p>
							 --%>
							<table id="xzxk_tb"></table>
						</div>

						<div title="行政处罚" style="padding: 10px">
							<%--
							<p style="font-size: 14px; font-weight: bold;">已上传文件:</p>
							--%>
							<table id="xzcf_tb"></table>
						</div>
					</div>
				</div>
				<%-- 
				<div data-options="region:'east',split:true, border: true,iconCls: 'icon-hamburg-library'" title="导航" style="width:200px;" >
				</div>
				--%>
				
			</div>
		</div>
	</div>



	<script type="text/javascript">
		//提交表单
		function submitForm() {
			//var file=document.getElementById('filebox').files;
			//var filesize=file.size/1024;//KB
			var fileName = $('#filebox').filebox('getValue');
			if (fileName != null && fileName != '') {
				var fileType = fileName.substring(
						fileName.lastIndexOf('.') + 1, fileName.length);
				if (fileType != 'xls' && fileType != 'xlsx') {
					$.messager.alert('提示', '请上传 xls或 xlsx文件!');
					return;
				}
				
			$('#uploadForm').form('submit',{
				url:'${ctx}/file/upload',
	            onSubmit:function(op){
	            	//return true;
	            	return $(this).form('validate');
	            },
	            success:function(data){
	            	var obj=eval('('+ data+ ')');
	            	$.messager.alert('提示',obj.msg);
	            	//行政许可
	            	var queryParams = $('#xzxk_tb').datagrid('options').queryParams;  ;  
	      			queryParams.bizId=$('#dept').combobox('getValue');  
	        		queryParams.type ='xzxk';  
					dgXzxk.datagrid('reload');
					//行政处罚
	            	var queryXzcf = $('#xzcf_tb').datagrid('options').queryParams;  ;  
	            	queryXzcf.bizId=$('#dept').combobox('getValue');  
	            	queryXzcf.type ='xzcf';  
	            	dgXzcf.datagrid('reload');
	            }
	          });
			}
		}

		//取消
		function clearForm() {
			$('#uploadForm').form('clear');
		}
		/**
		$('#mainform').form({    
		    onSubmit: function(){    
		    	return true;
		    },    
		    success:function(data){   
		    }    
		});  **/
	</script>

</body>
</html>