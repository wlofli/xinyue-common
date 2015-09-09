package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.ProductInfo;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Product;

/**
 * 
 * @author wenhai.you
 * @2015年5月22日
 * @下午6:29:11
 */
public interface ProductService {

	/**
	 * 根据查询条件返回product
	 * @param pinfo
	 * @return
	 */
	public List<Product> findList(ProductInfo pinfo);
	
	/**
	 * 根据查询条件返回记录数
	 * @param pinfo
	 * @return
	 */
	public int getCount(ProductInfo pinfo);
	
	
	/**
	 * 更新上架时间
	 * @param list
	 */
	public boolean updateShelve(List<String> list, String modifyUser);
	
	
	/**
	 * 更新下架时间
	 * @param list
	 */
	public boolean updateUnShelve(List<String> list, String modifyUser);
	
	
	/**
	 * 根据id查寻
	 * @param id
	 * @return
	 */
	public Product getProductById(String id);
	
	public void saveProduct(Product pro , String user);
	
	
	/**
	 * 
	 * add by lzc
	 * date: 2015年7月16日
	 * @param Recommend value->0 || 1
	 * @return
	 */
	public List<Product> getListByRecommend(String Recommend);

	/**
	 * 根据信贷经理id查询对应产品
	 * add by maozj
	 * @param managerId 信贷经理id
	 * @return 
	 */
	public List<SelectInfo> findProductsManagerId(String managerId);

	/**
	 * 根据信贷经理id查询产品
	 * add by maozj
	 * @param managerId
	 * @return
	 */
	public List<Product> getProductsByManagerId(String managerId,int page);

	/**
	 * 根据信贷经理id查询产品数量
	 * add by maozj
	 * @param managerId
	 * @return
	 */
	public int getProductsCountByManagerId(String managerId);
	
}
