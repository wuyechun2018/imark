package com.imark.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 信用芜湖-行政许可和行政处罚文件的验证
 * @author lwzhang
 *
 */
public class ExcelFmtValid {
	/**
	 * 行政许可
	 * 读取office 2003 xls
	 * @param filePath
	 */
	public Map<String, String> validXzxkXls(InputStream in) {
		Map<String, String> map = new HashMap<String, String>();
		// 默认格式正确
		map.put("flag", "0");
		map.put("message", "上传成功");
		try {
			POIFSFileSystem fs = new POIFSFileSystem(in);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			
			int line = getCntLineXls(sheet);
			// 判断第一条数据所在行
			if(line == 0) {
				map.put("flag", "1");
				map.put("message", "【上传失败】您上传的表格与模板不一致，请重新上传");
				return map;
			}
		
			HSSFRow row;
			for (int i = line; i < sheet.getPhysicalNumberOfRows(); i++) {
				row = sheet.getRow(i);
				// 判断第一个单元格是否为空
				if(row == null || row.getCell(0)==null || row.getCell(0).toString().trim().equals("")) {
					continue;
				}
				if(row.getCell(0).toString().indexOf("填表注意事项") == -1) {
					List<String> xxflList = new ArrayList<String>();
					xxflList.add("公开");  xxflList.add("不公开");  xxflList.add("暂缓公开");
					if(!xxflList.contains(row.getCell(0).toString().trim())) {
						map.put("flag", "1");
						map.put("message", "【上传失败】信息分类为空或格式不正确，请从【公开,不公开,暂缓公开】三选一 【行" + (i+1) + "，列" + 1 +"】");
						return map;
					}
					
					HSSFCell cell8 = row.getCell(8);
					boolean flag8 = dateFmtValidXls(cell8);
					if(!flag8) {
						map.put("flag", "1");
						map.put("message", "【上传失败】生效日期格式不正确，请按照格式\"yyyy/MM/dd\" 【行" + (i+1) + "，列" + 9 +"】");
						return map;
					}
					
					HSSFCell cell9 = row.getCell(9);
					boolean flag9 = dateFmtValidXls(cell9);
					if(!flag9) {
						map.put("flag", "1");
						map.put("message", "【上传失败】失效日期日期格式不正确，请按照格式\"yyyy/MM/dd\" 【行" + (i+1) + "，列" + 10 +"】");
						return map;
					}			
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "1");
			map.put("message", "【上传失败】您上传的表格与模板不一致，请重新上传");
		}
		
		return map;
	}
	
	/**
	 * 行政处罚
	 * 读取office 2003 xls
	 * @param filePath
	 */
	public Map<String, String> validXzcfXls(InputStream in) {
		Map<String, String> map = new HashMap<String, String>();
		// 默认格式正确
		map.put("flag", "0");
		map.put("message", "上传成功");
		try {
			POIFSFileSystem fs = new POIFSFileSystem(in);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			
			int line = getCntLineXls(sheet);
			// 判断第一条数据所在行
			if(line == 0) {
				map.put("flag", "1");
				map.put("message", "【上传失败】您上传的表格与模板不一致，请重新上传");
				return map;
			}
			for (int i = line; i < sheet.getPhysicalNumberOfRows(); i++) {
				HSSFRow row = sheet.getRow(i);
				// 判断第一个单元格是否为空
				if(row == null || row.getCell(0)==null || row.getCell(0).toString().trim().equals("")) {
					continue;
				}
				if(row.getCell(0).toString().indexOf("填表注意事项") == -1) {
					List<String> xxflList = new ArrayList<String>();
					xxflList.add("公开");  xxflList.add("不公开");  xxflList.add("暂缓公开");
					if(!xxflList.contains(row.getCell(0).toString().trim())) {
						map.put("flag", "1");
						map.put("message", "【上传失败】信息分类为空或格式不正确，请从【公开,不公开,暂缓公开】三选一【行" + (i+1) + "，列" + 1 +"】");
						return map;
					}
					
					HSSFCell cell10 = row.getCell(10);
					boolean flag10 = dateFmtValidXls(cell10);
					if(!flag10) {
						map.put("flag", "1");
						map.put("message", "【上传失败】生效日期格式不正确，请按照格式\"yyyy/MM/dd\" 【行" + (i+1) + "，列" + 11 +"】");
						return map;
					}
					
					HSSFCell cell13 = row.getCell(13);
					boolean flag13 = dateFmtValidXls(cell13);
					if(!flag13) {
						map.put("flag", "1");
						map.put("message", "【上传失败】结案日期不正确，请按照格式\"yyyy/MM/dd\" 【行" + (i+1) + "，列" + 14 +"】");
						return map;
					}
				}
			}
		} catch (Exception e) {
			map.put("flag", "1");
			map.put("message", "【上传失败】您上传的表格与模板不一致，请重新上传");
		}
		
		return map;
	}
	
	/**
	 * 行政许可
	 * 读取office 2007 xlsx
	 * @param filePath
	 */
	public Map<String, String> validXzxkXlsx(InputStream in) {
		// 构造 XSSFWorkbook 对象，strPath 传入文件路径
		XSSFWorkbook xwb = null;
		Map<String, String> map = new HashMap<String, String>();
		// 默认格式正确
		map.put("flag", "0");
		map.put("message", "上传成功");
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
		int line = getCntLineXlsx(sheet);
		// 判断第一条数据所在行
		if(line == 0) {
			map.put("flag", "1");
			map.put("message", "【上传失败】您上传的表格与模板不一致，请重新上传");
			return map;
		}
		
		XSSFRow row;
		try {
			// 循环输出表格中的内容  
			for (int i = line; i < sheet.getPhysicalNumberOfRows(); i++) {
				row = sheet.getRow(i);
				// 判断第一个单元格是否为空
				if(row == null || row.getCell(0)==null || row.getCell(0).toString().trim().equals("")) {
					continue;
				}
				if(row.getCell(0).toString().indexOf("填表注意事项") == -1) {
					List<String> xxflList = new ArrayList<String>();
					xxflList.add("公开");  xxflList.add("不公开");  xxflList.add("暂缓公开");
					if(!xxflList.contains(row.getCell(0).toString().trim())) {
						map.put("flag", "1");
						map.put("message", "【上传失败】信息分类为空或格式不正确，请从【公开,不公开,暂缓公开】三选一【行" + (i+1) + "，列" + 1 +"】");
						return map;
					}
					
					XSSFCell cell8 = row.getCell(8);
					boolean flag8 = dateFmtValidXlsx(cell8);
					if(!flag8) {
						map.put("flag", "1");
						map.put("message", "【上传失败】生效日期格式不正确，请按照格式\"yyyy/MM/dd\" 【行" + (i+1) + "，列" + 9 +"】");
						return map;
					}
					
					XSSFCell cell9 = row.getCell(9);
					boolean flag9 = dateFmtValidXlsx(cell9);
					if(!flag9) {
						map.put("flag", "1");
						map.put("message", "【上传失败】失效日期日期格式不正确，请按照格式\"yyyy/MM/dd\" 【行" + (i+1) + "，列" + 10 +"】");
						return map;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "1");
			map.put("message", "【上传失败】您上传的表格与模板不一致，请重新上传");
		}
		
		return map;
	}
	
	/**
	 * 行政处罚
	 * 读取office 2007 xlsx
	 * @param filePath
	 */
	public Map<String, String> validXzcfXlsx(InputStream in) {
		// 构造 XSSFWorkbook 对象，strPath 传入文件路径
		XSSFWorkbook xwb = null;
		Map<String, String> map = new HashMap<String, String>();
		// 默认格式正确
		map.put("flag", "0");
		map.put("message", "上传成功");
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
		// 判断第一条数据所在行
		if(line == 0) {
			map.put("flag", "1");
			map.put("message", "【上传失败】您上传的表格与模板不一致，请重新上传");
			return map;
		}
		try {
			// 循环输出表格中的内容  
			for (int i = line; i < sheet.getPhysicalNumberOfRows(); i++) {
				row = sheet.getRow(i);
				// 判断第一个单元格是否为空
				if(row == null || row.getCell(0)==null|| row.getCell(0).toString().trim().equals("")) {
					continue;
				}
				// 判断单元格下边框是否为黑色， 内容截止
				if(row.getCell(0).toString().indexOf("填表注意事项") == -1) {
					List<String> xxflList = new ArrayList<String>();
					xxflList.add("公开");  xxflList.add("不公开");  xxflList.add("暂缓公开");
					if(!xxflList.contains(row.getCell(0).toString().trim())) {
						map.put("flag", "1");
						map.put("message", "【上传失败】信息分类为空或格式不正确，请从【公开,不公开,暂缓公开】三选一【行" + (i+1) + "，列" + 1 +"】");
						return map;
					}
					
					XSSFCell cell10 = row.getCell(10);
					boolean flag10 = dateFmtValidXlsx(cell10);
					if(!flag10) {
						map.put("flag", "1");
						map.put("message", "【上传失败】生效日期格式不正确，请按照格式 \"yyyy/MM/dd\" 【行" + (i+1) + "，列" + 11 +"】");
						return map;
					}
					
					XSSFCell cell13 = row.getCell(13);
					boolean flag13 = dateFmtValidXlsx(cell13);
					if(!flag13) {
						map.put("flag", "1");
						map.put("message", "【上传失败】结案日期不正确，请按照格式\"yyyy/MM/dd\" 【行" + (i+1) + "，列" + 14 +"】");
						return map;
					}

				}
			}
		} catch (Exception e) {
			map.put("flag", "1");
			map.put("message", "【上传失败】您上传的表格与模板不一致，请重新上传");
		}
		
		return map;
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
	 * 时间格式验证     office 2003 xls
	 * @param cell
	 * @return
	 */
	public boolean dateFmtValidXls(HSSFCell cell) {
		String dateStr = "";
		if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			if(cell.getNumericCellValue() >= 10000 && cell.getNumericCellValue() <= 100000) {
				return true;							
			} else {
				return false;
			}
		} else {
			dateStr = cell.toString();
			if(!dateStr.matches("\\d{4}/\\d{1,2}/\\d{1,2}")) {
				return false;
			}		
		}
		
		return true;
	}
	
	/**
	 * 时间格式验证     office 2007 xlsx
	 * @param cell
	 * @return
	 */
	public boolean dateFmtValidXlsx(XSSFCell cell) {
		String dateStr = "";
		if(cell.getCellType() == 0) {
			if(Double.parseDouble(cell.getRawValue()) >= 10000 && Double.parseDouble(cell.getRawValue()) <= 100000) {
				return true;							
			} else {
				return false;
			}
		} else {
			dateStr = cell.toString();
			if(!dateStr.matches("\\d{4}/\\d{1,2}/\\d{1,2}")) {
				return false;
			}		
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		ExcelFmtValid valid = new ExcelFmtValid();
		try {
			@SuppressWarnings("rawtypes")
			Map map = valid.validXzxkXlsx(new FileInputStream(new File("D:/111.xlsx")));
			System.out.println(map.get("message"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
