package com.xinyue.manage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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

public interface CompanyInfoDAO {

	List<SelectInfo> getIndustryList();

	List<CompanyInfo> getCompanyInfoByCondition(HashMap<String, Object> map);

	int getAllCountBySearchInfo(HashMap<String, Object> map);

	int deleteCompanyById(@Param("companyCode")List<String> companyCode, @Param("user")String user);

	List<String> getCompanyCodeByMemberId(@Param("codeList")List<String> codeList);

	HashMap<String, String> getDetailIdByMemberId(String code);

	Applicant getApplicantInfoById(String id);

	CompanyBase getCompanyBaseInfoById(String id);

	List<Hold> getHoldInfoById(String id);
	
	/**
	 * 
	 * add by lzc
	 * date: 2015年7月21日
	 * @param id  orderId
	 * @return
	 */
	List<Hold> getHoldInfoByOrderId(String id);

	Control getControlInfoById(String id);

	List<Business> getBusinessInfoById(String id);

	RealEstate getRealEstateInfoById(String id);

	Debt getDebtInfoById(String id);

	Rating getRatingInfoById(String id);

	List<Document> getDocumentInfo(HashMap<String, Object> map);

	Document getDocumentById(String id);

	Applicant editApplicantInfoById(String applicantId);

	CompanyBase editCompanyBaseInfoById(String licenseId);

	List<Hold> editHoldInfoById(String memberId);
	
	/**
	 * add by lzc     date: 2015年7月29日
	 * @param orderId
	 * @return
	 */
	List<Hold> editHoldInfoByOrderId(String orderId);

	Control editControlInfoById(String controlId);

	Debt editDebtInfoById(String debtId);

	int updateApplicant(HashMap<String,Object> map);

	int addApplicant(HashMap<String, Object> map);

	int updateMemberInfo(HashMap<String, Object> map);

	int addCompanyBase(HashMap<String, Object> map);

	int updateCompanyBase(HashMap<String, Object> map);

	int updateHolds(@Param("holds")List<Hold> holds, @Param("user")String user);

	int addControl(HashMap<String, Object> map);

	int updateControl(HashMap<String, Object> map);

	int updateBusiness(@Param("businesses")List<Business> businesses,@Param("user")String user);

	int addEstate(HashMap<String, Object> map);

	int updateEstate(HashMap<String, Object> map);

	int addDebt(HashMap<String, Object> map);

	int updateDebt(HashMap<String, Object> map);

	int saveBusiness(@Param("businesses")List<Business> businesses, @Param("user")String user);

	int saveHolds(@Param("holds")List<Hold> holds);

	int saveMemberHolds(@Param("holds")List<Hold> holds, @Param("user")String user);

	int editRatingById(String ratingId);

	int getDocumentCount();

	int saveDocument(HashMap<String, Object> map);
	/**
	 * add by lzc     date: 2015年7月30日
	 * @param map
	 * @return
	 */
	int	saveDocumentByOrder(HashMap<String, Object> map);

	int updateDocument(HashMap<String, Object> map);

	List<Document> getDocumentByMemberId(String memberId);
	
}
