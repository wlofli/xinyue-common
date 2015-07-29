package com.xinyue.manage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.BusinessInfos;
import com.xinyue.manage.beans.SearchOrder;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.CompanyInfoDAO;
import com.xinyue.manage.dao.OrderDAO;
import com.xinyue.manage.model.Applicant;
import com.xinyue.manage.model.Business;
import com.xinyue.manage.model.Debt;
import com.xinyue.manage.model.Document;
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
		return orderDAO.getOrderInfo(id,GlobalConstant.ORDER_STATUS);
	}


	@Override
	public Order getOrder(String id) {
		// TODO Auto-generated method stub
		return orderDAO.getOrder(id,GlobalConstant.ORDER_STATUS);
	}

	@Override
	public boolean updateOrder(Order order) {
		try {
//System.out.println(order.getStatus());
//System.out.println("taxs======="+order.getTaxAuditeStatus());	
//System.out.println("blankx=========="+order.getBlankAuditeStatus());
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
System.out.println("debt===============" + debt.getId());
System.out.println("realestate=============" + realEstate.getId());
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


	
	



}
