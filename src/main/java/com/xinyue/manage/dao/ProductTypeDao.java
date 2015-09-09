package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.ProductTypeInfo;
import com.xinyue.manage.model.ProductType;

/**
 * 
 * @author wenhai.you
 * @2015年5月23日
 * @下午2:20:53
 */
public interface ProductTypeDao {

	public List<ProductType> findProductTypeList();
	public List<ProductType> findProductTypeByList();
	public List<ProductType> findTypeFirst(ProductTypeInfo pt);
	
	public int getTypeFirstCount();
	
	public List<ProductType> findTypeSecond(ProductTypeInfo pt);
	
	public int getTypeSecondCount();
	
	public void addTypeFirst(ProductType pt);
	
	public void updateProductType(ProductType pt);
	
	public void delProductType(@Param("id") String id , @Param("modifyUser") String modifyUser);
	
	public ProductType findTypeById(String id);
	
	public void enableProductType(@Param("id") String id, @Param("modifyUser") String modifyUser);
	
	public void unenableProductType(@Param("id") String id, @Param("modifyUser") String modifyUser);
	
	public void updateProductByType(@Param("id") String id, @Param("modifyUser") String modifyUser);
	
	public List<ProductType> findTypeFirstList(); 
}
