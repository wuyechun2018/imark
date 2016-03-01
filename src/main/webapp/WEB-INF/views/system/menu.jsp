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
	$('#menuForm').form('submit',{
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
	 $.ajax({
         type: "POST",
         url:'${ctx}/sysMenu/save',
         data: $('#menuForm').serialize(),
         success: function (data) {
        	 //var obj=eval('('+ data+ ')');
         	$.messager.alert('提示',data.msg);
         	$("#menuTree").tree("options").url='${ctx}/sysMenu/getChildList?pid=0' 
            $("#menuTree").tree("reload");
         	
         },
         error: function(data) {
             alert("error:"+data.responseText);
          }

     });
	
	
	
}


	$(function() {
		//禁用按钮
		$('#saveBtn').linkbutton('disable');
		$('#resetBtn').linkbutton('disable');
		
		//加载权限菜单树
		$('#menuTree').tree({
					checkbox : false,
					url : '${ctx}/sysMenu/getChildList?pid=0',
					method : 'post',
					onBeforeExpand : function(node, param) {
					   $('#menuTree').tree('options').url = ctx+ "/sysMenu/getChildList?pid=" + node.id;
					},
					onClick : function(node) {
							
						    //$('#menuName').val(node.text);
						    //注意,此处是 "easyui-textbox",不能用jquery的赋值方法
						    var pNode=$('#menuTree').tree('getParent',node.target);
						    if(pNode){
						      $('#parentMenuName').textbox('setValue',pNode.text);
						    }else{
						      $('#parentMenuName').textbox('setValue','');
						    }
						   
						    $("#menuId").val(node.id);
						    $("#menuPid").val(node.attributes.menuPid);
						    $("#menuName").textbox('setValue',node.text);
						    $("#menuAddr").textbox('setValue',node.attributes.menuAddr);
						    $('#menuType').combobox('setValue',node.attributes.menuType);
						    $('#orderNo').textbox('setValue',node.attributes.orderNo);
						    $('#menuIconUrl').textbox('setValue',node.attributes.menuIconUrl);
						    $("#memo").textbox('setValue',node.attributes.memo);
						    
						    //是否在用
						    if(node.attributes.isUse=='Y'){
	                			  //$('#radio_zrc').attr('checked',true);
	                			  //解决chrome下问题
	                			  $('#is_use_y').prop('checked', 'checked');
	                		  }else{
	                			  //$('#radio_jlx').attr('checked',true);
	                			  $('#is_use_n').prop('checked', 'checked');
	                		  }
						    
						    

					},
					onLoadSuccess : function(node, data) {
						//默认展开根节点
						var rooNode = $("#menuTree").tree('getRoot');
						//$("#menuTree").tree('expand',rooNode.target);
						$("#menuTree").tree('expandAll');

					},
					onContextMenu: function(e, node){  
                        e.preventDefault();  
                        $('#menuTree').tree('select', node.target);  
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
		                    		$('#menuForm').form('clear');
		                    		$("#menuPid").val(node.id);
		                    		$('#parentMenuName').textbox('setValue',node.text);
								    $('#is_use_y').prop('checked', 'checked');
		                    		
		                    	}else if(item.name=='delete'){
		                    		//删除
		                    		$.messager.confirm("删除确认", "您确认删除选定的记录吗？", function (action) {
						            if (action) {
						            	$.ajax({
						        			cache: true,
						        			type: "POST",
						        			url:'${ctx}/sysMenu/delete',
						        			data:{
						        				id:node.id
						        			},
						        			async: false,
						        		    error: function(request) {
						        		        alert("Connection error");
						        		    },
						        		    success: function(data) {
						        		    	//$.messager.alert('提示信息',data.msg);
						        		    	$("#menuTree").tree("options").url='${ctx}/sysMenu/getChildList?pid=0' 
						        		        $("#menuTree").tree("reload");
						        		    	
						        		    	//$("#menuTree").tree('expand',node.target);
						        		    }
						        		
						        		})
						            }
						            })
		                    		
		                    	}else{
		                    		//修改
		                    		var pNode=$('#menuTree').tree('getParent',node.target);
		  						    if(pNode){
		  						      $('#parentMenuName').textbox('setValue',pNode.text);
		  						    }else{
		  						      $('#parentMenuName').textbox('setValue','');
		  						    }
		  						   
		  						    $("#menuId").val(node.id);
		  						    $("#menuPid").val(node.attributes.menuPid);
		  						    $("#menuName").textbox('setValue',node.text);
		  						    $("#menuAddr").textbox('setValue',node.attributes.menuAddr);
		  						    $('#menuType').combobox('setValue',node.attributes.menuType);
		  						    $('#orderNo').textbox('setValue',node.attributes.orderNo);
		  						    $('#menuIconUrl').textbox('setValue',node.attributes.menuIconUrl);
		  						    $("#memo").textbox('setValue',node.attributes.memo);
		  						    
		  						    //是否在用
		  						    if(node.attributes.isUse=='Y'){
		  	                			  //$('#radio_zrc').attr('checked',true);
		  	                			  //解决chrome下问题
		  	                			  $('#is_use_y').prop('checked', 'checked');
		  	                		  }else{
		  	                			  //$('#radio_jlx').attr('checked',true);
		  	                			  $('#is_use_n').prop('checked', 'checked');
		  	                		  }
		  						    
		                    		
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
        <div data-options="region:'west',split:true,title:'系统菜单'" style="width: 240px; padding: 1px;">
            <div>
             <ul id="menuTree"></ul>
            </div>
        </div>
        <div id="tb" data-options="region:'center',title:'菜单编辑'" style="padding:5px;height:auto">                
            <div style="padding:10px 60px 20px 60px">
		    <form id="menuForm" method="post">
		    	<table cellpadding="5" width="360px;">
		    		<tr>
		    			<td style="width:80px;">父级权限:</td>
		    			<td>
		    				<input type="hidden" name="menuPid" id="menuPid"></input>
		    				<input class="easyui-textbox" type="text" id="parentMenuName" name="parentMenuName" data-options="required:true" style="width:100%;"></input>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td style="width:80px;">权限名称:</td>
		    			<td>
		    				<input type="hidden" name="menuId"  id="menuId"></input>
		    				<input class="easyui-textbox" type="text" id="menuName" name="menuName" data-options="required:true" style="width:100%;"></input>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>权限类型:</td>
		    			<td>
		    				<select class="easyui-combobox" id="menuType" name="menuType" style="width:100%;" data-options="editable:false,panelHeight:'auto'" >
			    				<option value="0">文件夹</option>
			    				<option value="1">菜单</option>
			    				<option value="2">按钮</option>
		    				</select>
		    			
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>地址:</td>
		    			<td><input class="easyui-textbox" type="text" id="menuAddr" name="menuAddr"  style="width:100%;"></input></td>
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
		    			<td>图标:</td>
		    			<td><input class="easyui-textbox" type="text" id="menuIconUrl" name="menuIconUrl"  style="width:100%;"></input></td>
		    		</tr>
		    		<tr>
		    			<td>排序:</td>
		    			<td><input class="easyui-numberbox" type="text" id="orderNo" name="orderNo"  data-options="required:true" style="width:100%;"></input></td>
		    		</tr>
		    		<tr>
		    			<td>备注:</td>
		    			<td><input class="easyui-textbox" id="memo" name="memo" data-options="multiline:true" style="width:100%;height:60px"></input></td>
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