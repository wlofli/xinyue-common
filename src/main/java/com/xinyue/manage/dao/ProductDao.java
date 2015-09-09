package com.xinyue.manage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.ProductInfo;
import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.Product;
import com.xinyue.manage.model.ProductFile;

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
	
	public List<ProductFile> findProductFileList(@Param("id")String pid);
	public List<Product> findProductById(@Param("pid")String pid);
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

	/**
	 * 根据信贷经理查找产品(1)
	 * add by maozj
	 * @param managerId
	 * @return
	 */
	public List<SelectInfo> findProductsManagerId(String managerId);

	/**
	 * 根据信贷经理查找产品(2)
	 * add by maozj
	 * @param map
	 * @return
	 */
	public List<Product> getProductsByManagerId(HashMap<String,Object> map);

	/**
	 * 根据信贷经理id查询产品数量
	 * add by maozj
	 * @param managerId
	 * @return
	 */
	public int getProductsCountByManagerId(String managerId);
}
