package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.OrderCustomer;
import com.xinyue.manage.beans.SearchCustomer;
import com.xinyue.manage.beans.SearchOrderCredit;
import com.xinyue.manage.model.OrderAppointed;
import com.xinyue.manage.model.OrderAuction;
import com.xinyue.manage.model.OrderFixed;
import com.xinyue.manage.model.OrderLowPrice;

/**
 * author lzc
 * 2015年7月1日下午4:02:13
 * 设为领取客户的操作逻辑
 * 竞拍,指定推送,立即领取,最低低价表的操作
 * 
 */
public interface OrderCustomerService {
	
	/**
	 * 
	 * add by lzc
	 * date: 2015年7月1日
	 * @param orderAppointed 指定客户信息
	 * @param tableName 快速申贷表表名||订单表表名
	 * @param orderStatus 订单状态
	 * @param orderType 订单类型
	 * @return
	 */
	public boolean addOrderAppointed(OrderAppointed orderAppointed,String tableName,String orderStatus);
	
	public boolean addOrderAuction(OrderAuction orderAuction,String tableName,String orderStatus);
	
	public boolean addOrderFixed(OrderFixed orderFixed,String tableName,String orderStatus);
	
	public boolean addOrderLowPrice(OrderLowPrice orderLowPrice, String tableName, String orderStatus);
	
	/**
	 * 
	 * add by lzc
	 * date: 2015年7月3日
	 * @param tableName 表名
	 * @param id 申贷||订单主键
	 * @return
	 */
	public boolean deleteOrderCustom(String tableName,String id, String modifiedId, String orderStatus);
	
	
	/**
	 * 
	 * add by lzc
	 * date: 2015年7月2日
	 * @param orderId 订单id
	 * @param type 订单表或者快速信贷表
	 * @return
	 */
	public OrderFixed getOrderFixed(String orderId,int type);
	/**
	 * 
	 * add by lzc
	 * date: 2015年7月2日
	 * @param orderId 订单id
	 * @param type 订单表或者快速信贷表
	 * @return
	 */
	public OrderAuction getOrderAuction(String orderId, int type);
	
	
	/**
	 * 
	 * add by lzc
	 * date: 2015年7月2日
	 *  @param orderId 订单id
	 * @param type 订单表或者快速信贷表
	 * @return
	 */
	public OrderAppointed getOrderAppointed(String orderId,int type);
	
	/**
	 * 
	 * add by lzc
	 * date: 2015年7月2日
	 * @param orderId 订单id
	 * @param type 订单表或者快速信贷表
	 * @return
	 */
	public OrderLowPrice getOrderLowPrice(String orderId,int type);
	
	/**从订单表及其关系表中获取信息
	 * add by lzc     date: 2015年8月17日
	 * @param orderId
	 * @return
	 */
	public OrderAppointed getOrderAppointedFromOrder(String orderId);
	
	
	/**从快速申贷及其表中获取信息
	 * add by lzc     date: 2015年8月24日
	 * @param orderId
	 * @return
	 */
	public OrderAppointed getOrderAppointedFromFastProduct(String fastId);
	
	/**从订单表及其关系表中获取信息
	 * add by lzc     date: 2015年8月17日
	 * @param orderId
	 * @return
	 */
	public OrderFixed getOrderFixedFromOrder(String orderId);
	
	/**从快速申贷及其表中获取信息
	 * add by lzc     date: 2015年8月24日
	 * @param orderId
	 * @return
	 */
	public OrderFixed getOrderFixedFromFastProduct(String fastId);
	
	/**信贷:获取立即领取列表
	 * add by lzc     date: 2015年8月20日
	 * @param searchCustomer
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<OrderFixed> getOrderFixedByPage(SearchCustomer searchCustomer, int pageNo, int pageSize);
	
	
	public int countOrderFixedByPage(SearchCustomer searchCustomer);
	
	/**信贷:推送客户列表
	 * add by lzc     date: 2015年8月20日
	 * @param searchCustomer
	 * @param pageNo
	 * @param pageSize
	 * @param manageId
	 * @return
	 */
	public List<OrderAppointed> getOrderAppointedByPage(SearchCustomer searchCustomer, int pageNo, int pageSize, String manageId);

	public int countOrderAppointedByPage(SearchCustomer searchCustomer, String manageId);
	
	/**信贷:购买订单
	 * add by lzc     date: 2015年8月21日
	 * @param customerId
	 * @param manageId
	 * @return
	 */
	public boolean saveOrderFixed(String fixId, String manageId, String modifiedId);
	
	
	public List<SearchOrderCredit> getSearchOrderCreditList(String typeCode, int[] orderStatus,String manageId);

	public List<OrderCustomer> getMyCustomer(SearchCustomer searchCustomer,
			String id, int i, int pageSize);

	public int countMyCustomer(SearchCustomer searchCustomer, String id);

	public List<SearchOrderCredit> getMyCustomerSearchOrderCreditList(
			String typeCode, int[] orderStatus, String manageId);
}
