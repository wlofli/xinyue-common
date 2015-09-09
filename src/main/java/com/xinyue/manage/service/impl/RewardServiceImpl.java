package com.xinyue.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.SearchReward;
import com.xinyue.manage.dao.RewardDAO;
import com.xinyue.manage.model.OutLine;
import com.xinyue.manage.model.Reward;
import com.xinyue.manage.model.WithdrawMoney;
import com.xinyue.manage.service.RewardService;
import com.xinyue.manage.util.GlobalConstant;

/**
 * author lzc
 */
@Service
public class RewardServiceImpl  implements RewardService{

	@Resource
	private RewardDAO rewardDAO;
	
	@Override
	public List<WithdrawMoney> getRewardWithdrawList(String userId,
			int pageNo, int pageSize,SearchReward searchReward) {
		// TODO Auto-generated method stub
		return rewardDAO.getWithdrawList(userId, pageNo, pageSize, searchReward);
	}

	@Override
	public List<Reward> getRewardList(String userId, int pageNo,
			int pageSize, SearchReward searchReward) {
		// TODO Auto-generated method stub
		return rewardDAO.getRewardList(userId, pageNo, pageSize, searchReward, GlobalConstant.REWARD_SOURCE);
	}

	@Override
	@Deprecated
	public OutLine getOutLine(String userId) {
		// TODO Auto-generated method stub
		return rewardDAO.getRewardOutLine(userId);
	}
	
	@Override
	public OutLine getOutLine(String userId, String userType) {
		// TODO Auto-generated method stub
		return rewardDAO.getRewardOutLineByuserId(userId, userType);
	}

	@Override
	public boolean addWithdraw(String userId, Reward reward) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int countRewardWithdraw(String userId, SearchReward searchReward) {
		// TODO Auto-generated method stub
		return rewardDAO.countWithdrawList(userId, searchReward);
	}

	@Override
	public int countRewardList(String userId, SearchReward searchReward) {
		// TODO Auto-generated method stub
		return rewardDAO.countRewardList(userId, searchReward);
	}

	

}
