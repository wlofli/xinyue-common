package com.xinyue.manage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.SearchCreditManager;
import com.xinyue.manage.model.CreditManager;
import com.xinyue.manage.model.CreditManagerInfo;

public interface CreditManagerDAO {

	int getManagerCount();

	List<CreditManagerInfo> findCmanagersByConditions(
			HashMap<String, Object> map);

	int getCmanagersCountByConditions(HashMap<String, Object> map);

	/**
	 * 信贷经理数量(后台)
	 * @param sc
	 * @return
	 */
	int getManagerCountByConditions(SearchCreditManager sc);

	/**
	 * 信贷经理列表(后台)
	 * @param sc
	 * @return
	 */
	List<CreditManager> getMangerListByConditions(SearchCreditManager sc);

	/**
	 * 删除信贷经理
	 * @param list
	 * @return
	 */
	int deleteCreditManagers(@Param("ids")List<String> list);

	/**
	 * 启用/屏蔽
	 * @param list
	 * @param status
	 * @return
	 */
	int lockCreditmanagers(@Param("ids")List<String> list, @Param("status")String status);

}
