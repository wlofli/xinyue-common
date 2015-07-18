package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.ProductTypeInfo;
import com.xinyue.manage.model.ProductType;

/**
 * 
 * @author wenhai.you
 * @2015年5月23日
 * @下午2:21:55
 */
public interface ProductTypeService {

	public List<ProductType> findProductTypeList();
	
	public List<ProductType> findTypeFirst(ProductTypeInfo pt);
	
	public int getTypeFirstCount();
	
	public List<ProductType> findTypeSecond(ProductTypeInfo pt);
	
	public int getTypeSecondCount();
		
	public void delProductType(String id, String modifyUser);
	
	public ProductType findTypeById(String id);
	
	public boolean enableProductType(String id, String modifyUser);
	
	public boolean unenableProductType(String id, String modifyUser);
	
	public boolean saveProductType(ProductType ptype , String user);
	
	public List<ProductType> findTypeFirstList();
}
