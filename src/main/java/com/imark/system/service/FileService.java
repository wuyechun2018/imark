package com.imark.system.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imark.common.util.IUtil;
import com.imark.system.dao.FileDao;

@Component
public class FileService {
	
	@Autowired
	private FileDao fileDaoImpl;
	
	/***
	 * 
	 * @Description：上传至FTP
	 *
	 * @date：2015-9-28 下午02:53:50
	 *
	 * @author ：wuyechun
	 */
	public String uploadToFTP(InputStream is,String remotePath){
		String result="";
		FTPClient ftpClient=null;
		try {
			ftpClient=new FTPClient();
			
			ftpClient.connect("59.203.153.19", 21);
			if (FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
				if (ftpClient.login("xf2015", "wh@ifly.2015")) {
					
					// 设置PassiveMode传输，被动模式
					ftpClient.enterLocalPassiveMode();
					// 设置以二进制流的方式传输
					ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
					
					if (remotePath.contains("/")) {
						//获取其文件夹路径
						String directory = remotePath.substring(0,remotePath.lastIndexOf("/") + 1);
						// 切换工作目录
						if (!directory.equalsIgnoreCase("/")&& !ftpClient.changeWorkingDirectory(directory)) {
							// 如果远程目录不存在，则递归创建远程服务器目录
							int start = 0;
							int end = 0;
							if (directory.startsWith("/")) {
								start = 1;
							} else {
								start = 0;
							}
							end = directory.indexOf("/", start);
							while (true) {
								String subDirectory = remotePath.substring(
										start, end);
								if (!ftpClient
										.changeWorkingDirectory(subDirectory)) {
									if (ftpClient.makeDirectory(subDirectory)) {
										ftpClient
												.changeWorkingDirectory(subDirectory);
									} else {
										result = "";
									}
								}
								start = end + 1;
								end = directory.indexOf("/", start);
								// 检查所有目录是否创建完毕
								if (end <= start) {
									break;
								}
							}
						}
					}

					String remoteFileName = remotePath.substring(remotePath.lastIndexOf("/") + 1);
					//is =new FileInputStream(new File("C:\\Users\\wuyechun\\Desktop\\down\\芜湖社管数据对接情况统计20150925.xlsx"));
					//处理中文乱码问题
					if (ftpClient.storeFile(new String(remoteFileName.getBytes("GBK"),"iso-8859-1"), is)) {
						result = remotePath;
					} else {
						result = "";
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(is!=null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		if (ftpClient.isConnected()) {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	
	/***
	 * 
	 * 功能 :根据文件类型,获取远程路径
	
	 * 开发：ycwu3 2015-6-23
	
	 * @param fileType 文件类型
	 * @param srcType  系统标志
	 * @param bizId    业务主键
	 * @return
	 */
	public  String getRemotePath(String foldName,String deptName,String fileName){
		return "7days"+"/"+foldName+"/"+deptName+"/"+fileName;
	}


	/**
	 * 
	 * @Description：文件名称添加备注
	 *
	 * @date：2015-9-28 下午03:17:21
	 *
	 * @author ：wuyechun
	 */
	public String combineFileName(String fileName, String curDate) {
		if(IUtil.isNotBlank(fileName)){
			String suffix=fileName.substring(fileName.lastIndexOf("."), fileName.length());
			String part=fileName.substring(0,fileName.lastIndexOf("."));
			return part+"-"+curDate+suffix ;
		}else{
			return fileName;
		}
		
	}


	/**
	 * 
	 * @Description：FTP下载
	 *
	 * @date：2015-9-29 下午04:08:42
	 *
	 * @author ：wuyechun
	 */
	public InputStream download(String ftpPath) {
		ByteArrayOutputStream bos = null;
		FTPClient ftpClient=new FTPClient();
		
		try {
			//ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.connect("59.203.153.19", 21);
			if (ftpClient.login("xf2015", "wh@ifly.2015")){
				// 设置PassiveMode传输，被动模式
				ftpClient.enterLocalPassiveMode();
				//ftpClient.setControlEncoding("GBK");    
				//FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);    
				//conf.setServerLanguageCode("zh");    
				//ftpClient.configure(conf);
				
				bos = new ByteArrayOutputStream();
				ftpClient.retrieveFile(new String(ftpPath.getBytes("GBK"),"iso-8859-1"), bos);
				//bos.flush();
			}
			return new ByteArrayInputStream(bos.toByteArray());
		} catch (IOException e) {
			return null;
		}finally {
			if(bos != null){
				try {
					bos.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
