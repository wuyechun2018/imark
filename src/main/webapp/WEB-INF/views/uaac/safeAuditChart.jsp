<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/WEB-INF/views/easyui.jsp"%>
<script type="text/javascript" src="${ctx}/resources/esl/esl-1.6.10.js"></script>
<link href="${ctx}/resources/styles/easyui-flat.css" rel="stylesheet"
	media="screen">
<link href="${ctx}/resources/styles/uaac.css" rel="stylesheet"
	media="screen">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
<title>安全审计日志分析</title>
</head>
<body>
<body>
	<div class="easyui-layout" fit="true">
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
										<th>查看类型：</th>
										<td>
											<div class="form-control">
												<span class="r"></span> <span class="l"></span>
												 <span class="c">
												 	<input class="iradio" type="radio" id="week" name="showType" value="1" checked="checked" /><label for="week" class="ilabel">按周显示</label>
													<input class="iradio" type="radio" id="month" name="showType" value="2" /><label for="month" class="ilabel">按月显示</label>
													<input class="iradio" type="radio" id="year" name="showType" value="3" /><label for="year" class="ilabel">按年显示</label>
												</span>
											</div></td>
										
										<th>查询日期：</th>
										<td>
											<div class="form-control">
												<span class="r"></span> <span class="l"></span> <span
													class="c"> <input id="startDate" style="width: 40%"
													class="text" type="text"
													onFocus="var endDate=$dp.$('endDate');WdatePicker({onpicked:function(){},maxDate:'#F{$dp.$D(\'endDate\')}', readOnly:true})" />
													<span style="padding-left: 5px; padding-right: 10px;">~</span>
													<input id="endDate" style="width: 40%" class="text"
													type="text"
													onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}', readOnly:true})" />
												</span>
											</div></td>
									</tr>
									

									<tr>
										<td colspan="4" class="text-right"><a
											class="btn btn-primary" id="queryBtn" href="javascript:;">
												<span class="l"></span> <span class="c" id="search" style="color:#333"><i
													class="icon icon-query"></i>查询</span><span class="r"></span> </a></td>
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
					<div class="btns"></div>

					<div class="arc arc-tl"></div>
					<div class="arc arc-tr"></div>
				</div>
				<div class="body">
					<div id="ichart" style="height: 400px;"></div>
				</div>
			</div>
		</div>
	</div>




<script type="text/javascript"> 
var myChart;
$(function(){
	
	//查询按钮事件
	$('#search').click(function(){
		refreshChart();
		
	});
	
	//文件类型 单选框绑定事件
	$("input[name='showType']").click(function(){
        	var id= $(this).attr("id");
        	//行政许可
        	if(id=='week'){
        		//周
        		var myDate = new Date();
        		myDate.setDate(myDate.getDate()-7);
        		$("#startDate").val(myDate.format("yyyy-MM-dd")); 
        		
        		$("#endDate").val(new Date().format("yyyy-MM-dd"));
        		
        		refreshChart();
        		
        	}else if(id=='month'){
        		//月
				var myDate = new Date();
        		myDate.setMonth(myDate.getMonth()-1);
        		$("#startDate").val(myDate.format("yyyy-MM-dd")); 
        		
        		$("#endDate").val(new Date().format("yyyy-MM-dd"));
        		
        		refreshChart();
        	}else{
        		//年
        		var myDate = new Date();
        		myDate.setFullYear(myDate.getFullYear()-1);
        		$("#startDate").val(myDate.format("yyyy-MM-dd"));
        		
				$("#endDate").val(new Date().format("yyyy-MM-dd"));
        		
				
        		
        		refreshChart();
        	}
       });
	
	 //$("input[name='showType'][value=2]").attr("checked",'true');
	  //默认选中
	  //$("input[name='showType'][value=1]").trigger('click');
	  
	  //设置默认时间
	  var myDate = new Date();
      myDate.setDate(myDate.getDate()-7);
      $("#startDate").val(myDate.format("yyyy-MM-dd")); 
      $("#endDate").val(new Date().format("yyyy-MM-dd"));
	 
	  require.config({
		    paths: {
		        "echarts": ctx+"/resources/echarts-2.2.7/echarts"
		    }
		});
		require(
				[
		         "echarts",
		         "echarts/chart/line"
		         ],
		function(ec) {
		   myChart = ec.init(document.getElementById("ichart"));
		   var option=new Object();
			//发送Ajax请求,获取展示数据
			 $.ajax({
					type: "post",
					url: ctx+"/log/getSafeChart",
					dataType:"json",
			        async:false, 
					data:{
							startDate:$('#startDate').val(),
							endDate:$('#endDate').val(),
							showType:$('input:radio[name="showType"]:checked').val()
			              },
				    cache :false,
			        success: function(result){
			        	var resultObj = eval("(" + result + ")");
			        	option=resultObj;
					}
				 });
		     myChart.setOption(option);
		});
	
})

function refreshChart(){
	 //alert($('input:radio[name="showType"]:checked').attr('id'));
	 myChart.hideLoading();
	 $.ajax({
			type: "post",
			url: ctx+"/log/getSafeChart",
			dataType:"json",
	        async:false, 
			data:{
					startDate:$('#startDate').val(),
					endDate:$('#endDate').val(),
					showType:$('input:radio[name="showType"]:checked').val()
	              },
		    cache :false,
	        success: function(result){
	        	var resultObj = eval("(" + result + ")");
	        	option=resultObj;
				myChart.setOption(option, true);
			}
		 });
}



</script>
	<script type="text/javascript"
		src="${ctx}/resources/My97DatePicker/WdatePicker.js" defer="defer"></script>
</body>
</body>
</html>