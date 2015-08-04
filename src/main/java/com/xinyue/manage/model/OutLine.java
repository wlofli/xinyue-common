package com.xinyue.manage.model;

import java.util.Date;

/**
 * author lzc
 */
public class OutLine {
	private String id;//主键
	private String userId;//用户id
	private String userType;
	private float rechargeTotal;//总充值金额
	private float consumptionTotal;//总消费金额
	private float rewardTotal;//总计奖励金额
	private float withdrawTotal;//总计提现金额
	private float remainingSum;//账户余额
	private String createdId;
	private String modifiedId;
	private Date createdTime;//创建时间
	private Date modifiedTime;//修改时间
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
	public float getRechargeTotal() {
		return rechargeTotal;
	}
	public void setRechargeTotal(float rechargeTotal) {
		this.rechargeTotal = rechargeTotal;
	}
	public float getConsumptionTotal() {
		return consumptionTotal;
	}
	public void setConsumptionTotal(float consumptionTotal) {
		this.consumptionTotal = consumptionTotal;
	}
	public float getRewardTotal() {
		return rewardTotal;
	}
	public void setRewardTotal(float rewardTotal) {
		this.rewardTotal = rewardTotal;
	}
	public float getWithdrawTotal() {
		return withdrawTotal;
	}
	public void setWithdrawTotal(float withdrawTotal) {
		this.withdrawTotal = withdrawTotal;
	}
	public float getRemainingSum() {
		return remainingSum;
	}
	public void setRemainingSum(float remainingSum) {
		this.remainingSum = remainingSum;
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
	
	
	
}
