package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.PageData;
import com.xinyue.manage.beans.SuccessCaseSearch;
import com.xinyue.manage.model.SuccessCase;

/**
 * 成功案例服务层
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年8月17日
 */
public interface SuccessCaseService {

	/**
	 * 信贷经理展示
	 * @param managerId
	 * @return
	 */
	List<SuccessCase> findSuccessCasesByManagerId(String managerId);

	/**
	 * 信贷经理成功案例列表
	 * @param search
	 * @return
	 */
	PageData<SuccessCase> findSuccessCaseList(SuccessCaseSearch search);

	/**
	 * 删除成功案例
	 * @param caseIds
	 * @param managerId
	 * @return
	 */
	boolean deleteCaseById(String caseIds,String managerId);

	/**
	 * 根据案例ID查找详情
	 * @param caseId
	 * @return
	 */
	SuccessCase getSuccessCaseByCaseId(String caseId);

	/**
	 * 保存成功案例
	 * @param caseInfo
	 * @return
	 */
	boolean saveCase(SuccessCase caseInfo);

	/**
	 * 后台信贷经理-详情-成功案例详细
	 * @param id
	 * @return
	 */
	SuccessCase getSuccessCaseDetailByCaseId(String id);

}
