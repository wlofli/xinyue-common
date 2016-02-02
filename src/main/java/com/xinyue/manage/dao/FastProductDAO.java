package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.SelectInfo;
import com.xinyue.manage.model.FastProduct;
import com.xinyue.manage.model.FastProductApplicant;
import com.xinyue.manage.model.FastProductCompany;


/**
 * 
 * @author lzc
 * @date 2015年6月26日
 */
public interface FastProductDAO {
	public List<FastProduct> getListByPage(@Param("fspdt")FastProduct fastProduct, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize, @Param("typeCode")String typeCode);
	
	public int countFastProduct(@Param("fspdt")FastProduct fastProduct);
	
	/**productId不为空的列表
	 * add by lzc     date: 2015年9月29日
	 * @param pageSize
	 * @return
	 */
	public List<FastProduct> getListWithProduct(@Param("fspdt")FastProduct fastProduct, @Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
	
	public int countListWithProduct(@Param("fspdt")FastProduct fastProduct);
	
	
	public FastProduct getFastProduct(@Param("id")String id,@Param("typeCode")String typeCode);
	//ywh modify 2015-12-23 start
	public FastProduct getTypeFastProduct(@Param("id")String id,@Param("typeCode")String typeCode);
	//ywh end
	/**获取快速申贷申请人信息
	 * add by lzc     date: 2015年10月8日
	 * @param id
	 * @return
	 */
	public FastProductApplicant getApplicant(@Param("id")String id);
	
	/**获取快速申贷公司信息
	 * add by lzc     date: 2015年10月8日
	 * @param id
	 * @return
	 */
	public FastProductCompany getCompany(@Param("id")String id);
	
	
	/**比较详细的快速申贷
	 * add by lzc     date: 2015年9月30日
	 * @param id
	 * @return
	 */
	public FastProduct getFastProductInfo(@Param("id")String id);
	
	public List<SelectInfo> getStatus(@Param("typeCode")String typeCode);
	
	public void modifiedFastProductStatus(@Param("name")String name, @Param("fspdt")FastProduct fastProduct);
	
	public void updateFastProduct(FastProduct fspdt);
	
	
	public void updateFastProductStatusList(@Param("list")List<String> idList, @Param("status")String status, 
			@Param("modifiedId")String modifiedId);

	public int saveFastOrder(FastProduct fastLoanInfo);
	
	
}
