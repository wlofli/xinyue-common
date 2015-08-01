package com.xinyue.manage.model;

import java.util.Date;

/**
 * author lzc
 */
public class RewardOutLine {
	private String id;//主键
	private String userId;//用户id
	private float totalPrice;//总计奖励金额
	private float totalWithdrawCash;//总计提现金额
	private float totalRecord;//账户余额
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
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public float getTotalWithdrawCash() {
		return totalWithdrawCash;
	}
	public void setTotalWithdrawCash(float totalWithdrawCash) {
		this.totalWithdrawCash = totalWithdrawCash;
	}
	public float getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(float totalRecord) {
		this.totalRecord = totalRecord;
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
