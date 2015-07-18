package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.OrganizationInfo;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Organization;

/**
 * 
 * @author wenhai.you
 * @2015年5月16日
 * @下午2:25:04
 */
public interface OrganizationService {

	/**
	 * 根据orginfo查询相应的数据
	 * @param orgInfo
	 * @return
	 */
	public List<Organization> findPageData(OrganizationInfo orgInfo);
	
	
	/**
	 * 根据orginfo查询相应的数据相应的记录数
	 * @param orgInfo
	 * @return
	 */
	public int getOrganizationCount(OrganizationInfo orgInfo);
	
	
	/**
	 * 根据number{java.util.List} 启用
	 * @param list
	 */
	public boolean updateEnable(List<String> list , String modifyUser);
	
	/**
	 * 根据number{java.util.List} 禁用
	 * @param list
	 */
	public boolean updateDisable(List<String> list , String modifyUser);
	
	/**
	 * 修改number{java.uti.List}删除标记marker 
	 * @param list
	 */
	public boolean updateMarker(List<String> list , String modifyUser);
	
	
	
	
	/**
	 * 根据机构编号
	 * @param number
	 * @return
	 */
	public List<Organization> findListByNumber(String number);
	
	/**
	 * 根据机构编号
	 * @param number
	 * @return
	 */
	public List<Organization> editListByNumber(String number);
	
	/**
	 * 添加或修改机构信息
	 * @param list
	 */
	public boolean saveOrganization(String orgedit , String loginName);
	
	/**
	 * 
	 * @param pinying
	 * @return
	 */
	public List<Organization> findOrgNameByPinying(String pinying);

	//add by mzj 2015/07/06 start
	/**
	 * 获得机构列表
	 * @return
	 */
	public List<SelectInfo> getOrganizations();
	//add by mzj 2015/07/06 end
}
