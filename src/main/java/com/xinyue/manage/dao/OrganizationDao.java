package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.OrganizationInfo;
import com.xinyue.manage.model.Organization;

/**
 * 
 * @author wenhai.you
 * @2015年5月16日
 * @下午2:23:33
 */
public interface OrganizationDao {

	/**
	 * 根据orginfo查询相应的数据
	 * @param orgInfo
	 * @return
	 */
	public  List<Organization> findPageData(OrganizationInfo orgInfo);
	
	/**
	 * 根据orginfo查询相应的数据相应的记录数
	 * @param orgInfo
	 * @return
	 */
	public  int getOrganizationCount(OrganizationInfo orgInfo);
	
	/**
	 * 根据number{java.util.List} 启用
	 * @param list
	 */
	public void updateEnable(@Param("list") List<String> list , @Param("modifyUser") String modifyUser);
	
	/**
	 * 根据number{java.util.List} 禁用
	 * @param list
	 */
	public void updateDisable(@Param("list") List<String> list , @Param("modifyUser") String modifyUser);
	
	/**
	 * 修改number{java.uti.List}删除标记marker 
	 * @param list
	 */
	public void updateMarker(@Param("list") List<String> list , @Param("modifyUser") String modifyUser);
	
	/**
	 * 添加数据
	 * @param org(Organization)
	 */
	public void addOrganization(@Param("org")Organization org , @Param("createUser") String createUser);
	
	/**
	 * 修改数据
	 * @param org
	 */
	public void updateOrganization(@Param("org")Organization org , @Param("modifyUser") String modifyUser);
	
	
	
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
	 * 
	 * @param pinying
	 * @return
	 */
	public List<Organization> findOrgNameByPinying(@Param("pinying") String pinying);
}
