package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.OrderCustomer;
import com.xinyue.manage.beans.OrderInfo;
import com.xinyue.manage.beans.SearchCustomer;
import com.xinyue.manage.beans.SearchOrderCredit;
import com.xinyue.manage.model.OrderAppointed;
import com.xinyue.manage.model.OrderAuction;
import com.xinyue.manage.model.OrderFixed;
import com.xinyue.manage.model.OrderLowPrice;

/**
 * author lzc
 * 2015年7月1日下午4:54:02
 * 竞拍,指定推送,立即领取,最低低价表的操作
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
	 * @param tabName (2)快速申贷表或(1)订单表表名
	 * @param orderStatus 订单设置状态 null则不修改
	 * @param orderType 订单类型 null则不修改
	 * @param modifyId 修改人id null则不修改
	 * @param id 快速申贷表过订单表主键
	 * @param status 订单状态
	 */
	void updateOrderType(@Param("tabName")String tabName, @Param("orderStatus")String orderStatus,
			@Param("orderType")String orderType,@Param("modifyId")String modifyId,
			@Param("id")String id,@Param("status")String status);

	/**
	 * add by lzc     date: 2015年8月21日
	 * @param tabName 立即领取表||指定推送表||最低低价表||竞拍表
	 * @param customerId 表主键id
	 * @param ManageId 
	 * @return
	 */
	public int updateOrderCustomerManageId(@Param("tabName")String tabName,@Param("id")String customerId, 
			@Param("manageId")String manageId, @Param("modifiedId")String modifiedId);
	
	void deleteOrderCustomer(@Param("orderId")String orderId,@Param("tabName")String tabName,
			@Param("modifiedId")String modifiedId,@Param("type")int type);
	/**数字形式
	 * add by lzc     date: 2015年9月1日
	 * @param tabName
	 * @param id
	 * @return
	 */
	String getOrderType(@Param("tabName")String tabName,@Param("id")String id);
	
	public OrderFixed getOrderFixedById(@Param("id")String id);
	
	public OrderFixed getOrderFixed(@Param("orderId")String orderId, @Param("type")int type);
	
	public OrderAuction getOrderAuction(@Param("orderId")String orderId, @Param("type")int type);
	
	public OrderAppointed getOrderAppointed(@Param("orderId")String orderId, @Param("type")int type);
	
	public OrderAppointed getOrderAppointById(@Param("id")String id);
	
	public OrderLowPrice getOrderLowPrice(@Param("orderId")String orderId, @Param("type")int type);
	
	
	/**从订单表及其关系表中获取信息
	 * add by lzc     date: 2015年8月17日
	 * @param orderId
	 * @return
	 */
	public OrderAppointed getOrderAppointedFromOrder(@Param("orderId")String orderId);
	
	/**从快速申贷表及其关系表中获取信息
	 * add by lzc     date: 2015年8月24日
	 * @param fastId
	 * @return
	 */
	public OrderAppointed getOrderAppointedFromFastProduct(@Param("fastId")String fastId);
	
	/**从订单表及其关系表中获取信息
	 * add by lzc     date: 2015年8月17日
	 * @param orderId
	 * @return
	 */
	public OrderFixed getOrderFixedFromOrder(@Param("orderId")String orderId);
	
	/**从快速申贷表及其关系表中获取信息
	 * add by lzc     date: 2015年8月24日
	 * @param fastId
	 * @return
	 */
	public OrderFixed getOrderFixedFromFastProduct(@Param("fastId")String fastId);
	
	
	public List<OrderAppointed> getAppointedListByManageId(@Param("manageId")String manageId, 
			@Param("pageNo")int pageNo, @Param("pageSize")int pageSize,@Param("search")SearchCustomer searchCustomer);
	
	public int countAppointedListByManageId(@Param("manageId")String manageId, @Param("search")SearchCustomer searchCustomer);
	
	
	public List<OrderFixed> getFixedListByPage(@Param("pageNo")int pageNo, 
			@Param("pageSize")int pageSize,@Param("search")SearchCustomer searchCustomer);
	
	
	public int countFixedListByPage(@Param("search")SearchCustomer searchCustomer);
	
	/**推送客户快速筛选部分
	 * add by lzc     date: 2015年8月31日
	 * @param typeCode
	 * @param statusList
	 * @param manageId
	 * @return
	 */
	public List<SearchOrderCredit> getSearchOrderCredit(@Param("typeCode")String typeCode, @Param("list")int[] statusList,@Param("manageId")String manageId);
	
	/**获取我的客户列表
	 * add by lzc     date: 2015年8月28日
	 * @param manageId
	 * @param searchCustomer
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<OrderCustomer> getMyCustomer(@Param("manageId")String manageId,
			@Param("search")SearchCustomer searchCustomer,@Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
	
	
	public int countMyCustomer(@Param("manageId")String manageId,
			@Param("search")SearchCustomer searchCustomer);
	
	
	public List<SearchOrderCredit> getMyCustomerSearchOrderCredit(@Param("typeCode")String typeCode, @Param("list")int[] statusList,@Param("manageId")String manageId);
	/**根据立即领取与订单获取orderInfo
	 * add by lzc     date: 2015年9月1日
	 * @param customerId
	 * @return
	 */
	public OrderInfo getOrderInfoByFixedOrder(@Param("customerId")String customerId);
	
	public OrderInfo getOrderInfoByFixedFast(@Param("customerId")String customerId);

	public OrderInfo getOrderInfoByAppointedOrder(@Param("customerId")String customerId);

	public OrderInfo getOrderInfoByAppointedFast(@Param("customerId")String customerId);
	
	
	
}
