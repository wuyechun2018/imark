package com.imark.common.util;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.h2.tools.Server;

public class H2DBServerStartListener implements ServletContextListener{

	 //H2数据库服务器启动实例
    private Server server;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		 if (this.server != null) {
	            // 停止H2数据库
	            this.server.stop();
	            this.server = null;
	        }
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		 try {  
	            System.out.println("正在启动h2数据库...");
	            //使用org.h2.tools.Server这个类创建一个H2数据库的服务并启动服务，由于没有指定任何参数，那么H2数据库启动时默认占用的端口就是8082
	            server = Server.createTcpServer().start(); 
	            System.out.println("h2数据库启动成功...");
	        } catch (SQLException e) {  
	            System.out.println("启动h2数据库出错：" + e.toString());  
	            e.printStackTrace();  
	            throw new RuntimeException(e);  
	        }  
		
	}

}
