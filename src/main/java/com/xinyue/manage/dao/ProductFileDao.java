package com.xinyue.manage.dao;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.model.ProductFile;

/**
 * 
 * @author wenhai.you
 * @2015年5月27日
 * @下午3:46:10
 */
public interface ProductFileDao {

	/**
	 * 添加产品文件
	 * @param pfile
	 */
   public void addProductFile(ProductFile pfile);
   
  
   /**
    * 删除产品文件
    * @param id
    */
   public void delProductFile(@Param("id")String id , @Param("modifyUser") String modifyUser);
}
