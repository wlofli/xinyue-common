package com.xinyue.manage.model;

import java.util.Date;

/**
 * author lzc
 */
public class WithdrawMoney {
	private String id;//订单号
	private String userId;//用户ID
	private String userType;
	private String sericalNumber;//流水号
	private String withdrawType;//类型
	private String status;//状态
	private float currentAmount;//账户余额
	private float withdrawAmount;//提现金额
	private Date withdrawTime;//提现时间
	private String remark;
	private String deleted;
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
	public String getSericalNumber() {
		return sericalNumber;
	}
	public void setSericalNumber(String sericalNumber) {
		this.sericalNumber = sericalNumber;
	}
	public String getWithdrawType() {
		return withdrawType;
	}
	public void setWithdrawType(String withdrawType) {
		this.withdrawType = withdrawType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(float currentAmount) {
		this.currentAmount = currentAmount;
	}
	public float getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(float withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	public Date getWithdrawTime() {
		return withdrawTime;
	}
	public void setWithdrawTime(Date withdrawTime) {
		this.withdrawTime = withdrawTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	
	
}
