package com.xinyue.manage.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xinyue.manage.beans.SearchMoneyAccount;
import com.xinyue.manage.beans.SearchReward;
import com.xinyue.manage.dao.FundDAO;
import com.xinyue.manage.dao.RewardDAO;
import com.xinyue.manage.model.Consumption;
import com.xinyue.manage.model.OutLine;
import com.xinyue.manage.model.Recharge;
import com.xinyue.manage.service.FundService;
import com.xinyue.manage.util.SericalNumber;

/**
 * 资金服务层（充值、消费）
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年9月9日
 */
@Service
public class FundServiceImpl implements FundService {

	@Resource
	private FundDAO fundDAO;
	
	@Resource
	private RewardDAO rewardDAO;
	
	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public List<Recharge> getRechargeRecords(
			SearchMoneyAccount searchMoneyAccount) {
		
		return fundDAO.getRechargeRecords(searchMoneyAccount);
	}

	@Override
	public int getRechargeRecordsCount(SearchMoneyAccount searchMoneyAccount) {
		
		return fundDAO.getRechargeRecordsCount(searchMoneyAccount);
	}

	@Override
	public List<Consumption> getConsumptionRecords(
			SearchMoneyAccount searchMoneyAccount) {
		
		return fundDAO.getConsumptionRecords(searchMoneyAccount);
	}

	@Override
	public int getConsumptionRecordsCount(SearchMoneyAccount searchMoneyAccount) {
		
		return fundDAO.getConsumptionRecordsCount(searchMoneyAccount);
	}
	@Override
	public List<Consumption> getConsumptionsByUserId(String userId,
			String userType, int pageNo, int pageSize, SearchReward searchReward) {
		// TODO Auto-generated method stub
		return fundDAO.getConsumptionListByUserId(userId, userType, pageNo, pageSize, searchReward);
	}

	@Override
	public int countConsumptionByUserId(String userId, String userType,
			SearchReward searchReward) {
		// TODO Auto-generated method stub
		return fundDAO.countConsumptionListByUserId(userId, userType, searchReward);
	}

	@Override
	public List<Recharge> getRechargesByUserId(String userId, String userType,
			int pageNo, int pageSize, SearchReward searchReward) {
		// TODO Auto-generated method stub
		return fundDAO.getRechargesByUserId(userId, userType, pageNo, pageSize, searchReward);
	}

	@Override
	public int countRechargeByUserId(String userId, String userType,
			SearchReward searchReward) {
		// TODO Auto-generated method stub
		return fundDAO.countRechargesByUserId(userId, userType, searchReward);
	}

	@Override
	public  boolean  addRecharge(Recharge recharge, String modifiedId) {
		// TODO Auto-generated method stub
		//undone可能要加个冲100送100的活动,具体等营运人员制定规则
		if(recharge.getUserId() == null || recharge.getUserType() == null || recharge.getRechargeAmount() == 0){
			log.debug("充值条件不足");
			return false;
		}
		try {
			OutLine outLine = rewardDAO.getRewardOutLineByuserId(recharge.getUserId(), recharge.getUserType());
			
//			Recharge recharge = new Recharge();
			recharge.setOrderId(UUID.randomUUID().toString().replaceAll("-", ""));
//			recharge.setRechargeAmount(money);
//			recharge.setUserId(userId);
//			recharge.setUserType(userType);
//			recharge.setRechargeType(rechargeType);
			recharge.setStatus("1");
//			undone ->status 除了成功还有什么状态???
			recharge.setSericalNumber(SericalNumber.getInstance().generaterNextNumber());
			
			outLine.setRechargeTotal(outLine.getRechargeTotal() + recharge.getRechargeAmount());
			outLine.setCashRemain(outLine.getCashRemain() + recharge.getRechargeAmount());
			outLine.setModifiedId(modifiedId);
			
			recharge.setCurrentAmount(outLine.getCashRemain());
			recharge.setRewordAmountC(outLine.getAwardRemain().toString());
			recharge.setRewordAmountD(outLine.getRewardRemain().toString());
			rewardDAO.updateOutline(outLine);
			fundDAO.addRecharge(recharge);
		} catch (Exception e) {	
			// TODO: handle exception
			throw new RuntimeException();
		}
		
		return true;
	}

	@Override
	public List<Recharge> getRechargesBySearch(SearchReward searchReward,
			int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return fundDAO.getRechargesByCondition(pageNo, pageSize, searchReward);
	}

	@Override
	public int countRechargesBySearch(SearchReward searchReward) {
		// TODO Auto-generated method stub
		return fundDAO.countRechargesByCondition(searchReward);
	}

	@Override
	public Double sumRechargeAmountByCondition(SearchReward searchReward) {
		// TODO Auto-generated method stub
		return fundDAO.sumRechargeAmountByCondition(searchReward);
	}

	@Override
	public Recharge getRechargeById(String id) {
		// TODO Auto-generated method stub
		return fundDAO.getRechargeById(id);
	}

	@Override
	public List<Consumption> getConsumptionByCondition(int pageNo,
			int pageSize, SearchReward searchReward) {
		// TODO Auto-generated method stub
		return fundDAO.getConsumptionByCondition(searchReward, pageNo, pageSize);
	}

	@Override
	public int countConsumptionByCondition(SearchReward searchReward) {
		// TODO Auto-generated method stub
		return fundDAO.countConsumptionByCondition(searchReward);
	}

	@Override
	public Double sumConsumptionByCondition(SearchReward searchReward) {
		// TODO Auto-generated method stub
		return fundDAO.sumConsumptionByCondition(searchReward);
	}

	@Override
	public Consumption getConsumptionById(String id) {
		// TODO Auto-generated method stub
		return fundDAO.getConsumptionById(id);
	}

}
