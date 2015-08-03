package com.xinyue.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.SearchReward;
import com.xinyue.manage.dao.RewardDAO;
import com.xinyue.manage.model.RewardOutLine;
import com.xinyue.manage.model.RewardReward;
import com.xinyue.manage.model.RewardWithdraw;
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
	public List<RewardWithdraw> getRewardWithdrawList(String userId,
			int pageNo, int pageSize,SearchReward searchReward) {
		// TODO Auto-generated method stub
		return rewardDAO.getWithdrawList(userId, pageNo, pageSize, searchReward);
	}

	@Override
	public List<RewardReward> getRewardList(String userId, int pageNo,
			int pageSize, SearchReward searchReward) {
		// TODO Auto-generated method stub
		return rewardDAO.getRewardList(userId, pageNo, pageSize, searchReward, GlobalConstant.REWARD_SOURCE);
	}

	@Override
	public RewardOutLine getOutLine(String userId) {
		// TODO Auto-generated method stub
		return rewardDAO.getRewardOutLine(userId);
	}

	@Override
	public boolean addWithdraw(String userId, RewardReward reward) {
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
