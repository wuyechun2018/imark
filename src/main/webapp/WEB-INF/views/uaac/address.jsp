<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--
<LINK href="${ctx}/resources/images/favicon.ico" type="image/x-icon" rel="icon">                        
<LINK href="${ctx}/resources/images/favicon.ico" type="image/x-icon" rel="shortcut icon">
 --%>
 
 <%
 	//接收传入该页面的参数
 	//行政区编码
 	String bm=request.getParameter("bm");
 	//用户
 	String user=request.getParameter("user");
 %>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--放置的位置要特别注意,不能放在第三行,否则会有一些样式问题 --%>
<%@ include file="/WEB-INF/views/easyui.jsp" %>
<link href="${ctx}/resources/styles/easyui-flat.css" rel="stylesheet" media="screen">
<link href="${ctx}/resources/styles/uaac.css" rel="stylesheet" media="screen">
<link href="${ctx}/resources/aicons/css/aicons.css" rel="stylesheet" media="screen">

<title>标准地址维护</title>

<style type="text/css">
.td-info{
	font-variant：normal;
	padding-left:60px;
	color:#FFA500;
}

.panel-header{
	background-color:rgb(103, 147, 130);
	background-color:#ffffff;
	border: 0px solid #d9d9d9;
}

.infoTable{
	font-size:14px;
}

.info{
	

}

.alink{
	text-decoration:none;
	color:RGB(255,69,0);
	font-family: Microsoft YaHei;
	font-size:14px;
}



</style>


<script type="text/javascript">
	var sNode=new Object();
	sNode.id="0";
	sNode.attributes=new Object();
	sNode.attributes.XZQID="0";
	
	//接受调用方传入的参数
	var bm="<%=bm%>";
	var user="<%=user%>";
	
	$(function(){
		
		//$('#biaozhundizhi').attr("disabled",true);
		//$('#radio_zrc').attr('checked',true);
		//左边行政区划树
		$('#addressTree').tree({   
            checkbox: false,   
            //url: '${ctx}/resources/data/tree_data.json?version='+new Date(),
            url:'${ctx}/address/getTreeList?bm='+bm,
            method:'post',
            onBeforeExpand:function(node,param){
            	$('#addressTree').tree('options').url = ctx + "/address/getTreeList?id="+node.id+"&bm="+bm;                  
             },               
             onClick:function(node){ 
            	//记录当前节点 
            	sNode=node;
            	//行政区ID
            	var sXZQID=node.attributes.XZQID;
            	//清空表单
            	resetForm();
            	
            	$("#lb_jlx_zrc").html('街路巷');
            	
               	//获取行政区信息
                $.ajax({
                	  type: "post",
                	  url: ctx+"/address/getBaseInfoByAreaCode",
                	  dataType:"json",
                	  async:false,
                	  data:{
                		  		areaCode:node.id
                	       },
                	  cache :false,
                	  success: function(result){
                		  //ADDRESS_TYPE 1,街路巷,2,自然村
                		  if(result.ADDRESS_TYPE=='2'){
                			  //$('#radio_zrc').attr('checked',true);
                			  //解决chrome下问题
                			  $('#radio_zrc').prop('checked', 'checked');
                		  }else{
                			  //$('#radio_jlx').attr('checked',true);
                			  $('#radio_jlx').prop('checked', 'checked');
                		  }
                		  
                		  
                		  //CENSUS_TYPE 1,非农业,2,农业
                		  if(result.CENSUS_TYPE==2){
                			  //$('#radio_ny').attr('checked','checked');
                			  $('#radio_ny').prop('checked', 'checked');
                    		  
                		  }else{
                			  // $('#radio_fny').attr('checked','checked');
                			  $('#radio_fny').prop('checked', 'checked');
                		  }
                		  
                		  //主键
                		 if(result.ID){
                			 $('#addressId').val(result.ID);
                		 }else{
                			 $('#addressId').val('');
                		 }
                		  
              			//加载街路巷，自然村
                       	var jlx = $('input[name="radio_jlx_zrc"]:checked').val();
                       	var jlxUrl=ctx+"/address/getJlxOrZrc?jlx="+jlx+"&szxzq="+sXZQID+"&date="+new Date().getTime();
                       	$('#jieluxiang').combobox("reload", jlxUrl);
                       	
                       	//加载小区
                       	$('#xiaoqu').combobox('clear');
                    	var xiaoquUrl=ctx+"/address/getXiaoqu?szxzq="+sXZQID+"&date="+new Date().getTime();
                       	$('#xiaoqu').combobox("reload", xiaoquUrl);
                		  
                		  
                		  //行政区全称
                		  //var xzqc=node.attributes.QC;
                		  var xzqc=node.text;
                		  var node_1=$('#addressTree').tree('getParent',node.target);
                		  if(node_1){
                			  xzqc=node_1.text+node.text;
                			  var node_2=$('#addressTree').tree('getParent',node_1.target);
                			  if(node_2){
                    			  xzqc=node_2.text+node_1.text+node.text;
                    			  var node_3=$('#addressTree').tree('getParent',node_2.target);
                    			  if(node_3){
                        			  xzqc=node_3.text+node_2.text+node_1.text+node.text;
                        		  }
                    		  }
                		  }
                		 
                		  
                		  //xzqc=xzqc.substring(0,xzqc.indexOf('区')+1);
                		  $('#xingzhengqu').val("安徽省"+xzqc);
                		  //标准地址
                		  $('#biaozhundizhi').val(result.BZDZ);
                		 
                		  if(result.ADDRESS_TYPE=='2'){
                			//自然村
                    		  $('#jieluxiang').combobox('setValue',result.ZRCID);
                		  }else{
                			//街路巷
                    		  $('#jieluxiang').combobox('setValue',result.JLXID);
                		  }
                		  //门牌号
                		  $('#menpaihao').val(result.MPHQC);
                		  //小区
                		  $('#xiaoqu').combobox('setValue',result.XQID);
                		  //详细地址
                		  $('#xiangxidizhi').val(result.XXDZ);
                		  //联系方式
                		  $('#lianxifangshi').val(result.TELE_GOV);
                		 
                		  
                		  //数据来源 1,公安,2,芜湖社管
                		  var dataSource=result.DATA_SOURCE;
                		  if(dataSource){
                			  $('#dataSource').val(dataSource);
                		  }else{
                			  $('#dataSource').val('2');
                		  }
                		  
                		  if(dataSource==1){
                			  //freezeForm();
                		  }else{
                			  activeForm();
                		  }
                		 
                	  }	
                });
            	 
            	 
             },
             onLoadSuccess:function(node, data){
            	 var rootNode = $("#addressTree").tree('getRoot');
            	 if(rootNode){
            		 //var children = $("#addressTree").tree('getChildren',rootNode.target);
                	 //展开根节点
                	 $("#addressTree").tree("expand",rootNode.target);
                	 sNode=node;
                	 //$("#addressTree").tree('expandAll');
            	 }
            	
             }
        });   
		
		
		
		//街路巷、自然村下拉框
		$('#jieluxiang').combobox({
					url : '${ctx}/address/getJlxOrZrc?jlx=1&szxzq='+sNode.attributes.XZQID,
					method : 'get',
					valueField : 'id',
					textField : 'text',
					//panelHeight:'auto',
					filter : function(q, row) {
						var opts = $(this).combobox('options');
						return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) > -1;
					},
					onSelect : function(rec) {
						setBiaozhundizhi();
					}
				});
		
		//加载小区数据
		$('#xiaoqu').combobox({
			url : '${ctx}/address/getXiaoqu?szxzq='+sNode.attributes.XZQID,
			method : 'get',
			valueField : 'id',
			textField : 'text',
			//panelHeight:'auto',
			filter : function(q, row) {
				var opts = $(this).combobox('options');
				return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) > -1;
			},
			onSelect : function(rec) {
				//选择小区后根据小区 和 街路巷 或自然村 查询门牌号
				//参照实体类型 CZSTLX  	L 街路巷  Z 自然村
				//参照实体ID CZSTID    参照实体ID
				//依附实体类型  YFSTLX 	Q小区 ,J建筑物,F房间
				//依附实体ID YFSTID    小区ID
				
			     var jlx = $('input[name="radio_jlx_zrc"]:checked').val();
				 var czstlx='L';
				 //1 街路巷  2 自然村
				 if(jlx=='2'){
					 czstlx='Z';
				 }
				 var czstid=$('#jieluxiang').combobox('getValue');
				 
				 $.ajax({
               	  type: "post",
               	  url: ctx+"/address/getMph",
               	  dataType:"json",
               	  async:false,
               	  data:{
              				czstlx:czstlx, //参照实体类型
              				czstid:czstid, //参照实体ID
              				yfstlx:'Q',    //依附实体类型
              		  		yfstid:rec.id  //小区ID
               	       },
               	  cache :false,
               	  success: function(result){
               		  if(result.MPH){
               			$('#menpaihao').val(result.MPH);
               			$('#menpaihao').attr("readonly","readonly");
               		  }else{
               			$('#menpaihao').val('');
               			$('#menpaihao').attr("readonly",false);
               		  }
               		  
               	  }	
               });
				
				 setBiaozhundizhi();
			
			}
		});
		
		//地址类型切换,街路巷,自然村
		$("input[name='radio_jlx_zrc']").click(function() {
			//清除数据
			$('#jieluxiang').combobox('clear');
			
			var id = $(this).attr("id");
			//行政许可
			if (id == 'radio_jlx') {
				$("#lb_jlx_zrc").html('街路巷');
				//加载街路巷，自然村
               	//var jlx = $('input[name="radio_jlx_zrc"]:checked').val();
               	var jlxUrl=ctx+"/address/getJlxOrZrc?jlx=1&szxzq="+sNode.attributes.XZQID+"&date="+new Date().getTime();
               	$('#jieluxiang').combobox("reload", jlxUrl);
			} else {
				$("#lb_jlx_zrc").html('自然村');
				//加载街路巷，自然村
               	//var jlx = $('input[name="radio_jlx_zrc"]:checked').val();
               	var jlxUrl=ctx+"/address/getJlxOrZrc?jlx=2&szxzq="+sNode.attributes.XZQID+"&date="+new Date().getTime();
               	$('#jieluxiang').combobox("reload", jlxUrl);
			}
		});
		
		//联系方式 valid
		$('#lianxifangshi').validatebox({ 
			required:true,
			missingMessage:'请输入联系方式'
		}); 
		
		//详细地址
		$('#xiangxidizhi').validatebox({ 
			required:true,
			missingMessage:'请输入详细地址,如:香格里拉社区居委会,广福社区居委会'
		}); 
		
		//标准地址 tooltip
		 $('#biaozhundizhi').tooltip({
			 position: 'right',
			 content:'<span style="color:#000">说明：由系统自动生成,标准地址=行政区+街路巷+门牌号+小区+详细地址。</span>',
			 onShow: function(){
						 $(this).tooltip('tip').css({
							 backgroundColor: 'RGB(255,255,204)',
							 borderColor: 'RGB(204,153,51)'
						 });
				 }
		});
		
		
		 //详细地址
		 $('#xiangxidizhi').tooltip({
			 position: 'right',
			 content:'<span style="color:#000">说明：请输入详细地址,如：大富居委会，清苑社区居委会</span>',
			 onShow: function(){
						 $(this).tooltip('tip').css({
							 backgroundColor: 'RGB(255,255,204)',
							 borderColor: 'RGB(204,153,51)'
						 });
				 }
		});
	  
	    //详细地址
	    $("#xiangxidizhi").change(function(){
	    	setBiaozhundizhi();
	    });
	    
	    //门牌号
	    $("#menpaihao").change(function(){
	    	setBiaozhundizhi();
	    });
		
	});
	
	//重置表单
	function resetForm(){
		//门牌号
		$('#menpaihao').val('');
		//小区
		$('#xiaoqu').val('');
	}
	
	//冻结表单
	function freezeForm(){
		$('input').attr("disabled",true);
		$('textarea').attr("disabled",true);
		$('#lianxifangshi').attr("disabled",false);
	}
	
	//活跃表单
	function activeForm(){
		$('input').attr("disabled",false);
		$('textarea').attr("disabled",false);
	}
	
	
	//拼接标准地址
	function setBiaozhundizhi(){
		//说明：标准地址=行政区+街路巷+门牌号+小区+详细地址
		//行政区
    	var xingzhengqu=$('#xingzhengqu').val();
    	//街路巷
    	var jieluxiang=$('#jieluxiang').combobox('getText');
    	//门牌号
    	var menpaihao=$('#menpaihao').val();
    	//小区
    	var xiaoqu=$('#xiaoqu').combobox('getText');
    	//详细地址
    	var xiangxidizhi=$('#xiangxidizhi').val();
    	//设置标准地址
    	$('#biaozhundizhi').val(xingzhengqu+jieluxiang+menpaihao+xiaoqu+xiangxidizhi);
	}
	
	//取消
	function clearForm() {
		$('#addressForm').form('clear');
	}
	
	//提交表单
	function submitForm() {
		var isJlxAdd=false;
		var isXqAdd=false;
		
		if($("#addressForm").form('validate')){
			//手输街路巷	
			if($('#jieluxiang').combobox('getValue')&&isNaN($('#jieluxiang').combobox('getValue'))){  
				var showMsg="您确定要新增街路巷（自然村）:"+$('#jieluxiang').combobox('getValue')+"?";
				if(confirm(showMsg)){
					isJlxAdd=true;
				 }else{
					 return ;
				 }
			}else{
				isJlxValid=true;
			}
			//手输小区
			if($('#xiaoqu').combobox('getValue')&&isNaN($('#xiaoqu').combobox('getValue'))){  
				var showMsg="您确定要新增小区:"+$('#xiaoqu').combobox('getValue')+"?";
				if(confirm(showMsg)){
					isXqAdd=true;
				 }else{
					 return ;
				 }	
			}
				$.ajax({
					cache: true,
					type: "POST",
					url:ctx+"/address/save",
					data:{
						addressId:$('#addressId').val(),
						bzdz:$('#biaozhundizhi').val(), //标准地址
						dzlx:'J',	//地址类型
					    xzqid:sNode.attributes.XZQID,  //行政区ID
					    areaCode:sNode.id, //行政区Code
					    xzqdm:$('#xingzhengqu').val(), //行政区地名
					    addressType:$('input[name="radio_jlx_zrc"]:checked').val(), //街路巷1,自然村2
					    jlxOrZrcId:$('#jieluxiang').combobox('getValue'), //街路巷,自然村ID
						jlxOrZrcQc:$('#jieluxiang').combobox('getText'), //街路巷,自然村全称
						mphid:'', //门牌号ID
						mphqc:$('#menpaihao').val(),//门牌号全称
						xqid:$('#xiaoqu').combobox('getValue'),//小区ID
						xqqc:$('#xiaoqu').combobox('getText'),//小区全称
						dataSource:$('#dataSource').val(),//数据来源 1,公安,2,芜湖社管
						xxdz: $('#xiangxidizhi').val(),//详细地址
						censusType:$('input[name="radio_fny_ny"]:checked').val(),
						telgov:$('#lianxifangshi').val(), //联系方式
						user:user,
						isJlxAdd:isJlxAdd,
						isXqAdd:isXqAdd
					},
					async: false,
				    error: function(request) {
				        alert("Connection error");
				    },
				    success: function(data) {
				    	$.messager.alert('提示信息',data.msg);
				    	if (sNode){
				    		$('#addressTree').tree('update', {
				    			target: sNode.target,
				    			iconCls: 'itree-accept'
				    		});
				    	}


				    }
				})
		
	}
	
	}
	
	//新增街路巷，自然村
	function addXieluxiang(){
		$('#jieluxiang_window').window('open');
	}
	
	//新增街路巷，自然村
	function addXiaoqu(){
		$('#xiaoqu_window').window('open');
	}
	
	
	//新增街道,街路巷 提交表单
	function submitJieluxiangForm() {
		if($("#jieluxiang_add_form").form('validate')){
			$.ajax({
				cache: true,
				type: "POST",
				url:ctx+"/address/jieLuXiangsave",
				data:{
					 addressType:$('input[name="radio_jlx_zrc_add"]:checked').val(), //街路巷1,自然村2
					 addressValue:$('jieluxiangOrZrc_add').val(),
					 xzqId:$('#jieluxiang_xzq_id').val(),
					 xzqCode:$('#jieluxiang_xzq_code').val()
				},
				async: false,
			    error: function(request) {
			        
			    },
			    success: function(data) {
			    	$.messager.alert('提示信息',data.msg);
			    }
			})
		}
	}
	
	//新增街道,街路巷 取消表单
	function clearJieluxiangForm() {
		$('#jieluxiang_add_form').form('clear');
		$('#jieluxiang_window').window('close');  
	}
	
	//新增小区  提交表单
	function submitXiaoquForm() {
		if($("#xiaoqu_add_form").form('validate')){
			$.ajax({
				cache: true,
				type: "POST",
				url:ctx+"/address/xiaoQuSave",
				data:{
					 xiaoquText:$('xiaoqu_add').val(),  //小区名称
					 xzqId:$('#xiaoqu_xzq_id').val(),   //小区 行政区ID
					 xzqCode:$('#xiaoqu_xzq_code').val() //小区行政区Code
				},
				async: false,
			    error: function(request) {
			        
			    },
			    success: function(data) {
			    	$.messager.alert('提示信息',data.msg);
			    }
			})
		}
	}
	
	//新增小区  取消表单
	function clearXiaoquForm() {
		$('#xiaoqu_add_form').form('clear');
		$('#xiaoqu_window').window('close');  
	}
	
	//打开信息提示框
	function openInfoWin(){
		$('#infoWin').window('open');  
	}
	
</script>

</head>
<body >
	<div class="easyui-layout" fit="true">
		<%--
		<div data-options="region:'north'" style="height:0px">
			<div></div>
		</div>
		--%>
		
		<div data-options="region:'west',split:true, border: true,iconCls:'icon-reload'"  title="行政区划树" style="width:220px;font-family: Microsoft YaHei;" >
			<ul id="addressTree"></ul>
		</div>
		<div data-options="region:'center',title:'地址维护',iconCls:'icon-edit'">
			<form id="addressForm">
				 <table class="table-form">
					<thead>
						 <tr class="col-width">
							<th class="td-tit"></th>
							<td></td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th><i class="required">&lowast;</i>行政区：</th>
							<td>
								<div class="form-control">
									<span class="r"></span>
									<span class="l"></span>
									<span class="c">
									<input id="xingzhengqu" type="text" name="xingzhengqu" name="xingzhengqu" class="text" maxlength="64"/></span>
								</div>
							</td>
							
							
						</tr>
						
						<tr>
							<th>地址类型：</th>
							<td>
								<div class="form-control form-combobox" style="height:30px;line-height: 30px;">
									<input style="margin-left:10px;" type="radio" id="radio_jlx" name="radio_jlx_zrc" value="1" checked="checked" />
									<label for="radio_jlx" >街路巷</label>
									<input style="margin-left:50px;" type="radio" id="radio_zrc" name="radio_jlx_zrc" value="2" />
									<label for="radio_zrc">自然村</label>
								</div>
							</td>
						</tr>
						
						<tr>
							<th><i class="required">&lowast;</i><label id="lb_jlx_zrc">街路巷</label>：</th>
							<td >
								<select data-options="required:true,missingMessage:'请选择一个 街路巷/自然村'" id="jieluxiang" name="jieluxiang" style="width:100%;">
							</td>
							
							<td class="td-info" style="padding-left:10px;">(可输入关键字,进行模糊查询)</td>
						</tr>
		
						<tr>
							<th>门牌号：</th>
							<td>
								<div class="form-control">
									<span class="r"></span>
									<span class="l"></span>
									<span class="c">
										<input type="text" id="menpaihao" name="menpaihao" class="text" maxlength="14" />
									</span>
								</div>
							</td>
							
						</tr>
						<tr>
							<th>小区：</th>
							<td>
								<select  data-options="required:false,missingMessage:'请选择一个小区'" id="xiaoqu" name="xiaoqu" style="width: 100%;">
							</td>
							<td class="td-info" style="padding-left:10px;">(可输入关键字,进行模糊查询)</td>
						</tr> 
						<tr>
							<th><i class="required">&lowast;</i><label id="lb_jlx_zrc">详细地址</label>：</th>
							<td>
								<div class="form-control form-combobox" id="xxdz">
									<span class="r"></span>
									<span class="l"></span>
									<span class="c">
										<input type="text" id="xiangxidizhi" name="xiangxidizhi" class="text"/>
										<%-- 
										<textarea id="xiangxidizhi" name="xiangxidizhi" class="text" width="99%"></textarea>
										--%>
									</span>
								</div>
							</td>
							
						</tr>
						
						<tr>
							<th>标准地址：</th>
							<td>
								<div class="form-control form-textarea" id="bzdz">
									<span class="r"></span>
									<span class="l"></span>
									<span class="c">
										<textarea readonly="readonly" id="biaozhundizhi" name="biaozhundizhi" maxlength="512" style="height:65px"></textarea>
									</span>
								</div>
							</td>
							<%-- 
							<td class="td-info" style="padding-left:10px;">(系统自动生成)</td>--%>
						</tr>
						
						<tr>
							<th><i class="required">&lowast;</i>联系方式：</th>
							<td>
								<div class="form-control form-combobox" id="lxfs">
									<span class="r"></span>
									<span class="l"></span>
									<span class="c">
										<input type="text"  id="lianxifangshi" name="lianxifangshi" class="text"/>
									</span>
								</div>
							</td>
							
						</tr>
						
						<tr>
							<th>非农业/农业：</th>
							<td>
								<div class="form-control form-combobox" id="ny" style="height:30px;line-height: 30px;">
									<input style="margin-left:10px;" type="radio" id="radio_fny" name="radio_fny_ny" value="1" checked="checked" />
									<label for="fny" >非农业</label>
									<input style="margin-left:50px;" type="radio" id="radio_ny" name="radio_fny_ny" value="2" />
									<label for="ny">农业</label>
									
									<%--数据来源 1,公安,2,芜湖社管--%>
									<input type="hidden" name="dataSource" id="dataSource"> 
									<%-- 主键ID --%>
									<input type="hidden" name="addressId" id="addressId">
									
								</div>
							</td>
						</tr>
						
					</tbody>
				</table>
				
				<div class="iform-btn">
					<a onclick="submitForm()" class="btn btn-primary mr10" id="root_save_btn" href="javascript:void(0);">
						<span class="l"></span><span class="c">保存</span><span class="r"></span>
					</a>
					<a onclick="clearForm()" class="btn btn-primary " id="root_reset_btn" href="javascript:void(0);">
						<span class="l"></span><span class="c">取消</span><span class="r"></span>
					</a>
				</div>
			</form> 
		</div>
		<div data-options="region:'south',split:false" style="height:25px;line-height: 20px;">
			<%--
			<div class="south-bottom" style="margin-left:10px;">
				<a class="alink" href="javascript:void(0)" onclick="openInfoWin()">版本说明</a>
			</div>
			 --%>
		</div>
		
	</div>	
	
	<%--新增 街路巷、自然村弹出框
	<div id="jieluxiang_window" class="easyui-window" title="新增街路巷(自然村)" data-options="collapsible:false,maximizable:false,minimizable:false,iconCls:'icon-add',resizable:false,closed:false" style="width:600px;height:280px;padding:10px;">
		<form id="jieluxiang_add_form">
			<table class="table-form">
				<thead>
					<tr class="col-width">
						<th class="td-tit"></th>
						<td></td>
						
					</tr>
				</thead>
				<tbody>
					<tr>
						<th><i class="required">&lowast;</i>行政区：</th>
						<td>
							<div class="form-control">
								<span class="r"></span> <span class="l"></span> <span class="c">
									<input id="xingzhengqu_add" type="text" name="xingzhengqu" class="text" maxlength="64" />
									<input type="hidden" name="jieluxiang_xzq_id" id="jieluxiang_xzq_id">
									<input type="hidden" name="jieluxiang_xzq_code" id="jieluxiang_xzq_code">
								</span>
							</div>
						</td>
					</tr>
					
					<tr>
							<th>地址类型：</th>
							<td>
								<div class="form-control form-combobox" style="height:30px;line-height: 30px;">
									<input style="margin-left:10px;" type="radio" id="radio_jlx_add" name="radio_jlx_zrc_add" value="1" checked="checked" />
									<label for="radio_jlx_add" >街路巷</label>
									<input style="margin-left:50px;" type="radio" id="radio_zrc_add" name="radio_jlx_zrc_add" value="2" />
									<label for="radio_zrc_add">自然村</label>
								</div>
							</td>
					</tr>
					
					<tr>
							<th><i class="required">&lowast;</i><label id="lb_jlx_zrc_add">街路巷</label>：</th>
							<td >
								<div class="form-control form-combobox" >
									<span class="r"></span>
									<span class="l"></span>
									<span class="c">
										<input type="text"  id="jieluxiangOrZrc_add" name="jieluxiangOrZrc_add" class="text"/>
									</span>
								</div>
							</td>
					</tr>
					
				</tbody>
			</table>
			
			<div class="iform-btn">
					<a onclick="submitJieluxiangForm()" class="btn btn-primary mr10"  href="javascript:void(0);">
						<span class="l"></span><span class="c">保存</span><span class="r"></span>
					</a>
					<a onclick="clearJieluxiangForm()" class="btn btn-primary " href="javascript:void(0);">
						<span class="l"></span><span class="c">取消</span><span class="r"></span>
					</a>
			</div>
			
		</form>
	</div>
	--%>
	<%--新增 小区弹出框
	<div id="xiaoqu_window" class="easyui-window" title="新增小区" data-options="collapsible:false,maximizable:false,minimizable:false,iconCls:'icon-add',resizable:false,closed:true" style="width:600px;height:280px;padding:10px;">
			<form id="xiaoqu_add_form">
			<table class="table-form">
				<thead>
					<tr class="col-width">
						<th class="td-tit"></th>
						<td></td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th><i class="required">&lowast;</i>行政区：</th>
						<td>
							<div class="form-control">
								<span class="r"></span> <span class="l"></span> <span class="c">
									<input id="xingzhengqu_xiaoqu_add" type="text" name="xingzhengqu_xiaoqu_add" class="text" maxlength="64" />
									<input type="hidden" name="xiaoqu_xzq_id" id="xiaoqu_xzq_id">
									<input type="hidden" name="xiaoqu_xzq_code" id="xiaoqu_xzq_code">
								</span>
							</div>
						</td>
					</tr>
					
					<tr>
						<th><i class="required">&lowast;</i><label id="lb_xiaoqu_add">小区名称:</label></th>
						<td >
							<div class="form-control form-combobox" >
								<span class="r"></span>
								<span class="l"></span>
								<span class="c">
									<input type="text"  id="xiaoqu_add" name="xiaoqu_add" class="text"/>
								</span>
							</div>
						</td>
					</tr>
					
				</tbody>
			</table>
			
			<div class="iform-btn">
					<a onclick="submitXiaoquForm()" class="btn btn-primary mr10"  href="javascript:void(0);">
						<span class="l"></span><span class="c">保存</span><span class="r"></span>
					</a>
					<a onclick="clearXiaoquForm()" class="btn btn-primary " href="javascript:void(0);">
						<span class="l"></span><span class="c">取消</span><span class="r"></span>
					</a>
			</div>
			
		</form>
	</div>
--%>
	
	<div id="infoWin" class="easyui-window" title="说明" data-options="collapsible:false,maximizable:false,minimizable:false,resizable:false,closed:true" style="width:600px;height:280px;padding:10px;">
			<table class="infoTable">
				<tr>
					
					<td>
						当前版本：v2.0
					</td>
				</tr>
				<tr>
					<td>
						升级信息：由"公安"信息升级到"网格化"平台
					</td>
				</tr>
				<tr>
					<td>
						原访问地址：<a style="color:RGB(255,69,0)" href="${ctx}/views/uaac/addressHandle" target="_blank">地址维护</a>
					</td>
				</tr>
			</table>
	</div>

<script type="text/javascript" src="${ctx}/resources/My97DatePicker/WdatePicker.js" defer="defer"></script>

</body>
</html>