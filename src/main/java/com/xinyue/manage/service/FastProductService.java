package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.FastProduct;

public interface FastProductService {

	/**
	 * add by lzc
	 * 2015年5月28日13:11:38
	 * @param fastProduct 条件对象
	 * @param pageNo 第几页
	 * @param pageSize 页面大小
	 * @return
	 */
	public List<FastProduct> getListByPage(FastProduct fastProduct, int pageNo, int pageSize);
	public int countFastProduct(FastProduct fastProduct);
	
	public boolean updateFastProductStatus(FastProduct fastProduct, String name);
	
	
	public FastProduct getFastProduct(String id);
	
	
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
	
	
	//2015/08/07 茅 追加 START
	/**
	 * 快速申贷保存
	 * @param fastLoanInfo
	 * @return
	 */
	public boolean saveFastOrder(FastProduct fastLoanInfo);
	//2015/08/07 茅 追加 END
}
