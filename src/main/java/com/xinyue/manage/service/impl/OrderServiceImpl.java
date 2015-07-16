package com.xinyue.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.SearchOrder;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.dao.OrderDAO;
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
	public List<Order> getListByMemberId(String memberId, SearchOrder order) {
		// TODO Auto-generated method stub
		return orderDAO.getListByMemberId(memberId, order, GlobalConstant.ORDER_INIT);
	}

	



}
