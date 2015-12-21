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



</style>


<script type="text/javascript">
	var sNode=new Object();
	sNode.id="0";
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
            url:'${ctx}/addressHandle/getTreeList?bm='+bm,
            method:'post',
            onBeforeExpand:function(node,param){
            	$('#addressTree').tree('options').url = ctx + "/addressHandle/getTreeList?id="+node.id+"&bm="+bm;                  
             },               
             onClick:function(node){ 
            	//记录当前节点 
            	sNode=node;
            	//清空表单
            	resetForm();
            	
            	$("#lb_jlx_zrc").html('街路巷');
            	
               	//获取行政区信息
                $.ajax({
                	  type: "post",
                	  url: ctx+"/addressHandle/getBaseInfo",
                	  dataType:"json",
                	  async:false,
                	  data:{
                		  		szxzq:sNode.id
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
                       	var jlxUrl=ctx+"/addressHandle/getJlxOrZrc?jlx="+jlx+"&szxzq="+node.id+"&date="+new Date().getTime();
                       	$('#jieluxiang').combobox("reload", jlxUrl);
                       	
                       	//加载小区
                       	$('#xiaoqu').combobox('clear');
                    	var xiaoquUrl=ctx+"/addressHandle/getXiaoqu?szxzq="+node.id+"&date="+new Date().getTime();
                       	$('#xiaoqu').combobox("reload", xiaoquUrl);
                		  
                		  
                		  //行政区全称
                		  var xzqc=node.attributes.QC;
                		  //xzqc=xzqc.substring(0,xzqc.indexOf('区')+1);
                		  $('#xingzhengqu').val(xzqc);
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
					url : '${ctx}/addressHandle/getJlxOrZrc?jlx=1&szxzq='+sNode.id,
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
			url : '${ctx}/addressHandle/getXiaoqu?szxzq='+sNode.id,
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
               	  url: ctx+"/addressHandle/getMph",
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
               	var jlxUrl=ctx+"/addressHandle/getJlxOrZrc?jlx=1&szxzq="+sNode.id+"&date="+new Date().getTime();
               	$('#jieluxiang').combobox("reload", jlxUrl);
			} else {
				$("#lb_jlx_zrc").html('自然村');
				//加载街路巷，自然村
               	//var jlx = $('input[name="radio_jlx_zrc"]:checked').val();
               	var jlxUrl=ctx+"/addressHandle/getJlxOrZrc?jlx=2&szxzq="+sNode.id+"&date="+new Date().getTime();
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
		/**
		$('#addressForm').form('submit',{
			url:'${ctx}/address/add',
			method:'post',
            onSubmit:function(op){
            	return $(this).form('validate');
            },
            success:function(data){
            	var obj=eval('('+ data+ ')');
            	$.messager.alert('提示',obj.msg);
            }
          });
		
		$.ajax({
			cache: true,
			type: "POST",
			url:ctx+"/address/save",
			data:$('#addressForm').serialize(),
			async: false,
		    error: function(request) {
		        alert("Connection error");
		    },
		    success: function(data) {
			  	alert('ok');
		    }
		});**/
		
		//var lianxifangshi=$('#lianxifangshi').val();
		//if(lianxifangshi==null||lianxifangshi==''){
		//	$.messager.alert('提示信息','请输入联系方式！');
		//	return;
		//}
		
	if($("#addressForm").form('validate')){
		$.ajax({
			cache: true,
			type: "POST",
			url:ctx+"/addressHandle/save",
			data:{
				addressId:$('#addressId').val(),
				bzdz:$('#biaozhundizhi').val(), //标准地址
				dzlx:'J',	//地址类型
			    xzqid:sNode.id,  //行政区ID
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
				user:user
			},
			async: false,
		    error: function(request) {
		        alert("Connection error");
		    },
		    success: function(data) {
		    	/**$.messager.show({  
		    		            title: '提示信息',  
		    		            msg: data.msg,  
		    		            showType: 'show', 
		    		            style:{				
		    		            		right:'',				
		    		            		top:'60',
		    		            		bottom:''	
		    		            }
		    		            
		    		   });**/
		    	
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
	

	
	
</script>

</head>
<body >
	<div class="easyui-layout" fit="true">
		
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
							<th>详细地址：</th>
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
		<div data-options="region:'south',split:false" style="height:20px;" class="ibackgroud">
			<div class="south-bottom">
			</div>
		</div>
		
	</div>	


<script type="text/javascript" src="${ctx}/resources/My97DatePicker/WdatePicker.js" defer="defer"></script>

</body>
</html>