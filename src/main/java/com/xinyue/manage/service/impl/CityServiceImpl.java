package com.xinyue.manage.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.CityInfo;
import com.xinyue.manage.beans.SearchCity;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.CityInfoDAO;
import com.xinyue.manage.model.City;
import com.xinyue.manage.model.Province;
import com.xinyue.manage.model.SubStation;
import com.xinyue.manage.model.Zone;
import com.xinyue.manage.service.CityService;
import com.xinyue.manage.util.CommonFunction;

/**
 * 城市分站Service
 * @author MK)茅
 *
 */
@Service
public class CityServiceImpl implements CityService {

	@Resource
	private CityInfoDAO cityInfoDAO;
	
	private Logger log = Logger.getLogger(CityServiceImpl.class);
	
	@Override
	public Province getProvinceById(int id) {
		
		return cityInfoDAO.selectProvinceById(id);
	}

	@Override
	public List<CityInfo> getCityInfoByIndex(int index) {
		
		return cityInfoDAO.getCityInfoByIndex(index);
	}

	@Override
	public int getCount() {
		
		return cityInfoDAO.getCityInfoCount();
	}

	@Override
	public List<SelectInfo> getAllProvince() {
		
		List<SelectInfo> list = null;
		List<Province> provinces = cityInfoDAO.getAllProvince();
		
		if (provinces != null && provinces.size() > 0) {
			list = new ArrayList<SelectInfo>();
			for (Province province : provinces) {
				SelectInfo selectInfo = new SelectInfo();
				selectInfo.setKey(province.getCode());
				selectInfo.setValue(province.getName());
				
				list.add(selectInfo);
			}
		}
		return list;
	}

	@Override
	public List<SelectInfo> getCitiesByProvinceId(String id) {
		
		List<SelectInfo> list = null;
		List<City> cities = cityInfoDAO.getCitiesByProvinceId(id);
		
		if (cities != null && cities.size() > 0) {
			list = new ArrayList<SelectInfo>();
			for (City city : cities) {
				SelectInfo selectInfo = new SelectInfo();
				selectInfo.setKey(city.getCode());
				selectInfo.setValue(city.getName());
				
				list.add(selectInfo);
			}
		}
		
		return list;
	}

	@Override
	public List<SelectInfo> getZonesByCityId(String id) {
	
		List<SelectInfo> list = null;
		List<Zone> zones = cityInfoDAO.getZonesByCityId(id);
		
		if (zones != null && zones.size() > 0) {
			list = new ArrayList<SelectInfo>();
			for (Zone zone : zones) {
				SelectInfo selectInfo = new SelectInfo();
				selectInfo.setKey(zone.getCode());
				selectInfo.setValue(zone.getName());
				
				list.add(selectInfo);
			}
		}
		
		return list;
	}

	@Override
	public boolean addOrUpdateSubStationInfo(SubStation substationInfo,String user) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_ss");
		
		HashMap<String, String> parameterMap = new HashMap<>();

		parameterMap.put("subName", substationInfo.getSubName());
		parameterMap.put("provinceId", substationInfo.getSelectedP());
		parameterMap.put("cityId", substationInfo.getSelectedC());
		parameterMap.put("zoneId", substationInfo.getSelectedZ());
		parameterMap.put("firstL", substationInfo.getFirstLetter());
		if (substationInfo.isHot()) {
			parameterMap.put("hot", "1");	
		}else {
			parameterMap.put("hot", "0");
		}
		parameterMap.put("user", user);
		parameterMap.put("del", "0");

		
		try {
			//已存在
			String ret = cityInfoDAO.getCityInfoExsitByName(substationInfo.getSubName());
			if (ret != null) {
				parameterMap.put("code", substationInfo.getStationCode());
				cityInfoDAO.updateSubStation(parameterMap);
			}else {
				String code = df.format(new Date());
				parameterMap.put("code", code);
				cityInfoDAO.addSubStation(parameterMap);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
		
		return true;
	}

	@Override
	public boolean deleteSubStation(String code) {
		try {
			cityInfoDAO.deleteSubStationByCode(code);
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}

	@Override
	public SubStation selectSubStation(String code) {
		
		SubStation temp = cityInfoDAO.selectSubStationByCode(code);
		temp.setSelectedCHid(temp.getSelectedC());
		temp.setSelectedZHid(temp.getSelectedZ());
		
		return temp;
	}

	@Override
	public List<CityInfo> getCityInfoBySearchConditions(SearchCity searchCity) {
		
		return cityInfoDAO.getCityInfoBySearchConditions(searchCity);
	}

	@Override
	public int getCountBySearchConditions(SearchCity searchCity) {
		
		return cityInfoDAO.getCountBySearchConditions(searchCity);
	}

	@Override
	public boolean findZoneByCode(String code) {
		
		try {
			int result = cityInfoDAO.findZoneByCode(code);
			
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return false;
	}

	@Override
	public String[] getCitiesByPy(String pinyin) {
		
		List<City> cityList = null;
		String[] cityArray = null;
		
		cityList = cityInfoDAO.getCitiesByPy(pinyin);
		
		if (cityList != null && cityList.size()>0) {
			cityArray = new String[cityList.size()];
			for (int i = 0; i < cityList.size(); i++) {
				cityArray[i] = cityList.get(i).getName();
			}
		}
		return cityArray;
	}

	@Override
	public List<Province> findProvince() {
		return cityInfoDAO.findProvince();
	}

	@Override
	public String[] findCitiesByParentId(String code) {
		
		List<City> cityList = cityInfoDAO.getCitiesByProvinceId(code);
		String[] cityArray = null;
		
		if (cityList != null && cityList.size()>0) {
			cityArray = new String[cityList.size()];
			for (int i = 0; i < cityList.size(); i++) {
				cityArray[i] = cityList.get(i).getName();
			}
		}
		return cityArray;
	}

	@Override
	public String findCityByCode(String code) {
		
		return cityInfoDAO.findCityByCode(code);
	}

	@Override
	public String findCityCodeByName(String cityName) {
		
		if (cityName.equals(CommonFunction.getValue("quanbu"))) {
			return "000000";
		}
		return cityInfoDAO.findCityCodeByName(cityName);
	}

	@Override
	public List<City> findServerZones() {
		return cityInfoDAO.findServerZones();
	}

}
