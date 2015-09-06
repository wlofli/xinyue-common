package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.model.OrderTrack;

/**
 * author lzc
 */
public interface OrderTrackDAO {
	
	public void addOrderTrack(OrderTrack orderTrack);
	
	
	public List<OrderTrack> getOrderTrackList(@Param("orderid")String orderId, @Param("type")String type,
			@Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
	

}
