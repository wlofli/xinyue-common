package com.xinyue.manage.dao;

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
	
	public List<Order> getListByMemberId(@Param("id")String id, @Param("order")SearchOrder order, @Param("typeCode")String typeCode);
	
	public int getCount(@Param("order")Order order);
	
	public int getCountByStatus(@Param("order")Order order, @Param("list")List<String> statusList);
	
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
    
    
    

	

}
