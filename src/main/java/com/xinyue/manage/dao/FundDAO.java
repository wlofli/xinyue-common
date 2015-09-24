package com.xinyue.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xinyue.manage.beans.SearchMoneyAccount;
import com.xinyue.manage.beans.SearchReward;
import com.xinyue.manage.model.Consumption;
import com.xinyue.manage.model.Recharge;

/**
 * 资金DAO（充值、消费）
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年9月9日
 */
public interface FundDAO {

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
	
	//add by lzc start
	/**根据用户id获取消费列表
	 * add by lzc     date: 2015年9月14日
	 * @return
	 */
	List<Consumption> getConsumptionListByUserId(@Param("userId")String userId, @Param("userType")String userType, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize, @Param("searchReward")SearchReward searchReward);
	
	/**根据用户id获取总消费条数
	 * add by lzc     date: 2015年9月14日
	 */
	int countConsumptionListByUserId(@Param("userId")String userId, @Param("userType")String userType,
			@Param("searchReward")SearchReward searchReward);
	
	/**根据搜索条件获取消费列表
	 * add by lzc     date: 2015年9月17日
	 * @param searchReward
	 * @return
	 */
	List<Consumption> getConsumptionByCondition(@Param("search")SearchReward searchReward, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize);
	
	int countConsumptionByCondition(@Param("search")SearchReward searchReward);
	
	
	/**根据条件获取总消费金额
	 * add by lzc     date: 2015年9月17日
	 * @param searchReward 可以为null
	 * @return
	 */
	Double sumConsumptionByCondition(@Param("search")SearchReward searchReward);
	
	
	/**获取信贷经理的消费记录详情
	 * add by lzc     date: 2015年9月17日
	 * @param id
	 * @return
	 */
	Consumption getConsumptionById(@Param("id")String id);
	
	
	/**根据用户id获取充值列表
	 * add by lzc     date: 2015年9月14日
	 */
	List<Recharge> getRechargesByUserId(@Param("userId")String userId, @Param("userType")String userType, @Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize, @Param("searchReward")SearchReward searchReward);
	
	/**根据用户id获取总充值条数
	 * add by lzc     date: 2015年9月14日
	 */
	int countRechargesByUserId(@Param("userId")String userId, @Param("userType")String userType,
			@Param("searchReward")SearchReward searchReward);
	
	
	/**根据条件获取信贷经理的充值记录
	 * add by lzc     date: 2015年9月15日
	 * @param searchReward
	 * @return
	 */
	List<Recharge> getRechargesByCondition(@Param("pageNo")int pageNo,
			@Param("pageSize")int pageSize, @Param("search")SearchReward searchReward);
	
	int countRechargesByCondition(@Param("search")SearchReward searchReward);
	
	/**根据条件查询总充值金额
	 * add by lzc     date: 2015年9月16日
	 * @param searchReward  null则表示获取所有充值金额
	 * @return
	 */
	Double sumRechargeAmountByCondition(@Param("search")SearchReward searchReward);
	
	/**添加充值
	 * add by lzc     date: 2015年9月14日
	 */
	boolean addRecharge(Recharge recharge);
	
	Recharge getRechargeById(@Param("id")String id);
	
//	add by lzc end

	/**
	 * 消费记录条数（后台）
	 * @param searchMoneyAccount
	 * @return
	 */
	int getConsumptionRecordsCount(SearchMoneyAccount searchMoneyAccount);

}
