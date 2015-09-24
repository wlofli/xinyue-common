package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.beans.ProductTypeInfo;
import com.xinyue.manage.model.ProductType;

/**
 * 
 * @author wenhai.you
 * @2015年5月23日
 * @下午2:21:55
 */
public interface ProductTypeService {

	
	//2015-09-11
	/**
	 * ywh 获取所有产品列表 后台调用 
	 * @return
	 */
	public List<ProductType> findProductTypeList();
	
	/**
	 * ywh 一级产品分类分页
	 * @param info
	 * @return
	 */
	public PageData<ProductType> findFirstPagedata(ProductTypeInfo info);
	
	
	/**
	 * ywh 二级产品分类分页
	 * @param info
	 * @return
	 */
	public PageData<ProductType> findSecondPagedata(ProductTypeInfo info);
	
	/**
	 * ywh 删除产品分类 
	 * @param id
	 * @param modifyUser
	 */
	public void delProductType(String id, String modifyUser);
	
	/**
	 * ywh 根据产品分类标识符加载产品分类
	 * @param id
	 * @return
	 */
	public ProductType findTypeById(String id);
	
	/**
	 * ywh 启用产品分类
	 * @param id
	 * @param modifyUser
	 * @return
	 */
	public boolean enableProductType(String id, String modifyUser);
	
	/**
	 * ywh 禁用产品分类 
	 * @param id
	 * @param modifyUser
	 * @return
	 */
	public boolean unenableProductType(String id, String modifyUser);
	
	/**
	 * ywh 保存产品分类
	 * @param ptype
	 * @param user
	 * @return
	 */
	public boolean saveProductType(ProductType ptype , String user);
	
	/**
	 * ywh 加载一级所有 产品分类
	 * @return
	 */
	public List<ProductType> findTypeFirstList();
}
