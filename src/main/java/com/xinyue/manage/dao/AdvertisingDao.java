package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.AdvertisingInfo;
import com.xinyue.manage.model.Advertising;

/**
 * 广告Dao
 * @author wenhai.you
 * @2015年5月6日
 * @上午9:25:29
 */
public interface AdvertisingDao{

	/**
	 * 返回当前页的记录数
	 * @param adver 广告vo
	 * @return
	 */
	public  List<Advertising> findForPage(AdvertisingInfo adver);
	
	/**
	 * 获取总记录数
	 * @param type 广告分类
	 * @return
	 */
	public  int getCountByType(@Param("title") String title);
	
	/**
	 * 根据id删除广告
	 * @param id 
	 */
	public  void delByAdvertisingId(@Param("id") String id , @Param("modifyUser") String modifyUser);
	
	/**
	 * 根据id集合删除相应的广告
	 * @param list 装载id
	 */
	public  void delAdvertisingMulti(@Param("list") List<String> list, @Param("modifyUser") String modifyUser);
	
	/**
	 * 添加 广告
	 * @param advert 
	 */
	public  void addAdvert(Advertising advert);
	
	/**
	 * 根据id查找广告
	 * @param id
	 */
	public  Advertising getAdvertById(String id);
	
	/**
	 * 修改广告
	 * @param advert
	 */
	public  void updateAdvert(Advertising advert);
	
	
	/**
	 * 发布广告
	 * @param list
	 */
	public  void updatePublish(@Param("list") List<String> list , @Param("modifyUser") String modifyUser);
	
	
	/**
	 * 屏蔽广告
	 * @param list
	 */
	public  void updateShielding(@Param("list") List<String> list, @Param("modifyUser") String modifyUser);
	
	/**
	 * 检测广告过期则将publish设置为4
	 */
	public  void updateOverdue();
}
