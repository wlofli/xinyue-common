package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.ProductInfo;
import com.xinyue.manage.model.Product;
import com.xinyue.manage.model.ProductType;

/**
 * 
 * @author wenhai.you
 * @2015年5月22日
 * @下午6:25:51
 */
public interface ProductDao {

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
	public void updateShelve(@Param("list") List<String> list , @Param("modifyUser") String modifyUser);
	
	
	/**
	 * 更新下架时间
	 * @param list
	 */
	public void updateUnShelve(@Param("list") List<String> list, @Param("modifyUser") String modifyUser);
	
	
	/**
	 * 根据id查寻
	 * @param id
	 * @return
	 */
	public Product getProductById(String id);
	
	
	public void addProduct(Product pro);
	
	
	public void updateProduct(Product pro);
	
	public void updateStatus();
	
	/**
	 * 根据推荐标志获取产品信息
	 * add by lzc
	 * date: 2015年7月16日
	 * @param recommend 
	 * @return
	 */
	public List<Product> getListByRecommend(@Param("recommend")String recommend);
}
