package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 信贷经理列表(后台)
 * author lzc
 * ywh 2015-12-08 添加 推荐标志 recommend
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
//	add by lzc
	private String organizationName = "";
	
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
	
	private String password = "";
	
	private String invitationCode = "";
	
	private String birthday = "";
	
	private String goodBusiness = "";
	//add by mzj end 2015/08/28
	

	//ywh start
	private String card;
	private String auditName;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private String recommend;
	//ywh over
	
	public String getId() {
		return id;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getAuditName() {
		return auditName;
	}

	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public String getFour() {
		return four;
	}

	public void setFour(String four) {
		this.four = four;
	}

	public String getFive() {
		return five;
	}

	public void setFive(String five) {
		this.five = five;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
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

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the invitationCode
	 */
	public String getInvitationCode() {
		return invitationCode;
	}

	/**
	 * @param invitationCode the invitationCode to set
	 */
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the goodBusiness
	 */
	public String getGoodBusiness() {
		return goodBusiness;
	}

	/**
	 * @param goodBusiness the goodBusiness to set
	 */
	public void setGoodBusiness(String goodBusiness) {
		this.goodBusiness = goodBusiness;
	}

	
	
	
}

