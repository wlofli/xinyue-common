package com.xinyue.manage.model;

import java.util.Date;

/**
 * author lzc
 */
public class Reward {
	private String id;//订单号
	private String userId;
	private String userType;
	private String rewardType;//奖励类型来源
	private String sericalNumber;//流水号
	private String remark;
//	private String source;//来源
	private Double rewardAmount;//奖励金额
	private Date rewardTime;//时间
	private Double currentAmount;//当前余额
	private Double otherRewardAmount;//代金券余额
	private Double otherAwardAmount;//奖励余额
	private String status;//状态
	private String deleted;
//	private String recommendUserId;//被推荐用户Id
//	private String recommendUserType;//被推荐用户类型（m：普通会员；c：信贷经理）
	
	private String recommendUserName;//被推荐用户姓名
	private String recommendUserPhone;//被推荐用户电话
	
	private String userName;//用户名
	private String userPhone;//用户电话
	private String province;//省
	private String city;//市
	private String zone;//区
	
	
	
	
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public Double getRewardAmount() {
		return rewardAmount;
	}
	public void setRewardAmount(Double rewardAmount) {
		this.rewardAmount = rewardAmount;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public String getRecommendUserName() {
		return recommendUserName;
	}
	public void setRecommendUserName(String recommendUserName) {
		this.recommendUserName = recommendUserName;
	}
	public String getRecommendUserPhone() {
		return recommendUserPhone;
	}
	public void setRecommendUserPhone(String recommendUserPhone) {
		this.recommendUserPhone = recommendUserPhone;
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
//	public String getSource() {
//		return source;
//	}
//	public void setSource(String source) {
//		this.source = source;
//	}
	public Date getRewardTime() {
		return rewardTime;
	}
	public void setRewardTime(Date rewardTime) {
		this.rewardTime = rewardTime;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	
}
