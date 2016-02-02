package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.model.ProductType;

/**
 * 
 * @author wenhai.you
 * @2015年5月23日
 * @下午2:20:53
 */
public interface ProductTypeDao {

	
	
	

	
	//2015-09-11 ywh 以后
	/**
	 * ywh 获取所有产品列表 后台调用 
	 * @return
	 */
	public List<ProductType> getProTypeList();
	
	/**
	 * ywh 获取产品列表 前台调用 
	 * @return
	 */
	public List<ProductType> findProductTypeByList();
	
	
	/**
	 * ywh 获取一级产品分类每页数据
	 * @param pt
	 * @return
	 */
	public List<ProductType> findTypeFirst(@Param("start") int start , @Param("pageSize") int pageSize);
	
	/**
	 * ywh 获取一级产品分类 总记录数
	 * @return
	 */
	public int getTypeFirstCount();
	
	/**
	 * ywh 获取二级产品分类每页数据
	 * @param pt
	 * @return
	 */
	public List<ProductType> findTypeSecond(@Param("start") int start , @Param("pageSize") int pageSize);
	
	/**
	 * ywh 获取二级产品分类 总记录数
	 * @return
	 */
	public int getTypeSecondCount();
	
	/**
	 * ywh 添加 产品分类 
	 * @param pt
	 */
	public void addTypeFirst(ProductType pt);
	
	public void updateProductType(ProductType pt);
	
	/**
	 * ywh 删除产品分类 
	 * @param id
	 * @param modifyUser
	 */
	public void delProductType(@Param("id") String id , @Param("modifyUser") String modifyUser);
	
	/**
	 * 获取要删除的id
	 * @param parentid
	 * @return
	 */
	public List<String> findIdByParentid(String parentid);
	
	/**
	 * ywh 根据产品分类 标识符 加载产品分类 
	 * @param id
	 * @return
	 */
	public ProductType findTypeById(String id);
	
	/**
	 * ywh 启用产品分类 
	 * @param id
	 * @param modifyUser
	 */
	public void enableProductType(@Param("id") String id, @Param("modifyUser") String modifyUser);
	
	/**
	 * ywh 禁用产品分类 
	 * @param id
	 * @param modifyUser
	 */
	public void unenableProductType(@Param("id") String id, @Param("modifyUser") String modifyUser);
	
	/**
	 * ywh 添加二级产品分类时显示 一级所有产品分类
	 * @return
	 */
	public List<ProductType> findTypeFirstList(); 
	
	/**
	 * ywh 删除产品分类时 清空产品外键
	 * @param id
	 * @param modifyUser
	 */
	public void updateProductByType(@Param("list") List<String> list, @Param("modifyUser") String modifyUser);
}
