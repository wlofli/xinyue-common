package com.xinyue.manage.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.InvitationMemberInfo;
import com.xinyue.manage.beans.SearchCreditManager;
import com.xinyue.manage.beans.SearchRecommend;
import com.xinyue.manage.model.AuthenticationCM;
import com.xinyue.manage.model.CreditManager;
import com.xinyue.manage.model.CreditManagerInfo;
import com.xinyue.manage.model.MoneyOutline;
import com.xinyue.manage.model.Order;
import com.xinyue.manage.model.Select;
/**
 * ywh  2015-12-08  添加推荐方法updateCreditRecommend
 */
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
	 * youwh
	 * 机构下的id
	 * @param orgid 机构id
	 * @return
	 */
	public List<CreditManagerInfo> findCreditByOrgid(@Param("orgid")String orgid);
	
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

	/**
	 * 资金账户
	 * @param managerId
	 * @return
	 */
	MoneyOutline getMoneyAccountByManagerId(String managerId);

	/**
	 * 评价信息列表
	 * @param managerId
	 * @return
	 */
	List<Order> getServerRating(HashMap<String, Object> map);

	/**
	 * 评价信息数量
	 * @param managerId
	 * @return
	 */
	int getServerRatingCount(String managerId);
	
	//ywh start
	/**
	 * 获取所有信贷经理
	 * @return
	 */
	public List<Select> getAllCredit();
	
	//2015-11-13 提交审核信息 ywh
	public void updateAudit(AuthenticationCM cm);
	//是否设为首页推荐
	public void updateCreditRecommend(AuthenticationCM cm);
	//ywh over
	
	
	//add by lzc
	/**信贷经理 -分享推荐会员 - 普通
	 * add by lzc     date: 2015年11月12日
	 * @param managerId
	 * @param index
	 * @param recommend
	 * @return
	 */
	public List<InvitationMemberInfo> getInvitationMember(@Param("managerId")String managerId,@Param("index")int index,
			@Param("search")SearchRecommend recommend);
	
	public int countInvitationMember(@Param("managerId")String managerId,@Param("search")SearchRecommend recommend);
	
	/**信贷经理 -分享推荐会员 - 信贷
	 * add by lzc     date: 2015年11月12日
	 * @param managerId
	 * @param index
	 * @param recommend
	 * @return
	 */
	public List<InvitationMemberInfo> getInvitationManager(@Param("managerId")String managerId,@Param("index")int index,
			@Param("search")SearchRecommend recommend);
	
	public int countInvitationMangager(@Param("managerId")String managerId,@Param("search")SearchRecommend recommend);
	
	
	
	/**首页获取推荐至首页的信贷经理列表
	 * add by lzc     date: 2015年12月4日
	 * @param index
	 * @param pageSize
	 * @return
	 */
	public List<CreditManagerInfo> getCreditManagerInfoByIndex(@Param("pageNo")int pageNo, @Param("pageSize")int pageSize);
	//end by lzc
	
	

}
