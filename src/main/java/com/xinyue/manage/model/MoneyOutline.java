package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 资金综合信息
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年9月7日
 */
public class MoneyOutline implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -441462303636849427L;

	//id
	private String id = "";
	
	//用户id
	private String userId = "";
	
	//总充值金额
	private String rechargeTotal = "";
	
	//总奖励
	private String rewardTotal = "";
	
	//总消费
	private String consumptionTotal = "";
	
	//账户余额
	private String remaining = "";

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the rechargeTotal
	 */
	public String getRechargeTotal() {
		return rechargeTotal;
	}

	/**
	 * @param rechargeTotal the rechargeTotal to set
	 */
	public void setRechargeTotal(String rechargeTotal) {
		this.rechargeTotal = rechargeTotal;
	}

	/**
	 * @return the rewardTotal
	 */
	public String getRewardTotal() {
		return rewardTotal;
	}

	/**
	 * @param rewardTotal the rewardTotal to set
	 */
	public void setRewardTotal(String rewardTotal) {
		this.rewardTotal = rewardTotal;
	}

	/**
	 * @return the consumptionTotal
	 */
	public String getConsumptionTotal() {
		return consumptionTotal;
	}

	/**
	 * @param consumptionTotal the consumptionTotal to set
	 */
	public void setConsumptionTotal(String consumptionTotal) {
		this.consumptionTotal = consumptionTotal;
	}

	/**
	 * @return the remaining
	 */
	public String getRemaining() {
		return remaining;
	}

	/**
	 * @param remaining the remaining to set
	 */
	public void setRemaining(String remaining) {
		this.remaining = remaining;
	}
	
	
}
