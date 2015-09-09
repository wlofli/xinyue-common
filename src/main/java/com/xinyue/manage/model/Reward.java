package com.xinyue.manage.model;

import java.util.Date;

/**
 * author lzc
 */
public class Reward {
	private String id;//订单号
	private String userId;
	private String userType;
	private String rewardType;//奖励类型
	private String sericalNumber;//流水号
	private String remark;
	private String source;//来源
	private float rewardAmount;//奖励金额
	private Date rewardTime;//时间
	private float currentAmount;//当前金额
	private float otherRewardAmount;//代金券奖励
	private String deleted;
	
	
	
	public float getOtherRewardAmount() {
		return otherRewardAmount;
	}
	public void setOtherRewardAmount(float otherRewardAmount) {
		this.otherRewardAmount = otherRewardAmount;
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
	public String getRewardType() {
		return rewardType;
	}
	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}
	public String getSericalNumber() {
		return sericalNumber;
	}
	public void setSericalNumber(String sericalNumber) {
		this.sericalNumber = sericalNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public float getRewardAmount() {
		return rewardAmount;
	}
	public void setRewardAmount(float rewardAmount) {
		this.rewardAmount = rewardAmount;
	}
	public Date getRewardTime() {
		return rewardTime;
	}
	public void setRewardTime(Date rewardTime) {
		this.rewardTime = rewardTime;
	}
	public float getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(float currentAmount) {
		this.currentAmount = currentAmount;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	
}
