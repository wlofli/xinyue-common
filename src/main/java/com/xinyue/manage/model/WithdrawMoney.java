package com.xinyue.manage.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	private Double currentAmount;//账户余额
	private Double otherRewardAmount;//代金券余额
	private Double otherAwardAmount;//奖励余额
	private Double withdrawAmount;//提现金额
	private Date withdrawTime;//提现时间
	private String remark;
	private String deleted;
	
	
	private String auditePerson;//审核人员
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date   auditeTime;//审核时间
	private String auditeRemark;//备注
	private String payPerson;//付款人员
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date   payTime;//付款时间
	private String payRemark;
	
	
	private String userName;//用户姓名
	private String userPhone;//用户电话
	private String userStatus;//用户状态
	
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getAuditePerson() {
		return auditePerson;
	}
	public void setAuditePerson(String auditePerson) {
		this.auditePerson = auditePerson;
	}
	public Date getAuditeTime() {
		return auditeTime;
	}
	public void setAuditeTime(Date auditeTime) {
		this.auditeTime = auditeTime;
	}
	public String getAuditeRemark() {
		return auditeRemark;
	}
	public void setAuditeRemark(String auditeRemark) {
		this.auditeRemark = auditeRemark;
	}
	public String getPayPerson() {
		return payPerson;
	}
	public void setPayPerson(String payPerson) {
		this.payPerson = payPerson;
	}
	
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public String getPayRemark() {
		return payRemark;
	}
	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	}
	public Double getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(Double currentAmount) {
		this.currentAmount = currentAmount;
	}
	public Double getOtherRewardAmount() {
		return otherRewardAmount;
	}
	public void setOtherRewardAmount(Double otherRewardAmount) {
		this.otherRewardAmount = otherRewardAmount;
	}
	public Double getOtherAwardAmount() {
		return otherAwardAmount;
	}
	public void setOtherAwardAmount(Double otherAwardAmount) {
		this.otherAwardAmount = otherAwardAmount;
	}
	public Double getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(Double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
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
