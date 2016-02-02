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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.xinyue.authe.AutheManage;
import com.xinyue.manage.beans.PageInfo;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.SelectDao;
/**
 * modify ywh 2015-11-30 downLoadFile
 */
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
		HSSFSheet sheet = wb.createSheet(sheetName);
		
		//在sheet中添加表头第1行
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
	 * modify ywh 2015-11-30 
	 * @param response
	 */
	public void downLoadFile(HttpServletResponse response, String filePath) {
		 response.setContentType("text/html;charset=utf-8");  
		
		// 下载文件名
		String fileName = "";
		BufferedInputStream bis = null;  
        BufferedOutputStream bos = null;  
	
		try {
			// 文件名+文件后缀取得
			int lastindex = filePath.lastIndexOf("/");

			if (lastindex != -1) {
				fileName = filePath.substring(lastindex + 1);
			}


			// 下载文件名字与类型
			long fileLength = new File(filePath).length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength)); 
			bis = new BufferedInputStream(new FileInputStream(filePath));  
            bos = new BufferedOutputStream(response.getOutputStream());  
            byte[] buff = new byte[2048];  
            int bytesRead;  
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
                bos.write(buff, 0, bytesRead);  
            }  
			bos.flush();
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bos.close();
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
	
	public static String createCode(String url , String path){
		File folder = new File(path);
		if(!folder.exists()){
			folder.mkdirs();
		}
		MultiFormatWriter multiFormatWriter= new MultiFormatWriter();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddss");
		String date = df.format(new Date(System.currentTimeMillis()));
		
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		//纠错等级
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		//余白
		hints.put(EncodeHintType.MARGIN, 1);
		try {
			BitMatrix bitMatrix = multiFormatWriter.encode(url, BarcodeFormat.QR_CODE, 150, 150, hints);
			//输出位置
			File file = new File(path, date+"_qrCode.jpg");
			
			MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file);
			
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	
	/**
	 * add by lzc     date: 2015年12月29日
	 * @param filePath
	 * @return
	 */
	public static String read(String filePath) {
		String code = "UTF-8";
		String fileContent = "";
		File file = new File(filePath);
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), code);
			BufferedReader reader = new BufferedReader(read);
			String line;
			while ((line = reader.readLine()) != null) {
				fileContent = fileContent + line + "\n";
			}
			read.close();
			reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			fileContent = null;
		}
		return fileContent;
	}
	
	
	
}
