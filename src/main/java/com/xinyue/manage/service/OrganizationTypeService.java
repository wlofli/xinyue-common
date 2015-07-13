package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.model.OrganizationType;

/**
 * 
 * @author wenhai.you
 * @2015年6月2日
 * @下午4:54:18
 */

public interface OrganizationTypeService {

	public List<OrganizationType> findListPage(int start , int pageSize);
	
	public int getCount();
	
	public void delOrganizationType(List<String> id, String modifyUser);
	
	public boolean saveOrganizationType(OrganizationType otype , String modifyUser);
	
	public OrganizationType findTypeById(String id);
}
