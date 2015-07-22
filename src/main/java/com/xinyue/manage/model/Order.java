package com.xinyue.manage.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * author lzc
 * 2015年5月30日下午3:46:58
 * 该model层较为混乱,以下字段意思是根据界面与表之间的关系猜测,以后可能需要修改
 * 2015年6月1日09:58:08 addby lzc
 */
public class Order {
	private String id;//订单id
	private String memberId;//会员id外键
	private String licenseInfo;//企业基本信息id外键
	private int companySave;   //企业基本信息状态
	private String debtInfo;//负责表id外键
	private int    debtSave;//负债状态
	private String realEstate;//实际资产id外键
	private int businessSave; //实际资产状态
	private String applicantInfo;//申请表id外键
	private int    applicantSave;//申请表状态
	private String ratingInfo;//评级表id外键
	private String applicant;//申请人姓名
	private String bank;//银行id外键
	private String productInfo;//产品表外键
	
	private String province;//省
	private String city;//市
	private String zone;//区
	
	private String productName;//产品名称
	private String productCode;//产品编号
	
	private String companyInfo;//申请单位
	private String name;
	private String code;//订单号
	private String linkUserName;//用户名
	
	private String applicatPerson;//申请人
	private String orderNumber;//useless
	private Double credit;//贷款额度
	private String linkPhone;//手机号
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	private Date commitTime;//下单时间
	private String status;//订单状态
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	private Date auditeTime;//放款实际
	private String auditePerson;
	private String remark;//放款备注
	
	private String memberStatus;//会员订单状态
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	private Date blankAuditeTime;//银行审核时间
	private String blankAuditeRemark;//银行备注
	private String blankAuditePerson;//银行审核人员
	private int blankAuditeStatus;
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	private Date taxAuditeTime;//新越审核时间
	private String taxAuditeRemark;//新越备注
	private String taxAuditePerson;//新越审核人员
	private int taxAuditeStatus;
	
	private int deleted;
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	private Date createdTime;//创建时间
	private String createdId;
	private String modifiedId;
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	private Date modifiedTime;
	
	
	private String orderStatus;//指定客户状态1.领取未开始2.未领取3.无人领取4.已领取
	private String orderType;//订单类型:1立即领取,2竞拍,3唯一低价,4指定推送,5人员主动操作
	private Double creditReal;//实际贷款
	
	
	
	
	public Double getCreditReal() {
		return creditReal;
	}
	public void setCreditReal(Double creditReal) {
		this.creditReal = creditReal;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public int getBlankAuditeStatus() {
		return blankAuditeStatus;
	}
	public void setBlankAuditeStatus(int blankAuditeStatus) {
		this.blankAuditeStatus = blankAuditeStatus;
	}
	public int getTaxAuditeStatus() {
		return taxAuditeStatus;
	}
	public void setTaxAuditeStatus(int taxAuditeStatus) {
		this.taxAuditeStatus = taxAuditeStatus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getLicenseInfo() {
		return licenseInfo;
	}
	public void setLicenseInfo(String licenseInfo) {
		this.licenseInfo = licenseInfo;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLinkUserName() {
		return linkUserName;
	}
	public void setLinkUserName(String linkUserName) {
		this.linkUserName = linkUserName;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getDebtInfo() {
		return debtInfo;
	}
	public void setDebtInfo(String debtInfo) {
		this.debtInfo = debtInfo;
	}
	public String getRealEstate() {
		return realEstate;
	}
	public void setRealEstate(String realEstate) {
		this.realEstate = realEstate;
	}
	public String getApplicantInfo() {
		return applicantInfo;
	}
	public void setApplicantInfo(String applicantInfo) {
		this.applicantInfo = applicantInfo;
	}
	public String getRatingInfo() {
		return ratingInfo;
	}
	public void setRatingInfo(String ratingInfo) {
		this.ratingInfo = ratingInfo;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public String getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}
	public String getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public Date getCommitTime() {
		return commitTime;
	}
	public void setCommitTime(Date commitTime) {
		this.commitTime = commitTime;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getAuditeTime() {
		return auditeTime;
	}
	public void setAuditeTime(Date auditeTime) {
		this.auditeTime = auditeTime;
	}
	public String getAuditePerson() {
		return auditePerson;
	}
	public void setAuditePerson(String auditePerson) {
		this.auditePerson = auditePerson;
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
	public Date getBlankAuditeTime() {
		return blankAuditeTime;
	}
	public void setBlankAuditeTime(Date blankAuditeTime) {
		this.blankAuditeTime = blankAuditeTime;
	}
	public String getBlankAuditeRemark() {
		return blankAuditeRemark;
	}
	public void setBlankAuditeRemark(String blankAuditeRemark) {
		this.blankAuditeRemark = blankAuditeRemark;
	}
	public String getBlankAuditePerson() {
		return blankAuditePerson;
	}
	public void setBlankAuditePerson(String blankAuditePerson) {
		this.blankAuditePerson = blankAuditePerson;
	}
	public Date getTaxAuditeTime() {
		return taxAuditeTime;
	}
	public void setTaxAuditeTime(Date taxAuditeTime) {
		this.taxAuditeTime = taxAuditeTime;
	}
	public String getTaxAuditeRemark() {
		return taxAuditeRemark;
	}
	public void setTaxAuditeRemark(String taxAuditeRemark) {
		this.taxAuditeRemark = taxAuditeRemark;
	}
	public String getTaxAuditePerson() {
		return taxAuditePerson;
	}
	public void setTaxAuditePerson(String taxAuditePerson) {
		this.taxAuditePerson = taxAuditePerson;
	}
	public String getApplicatPerson() {
		return applicatPerson;
	}
	public void setApplicatPerson(String applicatPerson) {
		this.applicatPerson = applicatPerson;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getCreatedId() {
		return createdId;
	}
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}
	public String getModifiedId() {
		return modifiedId;
	}
	public void setModifiedId(String modifiedId) {
		this.modifiedId = modifiedId;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public int getApplicantSave() {
		return applicantSave;
	}
	public void setApplicantSave(int applicantSave) {
		this.applicantSave = applicantSave;
	}
	public int getBusinessSave() {
		return businessSave;
	}
	public void setBusinessSave(int businessSave) {
		this.businessSave = businessSave;
	}
	public int getCompanySave() {
		return companySave;
	}
	public void setCompanySave(int companySave) {
		this.companySave = companySave;
	}
	public int getDebtSave() {
		return debtSave;
	}
	public void setDebtSave(int debtSave) {
		this.debtSave = debtSave;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	 

}
