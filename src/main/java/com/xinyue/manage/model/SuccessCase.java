package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 成功案例
 * @author MK)茅
 * @version v1.0
 * @date 创建时间：2015年8月17日
 */
public class SuccessCase implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6641372692916843326L;
	
	/**
	 * id
	 */
	private String id;
	/**
	 * 信贷经理ID
	 */
	private String creditManagerId;
	//2015/8/18 youwenhai
	private String creditManagerName;
	
	/**
	 * 产品ID
	 */
	private String productId;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 申请人/单位
	 */
	private String applicantCompany;
	/**
	 * 放款金额
	 */
	private String loanAmount;
	/**
	 * 放款日期
	 */
	private String loanDate;
	/**
	 * 贷款期限
	 */
	private String loanPeriod;
	/**
	 * 放款天数
	 */
	private String loanDays;
	/**
	 * 贷款类型ID
	 */
	private String loanType;
	/**
	 * 所属地区（省）
	 */
	private String loanProvince;
	/**
	 * 所属地区（市）
	 */
	private String loanCity;
	/**
	 * 月息
	 */
	private String monthInterest;
	/**
	 * 排序
	 */
	private String orderNumber;
	/**
	 * 详情描述
	 */
	private String description;
	/**
	 * 创建人
	 */
	private String createdId;
	/**
	 * 修改人
	 */
	private String modifiedId;
	
	/**
	 * 启用：0/屏蔽：1
	 */
	private boolean useFlag = false;
	
	
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
	 * @return the creditManagerId
	 */
	public String getCreditManagerId() {
		return creditManagerId;
	}
	/**
	 * @param creditManagerId the creditManagerId to set
	 */
	public void setCreditManagerId(String creditManagerId) {
		this.creditManagerId = creditManagerId;
	}
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * @return the applicantCompany
	 */
	public String getApplicantCompany() {
		return applicantCompany;
	}
	/**
	 * @param applicantCompany the applicantCompany to set
	 */
	public void setApplicantCompany(String applicantCompany) {
		this.applicantCompany = applicantCompany;
	}
	/**
	 * @return the loanAmount
	 */
	public String getLoanAmount() {
		return loanAmount;
	}
	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	/**
	 * @return the loanDate
	 */
	public String getLoanDate() {
		return loanDate;
	}
	/**
	 * @param loanDate the loanDate to set
	 */
	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}
	/**
	 * @return the loanPeriod
	 */
	public String getLoanPeriod() {
		return loanPeriod;
	}
	/**
	 * @param loanPeriod the loanPeriod to set
	 */
	public void setLoanPeriod(String loanPeriod) {
		this.loanPeriod = loanPeriod;
	}
	/**
	 * @return the loanDays
	 */
	public String getLoanDays() {
		return loanDays;
	}
	/**
	 * @param loanDays the loanDays to set
	 */
	public void setLoanDays(String loanDays) {
		this.loanDays = loanDays;
	}
	/**
	 * @return the loanType
	 */
	public String getLoanType() {
		return loanType;
	}
	/**
	 * @param loanType the loanType to set
	 */
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	/**
	 * @return the loanProvince
	 */
	public String getLoanProvince() {
		return loanProvince;
	}
	/**
	 * @param loanProvince the loanProvince to set
	 */
	public void setLoanProvince(String loanProvince) {
		this.loanProvince = loanProvince;
	}
	/**
	 * @return the loanCity
	 */
	public String getLoanCity() {
		return loanCity;
	}
	/**
	 * @param loanCity the loanCity to set
	 */
	public void setLoanCity(String loanCity) {
		this.loanCity = loanCity;
	}
	/**
	 * @return the monthInterest
	 */
	public String getMonthInterest() {
		return monthInterest;
	}
	/**
	 * @param monthInterest the monthInterest to set
	 */
	public void setMonthInterest(String monthInterest) {
		this.monthInterest = monthInterest;
	}
	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}
	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the createdId
	 */
	public String getCreatedId() {
		return createdId;
	}
	/**
	 * @param createdId the createdId to set
	 */
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}
	/**
	 * @return the modifiedId
	 */
	public String getModifiedId() {
		return modifiedId;
	}
	/**
	 * @param modifiedId the modifiedId to set
	 */
	public void setModifiedId(String modifiedId) {
		this.modifiedId = modifiedId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getCreditManagerName() {
		return creditManagerName;
	}
	public void setCreditManagerName(String creditManagerName) {
		this.creditManagerName = creditManagerName;
	}
	/**
	 * @return the useFlag
	 */
	public boolean isUseFlag() {
		return useFlag;
	}
	/**
	 * @param useFlag the useFlag to set
	 */
	public void setUseFlag(boolean useFlag) {
		this.useFlag = useFlag;
	}
	
}
