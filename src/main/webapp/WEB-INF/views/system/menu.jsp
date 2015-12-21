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
$(function(){
	$('#menu_tb').datagrid({  
		url:ctx+'/resources/data/datagrid_data.json',
		method:'get',
		title:"菜单管理",
		fit:true,
		fitColumns:true,
		striped: true,//奇偶行是否区分
		singleSelect:true,
		pagination: true,  
		rownumbers: true,  
		columns:[[
		          {field:'itemid',title: '来Item ID',align: 'center',width: 100},
		          {field:'productid',title: 'productid',align: 'center',width: 100}, 
		          {field:'listprice',title: 'listprice',align: 'center',width: 100}, 
		          {field:'attr1',title: 'attr1',align: 'center',width: 100}, 
		          {field:'status',title: 'status',align: 'center',width: 100}
		]],
		toolbar:$('#c_tb')
		//,footer:$('#ft')

		})

		$('#menu_tb').datagrid('getPanel').removeClass(
				'lines-both lines-no lines-right lines-bottom').addClass(
				'lines-both');

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
	
	
	
</script>



</head>
<body>

<%-- 
<div class="easyui-layout" fit="true">
		<div data-options="region:'west',split:true, border: false" title="菜单树" style="width:200px;" >
			<ul class="easyui-tree" data-options="url:'${ctx}/resources/data/tree_data.json',method:'get',animate:true,dnd:true"></ul>
		</div>
		<div data-options="region:'center',border: false,title:'Main Title',iconCls:'icon-ok'">
			<div class="easyui-panel" title="New Topic" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" method="post">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>Name:</td>
	    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Email:</td>
	    			<td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Subject:</td>
	    			<td><input class="easyui-textbox" type="text" name="subject" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Message:</td>
	    			<td><input class="easyui-textbox" name="message" data-options="multiline:true" style="height:60px"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Language:</td>
	    			<td>
	    				<select class="easyui-combobox" name="language"><option value="ar">Arabic</option><option value="bg">Bulgarian</option><option value="ca">Catalan</option><option value="zh-cht">Chinese Traditional</option><option value="cs">Czech</option><option value="da">Danish</option><option value="nl">Dutch</option><option value="en" selected="selected">English</option><option value="et">Estonian</option><option value="fi">Finnish</option><option value="fr">French</option><option value="de">German</option><option value="el">Greek</option><option value="ht">Haitian Creole</option><option value="he">Hebrew</option><option value="hi">Hindi</option><option value="mww">Hmong Daw</option><option value="hu">Hungarian</option><option value="id">Indonesian</option><option value="it">Italian</option><option value="ja">Japanese</option><option value="ko">Korean</option><option value="lv">Latvian</option><option value="lt">Lithuanian</option><option value="no">Norwegian</option><option value="fa">Persian</option><option value="pl">Polish</option><option value="pt">Portuguese</option><option value="ro">Romanian</option><option value="ru">Russian</option><option value="sk">Slovak</option><option value="sl">Slovenian</option><option value="es">Spanish</option><option value="sv">Swedish</option><option value="th">Thai</option><option value="tr">Turkish</option><option value="uk">Ukrainian</option><option value="vi">Vietnamese</option></select>
	    			</td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
	    </div>
	    </div>
		</div>
</div>
--%>

<div class="easyui-layout" style="width:700px;height:700px;" fit="true">
        <div data-options="region:'west',split:true,title:'菜单树'" style="width: 300px; padding: 1px;">
            <div>
              <ul class="easyui-tree" data-options="url:'${ctx}/resources/data/tree_data.json',method:'get',animate:true,dnd:true"></ul>
            </div>
        </div>
        <div id="tb" data-options="region:'center',title:'菜单编辑'" style="padding:5px;height:auto">                
            <div style="padding:10px 60px 20px 60px">
		    <form id="ff" method="post">
		    	<table cellpadding="5">
		    		<tr>
		    			<td>Name:</td>
		    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
		    		</tr>
		    		<tr>
		    			<td>Email:</td>
		    			<td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
		    		</tr>
		    		<tr>
		    			<td>Subject:</td>
		    			<td><input class="easyui-textbox" type="text" name="subject" data-options="required:true"></input></td>
		    		</tr>
		    		<tr>
		    			<td>Message:</td>
		    			<td><input class="easyui-textbox" name="message" data-options="multiline:true" style="height:60px"></input></td>
		    		</tr>
		    		<tr>
		    			<td>Language:</td>
		    			<td>
		    				<select class="easyui-combobox" name="language"><option value="ar">Arabic</option><option value="bg">Bulgarian</option><option value="ca">Catalan</option><option value="zh-cht">Chinese Traditional</option><option value="cs">Czech</option><option value="da">Danish</option><option value="nl">Dutch</option><option value="en" selected="selected">English</option><option value="et">Estonian</option><option value="fi">Finnish</option><option value="fr">French</option><option value="de">German</option><option value="el">Greek</option><option value="ht">Haitian Creole</option><option value="he">Hebrew</option><option value="hi">Hindi</option><option value="mww">Hmong Daw</option><option value="hu">Hungarian</option><option value="id">Indonesian</option><option value="it">Italian</option><option value="ja">Japanese</option><option value="ko">Korean</option><option value="lv">Latvian</option><option value="lt">Lithuanian</option><option value="no">Norwegian</option><option value="fa">Persian</option><option value="pl">Polish</option><option value="pt">Portuguese</option><option value="ro">Romanian</option><option value="ru">Russian</option><option value="sk">Slovak</option><option value="sl">Slovenian</option><option value="es">Spanish</option><option value="sv">Swedish</option><option value="th">Thai</option><option value="tr">Turkish</option><option value="uk">Ukrainian</option><option value="vi">Vietnamese</option></select>
		    			</td>
		    		</tr>
		    	</table>
		    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
	    </div>
	    </div>
        </div>
    </div>

</body>
</html>