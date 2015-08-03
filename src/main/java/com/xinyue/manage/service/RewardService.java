package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.SearchReward;
import com.xinyue.manage.model.RewardOutLine;
import com.xinyue.manage.model.RewardReward;
import com.xinyue.manage.model.RewardWithdraw;

/**
 * author lzc
 */
public interface RewardService {
	public List<RewardWithdraw> getRewardWithdrawList(String userId, int pageNo, int pageSize,SearchReward searchReward);
	
	public int countRewardWithdraw(String userId,SearchReward searchReward);
	
	public List<RewardReward> getRewardList(String userId, int pageNo, int pageSize, SearchReward searchReward);
	
	public int countRewardList(String userId,SearchReward searchReward);
	
	public RewardOutLine getOutLine(String userId);
	
	public boolean addWithdraw(String userId, RewardReward reward);

}
