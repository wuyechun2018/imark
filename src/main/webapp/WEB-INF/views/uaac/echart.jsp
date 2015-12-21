<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="/WEB-INF/views/easyui.jsp"%>
<script type="text/javascript" src="${ctx}/resources/esl/esl-1.6.10.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
 <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
<title>echart</title>
</head>
<body>
<body style="margin-bottom: 10px;">
	<div id="main" style="height:500px;"></div>
<script type="text/javascript"> 
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
    var myChart = ec.init(document.getElementById("main"));
    
    var option=new Object();
	//发送Ajax请求,获取展示数据
	 $.ajax({
			type: "post",
			url: ctx+"/log/getSafeChart",
			dataType:"json",
	        async:false, 
			data:{
	              },
		    cache :false,
	        success: function(result){
	        	var resultObj = eval("(" + result + ")");
	        	option=resultObj;
			}
		 });
    /**var option = {
    		   title: {
    		       text: "按时间登录日志分析",
    		       x: "center",
    		       textStyle: {
		    	    	fontSize: 18,
		    	    	fontWeight: 'bolder',
		    	    	color: 'RGB(30,69,110)'
		    		}     

    		   },
    		   tooltip: {
    		       trigger: "item",
    		       formatter: "{a} <br/>{b} : {c}"
    		   },
    		   legend: {
    		       x: 'center',
    		       y :'bottom',
    		       borderWidth:0,
    		       borderColor:'RGB(0,0,0)',
    		       data: ["新增", "更新"]
    		   },
    		   xAxis: [
    		       {
    		           type: "category",
    		           name: "",
    		           splitLine: {show: false},
    		           data: ["一", "二", "三", "四", "五", "六", "七", "八", "九"]
    		       }
    		   ],
    		   yAxis: [
    		       {
    		           type: "log",
    		           name: ""
    		       }
    		   ],
    		    toolbox: {
    		       show: true,
    		       feature: {
    		           mark: {
    		               show: false
    		           },
    		           dataView: {
    		               show: false,
    		               readOnly: false
    		           },
    		           restore: {
    		               show: true
    		           },
    		           saveAsImage: {
    		               show: true
    		           }
    		       }
    		   },
    		   calculable: true,
    		   series: [
    		       {
    		           name: "新增",
    		           type: "line",
    		           data: [1, 3, 9, 27, 81, 247, 741, 2223, 6669]

    		       },
    		       {
    		           name: "更新",
    		           type: "line",
    		           data: [1, 2, 4, 8, 16, 32, 64, 128, 256]

    		       }
    		   ]
    		};**/
    myChart.setOption(option);
});
</script>

</body>
</body>
</html>