package com.xinyue.manage.service;

import java.util.List;



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
	
	public List<Reward> getRewardList(String userId, int pageNo, int pageSize, SearchReward searchReward);
	
	public int countRewardList(String userId,SearchReward searchReward);
	
	
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

}
