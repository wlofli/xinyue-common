package com.xinyue.manage.service;

import java.util.List;

import com.xinyue.manage.beans.SearchMoneyAccount;
import com.xinyue.manage.beans.SearchReward;
import com.xinyue.manage.model.Consumption;
import com.xinyue.manage.model.Recharge;

/**
 * 资金服务层（充值、消费）
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年9月9日
 */
public interface FundService {

	/**
	 * 充值记录（后台）
	 * @param searchMoneyAccount
	 * @return
	 */
	List<Recharge> getRechargeRecords(SearchMoneyAccount searchMoneyAccount);

	/**
	 * 充值记录条数（后台）
	 * @param searchMoneyAccount
	 * @return
	 */
	int getRechargeRecordsCount(SearchMoneyAccount searchMoneyAccount);

	/**
	 * 消费记录（后台）
	 * @param searchMoneyAccount
	 * @return
	 */
	List<Consumption> getConsumptionRecords(
			SearchMoneyAccount searchMoneyAccount);

	/**
	 * 消费记录条数（后台）
	 * @param searchMoneyAccount
	 * @return
	 */
	int getConsumptionRecordsCount(SearchMoneyAccount searchMoneyAccount);
	
//	add by lzc start
	List<Consumption> getConsumptionsByUserId(String userId, String userType,
			int pageNo, int pageSize, SearchReward searchReward);
	
	int countConsumptionByUserId(String userId, String userType, SearchReward searchReward);
	
	/**根据条件获取消费记录
	 * add by lzc     date: 2015年9月17日
	 * @param searchReward
	 * @return
	 */
	List<Consumption> getConsumptionByCondition(int pageNo, int pageSize, SearchReward searchReward);

	int countConsumptionByCondition(SearchReward searchReward);
	
	/**根据条件获取总消费金额
	 * add by lzc     date: 2015年9月17日
	 * @param searchReward 可以为null
	 * @return
	 */
	Double sumConsumptionByCondition(SearchReward searchReward);
	
	/**获取信贷经理的消费记录详情
	 * add by lzc     date: 2015年9月17日
	 * @param id
	 * @return
	 */
	Consumption getConsumptionById(String id);
	
	List<Recharge> getRechargesByUserId(String userId, String userType,
			int pageNo, int pageSize, SearchReward searchReward);
	
	int countRechargeByUserId(String userId, String userType, SearchReward searchReward);
	
	/**根据条件查询充值记录->后台充值管理
	 * 充值只有信贷经理,所以不用考虑会员
	 * add by lzc     date: 2015年9月15日
	 * @return
	 */
	List<Recharge> getRechargesBySearch(SearchReward searchReward, int pageNo, int pageSize);
	
	int countRechargesBySearch(SearchReward searchReward);
	
	/**充值业务逻辑
	 * add by lzc     date: 2015年9月14日
	 * recharge必须包含userId,userType,rechargeAmount,rechargeType四个字段
	 */
	boolean addRecharge(Recharge recharge, String modifiedId);
	
	/**根据条件查询总充值金额
	 * add by lzc     date: 2015年9月16日
	 * @param searchReward  null则表示获取所有充值金额
	 * @return
	 */
	Double sumRechargeAmountByCondition(SearchReward searchReward);
	
	/**根据id获取充值信息
	 * add by lzc     date: 2015年9月16日
	 * @return
	 */
	Recharge getRechargeById(String id);
//	add by lzc end

}
