package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.model.OrganizationType;

/**
 * 
 * @author wenhai.you
 * @2015年6月2日
 * @下午4:51:26
 */
public interface OrganizationTypeDao {

	public List<OrganizationType> findListPage(@Param("start") int start , @Param("pageSize") int pageSize);
	
	public int getCount();
	
	public void delOrganizationType(List<String> id);
	
	public void updateOrganizationType(OrganizationType type);
	
	public void addOrganizationType(OrganizationType type);
	
	public OrganizationType findTypeById(String id);
	
	public void updateOrgByType(List<String> id , String modifyUser);
}
