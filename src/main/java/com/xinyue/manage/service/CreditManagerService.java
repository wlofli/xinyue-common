package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.SearchCreditManager;
import com.xinyue.manage.model.CreditManager;
import com.xinyue.manage.model.CreditManagerInfo;

/**
 * 信贷经理服务层
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年8月12日
 */
public interface CreditManagerService {


	List<CreditManagerInfo> findCmanagersByConditions(SearchCreditManager cmSearch);

	CreditManagerInfo findCreditManagerInfoById(String managerId);

	int getCmanagersCountByConditions(SearchCreditManager cmSearch);

	/**
	 * 信贷经理列表(后台)
	 * @param sc
	 * @return
	 */
	List<CreditManager> getMangerListByConditions(SearchCreditManager sc);

	/**
	 * 信贷经理数量(后台)
	 * @return
	 */
	int getManagerCountByConditions(SearchCreditManager sc);

	/**
	 * 信贷经理删除
	 * @param managerIds
	 * @return
	 */
	boolean deleteCreditManagers(String managerIds);

	/**
	 * 启用/屏蔽
	 * @param managerIds
	 * @param status
	 * @return
	 */
	boolean lockCreditmanagers(String managerIds, String status);
}
