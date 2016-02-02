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
/**
 * lzc 15-12-01 添加获取最近成功案例
 *
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

	/**
	 * 机构管理-店铺设置-成功案例 列表
	 * @param orgid
	 * @return
	 */
	List<SuccessCase> getSuccessCasesByOrgId(String orgid,int page);

	/**
	 * 机构管理-店铺设置-成功案例 数量
	 * @param orgid
	 * @param page
	 * @return
	 */
	int getSuccessCasesCountByOrgId(String orgid);

	/**
	 * 成功案例启用/屏蔽
	 * @param code
	 * @param type
	 * @return
	 */
	boolean updateOrgSuccessCaseUseFlag(String code, String type , String updateUser);

	/**
	 * 成功案例删除
	 * @param code
	 * @return
	 */
	boolean deleteSuccessCaseByIds(String code);
	
	/**获取信贷经理的成功案例数量
	 * add by lzc     date: 2015年11月13日
	 * @param successCaseSearch
	 * @return
	 */
	int countSuccessCaseByManagerId(SuccessCaseSearch successCaseSearch);
	
	/**获取最近的成功案例
	 * add by lzc     date: 2015年12月1日
	 * @param index 开始
	 * @param pageSize 
	 * @return
	 */
	List<SuccessCase> getSuccessByTime(int index, int pageSize);

}
