package com.imark.common.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		 String dataType=DBContextHolder.getDBType();
		 if(dataType==null||"".equals(dataType)){
			 dataType="dataSource";
		 }
		 return dataType;
	}

}
