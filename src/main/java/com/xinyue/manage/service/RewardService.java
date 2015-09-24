package com.xinyue.manage.service;

import java.util.List;







import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.SearchMoneyAccount;
import com.xinyue.manage.beans.SearchOrderCredit;
import com.xinyue.manage.beans.SearchReward;
import com.xinyue.manage.model.OutLine;
import com.xinyue.manage.model.Reward;
import com.xinyue.manage.model.WithdrawMoney;

/**
 * author lzc
 */
public interface RewardService {
	public List<WithdrawMoney> getRewardWithdrawList(String userId, int pageNo, int pageSize,SearchReward searchReward);
	
	public int countRewardWithdraw(String userId,SearchReward searchReward);
	
	
	/**根据条件获取提现列表
	 * add by lzc     date: 2015年9月21日
	 * @param searchReward
	 * @return
	 */
	public List<WithdrawMoney> getWithdrawListByCondition(SearchReward searchReward, int pageNo, int pageSize);
	
	public WithdrawMoney getWithdrawMoneyById(String id);
	
	
	/**后台->资金管理->提现管理列表
	 * add by lzc     date: 2015年9月23日
	 * @param statusList
	 * @return
	 */
	public List<SearchOrderCredit> getWithdrawInfoWithNum(int[] statusList);
	
	
	/**修改提现状态
	 * add by lzc     date: 2015年9月22日
	 * @param withdrawMoney 值不同,更新的字段不同
	 * @return
	 */
	public boolean updateWithdraw(WithdrawMoney withdrawMoney);
	
	public int countWithdrawListByCondition(SearchReward searchReward);
	
	/**获取userId对应的奖励列表
	 * add by lzc     date: 2015年9月21日
	 * @param userId
	 * @return
	 */
	public List<Reward> getRewardList(String userId, int pageNo, int pageSize, SearchReward searchReward);
	
	public int countRewardList(String userId,SearchReward searchReward);
	
	/**根据条件获取奖励列表->包括信贷经理和普通会员
	 * add by lzc     date: 2015年9月21日
	 */
	public List<Reward> getRewardListByCondition(SearchReward searchReward,int pageNo,int pageSize);
	
	
	public int countRewardListBycondition(SearchReward searchReward);
	
	
	/**返回总的奖励余额
	 * add by lzc     date: 2015年9月21日
	 * @return
	 */
	public Double getAllAwardRemain();
	
	/**返回总的奖励累计金额
	 * add by lzc     date: 2015年9月21日
	 * @return
	 */
	public Double getAllReward();
	
	/**返回总的提现累计金额
	 * add by lzc     date: 2015年9月21日
	 * @return
	 */
	public Double getAllWithdraw();
	
	
	@Deprecated
	public OutLine getOutLine(String userId);
	
	
	/**
	 * add by lzc     date: 2015年9月7日
	 * @param userId 用户id
	 * @param userType 用户类型
	 * @return
	 */
	public OutLine getOutLine(String userId, String userType);
	
	public boolean addWithdraw(String userId, Reward reward);
	
	
	/**信贷前台->资金管理->账户详情
	 * add by lzc     date: 2015年9月9日
	 * @param userId
	 * @param userType
	 * @return
	 */
	public List<OutLine> getDetaiList(String userId, String userType, int pageNo, int pageSize, SearchReward searchReward);
	
	public int countDetailList(String userId, String userType, SearchReward searchReward);

	/**
	 * 信贷经理管理-资金账户-奖励记录（后台）
	 * add by maozj 2015/9/9
	 * @param searchMoneyAccount
	 * @return
	 */
	public List<Reward> getRewardRecords(SearchMoneyAccount searchMoneyAccount);

	/**
	 * 信贷经理管理-资金账户-奖励记录数量（后台）
	 * add by maozj 2015/9/9
	 * @param searchMoneyAccount
	 * @return
	 */
	public int getRewardRecordsCount(SearchMoneyAccount searchMoneyAccount);

	/**
	 * 信贷经理管理-资金账户-提现记录（后台）
	 * @param searchMoneyAccount
	 * @return
	 */
	public List<WithdrawMoney> getWithdrawMoneyRecords(
			SearchMoneyAccount searchMoneyAccount);

	/**
	 * 信贷经理管理-资金账户-提现记录数量（后台）
	 * @param searchMoneyAccount
	 * @return
	 */
	public int getWithdrawMoneyRecordsCount(
			SearchMoneyAccount searchMoneyAccount);
	
	

}
