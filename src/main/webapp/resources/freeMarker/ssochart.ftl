{
    		   title: {
    		       text: "日志分析",
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
    		           data: [1, 333, 9, 27, 81, 247, 741, 1223, 6669]

    		       },
    		       {
    		           name: "更新",
    		           type: "line",
    		           data: [111, 2, 4, 8, 16, 32, 64, 128, 856]

    		       }
    		   ]
  }