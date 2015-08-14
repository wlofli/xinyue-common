package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 申请人信息
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年5月
 */
public class Applicant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3900843757264340378L;

	/** 申请信息id */
	private String id = "";
	
	/** 申请人姓名 */
	private String name ="";
	
	/** 手机 */
	private String phone ="";
	
	/** 邮箱 */
	private String email ="";
	
	/** 申贷期限 */
	private String limitDate ="";
	
	/** 申贷金额 */
	private String money ="";
	
	/** 可接受最高利率 */
	private String interestRate ="";
	
	/** 还款方式 */
	private String repayType ="";
	
	/** 主要担保方式 */
	private String guaranteeType ="";
	
	/** 担保人姓名 */
	private String guaranteePerson ="";
	
	/** 担保物名称*/
	private String guaranteeGoods ="";
	
	/** 担保金额 */
	private String guaranteeMoney ="";
	
	/** 担保物所在地区 */
	private String guaranteeProvince ="";
	private String guaranteeCity ="";
	private String guaranteeZone ="";
	
	/** 担保物是否在本地 */
	private String isLocation ="";
	
	/**
	 * 两年内信用
	 */
	private String twoYearCredit ="";

	/**add by lzc
	 * 申贷用途
	 */
	private String creditPurpose ="";
	
	
	

	public String getCreditPurpose() {
		return creditPurpose;
	}

	public void setCreditPurpose(String creditPurpose) {
		this.creditPurpose = creditPurpose;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the limitDate
	 */
	public String getLimitDate() {
		return limitDate;
	}

	/**
	 * @param limitDate the limitDate to set
	 */
	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}

	/**
	 * @return the money
	 */
	public String getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(String money) {
		this.money = money;
	}

	/**
	 * @return the interestRate
	 */
	public String getInterestRate() {
		return interestRate;
	}

	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	/**
	 * @return the repayType
	 */
	public String getRepayType() {
		return repayType;
	}

	/**
	 * @param repayType the repayType to set
	 */
	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}

	/**
	 * @return the guaranteeType
	 */
	public String getGuaranteeType() {
		return guaranteeType;
	}

	/**
	 * @param guaranteeType the guaranteeType to set
	 */
	public void setGuaranteeType(String guaranteeType) {
		this.guaranteeType = guaranteeType;
	}

	/**
	 * @return the guaranteePerson
	 */
	public String getGuaranteePerson() {
		return guaranteePerson;
	}

	/**
	 * @param guaranteePerson the guaranteePerson to set
	 */
	public void setGuaranteePerson(String guaranteePerson) {
		this.guaranteePerson = guaranteePerson;
	}

	/**
	 * @return the guaranteeGoods
	 */
	public String getGuaranteeGoods() {
		return guaranteeGoods;
	}

	/**
	 * @param guaranteeGoods the guaranteeGoods to set
	 */
	public void setGuaranteeGoods(String guaranteeGoods) {
		this.guaranteeGoods = guaranteeGoods;
	}

	/**
	 * @return the guaranteeMoney
	 */
	public String getGuaranteeMoney() {
		return guaranteeMoney;
	}

	/**
	 * @param guaranteeMoney the guaranteeMoney to set
	 */
	public void setGuaranteeMoney(String guaranteeMoney) {
		this.guaranteeMoney = guaranteeMoney;
	}

	/**
	 * @return the isLocation
	 */
	public String getIsLocation() {
		return isLocation;
	}

	/**
	 * @param isLocation the isLocation to set
	 */
	public void setIsLocation(String isLocation) {
		this.isLocation = isLocation;
	}

	/**
	 * @return the guaranteeProvince
	 */
	public String getGuaranteeProvince() {
		return guaranteeProvince;
	}

	/**
	 * @param guaranteeProvince the guaranteeProvince to set
	 */
	public void setGuaranteeProvince(String guaranteeProvince) {
		this.guaranteeProvince = guaranteeProvince;
	}

	/**
	 * @return the guaranteeCity
	 */
	public String getGuaranteeCity() {
		return guaranteeCity;
	}

	/**
	 * @param guaranteeCity the guaranteeCity to set
	 */
	public void setGuaranteeCity(String guaranteeCity) {
		this.guaranteeCity = guaranteeCity;
	}

	/**
	 * @return the guaranteeZone
	 */
	public String getGuaranteeZone() {
		return guaranteeZone;
	}

	/**
	 * @param guaranteeZone the guaranteeZone to set
	 */
	public void setGuaranteeZone(String guaranteeZone) {
		this.guaranteeZone = guaranteeZone;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the twoYearCredit
	 */
	public String getTwoYearCredit() {
		return twoYearCredit;
	}

	/**
	 * @param twoYearCredit the twoYearCredit to set
	 */
	public void setTwoYearCredit(String twoYearCredit) {
		this.twoYearCredit = twoYearCredit;
	}
	
	
}
