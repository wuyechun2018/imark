package com.imark.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by wyc on 2017/9/21.
 * 演示直接在APP中加载配置文件，获取数据库连接，进行数据库查找操作；
 */
public class ApplicationUseDemo {

    public static void main(String[]args){
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/spring/applicationContext.xml");
        //中心库数据源
        JdbcTemplate jdbcTemplateCenter=(org.springframework.jdbc.core.JdbcTemplate) context.getBean("jdbcTemplateCenter");

        String sql="select T.SERVICE_CODE,T.SERVICE_NAME from VIEW_GSB_SERVICE t WHERE T.APP_CODE='3402-0008'";
        List<Map<String, Object>> list=jdbcTemplateCenter.queryForList(sql);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).get("SERVICE_NAME"));
        }
    }


}
