package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.CityInfo;
import com.xinyue.manage.beans.SearchCity;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.City;
import com.xinyue.manage.model.Province;
import com.xinyue.manage.model.SubStation;

public interface CityService {

	Province getProvinceById(int id);
	
	List<CityInfo> getCityInfoByIndex(int index);
	
	int getCount();
	
	List<SelectInfo> getAllProvince();
	
	List<SelectInfo> getCitiesByProvinceId(String id);
	
	List<SelectInfo> getZonesByCityId(String id);
	
	boolean addOrUpdateSubStationInfo(SubStation substationInfo,String user);
	
	boolean deleteSubStation(String code);
	
	SubStation selectSubStation(String code);
	
	List<CityInfo> getCityInfoBySearchConditions(SearchCity searchCity);
	
	int getCountBySearchConditions(SearchCity searchCity);

	boolean findZoneByCode(String code);

	
	String[] getCitiesByPy(String pinyin);

	List<Province> findProvince();

	String[] findCitiesByParentId(String code);

	String findCityByCode(String code);

	/**
	 * 根据城市名查询行政区划代码
	 * @param cityName 城市名
	 * @return
	 */
	String findCityCodeByName(String cityName);

	/**
	 * 获取城市
	 * @return
	 */
	List<City> findServerZones();
}
