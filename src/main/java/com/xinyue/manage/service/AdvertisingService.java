package com.xinyue.manage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xinyue.manage.beans.AdvertisingInfo;
import com.xinyue.manage.model.Advertising;
import com.xinyue.manage.util.CommonFunction;

/**
 * 广告biz
 * @author wenhai.you
 * @2015年5月6日
 * @下午1:54:55
 */
public interface AdvertisingService {

	/**
	 * 根据广告分类显示信息
	 * @param info 广告vo
	 * @return
	 */
	public List<Advertising> getAdvertising(AdvertisingInfo info);
	
	/**
	 * 根据广告分类获取相应的总记录数
	 * @param type 广告分类
	 * @return
	 */
	public int getAdvertCountByType(String title);
	
	/**
	 * 根据id删除广告
	 * @param id 
	 */
	public boolean delByAdvertisingId(String id , String modifyUser);
	
	/**
	 * 根据id集合删除相应的广告
	 * @param list 装载id
	 */
	public boolean delAdvertisingMulti(List<String> list , String modifyUser);
	
	
	/**
	 * 根据id查找广告
	 * @param id
	 */
	public Advertising getAdvertById(String id);
	
	
	/**
	 * 发布广告
	 * @param list
	 */
	public boolean updatePublish(List<String> list , String modifyUser);
	
	public boolean saveAdvert(Advertising advert , String modifyUser);
	public String upload(String suffix , HttpServletRequest req);
	/**
	 * 屏蔽广告
	 * @param list
	 */
	public boolean updateShielding(List<String> list , String modifyUser);
	
	public final static String TEMP_PATH = (new StringBuffer(CommonFunction.getValue("upload.path")).append("advert/temp/")).toString();
	public final static String DOWN_PATH = (new StringBuffer(CommonFunction.getValue("down.path")).append("moko/images/advert/temp/")).toString();
	public final static String REAL_PATH = CommonFunction.getValue("upload.path");
	public final static String SHOW_PATH = CommonFunction.getValue("down.path")+"moko/images/";

	//add by mzj start
	public List<Advertising> getIndexAD();

	public Advertising findAdByType(int type);
	//add by mzj end
}
