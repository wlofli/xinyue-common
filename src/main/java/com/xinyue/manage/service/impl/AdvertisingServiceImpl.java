package com.xinyue.manage.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.xinyue.manage.beans.AdvertisingInfo;
import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.dao.AdvertisingDao;
import com.xinyue.manage.model.Advertising;
import com.xinyue.manage.service.AdvertisingService;
import com.xinyue.manage.util.GlobalConstant;

/**
 * 
 * @author wenhai.you
 * @2015年5月6日
 * @下午2:05:30
 */
@Service
public class AdvertisingServiceImpl implements AdvertisingService {

	@Resource
	private AdvertisingDao advertisingDao;
	
	private Logger logger = Logger.getLogger(AdvertisingServiceImpl.class);
	@Override
	public List<Advertising> getAdvertising(AdvertisingInfo info) {
		// TODO Auto-generated method stub
		
		return advertisingDao.findForPage(info.getTitle(), 0 , 10);
	}
	@Override
	public PageData<Advertising> findAdvertisingPage(AdvertisingInfo info) {
		// TODO Auto-generated method stub
		String topage = info.getTopage();
		if(!GlobalConstant.isNull(info.getAdtype())){
			
			int type = Integer.valueOf(info.getAdtype());
			
			if( type == 0){
				info.setPageAll(topage);
			}else if(type == 1){
				info.setPageBig(topage);
			}else if(type == 2){
				info.setPageSmall(topage);
			}else{
				info.setPageIn(topage);
			}
		}
		
		String title = info.getTitle();
		switch (title) {
		case "首页大广告":
			topage = info.getPageBig();
			
			break;
		case "首页小广告":
			topage = info.getPageSmall();
			break;
		case "内页广告":
			topage = info.getPageIn();
			break;
		default:
			topage = info.getPageAll();
			break;
		}
		int currentPage = GlobalConstant.isNull(topage) || "0".equals(topage)?1:Integer.valueOf(topage);
		int start = (currentPage - 1)*GlobalConstant.PAGE_SIZE;
		return new PageData<Advertising>(advertisingDao.findForPage(title , start , GlobalConstant.PAGE_SIZE), advertisingDao.getCountByType(title), currentPage);
	}
	
	
	@Override
	public boolean delAdvertisingMulti(List<String> list , String modifyUser) {
		try {
			advertisingDao.delAdvertisingMulti(list , modifyUser);
			logger.info("广告删除成功 id为:"+list+",操作者:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("广告删除失败 id为:"+list+",操作者:"+modifyUser, e);
			return false;
		}
	}
	
	@Override
	public boolean delByAdvertisingId(String id , String modifyUser) {
		// TODO Auto-generated method stub
		try {
			advertisingDao.delByAdvertisingId(id , modifyUser);
			logger.info("广告删除成功 id为:"+id+",操作者:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("广告删除失败 id为:"+id+",操作者:"+modifyUser, e);
			return false;
		}
	}
	
	
	@Override
	public Advertising getAdvertById(String id) {
		// TODO Auto-generated method stub
		return advertisingDao.getAdvertById(id);
	}
	
	
	
	@Override
	public boolean updatePublish(List<String> list , String modifyUser) {
		// TODO Auto-generated method stub
		try {
			advertisingDao.updatePublish(list , modifyUser);
			logger.info("发布广告成功 数据为:"+list+",发布者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("发布广告失败 数据为:"+list+",发布者为:"+modifyUser, e);
			return false;
		}
	}
	
	@Override
	public boolean updateShielding(List<String> list , String modifyUser) {
		// TODO Auto-generated method stub
		try {
			advertisingDao.updateShielding(list , modifyUser);
			logger.info("屏蔽广告成功 数据为:"+list+",屏蔽者为:"+modifyUser);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("屏蔽广告失败 数据为:"+list+",屏蔽者为:"+modifyUser, e);
			return false;
		}
	}
	
	private String _filterStr(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			switch (c) {
			case '\"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '/':
				sb.append("\\/");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			default:
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	@Override
	public boolean saveAdvert(Advertising advertedit, String modifyUser) {
		// TODO Auto-generated method stub
		
		String id = advertedit.getId();
		if(GlobalConstant.isNull(id)){
			try {
				//添加 
				String thumbnail = advertedit.getThumbnail();
				String tempImg = TEMP_PATH + thumbnail;
				String realImg = REAL_PATH + "advert/ad/" + thumbnail;
				File pathFile = new File(REAL_PATH + "advert/ad/");
				if (!pathFile.exists()) {
					pathFile.mkdirs();
				}
				
				File tempFile =  new File(tempImg);
				File realFile =  new File(realImg);
				
				try {
					FileCopyUtils.copy(tempFile, realFile);
				} catch (IOException e) {
					logger.error(e.getMessage() ,e);
					e.printStackTrace();
				}
				advertedit.setDeleted(0);
				advertedit.setDirectory("advert/ad/");
				id = thumbnail.substring(0, thumbnail.indexOf("."));
				
				advertedit.setId(id);
				
				advertedit.setCreateUser(modifyUser);
				advertisingDao.addAdvert(advertedit);
				logger.info("添加广告成功"+advertedit+",添加者为:"+modifyUser);
				return true;
			} catch (Exception e) {
				logger.error("添加广告失败"+advertedit, e);
				return false;
			}
			
		}else{
			try {
				//修改
				String thumbnail = advertedit.getThumbnail();
				String tempImg = TEMP_PATH + thumbnail;
				String realImg = REAL_PATH + "advert/ad/" + thumbnail;
				
				File tempFile =  new File(tempImg);
				File realFile =  new File(realImg);
				
				try {
					
					FileCopyUtils.copy(tempFile, realFile);
				} catch (IOException e) {
					logger.error(e.getMessage() , e);
					e.printStackTrace();
				}
				
				advertedit.setUpdateUser(modifyUser);
				
				advertisingDao.updateAdvert(advertedit);
				logger.info("修改广告成功"+advertedit+",修改者为:"+modifyUser);
				return true;
			} catch (Exception e) {
				logger.error("修改广告失败"+advertedit , e);
				return false;
			}
			
		}
	}
	
	@Override
	public String upload(String suffix , HttpServletRequest req) {
		// TODO Auto-generated method stub
		File dir = new File(TEMP_PATH);
		if(!dir.exists()){
			dir.mkdirs();
		}
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(req.getServletContext());
		
		if (resolver.isMultipart(req)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) req;
			
			Iterator<String> iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				String fileName = iter.next();
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssms");
				String code = new StringBuffer("ad_").append(df.format(new java.sql.Date(System.currentTimeMillis()))).toString();
				MultipartFile file = multiRequest.getFile(fileName);
				
				File uploadFile = new File(TEMP_PATH+code+"."+suffix);
								
				try {
					FileCopyUtils.copy(file.getBytes(), uploadFile);
					String retPath = DOWN_PATH+code+"."+suffix;
					
					return "{'name':'"+code+"."+suffix+"','path':'"+_filterStr(retPath)+"'}";
				} catch (Exception e) {
					logger.error("上传广告图片失败", e);
					return "fail";
				}
			}
		}
		return "fail";
	}

	@Override
	public List<Advertising> getIndexAD() {
				
		return advertisingDao.getIndexAD();
	}

	@Override
	public Advertising findAdByType(int type) {
		
		List<Advertising> advertisings = advertisingDao.findAdByType(type);
		
		if (advertisings != null && advertisings.size() > 0) {
			return advertisings.get(0);
		}
		return null;
	}
}
