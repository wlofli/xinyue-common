package com.xinyue.manage.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.SearchOrder;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.CompanyInfoDAO;
import com.xinyue.manage.dao.OrderDAO;
import com.xinyue.manage.model.Applicant;
import com.xinyue.manage.model.Document;
import com.xinyue.manage.model.Order;
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


	
	



}
