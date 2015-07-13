package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Document;
import com.xinyue.manage.model.Order;

/**
 * author lzc
 * 2015年5月30日下午4:02:37
 */
public interface OrderService {
	/**
	 * 
	 * add by lzc
	 * date: 2015年7月9日
	 * @param order
	 * @param pageSize 页码大小
	 * @param pageNo 
	 * @return
	 */
	public List<Order> getListByPage(Order order, int pageSize, int pageNo);
	
	/**
	 *
	 * add by lzc
	 * date: 2015年7月9日
	 * @param order
	 * @param pageSize
	 * @param pageNo
	 * @param statusList  限制条件 处于statusList下的订单
	 * @return
	 */
	public List<Order> getListByStatus(Order order ,int pageSize, int pageNo, List<String> statusList);
	
	
	public int getCount(Order order);
	
	public int getCountByStatus(Order order, List<String> status);
	
	
	public Order getOrder(String id);
	
	public boolean updateOrder(Order order);
	
	
	/**
	 * 修改状态
	 * add by lzc
	 * date: 2015年7月6日
	 * @param idList
	 * @param status 修改的状态
	 * @param userId 修改人id
	 * @return
	 */
	public boolean updateOrderList(List<String> idList, String status, String userId);
	
	/**
	 * 
	 *add by lzc
	 *
	 * @param s m_select_info表中对应的字符串
	 * @return select_info 
	 * key-id
	 * value-name
	 */
	public List<SelectInfo> getStatus(String typeCode);
	
	
//	public List<SelectOrder> doAuthority(List<SelectInfo> selectInfos, HttpServletRequest request);
	
	
	public List<Document> getDocumentInfoById(String id);
	
	//undone 订单详情打印下载功能 ->freemarker wordtemplete
//	public void downLoadOrder(HttpServletResponse response, Order order);
	
//	public Applicant getApplicant(String id);
//	
//	
//	public CompanyBase getcoCompanyBase(String id);
//	
//	
//	public List<Hold> getHoldInfoList(String id);
//	
//	
//	public ControlInfo getControlInfo(String id);
//	
//	
//	public List<Business> getBusinessInfoList(String id);
//	
//	public Debt getdeDebtInfo(String id);
//	
//	
//	public RealEstate getRealEstate(String id);
//	
//	public Rating getRatingInfo(String id);
	
	
	
	
	
	
	
}
