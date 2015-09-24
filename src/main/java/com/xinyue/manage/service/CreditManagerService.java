package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.InvitationMemberInfo;
import com.xinyue.manage.beans.SearchCreditManager;
import com.xinyue.manage.model.AuthenticationCM;
import com.xinyue.manage.model.CreditManager;
import com.xinyue.manage.model.CreditManagerInfo;
import com.xinyue.manage.model.MoneyOutline;
import com.xinyue.manage.model.Order;

/**
 * 信贷经理服务层
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年8月12日
 */
public interface CreditManagerService {

	List<CreditManagerInfo> findCmanagersByConditions(SearchCreditManager cmSearch);

	CreditManagerInfo findCreditManagerInfoById(String managerId);
	
	/**
	 * 信贷经理详情-基本信息(后台)
	 * @param managerId
	 * @return
	 */
	CreditManager getCreditManagerById(String managerId);

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
	boolean updateCreditmanagers(String managerIds, String status);

	/**
	 * 信贷经理保存
	 * @param creditManager
	 * @return
	 */
	boolean saveCreditManager(CreditManager creditManager);

	/**
	 * 信贷经理认证信息
	 * @param managerId
	 * @return
	 */
	AuthenticationCM getAuthenticationById(String managerId);

	/**
	 * 普通会员推荐人数
	 * @param managerId
	 * @return
	 */
	int getInvitationMemberCount(String managerId);

	/**
	 * 普通会员推荐信息
	 * @param managerId
	 * @param page
	 * @return
	 */
	List<InvitationMemberInfo> getInvitationMemberInfo(String managerId,int page);

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
	 * 信贷经理推荐信息
	 * @param managerId
	 * @param i
	 * @return
	 */
	List<InvitationMemberInfo> getInvitationManagerInfo(String managerId, int page);

	/**
	 * 信贷经理推荐信息记录数
	 * @param managerId
	 * @return
	 */
	int getInvitationManagerRecords(String managerId);

	/**
	 * 资金账户
	 * @param managerId
	 * @return
	 */
	MoneyOutline getMoneyAccountByManagerId(String managerId);

	/**
	 * 信贷经理详情-服务评级列表
	 * @param managerId
	 * @param star 
	 * @param page 
	 * @return
	 */
	List<Order> getServerRatingByManagerId(String managerId, int page, int star);

	/**
	 * 信贷经理详情-服务评级数量
	 * @param managerId
	 * @return
	 */
	int getServerRatingCount(String managerId);

	/**
	 * 信贷经理详情-服务评级综合
	 * @param managerId
	 * @return
	 */
	int getServerStar(String managerId);
}
