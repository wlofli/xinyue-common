package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Select;

/**
 * 
 * @author wenhai.you
 * @2015年5月18日
 * @上午9:27:12
 */
public interface SelectDao {

	/**
	 * 根据字典code查找相应的数据
	 * @param code
	 * @return
	 */
	List<Select> findSelectByCode(@Param("code") String code);
	
	/**
	 * 显示
	 * @param code
	 * @return
	 */
	public String showValue(Select select);
	
	List<SelectInfo> findSelectByType(String type);

	/**
	 * 查找省
	 * @return
	 */
	List<SelectInfo> findProvince();

	List<SelectInfo> findCitiesByProvinceId(@Param("code")String code);

	List<SelectInfo> findZonesByCityId(@Param("code")String code);
	
	List<Select> getIndustryList();
	
	public List<Select> getOrgList();
}
