/*
 * 杭州摩科商用设备有限公司
 * MOKO-Commercial Device Co.,Ltd
 * 
 * 新越网
 * 
 * 创建人：茅
 * 
 * 日期：2015/04/07
 * 
 * 版本v1.0.0
 * 
 * bug修改:
 * 
 * 
 */
package com.xinyue.manage.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.xinyue.authe.AutheManage;
import com.xinyue.manage.beans.PageInfo;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.SelectDao;

public class CommonFunction {

	private static Properties props = new Properties();
	
	@Resource
	private SelectDao selectDao;
	
	Logger log = Logger.getLogger(CommonFunction.class);

	/**
	 * 获得资源文件
	 */
	static {
		try {
			props.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		return props.getProperty(key);
	}

	public static void updateProperties(String key, String value) {
		props.setProperty(key, value);
	}

	/**
	 * 上传文件
	 * 
	 * @param uploadPath
	 *            指定路径
	 * @param fileMap
	 *            文件
	 * @return
	 */
	public boolean fileUpload(String uploadPath,
			HashMap<CommonsMultipartFile, String> fileMap) {

		String realPath = uploadPath;

		try {
			File file = new File(realPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			System.out.println(file.getAbsolutePath());
			// 获得文件名:
			for (Iterator<CommonsMultipartFile> it = fileMap.keySet()
					.iterator(); it.hasNext();) {
				CommonsMultipartFile key = (CommonsMultipartFile) it.next();
				String value = fileMap.get(key);

				String realFileName = key.getOriginalFilename();
				if (!value.equals("")) {
					realFileName = value;
				}

				File uploadFile = new File(realPath + "\\" + realFileName);
				if (key.getSize() != 0) {
					FileCopyUtils.copy(key.getBytes(), uploadFile);
				}

			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 页面分页
	 * 
	 * @param allCount 总条数
	 * @param nowPage 当前页
	 * @return PageInfo 分页类
	 */
	public PageInfo pageList(int allCount, int nowPage) {
		PageInfo page = new PageInfo();
		
		// 总条数
		int totalPge = 0;
		totalPge = allCount / GlobalConstant.PAGE_SIZE;
		if (allCount % GlobalConstant.PAGE_SIZE != 0) {
			totalPge += 1;
		}
		// 设置总页数
		page.setTotalPage(totalPge);
		// 设置当前
		page.setNowPage(nowPage);

		// 设置起始页
		if (page.getNowPage() - 2 <= 0) {
			page.setStartIndex(1);
		} else if (page.getTotalPage() > 5
				&& (page.getNowPage() - 2 >= page.getTotalPage() - 5)) {
			page.setStartIndex(page.getTotalPage() - 5);
		} else {
			page.setStartIndex(page.getNowPage() - 2);
		}
		// 设置末尾页
		if (page.getNowPage() + 2 >= page.getTotalPage()) {
			page.setEndIndex(page.getTotalPage());
		} else {
			page.setEndIndex(page.getNowPage() + 2);
			if (page.getNowPage() + 2 < 5) {
				page.setEndIndex(5);
			}

		}
		return page;
	}
	
	/**
	 * excel数据导出
	 * @param response
	 * @param dataList 数据
	 * @param fileName 文件名
	 * @param sheetName sheet名
	 * @param header 头部标题
	 * @throws Exception 异常
	 */
	public void exportDataToExcel(HttpServletResponse response,String fileName,String sheetName,String[] header,List<String[]> dataList) throws Exception {
		
		byte[] fileNameByte = fileName.getBytes("UTF-8");
		
		String filename = new String(fileNameByte, "UTF-8");
		
		//数据整理
		byte[] bytes = this.formatData(dataList,sheetName,header);
		
		//设置相关下载参数
		response.setContentType("application/x-msdownload");
		response.setContentLength(bytes.length);
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);
		response.getOutputStream().write(bytes);
	}

	/**
	 * excel数据整理
	 * @param dataList
	 * @param sheetName
	 * @param header
	 * @return
	 * @throws IOException
	 */
	private byte[] formatData(List<String[]> dataList,String sheetName,String[] header) throws IOException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		//创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		
		//在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet(GlobalConstant.AUTHENTICATION_SHEET_NAME);
		
		//在sheet中添加表头第0行
		HSSFRow row = sheet.createRow(0);
		
		//创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		//设置表头
	    List<String> excelHead = getExcelHead(header);
	    
	    HSSFCell cell = null;
	    
	    //excel头
	    for (int i = 0; i < excelHead.size(); i++) {
	      cell = row.createCell(i);
	      cell.setCellValue(excelHead.get(i));
	      cell.setCellStyle(style);
	      //设置列宽
	      sheet.setColumnWidth(i, excelHead.get(i).getBytes().length*256);
	    }
	    
	    //写入数据
	    for (int i = 0; i < dataList.size(); i++) {
			row = sheet.createRow(i+1);
			String[] temp = dataList.get(i);
			
			//创建单元格，并设置值
			int j=0;
			
			for (int k = 0; k < temp.length; k++) {
				insertCell(row, j++, temp[k]);
			}
		}
	    
	    wb.write(out);
	    
		return out.toByteArray();
	}
	
	/**
	 * 单元格内容设置
	 * @param row
	 * @param i
	 * @param obj
	 */
	private void insertCell(HSSFRow row, int i, Object obj) {
		if (obj == null) {
			row.createCell(i).setCellValue("");
		} else {
			row.createCell(i).setCellValue(obj.toString());
		}
		
	}

	/**
	 * 头部标题信息设置
	 * @return
	 */
	private List<String> getExcelHead(String[] header) {
		List<String> result = new ArrayList<String>();
		
		for (int i = 0; i < header.length; i++) {
			result.add(header[i]);
		}
		
		return result;
	}
	
	/**
	 * 下拉表信息（m_select_info）
	 * @param type 类型
	 * @return List<SelectInfo>
	 */
	public List<SelectInfo> getSelectByType(String type) {
		
		List<SelectInfo> selectList = null;
		try {
			if (!type.equals("")) {
				selectList = selectDao.findSelectByType(type);
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return selectList;
	}

	private static int BUFF_SIZE = 1024;

	/**
	 * 下载
	 * 
	 * @param response
	 */
	public void downLoadFile(HttpServletResponse response, String filePath) {

		// 文件路径
		// String filePath = "D:/maozj/S8722F.pdf";

		// 下载文件名
		String fileName = "";

		// 输入流
		InputStream is = null;

		try {
			// 文件名+文件后缀取得
			int lastindex = filePath.lastIndexOf("/");

			if (lastindex != -1) {
				fileName = filePath.substring(lastindex + 1);
			}

			// 文件读入
			is = new FileInputStream(filePath);

			response.reset();

			// 下载文件名字与类型
			response.setContentType("text/plain");
			response.addHeader("Content-Disposition", "attachment;filename="
					+ fileName);

			byte[] b = new byte[BUFF_SIZE];

			int length;

			try {
				// 文件输出
				while ((length = is.read(b)) > -1) {
					response.getOutputStream().write(b, 0, length);
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 各画面权限获得
	 * @param model
	 * @param request
	 * @param authNames 权限
	 * @param moduleName 模块名称
	 * @return true:成功;false:失败
	 */
	public boolean getAuth(Model model,HttpServletRequest request,List<String> authNames,String moduleName) {
		
		HashMap<String, Integer> authorities = new HashMap<>();
		
		try {
			for (String temp : authNames) {
				int auth = AutheManage.chkAuthe(request,temp);
				int authT = 0;
				if (auth > 0) {
					authT = 1;
				}
				authorities.put(temp, authT);
			}
			
			model.addAttribute("authorities", authorities);
			log.info(moduleName+"====权限取得成功！");
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
		
		return true;
	}
}
