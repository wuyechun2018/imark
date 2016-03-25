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

function submitForm(){
	/**
	$('#rightForm').form('submit',{
		url:'${ctx}/sysMenu/save',
        onSubmit:function(op){
        	//return $(this).form('validate');
        	return true;
        },
        success:function(data){
        	var obj=eval('('+ data+ ')');
        	$.messager.alert('提示',obj.msg);
        }
      });**/
      if($("#rightForm").form('validate')){  
		 $.ajax({
	         type: "POST",
	         url:'${ctx}/sysDic/save',
	         data: $('#rightForm').serialize(),
	         success: function (data) {
	        	 //var obj=eval('('+ data+ ')');
	         	$.messager.alert('提示',data.msg);
	         	$("#leftTree").tree("options").url='${ctx}/sysMenu/getChildList?pid=0' 
	            $("#leftTree").tree("reload");
	         	
	         },
	         error: function(data) {
	             alert("error:"+data.responseText);
	          }
	
	     });
     }
	
	
}


	$(function() {
		//禁用按钮
		$('#saveBtn').linkbutton('disable');
		$('#resetBtn').linkbutton('disable');
		
		//加载权限菜单树
		$('#leftTree').tree({
					checkbox : false,
					url : '${ctx}/sysDic/getChildList?pid=0',
					method : 'post',
					onBeforeExpand : function(node, param) {
					   $('#leftTree').tree('options').url = ctx+ "/sysDic/getChildList?pid=" + node.id;
					},
					onClick : function(node) {
							
						    //$('#dicName').val(node.text);
						    //注意,此处是 "easyui-textbox",不能用jquery的赋值方法
						    var pNode=$('#leftTree').tree('getParent',node.target);
						    if(pNode){
						      $('#parentDicName').textbox('setValue',pNode.text);
						    }else{
						      $('#parentDicName').textbox('setValue','');
						    }
						   
						    $("#id").val(node.id);
						    $("#pid").val(node.attributes.pid);
						    $("#dicName").textbox('setValue',node.text);
						    $("#disOrder").textbox('setValue',node.text);
						   
						    
						    //字典类型
						    if(node.attributes.dicType=='1'){
	                			  //$('#radio_zrc').attr('checked',true);
	                			  //解决chrome下问题
	                			  $('#dicType_zdlb').prop('checked', 'checked');
	                		  }else{
	                			  $('#dicType_zdx').prop('checked', 'checked');
	                		  }
						    //是否在用
						    if(node.attributes.isUse=='Y'){
	                			  //$('#radio_zrc').attr('checked',true);
	                			  //解决chrome下问题
	                			  $('#is_use_y').prop('checked', 'checked');
	                		  }else{
	                			  //$('#radio_jlx').attr('checked',true);
	                			  $('#is_use_n').prop('checked', 'checked');
	                		  }
						    
						    $("#dicCode").textbox('setValue',node.attributes.dicCode);
						    $("#dicMemo").textbox('setValue',node.attributes.dicMemo);
						    $('#disOrder').textbox('setValue',node.attributes.disOrder);
						    

					},
					onLoadSuccess : function(node, data) {
						//默认展开根节点
						var rooNode = $("#leftTree").tree('getRoot');
						//$("#leftTree").tree('expand',rooNode.target);
						$("#leftTree").tree('expandAll');

					},
					onContextMenu: function(e, node){  
                        e.preventDefault();  
                        $('#leftTree').tree('select', node.target);  
                        $('#mm').menu('show', {  
                            left: e.pageX,  
                            top: e.pageY  
                        });
                        $("#mm").menu({
		                    onClick : function (item) {
		                    	//启用按钮
		                    	$('#saveBtn').linkbutton('enable');
		                    	$('#resetBtn').linkbutton('enable');
		                    	
		                    	if(item.name=='add'){
		                    		//增加
		                    		$('#rightForm').form('clear');
		                    		$("#pid").val(node.id);
		                    		 $('#parentDicName').textbox('setValue',node.text);
								    $('#is_use_y').prop('checked', 'checked');
								    //默认字典项
								    $('#dicType_zdx').prop('checked', 'checked');
		                    		
		                    	}else if(item.name=='delete'){
		                    		//删除
		                    		$.messager.confirm("删除确认", "您确认删除选定的记录吗？", function (action) {
						            if (action) {
						            	$.ajax({
						        			cache: true,
						        			type: "POST",
						        			url:'${ctx}/sysDic/delete',
						        			data:{
						        				id:node.id
						        			},
						        			async: false,
						        		    error: function(request) {
						        		        alert("Connection error");
						        		    },
						        		    success: function(data) {
						        		    	//$.messager.alert('提示信息',data.msg);
						        		    	$("#leftTree").tree("options").url='${ctx}/sysDic/getChildList?pid=0' 
						        		        $("#leftTree").tree("reload");
						        		    	$('#rightForm').form('clear');
						        		    	
						        		    	//$("#leftTree").tree('expand',node.target);
						        		    }
						        		
						        		})
						            }
						            })
		                    		
		                    	}else{
		                    		//修改
		                    		var pNode=$('#leftTree').tree('getParent',node.target);
		  						    if(pNode){
		  						      $('#parentdicName').textbox('setValue',pNode.text);
		  						    }else{
		  						      $('#parentdicName').textbox('setValue','');
		  						    }
		  						   
		  						  
								    $("#id").val(node.id);
								    $("#pid").val(node.attributes.pid);
								    $("#dicName").textbox('setValue',node.text);
								    $("#disOrder").textbox('setValue',node.text);
								   
								    
								    //字典类型
								    if(node.attributes.dicType=='1'){
			                			  //$('#radio_zrc').attr('checked',true);
			                			  //解决chrome下问题
			                			  $('#dicType_zdlb').prop('checked', 'checked');
			                		  }else{
			                			  $('#dicType_zdx').prop('checked', 'checked');
			                		  }
								    //是否在用
								    if(node.attributes.isUse=='Y'){
			                			  //$('#radio_zrc').attr('checked',true);
			                			  //解决chrome下问题
			                			  $('#is_use_y').prop('checked', 'checked');
			                		  }else{
			                			  //$('#radio_jlx').attr('checked',true);
			                			  $('#is_use_n').prop('checked', 'checked');
			                		  }
								    
								    $("#dicCode").textbox('setValue',node.attributes.dicCode);
								    $("#dicMemo").textbox('setValue',node.attributes.dicMemo);
								    $('#disOrder').textbox('setValue',node.attributes.disOrder);
		                    		
		                    	}
		                    	//alert(node.text);
		                    	//alert(item.name);
		                    }
		                });
                        
                        
                    }
					
					
					
				});
	})
</script>



</head>
<body>
<div class="easyui-layout" style="width:700px;height:700px;" fit="true">
        <div data-options="region:'west',split:true,title:'字典类型'" style="width: 240px; padding: 1px;">
            <div>
             <ul id="leftTree"></ul>
            </div>
        </div>
        <div id="tb" data-options="region:'center',title:'字典项'" style="padding:5px;height:auto">                
            <div style="padding:10px 60px 20px 60px">
		    <form id="rightForm" method="post">
		    	<table cellpadding="5" width="360px;">
		    		<tr>
		    			<td style="width:80px;">字典类别:</td>
		    			<td>
		    				<input type="hidden" name="pid" id="pid"></input>
		    				<input class="easyui-textbox" type="text" id="parentDicName" name="parentDicName" data-options="required:true" style="width:100%;"></input>
		    			</td>
		    		</tr>
		    		
		    		<tr>
		    			<td>字典类型：</td>
						<td class="radioAlign">
						<input type="radio" id="dicType_zdlb" name="dicType"value="1" checked="checked" style="vetical-align:middle" />
						<label for="dicType_zdlb"  >字典类别</label>
						<input  type="radio" id="dicType_zdx" name="dicType" value="2"  />
						<label for="dicType_zdx"  >字典项</label>
						</td>
		    		</tr>
		    		
		    		
		    		<tr>
		    			<td style="width:80px;">字典名称:</td>
		    			<td>
		    				<input type="hidden" name="id"  id="id"></input>
		    				<input class="easyui-textbox" type="text" id="dicName" name="dicName" data-options="required:true" style="width:100%;"></input>
		    			</td>
		    		</tr>
		    		
		    		<tr>
		    			<td>字典编码:</td>
		    			<td><input class="easyui-textbox" type="text" id="dicCode" name="dicCode"  style="width:100%;"></input></td>
		    		</tr>
		    		
		    		
		    		
		    		<tr>
		    			<td>是否在用：</td>
						<td class="radioAlign">
						<input type="radio" id="is_use_y" name="isUse"value="Y" checked="checked" style="vetical-align:middle" />
						<label for="is_use_y"  >是</label>
						<input  type="radio" id="is_use_n" name="isUse" value="N"  />
						<label for="is_use_n"  >否</label>
						</td>
		    		</tr>
		    		
		    		<tr>
		    			<td>排序:</td>
		    			<td><input class="easyui-numberbox" type="text" id="disOrder" name="disOrder"  data-options="required:true" style="width:100%;"></input></td>
		    		</tr>
		    		<tr>
		    			<td>备注:</td>
		    			<td><input class="easyui-textbox" id="dicMemo" name="dicMemo" data-options="multiline:true" style="width:100%;height:60px"></input></td>
		    		</tr>
		    		
		    	</table>
		    </form>
		    <div style="text-align:center;padding-top:5px">
		    	<a href="javascript:void(0)" data-options="iconCls:'Pagesave'" id="saveBtn" class="easyui-linkbutton" onclick="submitForm()">确定</a>
		    		&nbsp;&nbsp;&nbsp;&nbsp;
		    	<a href="javascript:void(0)" data-options="iconCls:'Arrowredo'" id="resetBtn" class="easyui-linkbutton"  onclick="clearForm()">取消</a>
		    </div>
	    </div>
        </div>
    </div>
    
    <div id="mm" class="easyui-menu" style="display: none;">
 		 <div id="mm-tabclose" data-options="iconCls:'Applicationadd'" name="add">添加</div>
        <div id="mm-tabcloseall" data-options="iconCls:'Applicationdelete'" name="delete">删除</div>
        <div id="mm-tabcloseother" data-options="iconCls:'Applicationedit'" name="edit">修改</div>
 	</div>

</body>
</html>