package com.xinyue.manage.service;

import com.xinyue.manage.model.ProductFile;

/**
 * 
 * @author wenhai.you
 * @2015年5月27日
 * @下午3:51:33
 */
public interface ProductFileService {

	/**
	 * 添加产品文件
	 * @param pfile
	 */
   public boolean addProductFile(ProductFile pfile);
   
 
   /**
    * 删除产品文件
    * @param id
    */
   public boolean delProductFile(String id,String modifyUser);
}
