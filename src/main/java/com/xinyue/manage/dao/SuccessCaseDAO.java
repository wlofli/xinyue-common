package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.SuccessCaseSearch;
import com.xinyue.manage.model.SuccessCase;

/**
 * 成功案例DAO
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年8月17日
 */
public interface SuccessCaseDAO {

	List<SuccessCase> findSuccessCasesByManagerId(String managerId);

	int getCountByManagerId(SuccessCaseSearch search);

	List<SuccessCase> getSuccessCaseList(SuccessCaseSearch search);

	int deleteCaseById(@Param("ids")List<String> ids, @Param("managerId")String managerId);

	SuccessCase getSuccessCaseByCaseId(String caseId);

	int addCase(SuccessCase caseInfo);

	int updateCase(SuccessCase caseInfo);

	SuccessCase getSuccessCaseDetailByCaseId(String id);

	/**
	 * (ywh update @Param orgid index)
	 * 机构管理-店铺设置-成功案例 列表
	 * @param orgid
	 * @return
	 */
	List<SuccessCase> getSuccessCasesByOrgId(@Param("orgid") String orgid,@Param("index")int index);

	/**
	 * 机构管理-店铺设置-成功案例 数量
	 * @param orgid
	 * @return
	 */
	int getSuccessCasesCountByOrgId(String orgid);

	/**
	 * 成功案例启用/屏蔽
	 * @param codes
	 * @param type
	 * @return
	 */
	int updateOrgSuccessCaseUseFlag(@Param("codes")List<String> codes, @Param("type")String type , @Param("updateUser")String updateUser);

	/**
	 * 成功案例删除
	 * @param codes
	 * @return
	 */
	int deleteSuccessCaseByIds(@Param("codes")List<String> codes);
	
	/**获取最近的成功案例
	 * add by lzc     date: 2015年12月1日
	 * @param index 开始
	 * @param pageSize 
	 * @return
	 */
	List<SuccessCase> getSuccessByTime(@Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
	
	

}
