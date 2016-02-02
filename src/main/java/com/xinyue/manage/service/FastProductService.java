package com.xinyue.manage.service;

import java.util.List;

import org.springframework.ui.Model;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.FastProduct;
import com.xinyue.manage.model.FastProductApplicant;
import com.xinyue.manage.model.FastProductCompany;

public interface FastProductService {

	/**
	 * add by lzc
	 * 2015年5月28日13:11:38
	 * @param fastProduct 
	 * @param pageNo 第几页
	 * @param pageSize 页面大小
	 * @return
	 */
	public List<FastProduct> getListByPage(FastProduct fastProduct, int pageNo, int pageSize);
	public int countFastProduct(FastProduct fastProduct);
	
	/**productId不为空的列表
	 * add by lzc     date: 2015年9月29日
	 * @param pageSize
	 * @return
	 */
	public List<FastProduct> getListWithProduct(FastProduct fastProduct, int pageNo, int pageSize);
	
	public int countListWithProduct(FastProduct fastProduct);
	
	public boolean updateFastProductStatus(FastProduct fastProduct, String name);
	
	
	public FastProduct getFastProduct(String id);
	//ywh start 2015-12-23 
	public FastProduct getTypeFastProduct(String id);
	//ywh end
	/**获取快速申贷申请人信息
	 * add by lzc     date: 2015年10月8日
	 * @param id
	 * @return
	 */
	public FastProductApplicant getApplicant(String id);
	
	/**获取快速申贷公司信息
	 * add by lzc     date: 2015年10月8日
	 * @param id
	 * @return
	 */
	public FastProductCompany getCompany(String id);
	
	/**
	 * 修改快速申贷订单状态列表
	 * add by lzc
	 * date: 2015年7月13日
	 * @param idList 
	 * @param status 状态
	 * @param modifiedId
	 * @return
	 */
	public boolean updateFastProductStatusList(List<String> idList, String status, String modifiedId);
	
	
	/**
	 * 
	 * @return 获取status对应的相关文字描述
	 */
	public List<SelectInfo> getStatus(String typeCode);
	
	
	/**初始化有产品的快速申贷订单
	 * add by lzc     date: 2015年12月3日
	 * @param model
	 */
	public void initFastApplicant(Model model);
	
	
	//2015/08/07 茅 追加 START
	/**
	 * 快速申贷保存
	 * @param fastLoanInfo
	 * @return
	 */
	public boolean saveFastOrder(FastProduct fastLoanInfo);
	//2015/08/07 茅 追加 END
}
