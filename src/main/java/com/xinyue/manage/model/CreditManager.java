package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 信贷经理列表(后台)
 * author lzc
 */
public class CreditManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5279068618340158673L;

	private String id = "";
	
	private String tel = "";
	
	private String realName = "";
	
	private String organization = "";
	
	//add by mzj start 2015/08/28
	private String sex = "";
	
	private String email = "";
	
	private String star = "";
	
	private String province = "";
	
	private String city = "";
	
	private String zone = "";
	
	private String customerAmount = "";
	
	private String successCaseAmount = "";
	
	private String moneyRemaind = "";
	
	private String moneyPaper = "";
	
	private String status = "";
	
	private String registerDate = "";
	//add by mzj end 2015/08/28
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
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
	 * @return the star
	 */
	public String getStar() {
		return star;
	}

	/**
	 * @param star the star to set
	 */
	public void setStar(String star) {
		if (star !=null && !star.equals("")) {
			star = star+"星";
		}
		this.star = star;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}

	/**
	 * @param zone the zone to set
	 */
	public void setZone(String zone) {
		this.zone = zone;
	}

	/**
	 * @return the customerAmount
	 */
	public String getCustomerAmount() {
		return customerAmount;
	}

	/**
	 * @param customerAmount the customerAmount to set
	 */
	public void setCustomerAmount(String customerAmount) {
		this.customerAmount = customerAmount;
	}

	/**
	 * @return the successCaseAmount
	 */
	public String getSuccessCaseAmount() {
		return successCaseAmount;
	}

	/**
	 * @param successCaseAmount the successCaseAmount to set
	 */
	public void setSuccessCaseAmount(String successCaseAmount) {
		this.successCaseAmount = successCaseAmount;
	}

	/**
	 * @return the moneyRemaind
	 */
	public String getMoneyRemaind() {
		return moneyRemaind;
	}

	/**
	 * @param moneyRemaind the moneyRemaind to set
	 */
	public void setMoneyRemaind(String moneyRemaind) {
		this.moneyRemaind = moneyRemaind;
	}

	/**
	 * @return the moneyPaper
	 */
	public String getMoneyPaper() {
		return moneyPaper;
	}

	/**
	 * @param moneyPaper the moneyPaper to set
	 */
	public void setMoneyPaper(String moneyPaper) {
		this.moneyPaper = moneyPaper;
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
	 * @return the registerDate
	 */
	public String getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	
	
	
}

