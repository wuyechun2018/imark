<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--放置的位置要特别注意,不能放在第三行,否则会有一些样式问题 --%>
<%@ include file="/WEB-INF/views/easyui.jsp" %>
<link href="${ctx}/resources/styles/main.css" rel="stylesheet" media="screen">
<title>IMark</title>

<style type="text/css">
.tabs li a.tabs-inner{
	border-radius:0 0 0 0;
}



</style>


<script type="text/javascript">
function addTab(params) {
	var iframe = '<iframe src="' + params.url + '" frameborder="0" style="border:0;width:100%;height:98%;"></iframe>';
	var mainTab = $('#mainTabs');
	var opts = {
		title : params.title,
		closable : true,
		iconCls : params.iconCls,
		content : iframe,
		border : false,
		fit : true
	};
	if (mainTab.tabs('exists', opts.title)) {
		mainTab.tabs('select', opts.title);
	} else {
		mainTab.tabs('add', opts);
	}
}

function closeTab(menu, type) {
    var allTabs = $("#mainTabs").tabs("tabs");
    var len = allTabs.length;
    var index = $(menu).data("index");
    if ("cur" == type) {
        $("#mainTabs").tabs("close", index);
    } else if ("all" == type) {
        for (var i = 0; i < len; i++) {
            $("#mainTabs").tabs("close", 0);
        }
    } else if ("oth" == type) {
        for (var i = 0; i < len; i++) {
            if (index > i) {
                $("#mainTabs").tabs("close", 0);
            } else {
                $("#mainTabs").tabs("close", 1);
            }
        }
    }
}

//添加默认tab
function addDefault(){
	var param=new Object();
  	 param.url=ctx+'/resources/data/_content.html?version='+Math.random();
	 param.title='主页';
	 addTab(param);
}


$(function(){
	
	   $('#mainTabs').tabs({
		  	 onClose:function(title,index){
		    	  if(index==0){
		    		  addDefault();
		    	  }
		      },
		      onContextMenu: function(e, title, index){
		    	  e.preventDefault();

		    	  
		             $('#mm').menu('show', {
		                 left: e.pageX,
		                 top: e.pageY
		             }).data("index", index);
		             $("#mm").menu({
		                    onClick : function (item) {
		                        closeTab(this, item.name);
		                    }
		                });
		      }
		     });
	
	   addDefault();  
	
	
	//权限树
	$('#permission_tree').tree({      
      url: "${ctx}/resources/data/permission.json?date="+new Date().getTime(),  
      method:'get', 
      onClick:function(node){
    	  var param=new Object();
    	  param.url=ctx+node.attributes.url;
    	  param.title=node.text;
    	  addTab(param);
      }
		      
	});
	
	$('#jk_tree').tree({      
	      url: "${ctx}/resources/data/jk.json?date="+new Date().getTime(),  
	      method:'get', 
	      onClick:function(node){
	    	  var param=new Object();
	    	  param.url=ctx+node.attributes.url;
	    	  param.title=node.text;
	    	  addTab(param);
	      }
			      
		}); 
	
	
	
})

</script>



</head>
<body class="welcome_body">


<div id="mm" class="easyui-menu" style="display: none;">
  <div id="mm-tabclose" data-options="iconCls:'icon_cancle'" name="cur">关闭当前</div>
        <div id="mm-tabcloseall" data-options="iconCls:'icon_cross'" name="all">关闭全部</div>
        <div id="mm-tabcloseother" data-options="iconCls:'icon_no'" name="oth">关闭其他</div>
 </div>

<div class="easyui-layout" fit="true">
		<div data-options="region:'north'" style="height:50px">
			<div id="topbar" class="top-bar">
                <div class="top-bar-left">
                    <h1 style="margin-left: 10px; margin-top: 10px;color: #fff">
                    	<img src="${ctx}/resources/images/imark.png" style="vertical-align:middle">
                    	<span style="vertical-align:middle;font-family: STXingkai;font-size:30px;">IMark</span>
                    </h1>
                </div>
                
                <div class="top-bar-right">
                  	<span class="top-bar-user"> <strong>${CURRENT_USER.loginAccount}</strong>,欢迎您！</span>
                </div>
                
            </div>
            <%-- 
             <div id="toolbar" >
                <div id="infobar">
                    <span >
                      		您好
                    </span>
                </div>
               
                <div id="buttonbar">
                    
                </div>
            </div>
			--%>
		</div>
		<div data-options="region:'south',split:true" style="height:30px;" class="ibackgroud">
			<div class="south-bottom">Copyright © 2015 Imark. All Rights Reserved 京ICP备 0001XXX号     建议分辨率:1280*800 |关于我们</div>
		</div>
		
		<div data-options="region:'east',split:true,border: true,iconCls: 'icon-standard-date'" title="日历" style="width:210px;">
			<div id="eastLayout" class="easyui-layout" data-options="fit: true">
                <div data-options="region: 'north', split: false, border: false" style="height: 220px;">
                    <div class="easyui-calendar" data-options="fit: true, border: false"></div>
                </div>
                <div id="linkPanel" data-options="region: 'center', border: false, title: '通知', iconCls: 'icon-hamburg-link', tools: [{ iconCls: 'icon-hamburg-refresh', handler: function () { window.link.reload(); } }]">
                    <ul class="easyui-tree" data-options="url:'${ctx}/resources/data/tree_data.json',method:'get',animate:true,dnd:true"></ul>
                </div>
            </div>
			
			
		</div>
		<div data-options="region:'west',split:true, border: true,iconCls: 'icon-hamburg-library'" title="导航" style="width:200px;font-family: Microsoft YaHei;" >
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="我的年轮"  style="padding:10px;" >
					<ul class="easyui-tree" data-options="url:'${ctx}/resources/data/tree_data.json',method:'get',animate:true,dnd:true"></ul>
				</div>
				<div title="权限管理"  data-options="selected:true" style="padding:10px;">
					<ul id="permission_tree"></ul>
				</div>
				<div title="系统监控" style="padding:10px">
					<ul id="jk_tree"></ul>
				</div>
			</div>
		</div>
		<div data-options="region:'center',title:'工作区',iconCls:'icon-ok'">
			<div id="mainTabs"  data-options="fit:true,border:false,plain:true">
				
				<%-- <div title="主页" data-options="href:'${ctx}/resources/data/_content.html?version=133'" style="padding:10px"></div>
				
				<div title="我的轨迹" style="padding:5px">
					<table class="easyui-datagrid"
							data-options="url:'${ctx}/resources/data/datagrid_data.json',method:'get',singleSelect:true,fit:true,fitColumns:true">
						<thead>
							<tr>
								<th data-options="field:'itemid'" width="80">Item ID</th>
								<th data-options="field:'productid'" width="100">Product ID</th>
								<th data-options="field:'listprice',align:'right'" width="80">List Price</th>
								<th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
								<th data-options="field:'attr1'" width="150">Attribute</th>
								<th data-options="field:'status',align:'center'" width="50">Status</th>
							</tr>
						</thead>
					</table>
				</div> --%>
				
			</div>
		</div>
	</div>


</body>
</html>