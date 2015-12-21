package com.imark.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.imark.system.model.Xzcf;
import com.imark.system.model.Xzxk;

/**
 * 信用芜湖-行政许可和行政处罚文件的读取
 * @author lwzhang
 *
 */
public class ExcelReader {
	/**
	 * 行政许可
	 * 读取office 2003 xls
	 * @param filePath
	 */
	public List<Xzxk> loadXzxkXls(InputStream in) {
		List<Xzxk> xzxkList = new ArrayList<Xzxk>();
		try {
			POIFSFileSystem fs = new POIFSFileSystem(in);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			
			int line = getCntLineXls(sheet);
			for (int i = line; i < sheet.getPhysicalNumberOfRows(); i++) {
				HSSFRow row = sheet.getRow(i);
				// 判断一行内容是否为空
				if(row == null || row.getCell(0)==null || row.getCell(0).toString().trim().equals("")) {
					continue;
				}
				// 判断单元格
				if(row.getCell(0).toString().indexOf("填表注意事项") == -1) {
					Xzxk xzxk = new Xzxk();
					xzxk.setXxfl(row.getCell(0) == null ? null : row.getCell(0).toString());
					// 序号
					xzxk.setXh(row.getCell(1) == null ? null : numbericToStringXls(row.getCell(1)));
					xzxk.setJdswh(row.getCell(2) == null ? null : decimalNoFormatXls(row.getCell(2)));
					xzxk.setGwyw(row.getCell(3) == null ? null : row.getCell(3).toString());
					xzxk.setSdyj(row.getCell(4) == null ? null : row.getCell(4).toString());
					xzxk.setXmmc(row.getCell(5) == null ? null : row.getCell(5).toString());
					xzxk.setSplb(row.getCell(6) == null ? null : row.getCell(6).toString());
					// 信用代码
					xzxk.setXydm(row.getCell(7) == null ? null : decimalNoFormatXls(row.getCell(7)));
					// 生效日期
					xzxk.setTakeEffectDate(row.getCell(8) == null ? null : getFmtDateXls(row.getCell(8)));
					// 失效日期
					xzxk.setLostEffectDate(row.getCell(9) == null ? null : getFmtDateXls(row.getCell(9)));
					xzxk.setCbbm(row.getCell(10) == null ? null : row.getCell(10).toString());
					xzxk.setQtgtspbm(row.getCell(11) == null ? null : row.getCell(11).toString());
					xzxk.setBljg(row.getCell(12) == null ? null : row.getCell(12).toString());
					xzxk.setXkdx(row.getCell(13) == null ? null : row.getCell(13).toString());
					
					xzxkList.add(xzxk);
				} else {
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return xzxkList;
	}
	
	/**
	 * 行政处罚
	 * 读取office 2003 xls
	 * @param filePath
	 */
	public List<Xzcf> loadXzcfXls(InputStream in) {
		List<Xzcf> xzcfList = new ArrayList<Xzcf>();
		try {
			POIFSFileSystem fs = new POIFSFileSystem(in);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			
			int line = getCntLineXls(sheet);
			for (int i = line; i < sheet.getPhysicalNumberOfRows(); i++) {
				HSSFRow row = sheet.getRow(i);
				// 判断一行内容是否为空
				if(row == null || row.getCell(0)==null || row.getCell(0).toString().trim().equals("")) {
					continue;
				}
				// 判断单元格
				if(row.getCell(0).toString().indexOf("填表注意事项") == -1) {
					Xzcf xzcf = new Xzcf();
					xzcf.setXxfl(row.getCell(0) == null ? null : row.getCell(0).toString());
					// 序号
					xzcf.setXh(row.getCell(1) == null ? null : numbericToStringXls(row.getCell(1)));					
					xzcf.setJdswh(row.getCell(2) == null ? null : decimalNoFormatXls(row.getCell(2)));
					xzcf.setGwyw(row.getCell(3) == null ? null : row.getCell(3).toString());						
					xzcf.setZfyj(row.getCell(4) == null ? null : row.getCell(4).toString());
					xzcf.setAjmc(row.getCell(5) == null ? null : row.getCell(5).toString());
					// 信用代码
					xzcf.setXydm(row.getCell(6) == null ? null : decimalNoFormatXls(row.getCell(6)));
					xzcf.setCfsy(row.getCell(7) == null ? null : row.getCell(7).toString());
					xzcf.setCfjg(row.getCell(8) == null ? null : row.getCell(8).toString());
					xzcf.setCflxfs(row.getCell(9) == null ? null : row.getCell(9).toString());
					// 生效日期
					xzcf.setSxrq(row.getCell(10) == null ? null : getFmtDateXls(row.getCell(10)));
					xzcf.setCfqx(row.getCell(11) == null ? null : row.getCell(11).toString());
					xzcf.setCfbm(row.getCell(12) == null ? null : row.getCell(12).toString());
					// 结案日期
					xzcf.setJarq(row.getCell(13) == null ? null : getFmtDateXls(row.getCell(13)));
					xzcf.setJjqd(row.getCell(14) == null ? null : row.getCell(14).toString());
					xzcf.setCfdx(row.getCell(15) == null ? null : row.getCell(15).toString());
					
					xzcfList.add(xzcf);
				} else {
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return xzcfList;
	}

	/**
	 * 行政许可
	 * 读取office 2007 xlsx
	 * @param filePath
	 */
	public List<Xzxk> loadXzxkXlsx(InputStream in) {
		// 构造 XSSFWorkbook 对象，strPath 传入文件路径
		XSSFWorkbook xwb = null;
		List<Xzxk> xzxkList = new ArrayList<Xzxk>();
		try {
			xwb = new XSSFWorkbook(in);
		} catch (IOException e) {
			System.out.println("读取文件出错");
			e.printStackTrace();
		}
		// 读取第一章表格内容
		XSSFSheet sheet = xwb.getSheetAt(0);
		xwb.getSheetAt(1);
		// 定义 row、cell
		XSSFRow row;
		int line = getCntLineXlsx(sheet);
		// 循环输出表格中的内容  
		for (int i = line; i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			// 判断一行内容是否为空
			if(row == null || row.getCell(0)==null || row.getCell(0).toString().trim().equals("")) {
				continue;
			}
			// 判断单元格下边框是否为黑色， 内容截止
			if(row.getCell(0).toString().indexOf("填表注意事项") == -1) {
				Xzxk xzxk = new Xzxk();
				xzxk.setXxfl(row.getCell(0) == null ? null : row.getCell(0).toString());
				// 序号
				xzxk.setXh(row.getCell(1) == null ? null : numbericToStringXlsx(row.getCell(1)));					
				xzxk.setJdswh(row.getCell(2) == null ? null : decimalNoFormatXlsx(row.getCell(2)));
				xzxk.setGwyw(row.getCell(3) == null ? null : row.getCell(3).toString());						
				xzxk.setSdyj(row.getCell(4) == null ? null : row.getCell(4).toString());
				xzxk.setXmmc(row.getCell(5) == null ? null : row.getCell(5).toString());
				xzxk.setSplb(row.getCell(6) == null ? null : row.getCell(6).toString());
				// 信用代码
				xzxk.setXydm(row.getCell(7) == null ? null : decimalNoFormatXlsx(row.getCell(7)));
				// 生效日期
				xzxk.setTakeEffectDate(row.getCell(8) == null ? null : getFmtDateXlsx(row.getCell(8)));
				// 失效日期
				xzxk.setLostEffectDate(row.getCell(9) == null ? null : getFmtDateXlsx(row.getCell(9)));
				xzxk.setCbbm(row.getCell(10) == null ? null : row.getCell(10).toString());
				xzxk.setQtgtspbm(row.getCell(11) == null ? null : row.getCell(11).toString());
				xzxk.setBljg(row.getCell(12) == null ? null : row.getCell(12).toString());
				xzxk.setXkdx(row.getCell(13) == null ? null : row.getCell(13).toString());
				xzxkList.add(xzxk);
			} else {
				continue;
			}
		}
		
		return xzxkList;
	}
	
	/**
	 * 行政处罚
	 * 读取office 2007 xlsx
	 * @param filePath
	 */
	public List<Xzcf> loadXzcfXlsx(InputStream in) {
		// 构造 XSSFWorkbook 对象，strPath 传入文件路径
		XSSFWorkbook xwb = null;
		List<Xzcf> xzcfList = new ArrayList<Xzcf>();
		try {
	    	xwb = new XSSFWorkbook(in);		    	
		} catch (Exception e) {
			System.out.println("读取文件出错");
			e.printStackTrace();
		}
		// 读取第一章表格内容
		XSSFSheet sheet = xwb.getSheetAt(0);
		xwb.getSheetAt(1);
		// 定义 row、cell
		XSSFRow row;
		int line = getCntLineXlsx(sheet);
		// 循环输出表格中的内容  
		for (int i = line; i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			// 判断一行内容是否为空
			if(row == null || row.getCell(0)==null || row.getCell(0).toString().trim().equals("")) {
				continue;
			}
			
			// 判断单元格
			if(row.getCell(0).toString().indexOf("填表注意事项") == -1) {
				Xzcf xzcf = new Xzcf();
				xzcf.setXxfl(row.getCell(0) == null ? null : row.getCell(0).toString());
				// 序号
				xzcf.setXh(row.getCell(1) == null ? null : numbericToStringXlsx(row.getCell(1)));					
				xzcf.setJdswh(row.getCell(2) == null ? null : decimalNoFormatXlsx(row.getCell(2)));
				xzcf.setGwyw(row.getCell(3) == null ? null : row.getCell(3).toString());						
				xzcf.setZfyj(row.getCell(4) == null ? null : row.getCell(4).toString());
				xzcf.setAjmc(row.getCell(5) == null ? null : row.getCell(5).toString());
				// 信用代码
				xzcf.setXydm(row.getCell(6) == null ? null : decimalNoFormatXlsx(row.getCell(6)));
				xzcf.setCfsy(row.getCell(7) == null ? null : row.getCell(7).toString());
				xzcf.setCfjg(row.getCell(8) == null ? null : row.getCell(8).toString());
				xzcf.setCflxfs(row.getCell(9) == null ? null : row.getCell(9).toString());
				// 生效日期
				xzcf.setSxrq(row.getCell(10) == null ? null : getFmtDateXlsx(row.getCell(10)));
				xzcf.setCfqx(row.getCell(11) == null ? null : row.getCell(11).toString());
				xzcf.setCfbm(row.getCell(12) == null ? null : row.getCell(12).toString());
				// 结案日期
				xzcf.setJarq(row.getCell(13) == null ? null : getFmtDateXlsx(row.getCell(13)));
				xzcf.setJjqd(row.getCell(14) == null ? null : row.getCell(14).toString());
				xzcf.setCfdx(row.getCell(15) == null ? null : row.getCell(15).toString());
				
				xzcfList.add(xzcf);
			} else {
				continue;
			}
		}
		
		return xzcfList;
	}
	
	/**
	 * 获得具体内容所在行数 office 2003 xls
	 * @return
	 */
	public int getCntLineXls(HSSFSheet sheet) {
		for (int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++) {
			HSSFRow row = sheet.getRow(i);
			// 判断一行内容是否为空
			if(row == null || row.getCell(0)==null || row.getCell(0).toString().trim().equals("")) {
				continue;
			}
			//判断 "信息分类" 所在行
			if(row.getCell(0).toString().trim().indexOf("填表注意事项") == -1 && row.getCell(0).toString().trim().equals("信息分类")) {
				return i+1;
			}
		}
		return 0;
	}
	
	/**
	 * 获得具体内容所在行数 office 2007 xlsx
	 * @return
	 */
	public int getCntLineXlsx(XSSFSheet sheet) {
		for (int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			// 判断一行内容是否为空
			if(row == null || row.getCell(0)==null || row.getCell(0).toString().trim().equals("")) {
				continue;
			}
			//判断 "信息分类" 所在行
			if(row.getCell(0).toString().trim().indexOf("填表注意事项") == -1 && row.getCell(0).toString().trim().equals("信息分类")) {
				return i+1;
			}
		}
		return 0;
	}
	
	/**
	 * 符点型数字转成字符串    office 2003 xls
	 * @return
	 */
	public String numbericToStringXls(HSSFCell cell) {
		String cellStr = "";
		if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			cellStr = String.valueOf(cell.toString().trim().subSequence(0, cell.toString().trim().length()-2));
		} else {
			cellStr = cell.toString();			
		}
		
		return cellStr;
	}
	
	/**
	 * 符点型数字转成字符串   office 2007 xlsx
	 * @return
	 */
	public String numbericToStringXlsx(XSSFCell cell) {
		String cellStr = "";
		if(cell.getCellType() == 0) {
			cellStr = String.valueOf(cell.toString().trim().subSequence(0, cell.toString().trim().length()-2));
		} else {
			cellStr = cell.toString();					
		}
		
		return cellStr;
	}
	
	/**
	 * 大数去除科学计数格式  office 2003 xls
	 * @return
	 */
	public String decimalNoFormatXls(HSSFCell cell) {
		if(cell.getCellType() == 0) {
			DecimalFormat df = new DecimalFormat("0");
			return df.format(cell.getNumericCellValue());						
		} else {
			return cell.toString();
		}
	}
	
	/**
	 * 大数去除科学计数格式  office 2007 xlsx
	 * @return
	 */
	public String decimalNoFormatXlsx(XSSFCell cell) {
		if(cell.getCellType() == 0) {
			DecimalFormat df = new DecimalFormat("0");
			return df.format(cell.getNumericCellValue());						
		} else {
			return cell.toString();
		}
	}
	
	/**
	 * 时间格式转换    office 2003 xls
	 * @param cell
	 * @return
	 */
	public String getFmtDateXls(HSSFCell cell) {
		String cellStr = "";
		if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			if(cell.getNumericCellValue() >= 10000 && cell.getNumericCellValue() <= 100000) {
				cellStr = new SimpleDateFormat("yyyy/MM/dd").format(cell.getDateCellValue());
			} else {
				cellStr = cell.toString();
			}
		} else {
			cellStr = cell.toString();
		}
		
		return cellStr;
	}
	
	/**
	 * 时间格式转换    office 2007 xlsx
	 * @param cell
	 * @return
	 */
	public String getFmtDateXlsx(XSSFCell cell) {
		String cellStr = "";
		if(cell.getCellType() == 0) {
			if(Double.parseDouble(cell.getRawValue()) >= 10000 && Double.parseDouble(cell.getRawValue()) <= 100000) {
				cellStr = new SimpleDateFormat("yyyy/MM/dd").format(cell.getDateCellValue());
			} else {
				cellStr = cell.toString();
			}
		} else {
			cellStr = cell.toString();
		}
		
		return cellStr;
	}
	
	public static void main(String[] args) {
		ExcelReader reader = new ExcelReader();
		InputStream in = null;
		try {
			in = new FileInputStream(new File("D:/555.xls"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<Xzxk> xzxks = reader.loadXzxkXls(in);
		System.out.println(xzxks);
	}
}