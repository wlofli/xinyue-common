package com.xinyue.manage.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.xinyue.manage.beans.SearchAuthentication;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.AuthenticationDAO;
import com.xinyue.manage.model.Authentication;
import com.xinyue.manage.service.AuthenticationService;
import com.xinyue.manage.util.CommonFunction;
import com.xinyue.manage.util.GlobalConstant;


/**
 * 修改日志
 * 2015年11月24日  lzc saveMemberAuth()中更新认证信息添加修改认证标志位信息,业务逻辑修改
 * 2015-11-26 ywh 修改方法为: getDetailByCode
 * 2015-12-01 ywh getAllCount
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private String imgPath = CommonFunction.getValue("upload.path") + "auth/";
	
	private Logger log = Logger.getLogger(AuthenticationServiceImpl.class);
	
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
	public int getAllCount(SearchAuthentication searchAuthentication) {
		int res = 0;
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
		res = authenticationDAO.getAllCount(map);
		
		return res;
	}

	@Override
	public Authentication getDetailByCode(String code) {
		
		Authentication authentication = authenticationDAO.getDetailByCode(code);
		
		if (authentication != null) {
			authentication.setCode(code);
			//to do: modify ywh 2015-11-26  重新定义imgPath
			String imgPath = CommonFunction.getValue("down.path");
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

	@Override
	public boolean saveMemberAuth(Authentication authInfo, String imgPath,String memberId) {
		
		//图片实际存放路径
		String realFilePath = CommonFunction.getValue("upload.path")+imgPath;
		String uploadPath = CommonFunction.getValue("upload.path");
		File dirPath = new File(realFilePath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		
		try {
			//数据整理
			HashMap<String, Object> map = new HashMap<>();
			String id = "";
			if (authInfo.getCode().equals("")) {
				id = UUID.randomUUID().toString().replace("-", "");
			}else {
				id = authInfo.getCode();
			}
			map.put("id", id);
			map.put("companyName", authInfo.getCompanyName());
			map.put("blCode", authInfo.getZone());
			map.put("legalPersonName", authInfo.getLegalPersonName());
			map.put("legalPersonID", authInfo.getLegalPersonID());
			map.put("legalPersonTel", authInfo.getLegalPersonTel());
			map.put("registerAddress", authInfo.getRegisterAddress());
			map.put("companyRegDate", authInfo.getCompanyRegDate());
			map.put("regFund", authInfo.getRegFund());
			map.put("contactPerson", authInfo.getContactPerson());
			map.put("contactSex", authInfo.getContactSex());
			map.put("contactTel", authInfo.getContactTel());
			map.put("contactEmail", authInfo.getContactEmail());
			map.put("contactAddress", authInfo.getContactAddress());
			if (authInfo.getBusinessLicense().contains("temp")) {
				map.put("blImg", imgPath+authInfo.getBusinessLicense().split("/")[3]);
			}else {
				map.put("blImg", authInfo.getBusinessLicense());
			}
			if (authInfo.getOrganizationCode().contains("temp")) {
				map.put("ozImg", imgPath+authInfo.getOrganizationCode().split("/")[3]);
			}else {
				map.put("ozImg", authInfo.getOrganizationCode());
			}
			if (authInfo.getTaxRegistration().contains("temp")) {
				map.put("trImg", imgPath+authInfo.getTaxRegistration().split("/")[3]);
			}else {
				map.put("trImg", authInfo.getTaxRegistration());
			}
			if (authInfo.getIdentityCarda().contains("temp")) {
				map.put("idaImg", imgPath+authInfo.getIdentityCarda().split("/")[3]);
			}else {
				map.put("idaImg", authInfo.getIdentityCarda());
			}
			if (authInfo.getIdentityCardn().contains("temp")) {
				map.put("idnImg", imgPath+authInfo.getIdentityCardn().split("/")[3]);
			}else {
				map.put("idnImg", authInfo.getIdentityCardn());
			}
			if (authInfo.getIdentityCardp().contains("temp")) {
				map.put("idpImg", imgPath+authInfo.getIdentityCardp().split("/")[3]);
			}else {
				map.put("idpImg", authInfo.getIdentityCardp());
			}
			map.put("loginName", memberId);
			map.put("postCode", authInfo.getPostCode());
			
			
			//持久化
			int result = 0;
			if (authInfo.getCode().equals("")) {
				result = authenticationDAO.saveMemberAuth(map);
			}else {
				//add by lzc 2015-11-24 更新认证的状态为等待审核
				HashMap<String, Object> map2 = new HashMap<>();
				map2.put("status", 0);
				map2.put("code", id);
				map2.put("user", memberId);
				authenticationDAO.updateAuthenticationStatusByCode(map2);
				//end
				result = authenticationDAO.updateMemberAuth(map);
			}
			
			if (result > 0) {
				
				//添加时
				if (authInfo.getCode().equals("")) {
					//更新用户表
					map.clear();
					map.put("memberId", memberId);
					map.put("authId", id);
					authenticationDAO.updateMemberById(map);
				}
				
				//modified by lzc if条件取反
				//图片从临时文件夹移出
				for (int i = 0; i < 6; i++) {
					String tempImg = "";
					String realImg = "";
					
					switch (i) {
					case 0:
						tempImg = uploadPath+authInfo.getBusinessLicense();
						if (!tempImg.contains("temp")) {
							continue;
						}
						realImg = realFilePath+authInfo.getBusinessLicense().split("/")[3];
						authInfo.setBusinessLicense(imgPath+authInfo.getBusinessLicense().split("/")[3]);
						break;
					case 1:
						tempImg = uploadPath+authInfo.getOrganizationCode();
						if (!tempImg.contains("temp")) {
							continue;
						}
						realImg = realFilePath+authInfo.getOrganizationCode().split("/")[3];
						authInfo.setOrganizationCode(imgPath+authInfo.getOrganizationCode().split("/")[3]);
						break;
					case 2:
						tempImg = uploadPath+authInfo.getTaxRegistration();
						if (!tempImg.contains("temp")) {
							continue;
						}
						realImg = realFilePath+authInfo.getTaxRegistration().split("/")[3];
						authInfo.setTaxRegistration(imgPath+authInfo.getTaxRegistration().split("/")[3]);
						break;
					case 3:
						tempImg = uploadPath+authInfo.getIdentityCarda();
						if (!tempImg.contains("temp")) {
							continue;
						}
						realImg = realFilePath+authInfo.getIdentityCarda().split("/")[3];
						authInfo.setIdentityCarda(imgPath+authInfo.getIdentityCarda().split("/")[3]);
						break;
					case 4:
						tempImg = uploadPath+authInfo.getIdentityCardn();
						if (!tempImg.contains("temp")) {
							continue;
						}
						realImg = realFilePath+authInfo.getIdentityCardn().split("/")[3];
						authInfo.setIdentityCardn(imgPath+authInfo.getIdentityCardn().split("/")[3]);
						break;
					case 5:
						tempImg = uploadPath+authInfo.getIdentityCardp();
						if (!tempImg.contains("temp")) {
							continue;
						}
						realImg = realFilePath+authInfo.getIdentityCardp().split("/")[3];
						authInfo.setIdentityCardp(imgPath+authInfo.getIdentityCardp().split("/")[3]);
						break;
					default:
						break;
					}
					
					if (!tempImg.equals("") && !realImg.equals("")) {
						File tempFile =  new File(tempImg);
						File realFile =  new File(realImg);
						
						FileCopyUtils.copy(tempFile, realFile);
						tempFile.delete();
					}
				}
				
				return true;
			}
		} catch (Exception e) {
			log.error("error",e);
			throw new RuntimeException(e.getMessage());
		}
		
		return false;
	}

	@Override
	public Authentication findByMemberId(String memberId) {

		Authentication authentication = null;
		try {
			authentication = authenticationDAO.findByMemberId(memberId);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return authentication;
	}

}
