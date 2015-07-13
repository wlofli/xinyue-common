package com.xinyue.manage.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinyue.manage.beans.BusinessInfos;
import com.xinyue.manage.beans.HoldInfos;
import com.xinyue.manage.beans.SearchCompanyInfo;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.CompanyInfoDAO;
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
import com.xinyue.manage.service.CompanyInfoService;
import com.xinyue.manage.util.CommonFunction;
import com.xinyue.manage.util.GlobalConstant;

/**
 * 企业信息service
 * @author MK)茅
 *
 */
@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

	@Resource
	CompanyInfoDAO companyInfoDAO;
	
	private Logger log = Logger.getLogger(CompanyInfoServiceImpl.class);
	
	//double格式化
	private DecimalFormat df = new DecimalFormat("######0.00");
	
	@Override
	public List<SelectInfo> getIndustryList() {
		
		return companyInfoDAO.getIndustryList();
	}

	@Override
	public List<CompanyInfo> getCompanyInfoByCondition(
			SearchCompanyInfo searchCompanyInfo, int index, int type) {
		
		List<CompanyInfo> info = null;
		
		HashMap<String, Object> map = new HashMap<>();
		map.clear();
		
		//数据整理
		if (index == -99) {
			map.put("index", "-99");
		}else {
			map.put("index", index*GlobalConstant.PAGE_SIZE);
		}		
		map.put("company_name", searchCompanyInfo.getCompanyName());
		map.put("legal_person", searchCompanyInfo.getLegalPerson());
		map.put("tax_code", searchCompanyInfo.getTaxCode());
		map.put("industry", searchCompanyInfo.getIndustry());
		map.put("contact_person", searchCompanyInfo.getContactPerson());
		map.put("contact_tel", searchCompanyInfo.getTelPhone());
		map.put("register_date_start", searchCompanyInfo.getCompanyRegisterTimeStart());
		map.put("register_date_end", searchCompanyInfo.getCompanyRegisterTimeEnd());
		map.put("loan_times_start", searchCompanyInfo.getLoanTimesStart());
		map.put("loan_times_end", searchCompanyInfo.getLoanTimesEnd());
		map.put("register_fund_start", searchCompanyInfo.getRegisterFundStart());
		map.put("register_fund_end", searchCompanyInfo.getRegisterFundEnd());
		
		//类型判断
		switch (type) {
		case 0:
			//全部
			map.put("authentication_status", "");
			break;
		case 1:
			//已认证
			map.put("authentication_status", "1");
			break;
		case 2:
			//认证审核中
			map.put("authentication_status", "0");
			break;
		case 3:
			//屏蔽状态
			map.put("authentication_status", "4");
			break;
		default:
			//全部
			map.put("authentication_status", "");
			break;
		}
		
		try {
			info = companyInfoDAO.getCompanyInfoByCondition(map);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return info;
	}

	@Override
	public int getAllCountBySearchInfo(SearchCompanyInfo searchCompanyInfo,
			int type) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.clear();
		
		//数据整理
		map.put("company_name", searchCompanyInfo.getCompanyName());
		map.put("legal_person", searchCompanyInfo.getLegalPerson());
		map.put("tax_code", searchCompanyInfo.getTaxCode());
		map.put("industry", searchCompanyInfo.getIndustry());
		map.put("contact_person", searchCompanyInfo.getContactPerson());
		map.put("contact_tel", searchCompanyInfo.getTelPhone());
		map.put("register_date_start",
				searchCompanyInfo.getCompanyRegisterTimeStart());
		map.put("register_date_end",
				searchCompanyInfo.getCompanyRegisterTimeEnd());
		map.put("loan_times_start", searchCompanyInfo.getLoanTimesStart());
		map.put("loan_times_end", searchCompanyInfo.getLoanTimesEnd());
		map.put("register_fund_start", searchCompanyInfo.getRegisterFundStart());
		map.put("register_fund_end", searchCompanyInfo.getRegisterFundEnd());

		// 类型判断
		switch (type) {
		case 0:
			// 全部
			map.put("authentication_status", "");
			break;
		case 1:
			// 已认证
			map.put("authentication_status", "1");
			break;
		case 2:
			// 认证审核中
			map.put("authentication_status", "0");
			break;
		case 3:
			// 屏蔽状态
			map.put("authentication_status", "4");
			break;
		default:
			break;
		}
		
		int totalCount = 0;
		try {
			totalCount = companyInfoDAO.getAllCountBySearchInfo(map);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return totalCount;
	}

	@Override
	@Transactional
	public void exprot(HttpServletResponse response, List<CompanyInfo> allList) throws Exception {
		
		String sheetName = GlobalConstant.COMPANYINFO_SHEET_NAME;
		String fileName = GlobalConstant.COMPANYINFO_EXCEL_NAME;

		// 头部内容
		String[] header = new String[] { 
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
				GlobalConstant.AUTHENTICATION_TITLE_14 };
		
		// 实际内容
		List<String[]> dataList = new ArrayList<>();

		for (int i = 0; i < allList.size(); i++) {
			CompanyInfo temp = allList.get(i);

			String[] arrayT = new String[] { 
					String.valueOf(i + 1),
					temp.getTaxCode(), 
					temp.getCompanyName(), 
					temp.getZone(),
					temp.getCompanyRegisterDate(), 
					temp.getLegalPerson(),
					temp.getRegisterFund(), 
					temp.getIndustry(),
					temp.getContactPerson(), 
					temp.getContactTel(),
					temp.getAuthenticationStatus(), 
					temp.getLoanTimes(),
					temp.getMemberName(), 
					temp.getRegisterDate() };
			dataList.add(arrayT);
		}
		
		CommonFunction cf = new CommonFunction();
		//调用共通
		cf.exportDataToExcel(response, fileName, sheetName, header, dataList);
	}

	@Override
	public boolean deleteCompanyById(String code,String user) {
		
		List<String> codeList = new ArrayList<String>();
		String[] codeTemp = code.split("~");
		
		for (int i = 0; i < codeTemp.length; i++) {
			codeList.add(codeTemp[i]);
		}
		
		int res = 0;
		try {
			
			//企业信息ID取得
			List<String> companyCode = companyInfoDAO.getCompanyCodeByMemberId(codeList);
			
			//删除企业信息
			if (companyCode != null && companyCode.size() > 0) {
				res = companyInfoDAO.deleteCompanyById(companyCode,user);
			}
			
			if (res >0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public HashMap<String, String> getDetailIdByMemberId(String code) {
		
		HashMap<String, String> map = new HashMap<>();
		
		map = companyInfoDAO.getDetailIdByMemberId(code);
		
		return map;
	}

	@Override
	public Applicant getApplicantInfoById(String applicantId) {
		
		Applicant applicant = null;
		try {
			applicant = companyInfoDAO.getApplicantInfoById(applicantId);
			
			if (applicant !=  null) {
				applicant.setMoney(df.format(Double.parseDouble(applicant.getMoney())));
				applicant.setGuaranteeMoney(df.format(Double.parseDouble(applicant.getGuaranteeMoney())));
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return applicant;
	}


	@Override
	public CompanyBase getCompanyBaseInfoById(String licenseId) {
		
		CompanyBase companyBase = null;
		
		try {
			companyBase = companyInfoDAO.getCompanyBaseInfoById(licenseId);
			
			if (companyBase != null) {
				companyBase.setRegisterFund(df.format(Double.parseDouble(companyBase.getRegisterFund())));
				companyBase.setFactFund(df.format(Double.parseDouble(companyBase.getFactFund())));
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return companyBase;
	}

	@Override
	public List<Hold> getHoldInfoById(String memberId) {
		
		try {
			List<Hold> list = companyInfoDAO.getHoldInfoById(memberId);
			
			return list;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Control getControlInfoById(String controlId) {

		Control control = null;
		
		try {
			control = companyInfoDAO.getControlInfoById(controlId);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return control;
	}

	@Override
	public List<Business> getBusinessInfoById(String memberId) {
		try {
			List<Business> list = companyInfoDAO.getBusinessInfoById(memberId);
			
			ArrayList<Business> arrayList = new ArrayList<>();
			for (Business business : list) {
				business.setTotalSales(df.format(Double.parseDouble(business.getTotalSales())));
				business.setMonthWaterMoney(df.format(Double.parseDouble(business.getMonthWaterMoney())));
				business.setMonthOrderMoney(df.format(Double.parseDouble(business.getMonthOrderMoney())));
				business.setMonthElectricMoney(df.format(Double.parseDouble(business.getMonthElectricMoney())));
				business.setTotalVAT(df.format(Double.parseDouble(business.getTotalVAT())));
				business.setTotalIncomeTax(df.format(Double.parseDouble(business.getTotalIncomeTax())));
				
				arrayList.add(business);
			}
			
			return arrayList;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public RealEstate getRealEstateInfoById(String estateId) {
		RealEstate realEstate;
		try {
			realEstate = companyInfoDAO.getRealEstateInfoById(estateId);
			
			if (realEstate != null) {
				realEstate.setFactory(df.format(Double.parseDouble(realEstate.getFactory())));
				realEstate.setLand(df.format(Double.parseDouble(realEstate.getLand())));
				realEstate.setOffice(df.format(Double.parseDouble(realEstate.getOffice())));
				realEstate.setShop(df.format(Double.parseDouble(realEstate.getShop())));
				realEstate.setPrivateProperty(df.format(Double.parseDouble(realEstate.getPrivateProperty())));
				realEstate.setEquipment(df.format(Double.parseDouble(realEstate.getEquipment())));
				realEstate.setOther(df.format(Double.parseDouble(realEstate.getOther())));
			}
			
			return realEstate;
		} catch (Exception e) {
			log.error(e.getMessage());
		} 
		return null;
	}

	@Override
	public Debt getDebtInfoById(String debtId) {
		try {
			Debt debt = companyInfoDAO.getDebtInfoById(debtId);
			
			if (debt != null) {
				debt.setRepayIncome(df.format(Double.parseDouble(debt.getRepayIncome())));
				debt.setNetAsset(df.format(Double.parseDouble(debt.getNetAsset())));
				debt.setFactAsset(df.format(Double.parseDouble(debt.getFactAsset())));
			}
			
			return debt;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return null;
	}

	@Override
	public Rating getRatingInfoById(String ratingId) {
		
		try {
			Rating rating = companyInfoDAO.getRatingInfoById(ratingId);
			
			return rating;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Document> getDocumentInfoById(String memberId) {
		
		try {
			List<Document> list = companyInfoDAO.getDocumentInfoById(memberId);
			
			return list;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void downloadFile(HttpServletResponse response,String id) {

		String[] temp = id.split("~");

		for (int i = 0; i < temp.length; i++) {
			Document document = companyInfoDAO.getDocumentById(temp[i]);
			CommonFunction cf = new CommonFunction();

			if (document != null) {
				// 文件地址
				String filePath = document.getDocumentDir()
						+ document.getDocumentName();

				// 下载
				cf.downLoadFile(response, filePath);
			}
		}
		
	}

	@Override
	public Applicant editApplicantInfoById(String applicantId) {
		Applicant applicant = null;
		try {
			applicant = companyInfoDAO.editApplicantInfoById(applicantId);
			
			//对金额格式化
			if (applicant !=  null) {
				applicant.setMoney(df.format(Double.parseDouble(applicant.getMoney())));
				applicant.setGuaranteeMoney(df.format(Double.parseDouble(applicant.getGuaranteeMoney())));
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return applicant;
	}

	@Override
	public CompanyBase editCompanyBaseInfoById(String licenseId) {
		CompanyBase companyBase = null;
		
		try {
			companyBase = companyInfoDAO.editCompanyBaseInfoById(licenseId);
			
			if (companyBase != null) {
				companyBase.setRegisterFund(df.format(Double.parseDouble(companyBase.getRegisterFund())));
				companyBase.setFactFund(df.format(Double.parseDouble(companyBase.getFactFund())));
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return companyBase;
	}

	@Override
	public HoldInfos editHoldInfoById(String memberId) {
		try {
			List<Hold> list = companyInfoDAO.editHoldInfoById(memberId);
			
			HoldInfos holdInfos = new HoldInfos();
			
			//数据整理
			if (list != null && list.size() > 0) {
				int count = list.size();
				
				String[] ids = new String[count];
				String[] types = new String[count];
				String[] controlPersons = new String[count];
				String[] paperTypes = new String[count];
				String[] paperNumbers = new String[count];
				String[] workYears = new String[count];
				String[] educations = new String[count];
				String[] marriages = new String[count];
				
				for (int i = 0; i < list.size(); i++) {
					ids[i] = list.get(i).getId();
					types[i] = list.get(i).getHoldType();
					controlPersons[i] = list.get(i).getControlPerson();
					paperTypes[i] = list.get(i).getPaperType();
					paperNumbers[i] = list.get(i).getPaperNumber();
					workYears[i] = list.get(i).getWorkYear();
					educations[i] = list.get(i).getEducation();
					marriages[i] = list.get(i).getMarriage();
				}
				
				holdInfos.setIds(ids);
				holdInfos.setHoldTypes(types);
				holdInfos.setControlPersons(controlPersons);
				holdInfos.setPaperTypes(paperTypes);
				holdInfos.setPaperNumbers(paperNumbers);
				holdInfos.setWorkYears(workYears);
				holdInfos.setEducations(educations);
				holdInfos.setMarriages(marriages);
			}
			
			return holdInfos;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public BusinessInfos editBusinessInfoById(String memberId) {
		try {
			List<Business> list = companyInfoDAO.getBusinessInfoById(memberId);
			
			BusinessInfos businessInfos = new BusinessInfos();
			
			String[] ids ;
			String[] years ;
			String[] totalSales ;
			String[] monthWaterMoneys ;
			String[] monthOrderMoneys ;
			String[] monthElectricMoneys ;
			String[] totalVATs ;
			String[] totalIncomeTaxs ;
			
			//数据整理
			if (list != null && list.size() > 0 ) {
				int count = list.size();

				ids = new String[count];
				years = new String[count];
				totalSales = new String[count];
				monthWaterMoneys = new String[count];
				monthOrderMoneys = new String[count];
				monthElectricMoneys = new String[count];
				totalVATs = new String[count];
				totalIncomeTaxs = new String[count];

				//格式化数据并保存到beans
				for (int i = 0; i < count; i++) {
					ids[i] = list.get(i).getId();
					years[i] = list.get(i).getYear();
					totalSales[i] = df.format(Double.parseDouble(list.get(i).getTotalSales()));
					monthWaterMoneys[i] = df.format(Double.parseDouble(list.get(i).getMonthWaterMoney()));
					monthOrderMoneys[i] = df.format(Double.parseDouble(list.get(i).getMonthOrderMoney()));
					monthElectricMoneys[i] = df.format(Double.parseDouble(list.get(i).getMonthElectricMoney()));
					totalVATs[i] = df.format(Double.parseDouble(list.get(i).getTotalVAT()));
					totalIncomeTaxs[i] = df.format(Double.parseDouble(list.get(i).getTotalIncomeTax()));
				}
			}else {
				years = new String[3];
				totalSales = new String[3];
				monthWaterMoneys = new String[3];
				monthOrderMoneys = new String[3];
				monthElectricMoneys = new String[3];
				totalVATs = new String[3];
				totalIncomeTaxs = new String[3];
				
				Calendar cal = Calendar.getInstance();
				int yearNow = cal.get(Calendar.YEAR);
				
				for (int i = 0; i < 3; i++) {
					years[i] = String.valueOf(yearNow);
					totalSales[i] = "";
					monthWaterMoneys[i] = "";
					monthOrderMoneys[i] = "";
					monthElectricMoneys[i] = "";
					totalVATs[i] = "";
					totalIncomeTaxs[i] = "";
					
					yearNow--;
				}
			}
			
			businessInfos.setYears(years);
			businessInfos.setTotalSales(totalSales);
			businessInfos.setMonthWaterMoneys(monthWaterMoneys);
			businessInfos.setMonthOrderMoneys(monthOrderMoneys);
			businessInfos.setMonthElectricMoneys(monthElectricMoneys);
			businessInfos.setTotalVATs(totalVATs);
			businessInfos.setTotalIncomeTaxs(totalIncomeTaxs);
			
			return businessInfos;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Document> editDocumentInfoById(String memberId) {
		try {
			List<Document> list = companyInfoDAO.getDocumentInfoById(memberId);
			
			return list;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Control editControlInfoById(String controlId) {
		Control control = null;

		try {
			control = companyInfoDAO.editControlInfoById(controlId);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return control;
	}

	@Override
	public RealEstate editRealEstateInfoById(String estateId) {
		
		return this.getRealEstateInfoById(estateId);
	}

	@Override
	public Debt editDebtInfoById(String debtId) {
		try {
			Debt debt = companyInfoDAO.editDebtInfoById(debtId);
			
			if (debt != null) {
				if (!debt.getRepayIncome().equals("")) {
					debt.setRepayIncome(df.format(Double.parseDouble(debt.getRepayIncome())));
				}
				if (!debt.getNetAsset().equals("")) {
					debt.setNetAsset(df.format(Double.parseDouble(debt.getNetAsset())));
				}
				if (!debt.getFactAsset().equals("")) {
					debt.setFactAsset(df.format(Double.parseDouble(debt.getFactAsset())));
				}
				if (!debt.getFloatRate().equals("")) {
					debt.setFloatRate(df.format(Double.parseDouble(debt.getFloatRate())));
				}
			}else {
				debt = new Debt();
			}
			return debt;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return new Debt();
	}

	@Override
	public boolean saveApplicant(Applicant applicant,String memberId,String user) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		int count = 0;
		try {
			
			map.clear();
			map.put("name", applicant.getName());
			map.put("phone", applicant.getPhone());
			map.put("email", applicant.getEmail());
			if (applicant.getLimitDate().equals("")) {
				map.put("limitDate", null);
			}else {
				map.put("limitDate", applicant.getLimitDate());
			}
			if (applicant.getMoney().equals("")) {
				map.put("money", null);
			}else {
				map.put("money", applicant.getMoney());
			}
			map.put("interestRate", applicant.getInterestRate());
			if (applicant.getRepayType().equals("")) {
				map.put("repayType", null);
			}else {
				map.put("repayType", applicant.getRepayType());
			}
			if (applicant.getGuaranteeType().equals("")) {
				map.put("guaranteeType", null);
			}else {
				map.put("guaranteeType", applicant.getGuaranteeType());
			}
			map.put("guaranteePerson", applicant.getGuaranteePerson());
			map.put("guaranteeGoods", applicant.getGuaranteeGoods());
			if (applicant.getGuaranteeMoney().equals("")) {
				map.put("guaranteeMoney", null);
			}else {
				map.put("guaranteeMoney", applicant.getGuaranteeMoney());
			}
			if (applicant.getGuaranteeProvince().equals("0")) {
				map.put("guaranteeProvince", null);
			}else {
				map.put("guaranteeProvince", applicant.getGuaranteeProvince());
			}
			if (applicant.getGuaranteeCity().equals("0")) {
				map.put("guaranteeCity", null);
			}else {
				map.put("guaranteeCity", applicant.getGuaranteeCity());
			}
			if (applicant.getGuaranteeZone().equals("0")) {
				map.put("guaranteeZone", null);
			}else {
				map.put("guaranteeZone", applicant.getGuaranteeZone());
			}
			if (applicant.getIsLocation().equals("")) {
				map.put("guaranteeZone", null);
			}else {
				map.put("isLocation", applicant.getIsLocation());
			}
			map.put("user", user);
			
			if (applicant.getId().equals("")) {
				
				String id = UUID.randomUUID().toString().replace("-", "");
				map.put("id", id);

				count = companyInfoDAO.addApplicant(map);
				
				if (count > 0) {
					count = 0;
					map.clear();
					map.put("memberId", memberId);
					map.put("applicantId", id);
					map.put("user", user);
					map.put("type", "app");
					
					count = companyInfoDAO.updateMemberInfo(map);
					
				}else {
					return false;
				}
			}else {
				map.put("id", applicant.getId());
				count = companyInfoDAO.updateApplicant(map);
			}
			
			if (count > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean saveCompanyBase(CompanyBase companyBase, String memberId,
			String user) {
		HashMap<String, Object> map = new HashMap<>();
		
		int count = 0;
		
		try {
			map.clear();
			map.put("companyName", companyBase.getCompanyName());
			map.put("legalPerson", companyBase.getLegalPerson());
			map.put("paperType", companyBase.getPaperType());
			map.put("paperNumber", companyBase.getPaperNumber());
			map.put("licenseeNumber", companyBase.getLicenseeNumber());
			if (companyBase.getCompanyRegisterDate().equals("")) {
				map.put("companyRegisterDate", null);
			}else {
				map.put("companyRegisterDate", companyBase.getCompanyRegisterDate());
			}
			map.put("yearCheck", companyBase.getYearCheck());
			if (companyBase.getYearCheckDate().equals("")) {
				map.put("yearCheckDate", null);
			}else {
				map.put("yearCheckDate", companyBase.getYearCheckDate());
			}
			map.put("registerFundType", companyBase.getRegisterFundType());
			if (companyBase.getRegisterFund().equals("")) {
				map.put("registerFund", null);
			}else {
				map.put("registerFund", companyBase.getRegisterFund());
			}
			map.put("factFundType", companyBase.getFactFundType());
			if (companyBase.getFactFund().equals("")) {
				map.put("factFund", null);
			}else {
				map.put("factFund", companyBase.getFactFund());
			}
			map.put("companyType", companyBase.getCompanyType());
			map.put("registerAddress", companyBase.getRegisterAddress());
			if (companyBase.getCompanyProvince().equals("")) {
				map.put("companyProvince", null);
			}else {
				map.put("companyProvince", companyBase.getCompanyProvince());
			}
			if (companyBase.getCompanyCity().equals("")) {
				map.put("companyCity", null);
			}else {
				map.put("companyCity", companyBase.getCompanyCity());
			}
			if (companyBase.getCompanyZone().equals("")) {
				map.put("companyZone", null);
			}else {
				map.put("companyZone", companyBase.getCompanyZone());
			}
			map.put("businessRange", companyBase.getBusinessRange());
			map.put("organizationCode", companyBase.getOrganizationCode());
			map.put("companyEdoorNum", companyBase.getCompanyEdoorNum());
			map.put("companyTel", companyBase.getCompanyTel());
			map.put("companyFax", companyBase.getCompanyFax());
			if (companyBase.getLicenseeDeadLine().equals("")) {
				map.put("licenseeDeadLine", null);
			}else {
				map.put("licenseeDeadLine", companyBase.getLicenseeDeadLine());
			}
			map.put("licenseeType", companyBase.getLicenseeType());
			map.put("organizationType", companyBase.getOrganizationType());
			map.put("taxCode", companyBase.getTaxCode());
			map.put("user", user);
			
			if (companyBase.getId().equals("")) {
				String id = UUID.randomUUID().toString().replace("-", "");
				map.put("id", id);
				
				count = companyInfoDAO.addCompanyBase(map);
				
				if (count > 0) {
					count = 0;
					map.clear();
					map.put("memberId", memberId);
					map.put("licenseId", id);
					map.put("user", user);
					map.put("type", "comp");
					
					count = companyInfoDAO.updateMemberInfo(map);
					
					return true;
				}
			}else {
				map.put("id", companyBase.getId());
				
				count = companyInfoDAO.updateCompanyBase(map);
				
				if (count > 0) {
					return true;
				}
			}
			
			return false;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean saveHolds(HoldInfos holdInfos,String user) {

		List<Hold> holds = new ArrayList<>();
		
		try {
			for (int i = 0; i < 2; i++) {
				Hold temp = new Hold();
				temp.setId(holdInfos.getIds()[i]);
				temp.setHoldType(holdInfos.getHoldTypes()[i]);
				temp.setControlPerson(holdInfos.getControlPersons()[i]);
				temp.setPaperType(holdInfos.getPaperTypes()[i]);
				temp.setPaperNumber(holdInfos.getPaperNumbers()[i]);
				temp.setWorkYear(holdInfos.getWorkYears()[i]);
				temp.setEducation(holdInfos.getEducations()[i]);
				if (holdInfos.getMarriages()[i].equals("")) {
					temp.setMarriage(null);	
				}else {
					temp.setMarriage(holdInfos.getMarriages()[i]);
				}
				
				holds.add(temp);
			}
			
			//持久化
			int count = companyInfoDAO.updateHolds(holds,user);
			
			if (count > 0) {
				return true;
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
		
		return false;
	}

	@Override
	public boolean saveControl(Control control, String memberId, String user) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		int count = 0;
		try {
			map.clear();
			map.put("industry", control.getIndustry());
			map.put("businessStartDate", control.getBusinessStartDate());
			map.put("businessArea", control.getBusinessArea());
			map.put("saleArea", control.getSaleArea());
			map.put("fixedBusinessPlace", control.getFixedBusinessPlace());
			map.put("interYear", control.getInterYear());
			map.put("auditType", control.getAuditType());
			if (control.getPeopleNumber().equals("")) {
				map.put("peopleNumber", null);	
			}else {
				map.put("peopleNumber", control.getPeopleNumber());
			}
			map.put("haveLoanCard", control.getHaveLoanCard());
			map.put("loanCardNumber", control.getLoanCardNumber());
			map.put("user", user);
			
			if (control.getId().equals("")) {
				String id = UUID.randomUUID().toString().replace("-", "");
				
				map.put("id", id);
				
				count = companyInfoDAO.addControl(map);
				
				if (count > 0) {
					count = 0;

					map.clear();
					map.put("memberId", memberId);
					map.put("controlId", id);
					map.put("user", user);
					map.put("type", "cont");
					count = companyInfoDAO.updateMemberInfo(map);
				}
			}else {
				map.put("id", control.getId());
				
				count = companyInfoDAO.updateControl(map);
				
				if (count > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean saveBusiness(BusinessInfos businessInfos, String memberId,
			String user) {
		
		List<Business> businesses = new ArrayList<>();
		
		try {
			for (int i = 0; i < 3; i++) {
				Business temp = new Business();
				
				temp.setId(businessInfos.getIds()[i]);
				temp.setYear(businessInfos.getYears()[i]);
				if (businessInfos.getTotalSales()[i].equals("")) {
					temp.setTotalSales(null);
				}else {
					temp.setTotalSales(businessInfos.getTotalSales()[i]);
				}
				if (businessInfos.getMonthWaterMoneys()[i].equals("")) {
					temp.setMonthWaterMoney(null);
				}else {
					temp.setMonthWaterMoney(businessInfos.getMonthWaterMoneys()[i]);
				}
				if (businessInfos.getMonthOrderMoneys()[i].equals("")) {
					temp.setMonthOrderMoney(null);
				}else {
					temp.setMonthOrderMoney(businessInfos.getMonthOrderMoneys()[i]);
				}
				if (businessInfos.getMonthElectricMoneys()[i].equals("")) {
					temp.setMonthElectricMoney(null);
				}else {
					temp.setMonthElectricMoney(businessInfos.getMonthElectricMoneys()[i]);
				}
				if (businessInfos.getTotalVATs()[i].equals("")) {
					temp.setTotalVAT(null);
				}else {
					temp.setTotalVAT(businessInfos.getTotalVATs()[i]);
				}
				if (businessInfos.getTotalIncomeTaxs()[i].equals("")) {
					temp.setTotalIncomeTax(null);
				}else {
					temp.setTotalIncomeTax(businessInfos.getTotalIncomeTaxs()[i]);
				}
				
				businesses.add(temp);
			}
			
			int count = companyInfoDAO.updateBusiness(businesses);
			
			if (count > 0) {
				return false;
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
		
		return false;
	}

	@Override
	public boolean saveEstate(RealEstate estate, String memberId, String user) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		int count = 0;
		
		try {
			map.clear();
			map.put("factory", estate.getFactory());
			map.put("land", estate.getLand());
			map.put("office", estate.getOffice());
			map.put("shop", estate.getShop());
			map.put("private", estate.getPrivateProperty());
			map.put("equipment", estate.getEquipment());
			map.put("other", estate.getOther());
			map.put("user", user);
			
			if (estate.getId().equals("")) {
				String id = UUID.randomUUID().toString().replace("-", "");
				
				map.put("id", id);
				
				count = companyInfoDAO.addEstate(map);
				
				if (count > 0) {
					count = 0;
					map.clear();
					map.put("memberId", memberId);
					map.put("realEstate", id);
					map.put("type", "est");
					
					count = companyInfoDAO.updateMemberInfo(map);
				}
			}else {
				map.put("id", estate.getId());
				
				count = companyInfoDAO.updateEstate(map);
			}
			
			if (count > 0) {
				return true;
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		
		
		
		return false;
	}

	@Override
	public boolean saveDebt(Debt debt, String memberId, String user) {
		HashMap<String, Object> map = new HashMap<>();
		
		int count = 0;
		
		try {
			map.clear();
			map.put("rate", debt.getRate());
			map.put("collateral", debt.getCollateral());
			if (debt.getRepayIncome().equals("")) {
				map.put("repayIncome", null);
			}else {
				map.put("repayIncome", debt.getRepayIncome());
			}
			map.put("isBig", debt.getIsBig());
			if (debt.getNetAsset().equals("")) {
				map.put("netAsset", null);
			}else {
				map.put("netAsset", debt.getNetAsset());
			}
			if (debt.getFloatRate().equals("")) {
				map.put("floatRate", null);
			}else {
				map.put("floatRate", debt.getFloatRate());
			}
			if (debt.getFactAsset().equals("")) {
				map.put("factAsset", null);
			}else {
				map.put("factAsset", debt.getFactAsset());
			}
			map.put("user", user);
			
			if (debt.getId().equals("")) {
				String id = UUID.randomUUID().toString().replace("-", "");
				
				map.put("id", id);
				
				count = companyInfoDAO.addDebt(map);
				
				if (count > 0) {
					count = 0;
					map.clear();
					map.put("memberId", memberId);
					map.put("debt", id);
					map.put("type", "debt");
					
					count = companyInfoDAO.updateMemberInfo(map);
				}
				
			}else {
				map.put("id", debt.getId());
				
				count = companyInfoDAO.updateDebt(map);
			}
			
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		return false;
	}

}
