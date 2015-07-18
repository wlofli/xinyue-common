package com.xinyue.manage.service;

import com.xinyue.manage.model.OrderAppointed;
import com.xinyue.manage.model.OrderAuction;
import com.xinyue.manage.model.OrderFixed;
import com.xinyue.manage.model.OrderLowPrice;

/**
 * author lzc
 * 2015年7月1日下午4:02:13
 * 设为领取客户的操作逻辑
 * @param <T>
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

}
