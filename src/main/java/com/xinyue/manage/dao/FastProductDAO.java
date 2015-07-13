package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.FastProduct;


/**
 * 
 * @author lzc
 * @date 2015年6月26日
 */
public interface FastProductDAO {
	public List<FastProduct> getListByPage(@Param("fspdt")FastProduct fastProduct, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize, @Param("typeCode")String typeCode);
	
	public int countFastProduct(@Param("fspdt")FastProduct fastProduct);
	
//	public int countFastProductByStatus(@Param("fspdt")FastProduct fastProduct,@Param("list")List<String> statusList);
	
	public FastProduct getFastProduct(@Param("id")String id,@Param("typeCode")String typeCode);
	
	public List<SelectInfo> getStatus(@Param("typeCode")String typeCode);
	
	public void modifiedFastProductStatus(@Param("name")String name, @Param("fspdt")FastProduct fastProduct);
	
	public void updateFastProduct(FastProduct fspdt);
	
	
}
