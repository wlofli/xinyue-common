package com.xinyue.manage.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.xinyue.manage.beans.SearchAuthentication;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Authentication;

public interface AuthenticationService {

	List<SelectInfo> getIndustryList();

	List<Authentication> getAuthenticationInfo(
			SearchAuthentication searchAuthentication, int index);

	int getAllCount();

	Authentication getDetailByCode(String code);

	/**
	 * 数据导出Excel
	 * @param response 
	 * @param info
	 * @return
	 * @throws Exception
	 */
	void exportData(HttpServletResponse response, List<Authentication> info) throws Exception;

	boolean updateAuthenticationStatusByCode(Authentication authentication,String user);

	/**
	 * 前台普通会员实名认证
	 * @param authInfo
	 * @param imgPath
	 * @return
	 */
	boolean saveMemberAuth(Authentication authInfo, String imgPath,String memberId);

	Authentication findByMemberId(String memberId);


}
