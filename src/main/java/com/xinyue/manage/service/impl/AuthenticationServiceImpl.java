package com.xinyue.manage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.SearchAuthentication;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.AuthenticationDAO;
import com.xinyue.manage.model.Authentication;
import com.xinyue.manage.service.AuthenticationService;
import com.xinyue.manage.util.CommonFunction;
import com.xinyue.manage.util.GlobalConstant;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private String imgPath = CommonFunction.getValue("upload.path") + "auth/";
	
	private Logger log = Logger.getLogger(AdvertisingServiceImpl.class);
	
	@Resource
	AuthenticationDAO authenticationDAO;
	
	@Override
	public List<SelectInfo> getIndustryList() {
		
		return authenticationDAO.getIndustryList();
	}

	@Override
	public List<Authentication> getAuthenticationInfo(
			SearchAuthentication searchAuthentication,int index) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.clear();
		
		//参数整理
		//企业名称
		map.put("companyName", searchAuthentication.getCompanyName());
		//法人
		map.put("legalPersonName", searchAuthentication.getLegalPersonName());
		//纳税识别号
		map.put("taxCode", searchAuthentication.getTaxCode());
		//行业
		map.put("industry", searchAuthentication.getIndustry());
		//联系人
		map.put("contactName", searchAuthentication.getContactName());
		//联系电话
		map.put("contactTel", searchAuthentication.getContactTel());
		//认证时间段
		map.put("timeStart", searchAuthentication.getAuthenticationTimeStart());
		map.put("timeEnd", searchAuthentication.getAuthenticationTimeEnd());
		//注册资金段
		map.put("fundStart", searchAuthentication.getRegFundStart());
		map.put("fundEnd", searchAuthentication.getRegFundEnd());
		//分页
		map.put("index", index);
		
		List<Authentication> info = authenticationDAO.getAuthenticationInfo(map);
		
		return info;
	}

	@Override
	public int getAllCount() {
		int res = 0;
		
		res = authenticationDAO.getAllCount();
		
		return res;
	}

	@Override
	public Authentication getDetailByCode(String code) {
		
		Authentication authentication = authenticationDAO.getDetailByCode(code);
		
		if (authentication != null) {
			authentication.setCode(code);
			if (!authentication.getBusinessLicense().equals("")) {
				authentication.setBusinessLicense(imgPath+authentication.getBusinessLicense());
			}
			if (!authentication.getTaxRegistration().equals("")) {
				authentication.setTaxRegistration(imgPath+authentication.getTaxRegistration());
			}
			if (!authentication.getOrganizationCode().equals("")) {
				authentication.setOrganizationCode(imgPath+authentication.getOrganizationCode());
			}
			if (!authentication.getIdentityCarda().equals("")) {
				authentication.setIdentityCarda(imgPath+authentication.getIdentityCarda());
			}
			if (!authentication.getIdentityCardn().equals("")) {
				authentication.setIdentityCardn(imgPath+authentication.getIdentityCardn());
			}
			if (!authentication.getIdentityCardp().equals("")) {
				authentication.setIdentityCardp(imgPath+authentication.getIdentityCardp());
			}
		}
		
		return authentication;
	}

	@Override
	public void exportData(HttpServletResponse response,List<Authentication> info) throws Exception{
		
		String sheetName = GlobalConstant.AUTHENTICATION_SHEET_NAME;
		String fileName = GlobalConstant.AUTHENTICATION_EXCEL_NAME;
		
		//头部内容
		String[] header = new String[]{
				GlobalConstant.AUTHENTICATION_TITLE_1,	
				GlobalConstant.AUTHENTICATION_TITLE_2,	
				GlobalConstant.AUTHENTICATION_TITLE_3,	
				GlobalConstant.AUTHENTICATION_TITLE_4,	
				GlobalConstant.AUTHENTICATION_TITLE_5,	
				GlobalConstant.AUTHENTICATION_TITLE_6,	
				GlobalConstant.AUTHENTICATION_TITLE_7,	
				GlobalConstant.AUTHENTICATION_TITLE_8,	
				GlobalConstant.AUTHENTICATION_TITLE_9,	
				GlobalConstant.AUTHENTICATION_TITLE_10,	
				GlobalConstant.AUTHENTICATION_TITLE_11,	
				GlobalConstant.AUTHENTICATION_TITLE_12,	
				GlobalConstant.AUTHENTICATION_TITLE_13,	
				GlobalConstant.AUTHENTICATION_TITLE_14,	
				GlobalConstant.AUTHENTICATION_TITLE_15	
		};
		
		//实际内容
		List<String[]> dataList = new ArrayList<>();
		
		for (int i = 0; i < info.size(); i++) {
			Authentication temp = info.get(i);
			
			String[] arrayT = new String[]{
					String.valueOf(i+1),
					temp.getTaxCode(),
					temp.getCompanyName(),
					temp.getZone(),
					temp.getCompanyRegDate(),
					temp.getLegalPersonName(),
					temp.getRegFund(),
					temp.getIndustry(),
					temp.getContactPerson(),
					temp.getContactTel(),
					temp.getMemberName(),
					temp.getRegDate(),
					temp.getAuthenticationDate(),
					temp.getAuthenticationStatus(),
					temp.getAuthenticationType()
			};
			
			dataList.add(arrayT);
		}
	    
		CommonFunction cf = new CommonFunction();
		//调用共通
		cf.exportDataToExcel(response, fileName, sheetName, header, dataList);
		
	}

	@Override
	public boolean updateAuthenticationStatusByCode(Authentication authentication, String user) {
		boolean ret = false;
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.clear();
		
		try {
			if (authentication.getCode() != null && !authentication.getCode().equals("")) {
				//数据
				map.put("user", user);
				map.put("code", authentication.getCode());
				map.put("status", authentication.getAuthenticationStatus());
				
				int res = authenticationDAO.updateAuthenticationStatusByCode(map);
				
				if (res > 0) {
					ret = true;
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return ret;
	}

}
