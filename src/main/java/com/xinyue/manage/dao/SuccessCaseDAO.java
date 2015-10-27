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
	 * 机构管理-店铺设置-成功案例 列表
	 * @param orgid
	 * @return
	 */
	List<SuccessCase> getSuccessCasesByOrgId(String orgid,int index);

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
	int updateOrgSuccessCaseUseFlag(@Param("codes")List<String> codes, @Param("type")String type);

	/**
	 * 成功案例删除
	 * @param codes
	 * @return
	 */
	int deleteSuccessCaseByIds(@Param("codes")List<String> codes);

}
