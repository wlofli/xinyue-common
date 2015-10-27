package com.xinyue.manage.dao;

import java.util.List;

import com.xinyue.manage.model.SubStation;

/**
 * 
 * @author wenhai.you
 * @2015年9月2日
 * @下午6:38:25
 */
public interface CityStationDao {

	/**
	 * ywh 返回所有 城市分站
	 * @return
	 */
	public List<SubStation> findAllStation();
}
