{
    		   title: {
    		       text: "${title_text}",
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
    		       data: [
	    		       <#list seriesList as chartSeries>
	    	        	 <#if !chartSeries_has_next> 
							"${chartSeries.name}"
						 <#else>
						 	"${chartSeries.name}",
						 </#if> 	
	    	      	   </#list>
    		       ]
    		   },
    		   xAxis: [
    		       {
    		           type: "category",
    		           name: "",
    		           splitLine: {show: false},
    		           data: ${xAxis_data}
    		       }
    		   ],
    		   yAxis: [
    		       {
    		           type: "value",
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
		     	  <#list seriesList as chartSeries>
    	        	 <#if !chartSeries_has_next>
    	        	 { 
						name: "${chartSeries.name}",
						type: "line",
						data: ${chartSeries.data}
					 }
					 <#else>
					 {
					 	name: "${chartSeries.name}",
						type: "line",
						data: ${chartSeries.data}
					 },
					 </#if> 	
    	      	  </#list>
    		   ]
  }