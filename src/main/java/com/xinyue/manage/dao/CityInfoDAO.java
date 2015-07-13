package com.xinyue.manage.dao;

import java.util.HashMap;
import java.util.List;

import com.xinyue.manage.beans.CityInfo;
import com.xinyue.manage.beans.SearchCity;
import com.xinyue.manage.model.City;
import com.xinyue.manage.model.Province;
import com.xinyue.manage.model.SubStation;
import com.xinyue.manage.model.Zone;

public interface CityInfoDAO {
	
	Province selectProvinceById(int id);
	
	List<CityInfo> getCityInfoByIndex(int index);
	
	int getCityInfoCount();
	
	List<Province> getAllProvince();
	
	List<City> getCitiesByProvinceId(String id);
	
	List<Zone> getZonesByCityId(String id);
	
	void addSubStation(HashMap<String, String> parameterMap);
	
	void updateSubStation(HashMap<String, String> parameterMap);
	
	String getCityInfoExsitByName(String name);
	
	void deleteSubStationByCode(String code);
	
	SubStation selectSubStationByCode(String code);
	
	List<CityInfo> getCityInfoBySearchConditions(SearchCity searchCity);
	
	int getCountBySearchConditions(SearchCity searchCity);
}
