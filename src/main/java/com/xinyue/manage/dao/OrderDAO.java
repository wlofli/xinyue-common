package com.xinyue.manage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.CustomerInfo;
import com.xinyue.manage.beans.SearchCustomer;
import com.xinyue.manage.beans.SearchOrder;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.CreditManager;
import com.xinyue.manage.model.Document;
import com.xinyue.manage.model.FastProductApplicant;
import com.xinyue.manage.model.FastProductCompany;
import com.xinyue.manage.model.Order;

/**
 * author lzc
 * 2015年5月30日下午4:02:05
 */
public interface OrderDAO {
	
	public List<Order> getListByPage(@Param("order")Order order, @Param("pageSize")int pageSize, 
			@Param("pageNo")int pageNo, @Param("typeCode")String typeCode);
	
	public List<Order> getListByStatus(@Param("order")Order order,@Param("pageSize")int pageSize, 
			@Param("pageNo")int pageNo,@Param("list")List<String> idList, @Param("typeCode")String typeCode);
	

	public List<Order> getListByMemberId(@Param("id")String id, @Param("order")SearchOrder order, @Param("typeCode")String typeCode,
			@Param("pageSize")int pageSize, @Param("pageNo")int pageNo);

	
	public int getCount(@Param("order")Order order);
	
	public int getCountByStatus(@Param("order")Order order, @Param("list")List<String> statusList);
	

	public int getCountByMemeberId(@Param("id")String string, @Param("order")SearchOrder order);
	
	/** 获取订单详细信息
	 * add by lzc     date: 2015年7月22日
	 * @return
	 */
	public Order getOrderInfo(@Param("id")String id, @Param("typeCode")String typeCode);
	
	
	public Order getOrder(@Param("id")String id, @Param("typeCode")String typeCode);
	
	/**
	 * key ->id
	 * value -> name
	 * add by lzc
	 * date: 2015年7月6日
	 * @param typeCode
	 * @return
	 * 
	 */
	public List<SelectInfo> getStatus(String typeCode);
	
	
	
	public List<Document> getDocumentInfoById(String id);
	
	/**
	 * 
	 * add by lzc
	 * date: 2015年6月30日
	 * @param order
	 * @return 
	 * 专门修改订单状态
	 */
	public boolean updateOrder(@Param("order")Order order);
	
	/**更新订单评价信息
	 * add by lzc     date: 2015年8月14日
	 * @param order
	 * @return
	 */
	public boolean updateOrderEvaluate(@Param("order")Order order, @Param("modifiedId")String modifiedId);
	
	
	
	/**
	 * 更新订单status ,单个或者订单列表
	 * add by lzc
	 * date: 2015年7月9日
	 * @param idList
	 * @param status
	 * @param modifiedId
	 */
    public void updateOrderTypeList(@Param("list")List<String> idList, @Param("status")String status,
		@Param("modifiedId")String modifiedId);
    

    public void deleteOrderList(@Param("list")List<String> idList, @Param("modifiedId")String modifiedId);
    
    public boolean updateOrderDetail(HashMap<String, Object> map);
    
    //以下为对m_order_hold表操作的方法
    
    public void addHoldList(@Param("list")List<String> holdList, @Param("id")String orderId);
    
    public List<String> getHoldList(@Param("id")String orderId);

	
    
    
    public void addDocumentList(@Param("list")List<String> documentList, @Param("id")String orderId);
    
    public void addDocument(@Param("documentId")String document, @Param("id")String orderId);
    
    public void deleteDocument(@Param("documentId")String document, @Param("id")String orderId);
    
    /**初始化订单
     * add by lzc     date: 2015年9月2日
     * @param order
     * @return
     */
    public int addOrder(Order order);
    
    /**
	 * add by lzc     date: 2015年7月30日
	 * @param orderId
	 * @return
	 */
	public List<Document> getDocumentByOrderId(HashMap<String, Object> map);
	
	public int getDocumentCount(String orderId);

	/**根据信贷经理姓名获取信贷经理信息
	 * add by lzc     date: 2015年8月25日
	 * @param name
	 * @return
	 */
	public CreditManager getCreditManagerByName(@Param("name")String name);
	
	/**返回信贷经理列表
	 * add by lzc     date: 2015年8月26日
	 * @return key->id value->name
	 */
	public List<SelectInfo> getCreditManagerList();
	
	/**
	 * 追加快速申贷申请人信息
	 * add by mzj 2015/8/26
	 * @param applicantFast
	 * @return
	 */
	public int addFastApplicant(FastProductApplicant applicantFast);

	/**
	 * 追加快速申贷公司信息
	 * add by mzj 2015/8/26
	 * @param companyFast
	 * @return
	 */
	public int addFastCompany(FastProductCompany companyFast);

	/**
	 * 追加快速申贷订单
	 * add by mzj 2015/8/26
	 * @param map
	 * @return
	 */
	public int addFastOrder(HashMap<String, Object> map);

	/**
	 * 信贷经理详情-客户信息（后台）
	 * add by mzj 2015/9/10
	 * @param searchCustomer
	 * @return
	 */
	public List<CustomerInfo> getCustomerInfoByCondition(
			SearchCustomer searchCustomer);

	/**
	 * 信贷经理详情-客户信息数量（后台）
	 * add by mzj 2015/9/10
	 * @param searchCustomer
	 * @return
	 */
	public int getCustomerInfoCountByCondition(SearchCustomer searchCustomer);

	/**
	 * 信贷经理详情-客户信息-订单跟踪明细（后台）
	 * @param id
	 * @return
	 */
	public CustomerInfo getOrderTrackByOrderId(String id);
	
	/**根据申请人申贷金额更新订单金额
	 * add by lzc     date: 2015年12月18日
	 * @param credit
	 * @param id
	 * @return
	 */
	public int updateOrderCredit(@Param("credit")String credit, @Param("applicantId")String id);

	
}
