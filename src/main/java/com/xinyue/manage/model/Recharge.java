package com.xinyue.manage.model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * 
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年9月9日
 */
public class Recharge implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3202311281221070149L;

	//订单号
	private String orderId = "";
	
	//用户ID
	private String userId = "";
	
//	add by lzc
	private String userType = "";
	
	//充值类型
	private String rechargeType = "";
	
	//充值金额
	private double rechargeAmount ;
	private String rechargeAmountShow = "";
	
	//充值时间
	private String rechargeTime = "";
	
	//状态
	private String status = "";
	
	//流水号
	private String sericalNumber = "";
	
	//备注
	private String remark = "";
	
	//余额
	private double currentAmount ;
	private String currentAmountShow = "";
	
	//代金券余额
	private String rewordAmountD = "";
	
	//奖励余额
	private String rewordAmountC = "";
	
	protected DecimalFormat df = new DecimalFormat("######0");
	
	private String userName;
	private String userPhone;
	private String organization;
	
	
	
	

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the rechargeType
	 */
	public String getRechargeType() {
		return rechargeType;
	}

	/**
	 * @param rechargeType the rechargeType to set
	 */
	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}

	/**
	 * @return the rechargeTime
	 */
	public String getRechargeTime() {
		return rechargeTime;
	}

	/**
	 * @param rechargeTime the rechargeTime to set
	 */
	public void setRechargeTime(String rechargeTime) {
		this.rechargeTime = rechargeTime;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the sericalNumber
	 */
	public String getSericalNumber() {
		return sericalNumber;
	}

	/**
	 * @param sericalNumber the sericalNumber to set
	 */
	public void setSericalNumber(String sericalNumber) {
		this.sericalNumber = sericalNumber;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the rewordAmountD
	 */
	public String getRewordAmountD() {
		return rewordAmountD;
	}

	/**
	 * @param rewordAmountD the rewordAmountD to set
	 */
	public void setRewordAmountD(String rewordAmountD) {
		this.rewordAmountD = rewordAmountD;
	}

	/**
	 * @return the rewordAmountC
	 */
	public String getRewordAmountC() {
		return rewordAmountC;
	}

	/**
	 * @param rewordAmountC the rewordAmountC to set
	 */
	public void setRewordAmountC(String rewordAmountC) {
		this.rewordAmountC = rewordAmountC;
	}

	/**
	 * @return the rechargeAmountShow
	 */
	public String getRechargeAmountShow() {
		return rechargeAmountShow;
	}

	/**
	 * @param rechargeAmountShow the rechargeAmountShow to set
	 */
	public void setRechargeAmountShow(String rechargeAmountShow) {
		this.rechargeAmountShow = rechargeAmountShow;
	}

	/**
	 * @param rechargeAmount the rechargeAmount to set
	 */
	public void setRechargeAmount(double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
		this.rechargeAmountShow = df.format(rechargeAmount);
	}

	/**
	 * @return the rechargeAmount
	 */
	public double getRechargeAmount() {
		return rechargeAmount;
	}

	/**
	 * @return the currentAmount
	 */
	public double getCurrentAmount() {
		return currentAmount;
	}

	/**
	 * @param currentAmount the currentAmount to set
	 */
	public void setCurrentAmount(double currentAmount) {
		this.currentAmount = currentAmount;
		this.currentAmountShow = df.format(currentAmount);
	}

	/**
	 * @return the currentAmountShow
	 */
	public String getCurrentAmountShow() {
		return currentAmountShow;
	}

	/**
	 * @param currentAmountShow the currentAmountShow to set
	 */
	public void setCurrentAmountShow(String currentAmountShow) {
		this.currentAmountShow = currentAmountShow;
	}
	
}
