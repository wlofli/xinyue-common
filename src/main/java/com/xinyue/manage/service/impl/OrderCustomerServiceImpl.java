package com.xinyue.manage.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.OrderCustomer;
import com.xinyue.manage.beans.SearchCustomer;
import com.xinyue.manage.beans.SearchOrderCredit;
import com.xinyue.manage.dao.OrderCustomerDAO;
import com.xinyue.manage.dao.OrderDAO;
import com.xinyue.manage.model.OrderAppointed;
import com.xinyue.manage.model.OrderAuction;
import com.xinyue.manage.model.OrderFixed;
import com.xinyue.manage.model.OrderLowPrice;
import com.xinyue.manage.service.OrderCustomerService;
import com.xinyue.manage.util.GlobalConstant;

/**
 * author lzc
 * 2015年7月1日下午5:01:44
 */
/**
 *  lzc @date 2015年12月16日  saveOrderFixed()添加receiver
 *
 */
@Service
public class OrderCustomerServiceImpl implements OrderCustomerService{
	
	@Resource
	private OrderCustomerDAO orderCustomerDAO;
	
	@Resource
	private OrderDAO orderDAO;
	
	Logger log = Logger.getLogger(getClass());

	@Override
	public boolean addOrderAppointed(OrderAppointed orderAppointed,
			String tableName, String orderStatus) {
		// TODO Auto-generated method stub
		try {
			orderCustomerDAO.addOrderAppointed(orderAppointed);
			orderCustomerDAO.updateOrderType(tableName, orderStatus, GlobalConstant.ORDER_TYPE_APPOINTED, 
					orderAppointed.getCreatedId(),orderAppointed.getOrderId(), GlobalConstant.ORDER_STATUS_PASS_SET);
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.toString());
			throw new RuntimeException();
		}
		return true;
	}
	
	@Override
	public boolean addOrderAuction(OrderAuction orderAuction, String tableName,
			String orderStatus) {
		// TODO Auto-generated method stub
		try {
			orderCustomerDAO.addOrderAuction(orderAuction);
			orderCustomerDAO.updateOrderType(tableName, orderStatus, GlobalConstant.ORDER_TYPE_AUCTION,
					orderAuction.getCreatedId(),orderAuction.getOrderId(), GlobalConstant.ORDER_STATUS_PASS_SET);
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.toString());
			throw new RuntimeException();
		}
		return true;
	}

	@Override
	public boolean addOrderFixed(OrderFixed orderFixed, String tableName,
			String orderStatus) {
		// TODO Auto-generated method stub
		try {
			orderCustomerDAO.addOrderFixed(orderFixed);
			orderCustomerDAO.updateOrderType(tableName, orderStatus, GlobalConstant.ORDER_TYPE_FIXED,
					orderFixed.getCreatedId(),orderFixed.getOrderId(), GlobalConstant.ORDER_STATUS_PASS_SET);
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.toString());
			throw new RuntimeException();
		}
		return true;
	}

	@Override
	public boolean addOrderLowPrice(OrderLowPrice orderLowPrice,
			String tableName, String orderStatus) {
		// TODO Auto-generated method stub
		try {
			orderCustomerDAO.addOrderLowPrice(orderLowPrice);
			orderCustomerDAO.updateOrderType(tableName, orderStatus, GlobalConstant.ORDER_TYPE_LOWPRICE, 
					orderLowPrice.getCreatedId(),orderLowPrice.getOrderId(), GlobalConstant.ORDER_STATUS_PASS_SET);
		} catch (Exception e) {
			// TODO: handle exception
			log.info(e.toString());
			throw new RuntimeException();
		}
		return true;
	}



	@Override
	public OrderFixed getOrderFixed(String orderId, int type) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.getOrderFixed(orderId, type);
	}

	@Override
	public OrderAuction getOrderAuction(String orderId, int type) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.getOrderAuction(orderId, type);
	}

	@Override
	public OrderAppointed getOrderAppointed(String orderId, int type) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.getOrderAppointed(orderId, type);
	}

	@Override
	public OrderLowPrice getOrderLowPrice(String orderId, int type) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.getOrderLowPrice(orderId, type);
	}
	
	@Override
	public boolean deleteOrderCustom(String tableName, String id, String modifiedId, String orderStatus) {
		// TODO Auto-generated method stub
		String orderType = orderCustomerDAO.getOrderType(tableName, id);
		if(orderType != null){
			//竞拍表||立即领取表||指定客户表||最低价表表名
			String orderTabName = null;
			switch (orderType) {
			case GlobalConstant.ORDER_TYPE_FIXED:
				orderTabName = GlobalConstant.ORDER_TABNAME_FIXED;
				break;
			case GlobalConstant.ORDER_TYPE_AUCTION:
				orderTabName = GlobalConstant.ORDER_TABNAME_AUCTION;
				break;
			case GlobalConstant.ORDER_TYPE_LOWPRICE:
				orderTabName = GlobalConstant.ORDER_TABNAME_LOWPRICE;
				break;
			case GlobalConstant.ORDER_TYPE_APPOINTED:
				orderTabName = GlobalConstant.ORDER_TABNAME_APPOINTED;
				break;
			default:
				break;
			}
			int type = 0 ;
			if(tableName.equals(GlobalConstant.FASTPRODUCT_TABNAME_FAST)){
				 type = GlobalConstant.FASUPRODUCT_CUSTOMER_TYPE;
			}
			if(tableName.equals(GlobalConstant.ORDER_TABLENAME)){
				 type = GlobalConstant.ORDER_CUSTOMER_TYPE;
			}
			try {
				orderCustomerDAO.deleteOrderCustomer(id, orderTabName, modifiedId, type);
				orderCustomerDAO.updateOrderType(tableName, orderStatus, GlobalConstant.ORDER_TYPE_RESET, 
						modifiedId, id,GlobalConstant.ORDER_STATUS_PASS);
				List<String> idList = new LinkedList<String>();
				idList.add(id);
				orderDAO.updateOrderTypeList(idList, GlobalConstant.ORDER_STATUS_PASS, modifiedId);
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException();
			}
			
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public OrderAppointed getOrderAppointedFromOrder(String orderId) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.getOrderAppointedFromOrder(orderId);
	}

	@Override
	public OrderFixed getOrderFixedFromOrder(String orderId) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.getOrderFixedFromOrder(orderId);
	}

	@Override
	public List<OrderFixed> getOrderFixedByPage(SearchCustomer searchCustomer,
			int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.getFixedListByPage(pageNo, pageSize, searchCustomer);
	}

	@Override
	public List<OrderAppointed> getOrderAppointedByPage(
			SearchCustomer searchCustomer, int pageNo, int pageSize,
			String manageId) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.getAppointedListByManageId(manageId, pageNo, pageSize, searchCustomer);
	}

	@Override
	public int countOrderFixedByPage(SearchCustomer searchCustomer) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.countFixedListByPage(searchCustomer);
	}

	@Override
	public int countOrderAppointedByPage(SearchCustomer searchCustomer,
			String manageId) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.countAppointedListByManageId(manageId, searchCustomer);
	}

	@Override
	public boolean saveOrderFixed(String fixId, String manageId, String modifiedId) {
		// TODO Auto-generated method stub
		OrderFixed orderFixed = orderCustomerDAO.getOrderFixedById(fixId);
		try {
//			undone->信贷经理资金未扣除
			
			orderCustomerDAO.updateOrderCustomerManageId(GlobalConstant.ORDER_TABNAME_FIXED, 
					fixId, manageId, modifiedId);
			String tabName;
			if(orderFixed.getType() == 1){
				tabName = GlobalConstant.ORDER_TABLENAME;
			}else {
				tabName = GlobalConstant.FASTPRODUCT_TABNAME_FAST;
			}
			orderCustomerDAO.updateOrderType(tabName, GlobalConstant.ORDER_ORDERSTATUS_GET, null, 
					modifiedId, orderFixed.getOrderId(), null);
			
			orderCustomerDAO.addReceiver(tabName, manageId, orderFixed.getOrderId(), modifiedId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.warn(e.toString());
			throw new RuntimeException();
		}
	}
	
	
	@Override
	public boolean saveOrderAppointed(String appointId, String manageId,
			String modifiedId) {
		OrderAppointed appointed = orderCustomerDAO.getOrderAppointById(appointId);
		try {
//			undone->信贷经理资金未扣除
			orderCustomerDAO.updateOrderCustomerManageId(GlobalConstant.ORDER_TABNAME_APPOINTED,
					appointId, manageId, modifiedId);
			String tabName;
			if(appointed.getType() == 1){
				tabName = GlobalConstant.ORDER_TABLENAME;
			}else {
				tabName = GlobalConstant.FASTPRODUCT_TABNAME_FAST;
			}
			orderCustomerDAO.updateOrderType(tabName, GlobalConstant.ORDER_ORDERSTATUS_GET, null, 
					modifiedId, appointed.getOrderId(), null);
			orderCustomerDAO.addReceiver(tabName, manageId, appointed.getOrderId(), modifiedId);
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			log.warn("获取指定推送订单失败", e);
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderAppointed getOrderAppointedFromFastProduct(String fastId) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.getOrderAppointedFromFastProduct(fastId);
	}

	@Override
	public OrderFixed getOrderFixedFromFastProduct(String fastId) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.getOrderFixedFromFastProduct(fastId);
	}

	@Override
	public List<SearchOrderCredit> getSearchOrderCreditList(String typeCode,
			int[] orderStatus, String manageId) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.getSearchOrderCredit(typeCode, orderStatus, manageId);
	}

	@Override
	public List<OrderCustomer> getMyCustomer(SearchCustomer searchCustomer,
			String manageId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.getMyCustomer(manageId, searchCustomer, pageNo, pageSize);
	}

	@Override
	public int countMyCustomer(SearchCustomer searchCustomer, String manageId) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.countMyCustomer(manageId, searchCustomer);
	}

	@Override
	public List<SearchOrderCredit> getMyCustomerSearchOrderCreditList(
			String typeCode, int[] orderStatus, String manageId) {
		// TODO Auto-generated method stub
		return orderCustomerDAO.getMyCustomerSearchOrderCredit(typeCode, orderStatus, manageId);
	}

	


}
