package com.xinyue.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.SearchMoneyAccount;
import com.xinyue.manage.beans.SearchOrderCredit;
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

	@Override
	public List<Reward> getRewardRecords(SearchMoneyAccount searchMoneyAccount) {
		
		return rewardDAO.getRewardRecords(searchMoneyAccount);
	}

	@Override
	public int getRewardRecordsCount(SearchMoneyAccount searchMoneyAccount) {
		
		return rewardDAO.getRewardRecordsCount(searchMoneyAccount);
	}

	@Override
	public List<WithdrawMoney> getWithdrawMoneyRecords(
			SearchMoneyAccount searchMoneyAccount) {
		
		return rewardDAO.getWithdrawMoneyRecords(searchMoneyAccount);
	}

	@Override
	public int getWithdrawMoneyRecordsCount(
			SearchMoneyAccount searchMoneyAccount) {
		
		return rewardDAO.getWithdrawMoneyRecordsCount(searchMoneyAccount);
	}

	@Override
	public List<OutLine> getDetaiList(String userId, String userType, int pageNo ,int pageSize, SearchReward searchReward) {
		// TODO Auto-generated method stub
		return rewardDAO.getDetailList(userId, userType, pageNo, pageSize, searchReward);
	}

	@Override
	public int countDetailList(String userId, String userType,
			SearchReward searchReward) {
		// TODO Auto-generated method stub
		return rewardDAO.countDetailList(userId, userType, searchReward);
	}

	@Override
	public List<Reward> getRewardListByCondition(SearchReward searchReward,
			int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return rewardDAO.getRewardListByCondition(searchReward, pageNo, pageSize);
	}

	@Override
	public int countRewardListBycondition(SearchReward searchReward) {
		// TODO Auto-generated method stub
		return rewardDAO.countRewardListByCondition(searchReward);
	}

	@Override
	public Double getAllAwardRemain() {
		// TODO Auto-generated method stub
		return rewardDAO.getAllAwardRemain();
	}

	@Override
	public Double getAllReward() {
		// TODO Auto-generated method stub
		return rewardDAO.getAllReward();
	}

	@Override
	public Double getAllWithdraw() {
		// TODO Auto-generated method stub
		return rewardDAO.getAllWithdraw();
	}

	@Override
	public List<WithdrawMoney> getWithdrawListByCondition(
			SearchReward searchReward, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return rewardDAO.getWithdrawListByCondition(searchReward, pageNo, pageSize);
	}

	@Override
	public int countWithdrawListByCondition(SearchReward searchReward) {
		// TODO Auto-generated method stub
		return rewardDAO.countWithdrawListByCondition(searchReward);
	}

	@Override
	public WithdrawMoney getWithdrawMoneyById(String id) {
		// TODO Auto-generated method stub
		return rewardDAO.getWithdrawMoneyById(id);
	}

	@Override
	public boolean updateWithdraw(WithdrawMoney withdrawMoney) {
		// TODO Auto-generated method stub
		try {
			rewardDAO.updateWithdrawMoney(withdrawMoney);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
		return true;
	}

	@Override
	public List<SearchOrderCredit> getWithdrawInfoWithNum(int[] statusList) {
		// TODO Auto-generated method stub
		return rewardDAO.getWithdrawInfoWithNum(statusList);
	}

	

}
