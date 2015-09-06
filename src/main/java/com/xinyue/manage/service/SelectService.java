package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Select;

/**
 * 
 * @author wenhai.you
 * @2015年5月18日
 * @上午9:32:06
 */
public interface SelectService {

	/**
	 * 根据字典code查找相应的数据
	 * @param code
	 * @return
	 */
	public List<Select> findSelectByCode(String code);
	
	/**
	 * 显示
	 * @param code
	 * @return
	 */
	public String showValue(Select select);
	
	//mzj add 2015/06/03 start
	public List<SelectInfo> findSelectByType(String code);
	
	/**获取部分的键值对
	 * add by lzc     date: 2015年9月1日
	 * @param code
	 * @param number ->需要的键集合
	 * @return
	 */
	public List<SelectInfo> findSelectByTypePart(String code, int[] number);
	
	/**
	 * 检索省
	 * @return
	 */
	public List<SelectInfo> findProvince();

	/**
	 * 根据省id查找市
	 * @param id 省id
	 * @return list
	 */
	public List<SelectInfo> findCitiesByProvinceCode(String code);

	/**
	 * 根据市id查找地区
	 * @param id 市id
	 * @return list
	 */
	public List<SelectInfo> findZonesByCityCode(String code);
	//mzj add 2015/06/03 end
	
	public List<Select> getIndustryList();
	
	public List<Select> getOrgList();
	
	
	/**获取所有产品列表
	 * add by lzc     date: 2015年8月26日
	 * @return key->id, value->name
	 */
	public List<SelectInfo> getProductList();
}
