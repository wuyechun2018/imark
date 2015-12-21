package com.imark.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IFileUtil {
	
	
	// new File("/ftp-temp/"+localPath)  当前盘的根目录  ftp-temp 路径
	
	
	/**
	 * 
	 * @Description：将byte[]转成文件
	 *
	 * @date：2015-10-22 上午10:04:10
	 *
	 * @author ：wuyechun
	 */
	public static void byteToFile(byte[] fileByte, String filePath) throws IOException {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File(filePath));
            os.write(fileByte);
            os.flush();
        } finally {
            if (os != null){
            	 os.close();
            }
               
        }
    }
	
	/**
	 * 
	 * @Description：文件转成二进制数据组
	 *
	 * @date：2015-10-22 上午10:05:34
	 *
	 * @author ：wuyechun
	 */
	public static byte[] covertFileToBytes(String path) throws IOException {
        byte[] b = null;
        InputStream is = null;
        File f = new File(path);
        try {
            is = new FileInputStream(f);
            b = new byte[(int) f.length()];
            is.read(b);
        } finally {
            if (is != null)
                is.close();
        }
        return b;
    }


}
