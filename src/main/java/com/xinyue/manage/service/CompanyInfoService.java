package com.xinyue.manage.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.xinyue.manage.beans.BusinessInfos;
import com.xinyue.manage.beans.HoldInfos;
import com.xinyue.manage.beans.SearchCompanyInfo;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Applicant;
import com.xinyue.manage.model.Business;
import com.xinyue.manage.model.CompanyBase;
import com.xinyue.manage.model.CompanyInfo;
import com.xinyue.manage.model.Control;
import com.xinyue.manage.model.Debt;
import com.xinyue.manage.model.Document;
import com.xinyue.manage.model.Hold;
import com.xinyue.manage.model.Rating;
import com.xinyue.manage.model.RealEstate;

public interface CompanyInfoService {

	List<SelectInfo> getIndustryList();

	/**
	 * 检索企业信息
	 * @param searchCompanyInfo 检索条件
	 * @param index 当前页-1
	 * @param type 类型
	 * @return
	 */
	List<CompanyInfo> getCompanyInfoByCondition(SearchCompanyInfo searchCompanyInfo,int index,int type);

	/**
	 * 检索条数
	 * @param searchCompanyInfo 检索条件
	 * @param type 类型 0:全部 1:认证 2:审核 3:屏蔽
	 * @return
	 */
	int getAllCountBySearchInfo(SearchCompanyInfo searchCompanyInfo, int type);

	void exprot(HttpServletResponse response, List<CompanyInfo> allList) throws Exception;

	boolean deleteCompanyById(String code,String user);

	HashMap<String, String> getDetailIdByMemberId(String code);

	//查看用数据取得
	Applicant getApplicantInfoById(String applicantId);

	CompanyBase getCompanyBaseInfoById(String licenseId);

	List<Hold> getHoldInfoById(String memberId);
	/**
	 * add by lzc     date: 2015年7月21日
	 * @param orderId
	 * @return
	 */
	List<Hold> getHoldInfoByOrderId(String orderId);
	
	Control getControlInfoById(String controlId);

	List<Business> getBusinessInfoById(String memberId);

	RealEstate getRealEstateInfoById(String estateId);

	Debt getDebtInfoById(String debtId);

	Rating getRatingInfoById(String ratingId);

	List<Document> getDocumentInfoById(String memberId);

	/**
	 * 下载
	 * @param response
	 * @param id
	 */
	void downloadFile(HttpServletResponse response, String id);

	//编辑用数据取得
	Applicant editApplicantInfoById(String applicantId);

	CompanyBase editCompanyBaseInfoById(String licenseId);

	HoldInfos editHoldInfoById(String memberId);

	BusinessInfos editBusinessInfoById(String memberId);

	List<Document> editDocumentInfoById(String memberId);

	Control editControlInfoById(String controlId);

	RealEstate editRealEstateInfoById(String estateId);

	Debt editDebtInfoById(String debtId);

	boolean saveApplicant(Applicant applicant,String memberId,String user);

	boolean saveCompanyBase(CompanyBase companyBase, String memberId,
			String user);

	boolean saveHolds(HoldInfos holdInfos, String user);

	boolean saveControl(Control control, String memberId, String user);

	boolean saveBusiness(BusinessInfos businessInfos, String memberId,
			String user);

	boolean saveEstate(RealEstate estate, String memberId, String user);

	boolean saveDebt(Debt debt, String memberId, String user);

	BusinessInfos initBusinessInfo();
}
