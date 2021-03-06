package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.BusinessInfos;
import com.xinyue.manage.beans.HoldInfos;
import com.xinyue.manage.beans.SearchCustomer;
import com.xinyue.manage.beans.SearchOrder;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Applicant;
import com.xinyue.manage.model.CompanyBase;
import com.xinyue.manage.model.Control;
import com.xinyue.manage.model.CreditManager;
import com.xinyue.manage.model.Debt;
import com.xinyue.manage.model.Document;
import com.xinyue.manage.model.FastProductApplicant;
import com.xinyue.manage.model.FastProductCompany;
import com.xinyue.manage.model.Order;
import com.xinyue.manage.model.OrderAppointed;
import com.xinyue.manage.model.RealEstate;

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
	
	

	public List<Order> getListByMemberId(String memberId,SearchOrder order, int pageSize, int pageNo);

	
	
	public int getCount(Order order);
	
	public int getCountByStatus(Order order, List<String> status);
	

	public int getCountByMemberId(String id, SearchOrder order);
	/**
	 * add by lzc     date: 2015年7月23日
	 * @param id
	 * @return
	 * 获取详细订单
	 */
	public Order getOrderInfo(String id);
	
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
	
	
	
	
	public List<Document> getDocumentInfoById(String id);
	
	//undone 订单详情打印下载功能 ->freemarker wordtemplete
//	public void downLoadOrder(HttpServletResponse response, Order order);
	
	

	public boolean deleteOrderList(List<String> idList, String modifiedId);

	/**
	 * add by lzc     date: 2015年7月24日
	 * @param applicant
	 * @param orderId
	 * @param modifiedId
	 * @param state 0->add 1->update
	 * @return
	 */
	public boolean addOrUpdateApplicant(Applicant applicant, String orderId, String modifiedId, int state);
	
	/**
	 * add by lzc     date: 2015年7月28日
	 * @param debt
	 * @param realEstate
	 * @param orderId
	 * @param modifiedId
	 * @param state 0->add 1->update
	 * @return
	 */
	public boolean addOrUpdateDebt(Debt debt, RealEstate realEstate, String orderId, String modifiedId, int state);
	
	
	public boolean addOrUpdateBusiness(BusinessInfos businessInfos, String orderId, String modifiedId,int state);
	/**
	 * add by lzc     date: 2015年7月29日
	 * @param state state 0->add 1->update
	 */
	public boolean addOrUpdateCompany(CompanyBase companyBase, HoldInfos holdInfos, Control control, String orderId,
			String modifiedId, int state);
	/**从企业档案资料导入到订单资料
	 * add by lzc     date: 2015年7月30日
	 * @param documentList
	 * @param orderId
	 * @param modifiedId
	 * @return
	 */
	public boolean addDocumentList(List<Document> documentList, String orderId,  String modifiedId);
	/**
	 * add by lzc     date: 2015年7月30日
	 * @param filePath
	 * @param memberId
	 * @param typeId
	 * @param dId  添加的document id
	 * @param orderId
	 * @param documentId 删除的document id
	 * @return
	 */
	public boolean addOrUpdateDocument(String filePath,String memberId, String typeId, String dId, String orderId,String documentId);
	
	public List<Document> getDocumentList(String orderId, int index);
	
	public int getDocumentCount(String orderId);
	
	public boolean updateOrderEvaluate(Order order, String modifiedId);

	public CreditManager getCreditManager(String name);
	/**返回所有信贷经理列表
	 * add by lzc     date: 2015年8月26日
	 * @return  key->id ,value->name
	 */
	public List<SelectInfo> getCreditMangerList();
	
	/**
	 * 快速申贷第二类
	 * add by mzj
	 * @param tel
	 * @param applicantFast
	 * @param companyFast
	 * @return
	 */
	public boolean addFastOrderTypeTwo(String stepOneData,
			FastProductApplicant applicantFast, FastProductCompany companyFast);

	
	public void addOrder(Order order);
}
