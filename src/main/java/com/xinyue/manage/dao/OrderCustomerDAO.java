package com.xinyue.manage.dao;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.OrderAppointed;
import com.xinyue.manage.model.OrderAuction;
import com.xinyue.manage.model.OrderFixed;
import com.xinyue.manage.model.OrderLowPrice;

/**
 * author lzc
 * 2015年7月1日下午4:54:02
 */
public interface OrderCustomerDAO {
	/**
	 * 添加指定客户类型
	 * add by lzc
	 * date: 2015年7月2日
	 * @param orderAppointed
	 */
	void addOrderAppointed(OrderAppointed orderAppointed);
	
	void addOrderAuction(OrderAuction orderAuction);
	
	void addOrderFixed(OrderFixed orderFixed);
	
	void addOrderLowPrice(OrderLowPrice orderLowPrice);
	
	/**
	 * add by lzc
	 * date: 2015年7月2日
	 * @param tabName 快速申贷表过订单表表名
	 * @param orderStatus 订单设置状态
	 * @param orderType 订单类型
	 * @param modifyId 修改人id
	 * @param id 快速申贷表过订单表主键
	 * @param status 订单状态
	 */
	void updateOrderType(@Param("tabName")String tabName, @Param("orderStatus")String orderStatus,
			@Param("orderType")String orderType,@Param("modifyId")String modifyId,@Param("id")String id,@Param("status")String status);

	

	
	void deleteOrderCustomer(@Param("orderId")String orderId,@Param("tabName")String tabName,
			@Param("modifiedId")String modifiedId,@Param("type")int type);
	
	String getOrderType(@Param("tabName")String tabName,@Param("id")String id);
	
	public OrderFixed getOrderFixed(@Param("orderId")String orderId, @Param("type")int type);
	
	public OrderAuction getOrderAuction(@Param("orderId")String orderId, @Param("type")int type);
	
	public OrderAppointed getOrderAppointed(@Param("orderId")String orderId, @Param("type")int type);
	
	public OrderLowPrice getOrderLowPrice(@Param("orderId")String orderId, @Param("type")int type);
}
