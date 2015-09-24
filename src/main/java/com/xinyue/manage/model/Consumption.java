package com.xinyue.manage.model;

import java.util.Date;

/**
 * author lzc
 * 消费
 */
public class Consumption {
	    private String orderId;
	    private String userId;
	    private String consumptionType;
	    private Double consumptionAmount;//消费金额
	    private Double otherPayAmount;//代金券消费金额
	    private String otherPayType;//代金券消费类型
	    private Double otherPayAward;//奖励消费金额
	    private Double payAward;//现金消费金额
	    private Date consumptionTime;
	    private String status;
	    private String sericalNumber;//流水号
	    private String remark;
	    private String deleted;
	    private String userType;

	    private Double currentAmount;//当前金额
	    private Double otherRewardAmount;//代金券余额
	    private Double otherAwardAmount;//奖励余额
	    
	    private String customerName;//客户姓名
	    private String customerPhone;//客户电话
	    private String organization;//机构
	    
	    
	    
	    
	    
		public String getOrganization() {
			return organization;
		}
		public void setOrganization(String organization) {
			this.organization = organization;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getCustomerPhone() {
			return customerPhone;
		}
		public void setCustomerPhone(String customerPhone) {
			this.customerPhone = customerPhone;
		}
		public Double getPayAward() {
			return payAward;
		}
		public void setPayAward(Double payAward) {
			this.payAward = payAward;
		}
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getConsumptionType() {
			return consumptionType;
		}
		public void setConsumptionType(String consumptionType) {
			this.consumptionType = consumptionType;
		}
		public Double getConsumptionAmount() {
			return consumptionAmount;
		}
		public void setConsumptionAmount(Double consumptionAmount) {
			this.consumptionAmount = consumptionAmount;
		}
		public Double getOtherPayAmount() {
			return otherPayAmount;
		}
		public void setOtherPayAmount(Double otherPayAmount) {
			this.otherPayAmount = otherPayAmount;
		}
		public String getOtherPayType() {
			return otherPayType;
		}
		public void setOtherPayType(String otherPayType) {
			this.otherPayType = otherPayType;
		}
		public Double getOtherPayAward() {
			return otherPayAward;
		}
		public void setOtherPayAward(Double otherPayAward) {
			this.otherPayAward = otherPayAward;
		}
		public Date getConsumptionTime() {
			return consumptionTime;
		}
		public void setConsumptionTime(Date consumptionTime) {
			this.consumptionTime = consumptionTime;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
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
		public String getDeleted() {
			return deleted;
		}
		public void setDeleted(String deleted) {
			this.deleted = deleted;
		}
		public String getUserType() {
			return userType;
		}
		public void setUserType(String userType) {
			this.userType = userType;
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

}
