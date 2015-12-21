function toolTipCol(val,rec){
		  if (val.length>=50) {
	        showVal = val.substring(0,45) + "...";
	    }
	    return '<span title="'+val+'">'+showVal+'</span>';
}