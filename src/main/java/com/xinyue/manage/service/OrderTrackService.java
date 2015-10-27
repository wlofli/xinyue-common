package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.OrderInfo;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.OrderTrack;
import com.xinyue.manage.model.User;

/**
 * author lzc
 */
public interface OrderTrackService {
	/**
	 * add by lzc     date: 2015年9月1日
	 * @param customerId id
	 * @param orderType 立即领取||指定推送||竞拍||最低低价
	 * @return
	 */
	public OrderInfo getOrderInfo(String customerId, String orderType);
	
	
	
	/**
	 * add by lzc     date: 2015年9月1日
	 * @param orderId
	 * @param type 1订单2快速申贷
	 * @param pageSize 0->不分页
	 * @return
	 */
	public List<OrderTrack> getOrderTrackList(String orderId, String type, int pageNo, int pageSize);
	
	
	public boolean addOrderTrack(OrderTrack orderTrack, String user);

}
