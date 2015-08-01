package com.xinyue.manage.model;

import java.util.Date;

/**
 * author lzc
 */
public class RewardReward {
	private String id;
	private String code;
	private String userId;
	private String waterId;//流水号
	private String remark;
	private String source;//来源
	private Date createdTime;
	private String createdId;
	private float rewardPrice;//奖励金额
	private float totalRecord;//奖励余额
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getWaterId() {
		return waterId;
	}
	public void setWaterId(String waterId) {
		this.waterId = waterId;
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
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getCreatedId() {
		return createdId;
	}
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}
	public float getRewardPrice() {
		return rewardPrice;
	}
	public void setRewardPrice(float rewardPrice) {
		this.rewardPrice = rewardPrice;
	}
	public float getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(float totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	
}
