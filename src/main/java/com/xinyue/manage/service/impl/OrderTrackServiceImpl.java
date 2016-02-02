package com.xinyue.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.OrderInfo;
import com.xinyue.manage.dao.FastProductDAO;
import com.xinyue.manage.dao.OrderCustomerDAO;
import com.xinyue.manage.dao.OrderDAO;
import com.xinyue.manage.dao.OrderTrackDAO;
import com.xinyue.manage.model.FastProduct;
import com.xinyue.manage.model.Order;
import com.xinyue.manage.model.OrderAppointed;
import com.xinyue.manage.model.OrderFixed;
import com.xinyue.manage.model.OrderTrack;
import com.xinyue.manage.service.OrderTrackService;
import com.xinyue.manage.util.GlobalConstant;

/**
 * author lzc
 */
@Service
public class OrderTrackServiceImpl implements OrderTrackService{
	
	@Resource
	private OrderDAO orderDAO;
	
	@Resource
	private FastProductDAO fastProductDAO;
	
	@Resource
	private OrderCustomerDAO orderCustomerDAO;
	
	@Resource 
	private OrderTrackDAO orderTrackDAO;
	
	Logger log = Logger.getLogger(getClass());
	
	@Override
	public OrderInfo getOrderInfo(String customerId, String orderType) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = new OrderInfo();
		
		switch (orderType) {
		case GlobalConstant.ORDER_TYPE_FIXED://立即领取
			OrderFixed orderFixed  = orderCustomerDAO.getOrderFixedById(customerId);
			if(orderFixed.getType() == 1){//订单
				orderInfo = orderCustomerDAO.getOrderInfoByFixedOrder(customerId);
			}else if (orderFixed.getType() == 2) {//快速申贷
				orderInfo = orderCustomerDAO.getOrderInfoByFixedFast(customerId);
			}
			break;
		case GlobalConstant.ORDER_TYPE_APPOINTED://指定推送
			OrderAppointed orderAppointed = orderCustomerDAO.getOrderAppointById(customerId);
			if(orderAppointed.getType() == 1){//订单
				orderInfo = orderCustomerDAO.getOrderInfoByAppointedOrder(customerId);
			}else if (orderAppointed.getType() == 2) {//快速申贷
				orderInfo = orderCustomerDAO.getOrderInfoByAppointedFast(customerId);
			}
			break;
		default:
			orderInfo = null;
			break;
		}
		return orderInfo;
	}

	@Override
	public List<OrderTrack> getOrderTrackList(String orderId, String type, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return orderTrackDAO.getOrderTrackList(orderId, type, pageNo, pageSize);
	}

	@Override
	public boolean addOrderTrack(OrderTrack orderTrack, String user) {
		// TODO Auto-generated method stub
		try {
			if(orderTrack.getOrderType().equals("1")){//订单
				Order order = new Order();
				order.setId(orderTrack.getOrderId());
				order.setStatus(orderTrack.getOrderStatus());
				order.setBlankAuditePerson(user);
				order.setBlankAuditeRemark(orderTrack.getRemark());
				order.setRemark(orderTrack.getRemark());
				order.setCreditReal(orderTrack.getCreditReal());
				order.setAuditeTime(orderTrack.getCreditTime());
				order.setModifiedId(orderTrack.getCreatedId());
				
				orderDAO.updateOrder(order);
			}else {//快速申贷
				FastProduct fastProduct = new FastProduct();
				fastProduct.setId(orderTrack.getOrderId());
				fastProduct.setStatus(orderTrack.getOrderStatus());
				fastProduct.setBlankAuditePerson(user);
				fastProduct.setBlankAuditeRemark(orderTrack.getRemark());
				fastProduct.setRemark(orderTrack.getRemark());
				fastProduct.setCreditReal(orderTrack.getCreditReal());
				fastProduct.setAuditeTime(orderTrack.getCreditTime());
				fastProduct.setModifiedId(orderTrack.getCreatedId());
				fastProductDAO.modifiedFastProductStatus(orderTrack.getCreatedId(), fastProduct);
			}
			orderTrackDAO.addOrderTrack(orderTrack);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.fatal(e.toString());
			throw new RuntimeException();
			
		}
	}
}
