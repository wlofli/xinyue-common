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

}
