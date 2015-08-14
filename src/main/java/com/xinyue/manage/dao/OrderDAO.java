package com.xinyue.manage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.SearchOrder;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Document;
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
    
    
    /**
	 * add by lzc     date: 2015年7月30日
	 * @param orderId
	 * @return
	 */
	public List<Document> getDocumentByOrderId(HashMap<String, Object> map);
	
	public int getDocumentCount(String orderId);


}
