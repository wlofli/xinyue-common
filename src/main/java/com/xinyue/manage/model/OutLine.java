package com.xinyue.manage.model;

import java.util.Date;

/**
 * author lzc
 */
public class OutLine {
	private String id;//主键
	private String userId;//用户id
	private String userType;//用户类型(m:普通会员 c:信贷经理)
	private Double rechargeTotal;//总充值金额
	private Double consumptionTotal;//总消费金额
	private Double rewardTotal;//总计奖励金额
	private Double withdrawTotal;//总计提现金额
	private Double cashRemain;//账户余额
	private Double rewardRemain;//代金券余额
	private Double awardRemain;//奖励余额
	private String createdId;
	private String modifiedId;
	private Date createdTime;//创建时间
	private Date modifiedTime;//修改时间
	
	
	private Double consumption;//消费
	private Double income;//收入
	
	
	
	public Double getConsumption() {
		return consumption;
	}
	public void setConsumption(Double consumption) {
		this.consumption = consumption;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getCreatedId() {
		return createdId;
	}
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}
	public String getModifiedId() {
		return modifiedId;
	}
	public void setModifiedId(String modifiedId) {
		this.modifiedId = modifiedId;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public Double getCashRemain() {
		return cashRemain;
	}
	public void setCashRemain(Double cashRemain) {
		this.cashRemain = cashRemain;
	}
	public Double getRewardRemain() {
		return rewardRemain;
	}
	public void setRewardRemain(Double rewardRemain) {
		this.rewardRemain = rewardRemain;
	}

	public Double getAwardRemain() {
		return awardRemain;
	}
	public void setAwardRemain(Double awardRemain) {
		this.awardRemain = awardRemain;
	}
	public Double getRechargeTotal() {
		return rechargeTotal;
	}
	public void setRechargeTotal(Double rechargeTotal) {
		this.rechargeTotal = rechargeTotal;
	}
	public Double getConsumptionTotal() {
		return consumptionTotal;
	}
	public void setConsumptionTotal(Double consumptionTotal) {
		this.consumptionTotal = consumptionTotal;
	}
	public Double getRewardTotal() {
		return rewardTotal;
	}
	public void setRewardTotal(Double rewardTotal) {
		this.rewardTotal = rewardTotal;
	}
	public Double getWithdrawTotal() {
		return withdrawTotal;
	}
	public void setWithdrawTotal(Double withdrawTotal) {
		this.withdrawTotal = withdrawTotal;
	}
	
	
	
	
	
}
