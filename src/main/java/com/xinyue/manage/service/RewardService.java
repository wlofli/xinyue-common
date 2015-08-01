package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.model.RewardOutLine;
import com.xinyue.manage.model.RewardReward;
import com.xinyue.manage.model.RewardWithdraw;

/**
 * author lzc
 */
public interface RewardService {
	public List<RewardWithdraw> getRewardWithdrawList(String userId, int pageNo, int pageSize);
		
	public List<RewardReward> getRewardList(String userId, int pageNo, int pageSize);
	
	public RewardOutLine getOutLine(String userId);
	
	

}
