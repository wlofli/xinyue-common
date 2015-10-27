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
	public List<Hold> getHoldByOrderId(String orderId) {
		// TODO Auto-generated method stub
		try {
			List<Hold> list = companyInfoDAO.getHoldInfoByOrderId(orderId);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		return new ArrayList<Hold>();
	}


	@Override
	public HoldInfos getHoldInfoByOrderId(String orderId) {
		
		try {
			List<Hold> list = companyInfoDAO.editHoldInfoByOrderId(orderId);
			
			HoldInfos holdInfos = new HoldInfos();
			
			String[] ids = null;
			String[] types = null;
			String[] controlPersons = null;
			String[] paperTypes = null;
			String[] paperNumbers = null;
			String[] workYears = null;
			String[] educations = null;
			String[] marriages = null;
			
			//数据整理
			if (list != null && list.size() > 0) {
				int count = list.size();
				
				ids = new String[count];
				types = new String[count];
				controlPersons = new String[count];
				paperTypes = new String[count];
				paperNumbers = new String[count];
				workYears = new String[count];
				educations = new String[count];
				marriages = new String[count];
				
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
				
			}else {
				ids = new String[2];
				types = new String[2];
				controlPersons = new String[2];
				paperTypes = new String[2];
				paperNumbers = new String[2];
				workYears = new String[2];
				educations = new String[2];
				marriages = new String[2];
				
				for (int i = 0; i < 2; i++) {
					ids[i] ="";
					types[i] ="";
					controlPersons[i] ="";
					paperTypes[i] ="";
					paperNumbers[i] ="";
					workYears[i] ="";
					educations[i] ="";
					marriages[i] ="";
				}
				
			}
			holdInfos.setIds(ids);
			holdInfos.setHoldTypes(types);
			holdInfos.setControlPersons(controlPersons);
			holdInfos.setPaperTypes(paperTypes);
			holdInfos.setPaperNumbers(paperNumbers);
			holdInfos.setWorkYears(workYears);
			holdInfos.setEducations(educations);
			holdInfos.setMarriages(marriages);
			
			return holdInfos;
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
			e.printStackTrace();
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
				if (!realEstate.getFactory().equals("")) {
					realEstate.setFactory(df.format(Double.parseDouble(realEstate.getFactory())));
				}else {
					realEstate.setFactory("");
				}
				if (!realEstate.getLand().equals("")) {
					realEstate.setLand(df.format(Double.parseDouble(realEstate.getLand())));
				} else {
					realEstate.setLand("");
				}
				if (!realEstate.getOffice().equals("")) {
					realEstate.setOffice(df.format(Double.parseDouble(realEstate.getOffice())));
				} else {
					realEstate.setOffice("");
				}
				if (!realEstate.getShop().equals("")) {
					realEstate.setShop(df.format(Double.parseDouble(realEstate.getShop())));
				} else {
					realEstate.setShop("");
				}
				if (!realEstate.getPrivateProperty().equals("")) {
					realEstate.setPrivateProperty(df.format(Double.parseDouble(realEstate.getPrivateProperty())));
				} else {
					realEstate.setPrivateProperty("");
				}
				if (!realEstate.getEquipment().equals("")) {
					realEstate.setEquipment(df.format(Double.parseDouble(realEstate.getEquipment())));
				} else {
					realEstate.setEquipment("");
				}
				if (!realEstate.getOther().equals("")) {
					realEstate.setOther(df.format(Double.parseDouble(realEstate.getOther())));
				} else {
					realEstate.setOther("");
				}
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
	public List<Document> getDocumentInfoById(String memberId,int index) {
		
		try {
			HashMap<String, Object> map = new HashMap<>();
			map.put("memberId", memberId);
			map.put("index", index);
			
			List<Document> list = companyInfoDAO.getDocumentInfo(map);
			
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
				if (!companyBase.getRegisterFund().equals("")) {
					companyBase.setRegisterFund(df.format(Double.parseDouble(companyBase.getRegisterFund())));
				} else {
					companyBase.setRegisterFund("");
				}
				if (!companyBase.getFactFund().equals("")) {
					companyBase.setFactFund(df.format(Double.parseDouble(companyBase.getFactFund())));
				} else {
					companyBase.setFactFund("");
				}
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
			
			String[] ids = null;
			String[] types = null;
			String[] controlPersons = null;
			String[] paperTypes = null;
			String[] paperNumbers = null;
			String[] workYears = null;
			String[] educations = null;
			String[] marriages = null;
			
			//数据整理
			if (list != null && list.size() > 0) {
				int count = list.size();
				
				ids = new String[count];
				types = new String[count];
				controlPersons = new String[count];
				paperTypes = new String[count];
				paperNumbers = new String[count];
				workYears = new String[count];
				educations = new String[count];
				marriages = new String[count];
				
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
				
			}else {
				ids = new String[2];
				types = new String[2];
				controlPersons = new String[2];
				paperTypes = new String[2];
				paperNumbers = new String[2];
				workYears = new String[2];
				educations = new String[2];
				marriages = new String[2];
				
				for (int i = 0; i < 2; i++) {
					ids[i] ="";
					types[i] ="";
					controlPersons[i] ="";
					paperTypes[i] ="";
					paperNumbers[i] ="";
					workYears[i] ="";
					educations[i] ="";
					marriages[i] ="";
				}
				
			}
			holdInfos.setIds(ids);
			holdInfos.setHoldTypes(types);
			holdInfos.setControlPersons(controlPersons);
			holdInfos.setPaperTypes(paperTypes);
			holdInfos.setPaperNumbers(paperNumbers);
			holdInfos.setWorkYears(workYears);
			holdInfos.setEducations(educations);
			holdInfos.setMarriages(marriages);
			
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
					if (list.get(i).getTotalSales() != null && !list.get(i).getTotalSales().equals("")) {
						totalSales[i] = df.format(Double.parseDouble(list.get(i).getTotalSales()));
					}else {
						totalSales[i] = "";
					}
					if (list.get(i).getMonthWaterMoney() != null && !list.get(i).getMonthWaterMoney().equals("")) {
						monthWaterMoneys[i] = df.format(Double.parseDouble(list.get(i).getMonthWaterMoney()));
					} else {
						monthWaterMoneys[i] = "";
					}
					if (list.get(i).getMonthOrderMoney() != null && !list.get(i).getMonthOrderMoney().equals("")) {
						monthOrderMoneys[i] = df.format(Double.parseDouble(list.get(i).getMonthOrderMoney()));
					} else {
						monthOrderMoneys[i] = "";
					}
					if (list.get(i).getMonthElectricMoney() != null && !list.get(i).getMonthElectricMoney().equals("")) {
						monthElectricMoneys[i] = df.format(Double.parseDouble(list.get(i).getMonthElectricMoney()));
					} else {
						monthElectricMoneys[i] = "";
					}
					if (list.get(i).getTotalVAT() != null && !list.get(i).getTotalVAT().equals("")) {
						totalVATs[i] = df.format(Double.parseDouble(list.get(i).getTotalVAT()));
					} else {
						totalVATs[i] = "";
					}
					if (list.get(i).getTotalIncomeTax() != null && !list.get(i).getTotalIncomeTax().equals("")) {
						totalIncomeTaxs[i] = df.format(Double.parseDouble(list.get(i).getTotalIncomeTax()));
					} else {
						totalIncomeTaxs[i] = "";
					}
				}
			}else {
				ids = new String[3];
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
					ids[i] = "";
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
			businessInfos.setIds(ids);
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

//	@Override
//	public List<Document> editDocumentInfoById(String memberId) {
//		try {
//			HashMap<String, Object> map = new HashMap<>();
//			map.put("memberId", memberId);
//			map.put("index", index);
//			List<Document> list = companyInfoDAO.getDocumentInfoById(memberId,"0");
//			
//			return list;
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
//		return null;
//	}

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
			if (applicant.getTwoYearCredit().equals("")) {
				map.put("twoYearCredit", null);
			} else {
				map.put("twoYearCredit", applicant.getTwoYearCredit());
			}
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
			if (applicant.getInterestRate().equals("")) {
				map.put("interestRate", null);
			} else {
				map.put("interestRate", applicant.getInterestRate());
			}
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
			if (applicant.getGuaranteeProvince().equals("0") || applicant.getGuaranteeProvince().equals("")) {
				map.put("guaranteeProvince", null);
			}else {
				map.put("guaranteeProvince", applicant.getGuaranteeProvince());
			}
			if (applicant.getGuaranteeCity().equals("0") || applicant.getGuaranteeCity().equals("")) {
				map.put("guaranteeCity", null);
			}else {
				map.put("guaranteeCity", applicant.getGuaranteeCity());
			}
			if (applicant.getGuaranteeZone().equals("0") || applicant.getGuaranteeZone().equals("")) {
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
			map.put("taxCodeN", companyBase.getTaxCodeN());
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
					if (count > 0) {
						companyBase.setId(id);
						return true;
					}
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
		String[] ids = new String[holdInfos.getIds().length]; 
		
		String type = "add";
		try {
			for (int i = 0; i < 2; i++) {
				Hold temp = new Hold();
				if (holdInfos.getIds()[i].equals("")) {
					String uuid = UUID.randomUUID().toString().replace("-", "");
					temp.setId(uuid);
					temp.setOrderNum(String.valueOf(i));
					ids[i] = uuid;
					type = "add";
				} else {
					temp.setId(holdInfos.getIds()[i]);
					type = "update";
				}
				if (holdInfos.getHoldTypes()[i].equals("")) {
					temp.setHoldType(null);
				} else {
					temp.setHoldType(holdInfos.getHoldTypes()[i]);
				}
				if (holdInfos.getControlPersons()[i].equals("")) {
					temp.setControlPerson(null);
				} else {
					temp.setControlPerson(holdInfos.getControlPersons()[i]);
				}
				if (holdInfos.getPaperTypes()[i].equals("")) {
					temp.setPaperType(null);
				} else {
					temp.setPaperType(holdInfos.getPaperTypes()[i]);
				}
				if (holdInfos.getPaperNumbers()[i].equals("")) {
					temp.setPaperNumber(null);
				} else {
					temp.setPaperNumber(holdInfos.getPaperNumbers()[i]);
				}
				if (holdInfos.getWorkYears()[i].equals("")) {
					temp.setWorkYear(null);
				} else {
					temp.setWorkYear(holdInfos.getWorkYears()[i]);
				}
				if (holdInfos.getEducations()[i].equals("")) {
					temp.setEducation(null);
				} else {
					temp.setEducation(holdInfos.getEducations()[i]);
				}
				if (holdInfos.getMarriages()[i].equals("")) {
					temp.setMarriage(null);	
				}else {
					temp.setMarriage(holdInfos.getMarriages()[i]);
				}
				
				holds.add(temp);
			}
			
			//持久化
			int count = 0;
			if (type.equals("add")) {
				count = companyInfoDAO.saveHolds(holds);
				if (count>0) {
					count = companyInfoDAO.saveMemberHolds(holds,user);
				}
				holdInfos.setIds(ids);
				
			}else {
				count = companyInfoDAO.updateHolds(holds,user);
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
	public boolean saveControl(Control control, String memberId, String user) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		int count = 0;
		try {
			map.clear();
			if (control.getIndustry().equals("")) {
				map.put("industry", null);
			}else {
				map.put("industry", control.getIndustry());
			}
			if (control.getBusinessStartDate().equals("")) {
				map.put("businessStartDate", null);
			} else {
				map.put("businessStartDate", control.getBusinessStartDate());
			}
			if ( control.getBusinessArea().equals("")) {
				map.put("businessArea", null);
			} else {
				map.put("businessArea", control.getBusinessArea());
			}
			if (control.getSaleArea().equals("")) {
				map.put("saleArea", null);
			} else {
				map.put("saleArea", control.getSaleArea());
			}
			if (control.getFixedBusinessPlace().equals("")) {
				map.put("fixedBusinessPlace",null);
			} else {
				map.put("fixedBusinessPlace", control.getFixedBusinessPlace());
			}
			if (control.getInterYear().equals("")) {
				map.put("interYear", null);
			} else {
				map.put("interYear", control.getInterYear());
			}
			if (control.getAuditType().equals("")) {
				map.put("auditType", null);
			} else {
				map.put("auditType", control.getAuditType());
			}
			if (control.getPeopleNumber().equals("")) {
				map.put("peopleNumber", null);	
			}else {
				map.put("peopleNumber", control.getPeopleNumber());
			}
			if (control.getHaveLoanCard().equals("")) {
				map.put("haveLoanCard", null);
			} else {
				map.put("haveLoanCard", control.getHaveLoanCard());
			}
			if (control.getLoanCardNumber().equals("")) {
				map.put("loanCardNumber", null);
			} else {
				map.put("loanCardNumber", control.getLoanCardNumber());
			}
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
	public boolean saveBusiness(BusinessInfos businessInfos, String memberId, String user) {
		
		List<Business> businesses = new ArrayList<>();
		
		String type = "add";
		
		try {
			for (int i = 0; i < 3; i++) {
				Business temp = new Business();
				
				if (businessInfos.getIds()[i].equals("")) {
					temp.setId(UUID.randomUUID().toString().replace("-", ""));
					type = "add";
				}else {
					temp.setId(businessInfos.getIds()[i]);
					type = "update";
				}
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
				
				temp.setTargetId(memberId);
				temp.setTargetType("1");
				
				businesses.add(temp);
			}
			
			int count = 0;
			if (type.equals("add")) {
				count = companyInfoDAO.saveBusiness(businesses,user);
			}else {
				count = companyInfoDAO.updateBusiness(businesses,user);
			}
			
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
			
			String id = UUID.randomUUID().toString().replace("-", "");
			if (estate.getId().equals("")) {
				
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
				estate.setId(id);
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
			
			String id = UUID.randomUUID().toString().replace("-", "");
			if (debt.getId().equals("")) {
				
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
				debt.setId(id);
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		return false;
	}

	@Override
	public BusinessInfos initBusinessInfo() {
		
		String[] years = new String[3];
		
		Calendar calendar = Calendar.getInstance();
		int nowYear = calendar.get(Calendar.YEAR);
		
		BusinessInfos businessInfos = new BusinessInfos();
		for (int i = 0; i < 3; i++) {
			years[i] = String.valueOf(nowYear-i);
		}
		businessInfos.setYears(years);
		
		return businessInfos;
	}

	@Override
	public Rating editRating(String ratingId) {
		
//		Rating rating = new Rating();
//		
//		int result = companyInfoDAO.editRatingById(ratingId);
		
		return null;
	}

	@Override
	public int getDocumentCount() {
		return companyInfoDAO.getDocumentCount();
	}

	@Override
	public String updateDocument(String filePath,String fileId, String typeId,String memberId) {
		
		int result = 0;
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("filePath", filePath);
			map.put("typeId", typeId);
			map.put("memberId", memberId);
			
			if (fileId.equals("")) {
				fileId = UUID.randomUUID().toString().replace("-", "");
				map.put("fileId", fileId);
				
				result = companyInfoDAO.saveDocument(map);
			}else {
				map.put("fileId", fileId);
				
				result = companyInfoDAO.updateDocument(map);
			}
			
			if (result > 0) {
				return fileId;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return "";
	}

	@Override
	public List<Document> editDocuments(String memberId) {
		
		List<Document> list = null;
		try {
			list = companyInfoDAO.getDocumentByMemberId(memberId);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return list;
	}

	
}
