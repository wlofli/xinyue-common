package com.xinyue.manage.dao;

import java.util.HashMap;
import java.util.List;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Authentication;

public interface AuthenticationDAO {

	List<SelectInfo> getIndustryList();

	List<Authentication> getAuthenticationInfo(HashMap<String, Object> map);

	int getAllCount();

	Authentication getDetailByCode(String code);

	int updateAuthenticationStatusByCode(HashMap<String, Object> map);

	int saveMemberAuth(HashMap<String, Object> map);

	Authentication findByMemberId(String memberId);

	void updateMemberById(HashMap<String, Object> map);

	int updateMemberAuth(HashMap<String, Object> map);


}
