package com.xinyue.manage.model;

import java.util.Date;

/**
 * author lzc
 */
public class RewardWithdraw {
	
	private String id;
	private String code;//订单号
	private String userId;
	private String waterId;//流水号
	private String remark;
	private String type;//类型
	private String status;//状态
	private Date createdTime;
	private String createdId;
	private String modifiedId;
	private Date modifiedTime;
	private float totalRecord;//账户余额
	private float withdrawPrice;//提现金额
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatu(String status) {
		this.status = status;
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
	public String getModifiedId() {
		return modifiedId;
	}
	public void setModifiedId(String modifiedId) {
		this.modifiedId = modifiedId;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public float getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(float totalRecord) {
		this.totalRecord = totalRecord;
	}
	public float getWithdrawPrice() {
		return withdrawPrice;
	}
	public void setWithdrawPrice(float withdrawPrice) {
		this.withdrawPrice = withdrawPrice;
	}
	

}
