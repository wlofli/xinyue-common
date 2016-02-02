package com.xinyue.manage.dao;

import java.util.HashMap;
import java.util.List;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Authentication;
/**
 * modify ywh 2015-12-01 getAllCount
 */
public interface AuthenticationDAO {

	List<SelectInfo> getIndustryList();

	List<Authentication> getAuthenticationInfo(HashMap<String, Object> map);

	//modify ywh 2015-12-01 
	int getAllCount(HashMap<String, Object> map);

	Authentication getDetailByCode(String code);

	int updateAuthenticationStatusByCode(HashMap<String, Object> map);

	int saveMemberAuth(HashMap<String, Object> map);

	Authentication findByMemberId(String memberId);

	void updateMemberById(HashMap<String, Object> map);

	int updateMemberAuth(HashMap<String, Object> map);


}
