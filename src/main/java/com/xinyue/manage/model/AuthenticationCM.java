package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 信贷经理认证信息(后台)
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年9月2日
 * 
 * ywh 2015-12-08 添加推荐标志  recommend
 */
public class AuthenticationCM implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5277246551964504524L;

	
	private String id = "";
	
	//真实姓名
	private String realName = "";
	
	//性别
	private String sex = "";
	
	//身份证号
	private String idCard = "";
	
	//手机号
	private String telPhone = "";
	
	//机构
	private String organization = "";
	
	//职位
	private String position = "";
	
	//省
	private String province = "";
	
	//市
	private String city = "";
	
	//地址
	private String address = "";
	
	//身份证照片
	private String cardImg = "";
	
	//工作照片
	private String workImg = "";
	
	//半身照片
	private String halfImg = "";
	
	//审核状态  1:为默认处于待审核;2:为审核中;3:审核失败;4:审核成功
	private String audit = "";
	
	//启用和屏蔽  0:为屏蔽;1:为启用默认
	private String status = "";
	
	//信贷经理ID
	private String managerId = "";
	
	//审核信息
	private String auditMessage = "";

	//ywh start
	private String recommend;
	
	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	//end
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
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
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
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return the telPhone
	 */
	public String getTelPhone() {
		return telPhone;
	}

	/**
	 * @param telPhone the telPhone to set
	 */
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the cardImg
	 */
	public String getCardImg() {
		return cardImg;
	}

	/**
	 * @param cardImg the cardImg to set
	 */
	public void setCardImg(String cardImg) {
		this.cardImg = cardImg;
	}

	/**
	 * @return the workImg
	 */
	public String getWorkImg() {
		return workImg;
	}

	/**
	 * @param workImg the workImg to set
	 */
	public void setWorkImg(String workImg) {
		this.workImg = workImg;
	}

	/**
	 * @return the halfImg
	 */
	public String getHalfImg() {
		return halfImg;
	}

	/**
	 * @param halfImg the halfImg to set
	 */
	public void setHalfImg(String halfImg) {
		this.halfImg = halfImg;
	}

	/**
	 * @return the audit
	 */
	public String getAudit() {
		return audit;
	}

	/**
	 * @param audit the audit to set
	 */
	public void setAudit(String audit) {
		this.audit = audit;
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
	 * @return the managerId
	 */
	public String getManagerId() {
		return managerId;
	}

	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	/**
	 * @return the auditMessage
	 */
	public String getAuditMessage() {
		return auditMessage;
	}

	/**
	 * @param auditMessage the auditMessage to set
	 */
	public void setAuditMessage(String auditMessage) {
		this.auditMessage = auditMessage;
	}
	
	
}
