package com.xinyue.manage.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.BusinessInfos;
import com.xinyue.manage.beans.CustomerInfo;
import com.xinyue.manage.beans.HoldInfos;
import com.xinyue.manage.beans.SearchCustomer;
import com.xinyue.manage.beans.SearchOrder;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.CompanyInfoDAO;
import com.xinyue.manage.dao.OrderDAO;
import com.xinyue.manage.model.Applicant;
import com.xinyue.manage.model.Business;
import com.xinyue.manage.model.CompanyBase;
import com.xinyue.manage.model.Control;
import com.xinyue.manage.model.CreditManager;
import com.xinyue.manage.model.Debt;
import com.xinyue.manage.model.Document;
import com.xinyue.manage.model.FastProductApplicant;
import com.xinyue.manage.model.FastProductCompany;
import com.xinyue.manage.model.Hold;
import com.xinyue.manage.model.Order;
import com.xinyue.manage.model.RealEstate;
import com.xinyue.manage.service.OrderService;
import com.xinyue.manage.util.GlobalConstant;

/**
 * author lzc
 * 2015年6月1日上午11:01:50
 */
@Service
public class OrderServiceImpl implements OrderService{
	
	@Resource
	private OrderDAO orderDAO;
	
	@Resource 
	private CompanyInfoDAO companyInfoDAO;
	
	private Logger log = Logger.getLogger(getClass());
	

	@Override
	public List<Order> getListByPage(Order order, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return orderDAO.getListByPage(order, pageSize , pageNo * pageSize, GlobalConstant.ORDER_STATUS);
	}
	
	
	@Override
	public List<Order> getListByStatus(Order order, int pageSize, int pageNo,
			List<String> statusList) {
		// TODO Auto-generated method stub
		if(statusList != null && statusList.size() == 0)
			statusList = null;
		return orderDAO.getListByStatus(order, pageSize, pageNo * pageSize, statusList, GlobalConstant.ORDER_STATUS);
	}

	@Override
	public int getCount(Order order) {
		// TODO Auto-generated method stub
		return orderDAO.getCount(order);
	}
	@Override
	public Order getOrderInfo(String id) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderInfo(id, GlobalConstant.ORDER_MEMBER_STATUS);
	}


	@Override
	public Order getOrder(String id) {
		// TODO Auto-generated method stub
		return orderDAO.getOrder(id, GlobalConstant.ORDER_STATUS);
	}

	@Override
	public boolean updateOrder(Order order) {
		try {
			orderDAO.updateOrder(order);
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.toString());
			throw new RuntimeException();
		}
		return true;
	}

	@Override
	public List<SelectInfo> getStatus(String typeCode) {
		// TODO Auto-generated method stub
		return orderDAO.getStatus(typeCode);
	}

	@Override
	public List<Document> getDocumentInfoById(String id) {
		// TODO Auto-generated method stub

		try {
			List<Document> list = orderDAO.getDocumentInfoById(id);
			return list;
		} catch (Exception e) {
			log.error(e.getMessage());
			
		}
		return null;
	}

	@Override
	public boolean updateOrderList(List<String> idList, String status,
			String userId) {
		// TODO Auto-generated method stub
		try {
			orderDAO.updateOrderTypeList(idList, status, userId);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
		return true;
	}


	@Override
	public int getCountByStatus(Order order, List<String> status) {
		// TODO Auto-generated method stub
		if(status != null && status.size() == 0)
		 status = null;
		return orderDAO.getCountByStatus(order, status);
		
	}


	@Override
	public List<Order> getListByMemberId(String memberId, SearchOrder order, int pageSize, int PageNo) {
		// TODO Auto-generated method stub
		return orderDAO.getListByMemberId(memberId, order, GlobalConstant.ORDER_MEMBER_STATUS, pageSize, PageNo * pageSize);
	}


	@Override
	public int getCountByMemberId(String id, SearchOrder order) {
		// TODO Auto-generated method stub
		return orderDAO.getCountByMemeberId(id, order);
	}


	@Override
	public boolean deleteOrderList(List<String> idList, String modifiedId) {
		// TODO Auto-generated method stub
		try {
			if(idList != null && idList.size() == 0 )
				idList = null;
			orderDAO.deleteOrderList(idList, modifiedId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
	}

	@Override
	public boolean addOrUpdateApplicant(Applicant applicant, String orderId,
			String modifiedId,int state) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<>();
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
			if(applicant.getCreditPurpose().equals("")){
				map.put("creditPurpose", null);
			}else {
				map.put("creditPurpose", applicant.getCreditPurpose());
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
			map.put("id", applicant.getId());
			map.put("user", modifiedId);
			if(state == 0){
				map.put("type", "app");
				map.put("applicantId", applicant.getId());
				map.put("orderId", orderId);
				orderDAO.updateOrderDetail(map);
				companyInfoDAO.addApplicant(map);
			}else {
				companyInfoDAO.updateApplicant(map);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException();
		}
		return true;
	}


	@Override
	public boolean addOrUpdateDebt(Debt debt, RealEstate realEstate,
			String orderId, String modifiedId, int state) {
		// TODO Auto-generated method stub
		//负债
		HashMap<String, Object> map = new HashMap<>();
		//抵押物
		HashMap<String, Object> map1 = new HashMap<>();
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
			map.put("user", modifiedId);
			
			map1.clear();
			map1.put("factory", realEstate.getFactory());
			map1.put("land", realEstate.getLand());
			map1.put("office", realEstate.getOffice());
			map1.put("shop", realEstate.getShop());
			map1.put("private", realEstate.getPrivateProperty());
			map1.put("equipment", realEstate.getEquipment());
			map1.put("other", realEstate.getOther());
			map1.put("user", modifiedId);
			map1.put("id", realEstate.getId());
			map.put("id", debt.getId());
			if (state == 0) {
				companyInfoDAO.addDebt(map);
				map.clear();
				map1.put("user", modifiedId);
				map.put("debt", debt.getId());
				map.put("realEstate", realEstate.getId());
				map.put("type", "debt");
				map.put("orderId", orderId);
				
				companyInfoDAO.addEstate(map1);
				orderDAO.updateOrderDetail(map);
			}else {
				companyInfoDAO.updateDebt(map);
				companyInfoDAO.updateEstate(map1);
			}
		}catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		
		return false;
	}


	@Override
	public boolean addOrUpdateBusiness(BusinessInfos businessInfos,
			String orderId, String modifiedId, int state) {
		// TODO Auto-generated method stub

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
				
				temp.setTargetId(orderId);
				temp.setTargetType("2");
				businesses.add(temp);
			}
			
			HashMap<String, Object> map = new HashMap<>();
			map.clear();
			map.put("user", modifiedId);
			map.put("orderId", orderId);
			map.put("type", "business");
			if (state == 0) {
				companyInfoDAO.saveBusiness(businesses,modifiedId);
				orderDAO.updateOrderDetail(map);
			}else {
				companyInfoDAO.updateBusiness(businesses,modifiedId);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException();
		}
		return false;
	}


	@Override
	public boolean addOrUpdateCompany(CompanyBase companyBase, HoldInfos holdInfos,
			Control control, String orderId, String modifiedId, int state) {
		// TODO Auto-generated method stub
			//获取企业基本信息
			HashMap<String, Object> map = getCompanyBase(companyBase);
			//获取治理信息
			HashMap<String, Object> map2 = getControl(control);
			//获取控股信息
			List<Hold> holds = getHoldList(holdInfos);
		try {
			map.put("user", modifiedId);
			map2.put("user", modifiedId);
			map2.put("id", control.getId());
				if(state == 0){
					companyInfoDAO.addCompanyBase(map);
					companyInfoDAO.addControl(map2);
					map.clear();
					map.put("orderId", orderId);
					map.put("licenseId", companyBase.getId());
					map.put("controlId", control.getId());
					map.put("user", modifiedId);
					map.put("type", "comp");
					companyInfoDAO.saveHolds(holds);
					List<String> holdList = new LinkedList<String>();
					for(Hold hold : holds){
						holdList.add(hold.getId());
					}
					orderDAO.addHoldList(holdList, orderId);
					orderDAO.updateOrderDetail(map);
				}else {
					companyInfoDAO.updateCompanyBase(map);
					companyInfoDAO.updateHolds(holds,modifiedId);
					companyInfoDAO.updateControl(map2);
					
				}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		return true;
	}
	
	@Override
	public boolean addDocumentList(List<Document> documentList,
			String orderId,  String modifiedId) {
		// TODO Auto-generated method stub
		try {
			if(documentList.size() > 0){
				List<String> documentIdList = new LinkedList<String>();
				for (Document document : documentList) {
					documentIdList.add(document.getDocumentId());
				}
				orderDAO.addDocumentList(documentIdList, orderId);
			}
			HashMap<String, Object> map = new HashMap<>();
			map.clear();
			map.put("user", modifiedId);
			map.put("type", "document");
			map.put("orderId", orderId);
			orderDAO.updateOrderDetail(map);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.toString());
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return true;
	}
	
	@Override
	public boolean addOrUpdateDocument(String filePath,String memberId, String typeId, String dId, String orderId, String documentId) {
		// TODO Auto-generated method stub
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("filePath", filePath);
			map.put("typeId", typeId);
			map.put("memberId", memberId);
			map.put("fileId", dId);
			companyInfoDAO.saveDocumentByOrder(map);
			if(documentId != null){
				orderDAO.deleteDocument(documentId, orderId);
			}
			orderDAO.addDocument(dId, orderId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException();
		}
		return true;
	}


	
	
	private List<Hold> getHoldList(HoldInfos holdInfos){
		//holdInfos
		List<Hold> holds = new ArrayList<>();
		try {
			for (int i = 0; i < 2; i++) {
				Hold temp = new Hold();
				temp.setId(holdInfos.getIds()[i]);
				temp.setOrderNum(String.valueOf(i));
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
			return holds;
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return null;
			
	}

	
	private HashMap<String, Object> getCompanyBase(CompanyBase companyBase){
			HashMap<String, Object> map = new HashMap<>();
			map.clear();
			map.put("companyName", companyBase.getCompanyName());
			map.put("legalPerson", companyBase.getLegalPerson());
			map.put("paperType", companyBase.getPaperType());
			map.put("paperNumber", companyBase.getPaperNumber());
			map.put("licenseeNumber", companyBase.getLicenseeNumber());
			map.put("controlInfo", companyBase.getControlInfo());
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
			map.put("id", companyBase.getId());
			return map;
	}
	
	
	private HashMap<String, Object> getControl(Control control){
			HashMap<String, Object> map = new HashMap<>();
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
			return map;
	}


	@Override
	public List<Document> getDocumentList(String orderId, int index) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<>();
		map.clear();
		map.put("orderId", orderId);
		map.put("index", index);
		return orderDAO.getDocumentByOrderId(map);
	}


	@Override
	public int getDocumentCount(String orderId) {
		// TODO Auto-generated method stub
		return orderDAO.getDocumentCount(orderId);
	}


	@Override
	public boolean updateOrderEvaluate(Order order, String modifiedId) {
		// TODO Auto-generated method stub
		try {
			orderDAO.updateOrderEvaluate(order, modifiedId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public CreditManager getCreditManagerByName(String name) {
		// TODO Auto-generated method stub
		try {
			return orderDAO.getCreditManagerByName(name);
		} catch (Exception e) {
			// TODO: handle exception
			//可能会出现信贷经理同名情形,查询 1 but found n
			log.error(e.toString());
			throw new RuntimeException();
		}
	}
	
	@Override
	public List<SelectInfo> getCreditMangerList() {
		// TODO Auto-generated method stub
		return orderDAO.getCreditManagerList();
	}
	
	@Override
	public boolean addFastOrderTypeTwo(String stepOneData,
			FastProductApplicant applicantFast, FastProductCompany companyFast) {
		
		int result = 0;
		
		SimpleDateFormat sf = new SimpleDateFormat("yyMMddHHmmss");
		
		try {
			//生成申请人信息
			String applicantId = UUID.randomUUID().toString().replace("-", "");
			applicantFast.setApplicantFastId(applicantId);
			result = orderDAO.addFastApplicant(applicantFast);
			
			//生成公司信息
			String companyId = UUID.randomUUID().toString().replace("-", "");
			companyFast.setCompanyFastId(companyId);
			result = orderDAO.addFastCompany(companyFast);
			
			//生成快速订单
			String fastId = UUID.randomUUID().toString().replace("-", "");
			String orderId = "F"+sf.format(new Date());
			HashMap<String, Object> map = new HashMap<>();
			map.put("id", fastId);
			map.put("company", companyFast.getCompanyName());
			map.put("code", orderId);
			map.put("province", applicantFast.getRegisterProvince());
			map.put("city", applicantFast.getRegisterCity());
			map.put("zone", applicantFast.getRegisterZone());
			map.put("phone", stepOneData.split("&")[0]);
			map.put("manageid", stepOneData.split("&")[1]);
			map.put("productid", stepOneData.split("&")[2]);
			map.put("type", 2);
//			if (stepOneData.split("&").length>2) {
//				map.put("mark", stepOneData.split("&")[1]);
//			}else {
//				map.put("mark", "");
//			}
			map.put("applicantFastId", applicantId);
			map.put("companyFastId", companyId);
			
			result = orderDAO.addFastOrder(map);
			
			if (result > 0) {
				return true;
			}
			
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException();
		}
		return false;
	}


	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
//		订单初始化
		order.setApplicantSave(0);
		order.setBusinessSave(0);
		order.setCompanySave(0);
		order.setDebtSave(0);
		order.setDocumentSave(0);
		order.setStatus("0");
		try {
			orderDAO.addOrder(order);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<CustomerInfo> getCustomerInfoByCondition(
			SearchCustomer searchCustomer) {
		
		List<CustomerInfo> infos = orderDAO.getCustomerInfoByCondition(searchCustomer);
		
		return infos;
	}


	@Override
	public int getCustomerInfoCountByCondition(SearchCustomer searchCustomer) {
		
		return orderDAO.getCustomerInfoCountByCondition(searchCustomer);
	}


	@Override
	public CustomerInfo getOrderTrackByOrderId(String id) {
		
		return orderDAO.getOrderTrackByOrderId(id);
	}


	@Override
	public String saveOrderStatus(Order order, String modifiedId) {
		// TODO Auto-generated method stub
		if (order.getApplicantSave() != 1) 
			return "申请人信息未保存";
		if (order.getCompanySave() != 1) 
			return "企业基本信息未保存";
		if(order.getBusinessSave() != 1)
			return "基本经营信息未保存";
		if (order.getDebtSave() != 1) 
			return "抵押物与负债信息未保存";
		order.setModifiedId(modifiedId);
		order.setStatus("1");
		try {
			orderDAO.updateOrder(order);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return GlobalConstant.RET_SUCCESS;
	}
	
}
