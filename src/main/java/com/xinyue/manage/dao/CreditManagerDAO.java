package com.xinyue.manage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.InvitationMemberInfo;
import com.xinyue.manage.beans.SearchCreditManager;
import com.xinyue.manage.model.AuthenticationCM;
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
	int updateCreditmanagers(@Param("ids")List<String> list, @Param("status")String status);

	/**
	 * 信贷经理保存
	 * @param creditManager
	 * @return
	 */
	int saveCreditManager(CreditManager creditManager);

	/**
	 * 检查邀请码
	 * @param invitationCode
	 * @return
	 */
	int checkInvitationCode(String invitationCode);

	/**
	 * 信贷经理详情-基本信息(后台)
	 * @param managerId
	 * @return
	 */
	CreditManager getCreditManagerById(String managerId);

	/**
	 * 信贷经理详情-认证信息(后台)
	 * @param managerId
	 * @return
	 */
	AuthenticationCM getAuthenticationById(String managerId);

	/**
	 * 信贷经理详情-普通会员推荐数量(后台)
	 * @param managerId
	 * @return
	 */
	int getInvitationMemberCount(String managerId);

	/**
	 * 信贷经理详情-普通会员推荐信息(后台)
	 * @param managerId
	 * @param index
	 * @return
	 */
	List<InvitationMemberInfo> getInvitationMemberInfo(@Param("managerId")String managerId,@Param("index")int index);

	/**
	 * 普通会员推荐信息记录数
	 * @param managerId
	 * @return
	 */
	int getInvitationMemberRecords(String managerId);

	/**
	 * 信贷经理推荐人数
	 * @param managerId
	 * @return
	 */
	int getInvitationManagerCount(String managerId);

	/**
	 * 信贷经理详情-信贷经理推荐信息(后台)
	 * @param managerId
	 * @param index
	 * @return
	 */
	List<InvitationMemberInfo> getInvitationManagerInfo(@Param("managerId")String managerId,@Param("index")int index);

	/**
	 * 信贷经理推荐信息记录数
	 * @param managerId
	 * @return
	 */
	int getInvitationManagerRecords(String managerId);

}
