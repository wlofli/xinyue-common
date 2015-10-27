package com.xinyue.manage.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * @author lzc
 * @date 2015年6月26日上午10:55:59
 */
public class FastProduct {
	private String id;
	private String company;
	private String code;//订单号
	private String areaProvince;
	private String areaCity;
	private String areaZone;
	private String contactName;
	private int deleted;
	private String status;
	private String statusValue;
	private Double credit; //贷款额度
	private String contactPhone;
	private String createdId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdTime;
	private String modifiedId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date modifiedTime;
	private String remark;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date auditeTime;//放款时间
	private String auditePerson;//放款人员
	private String receiver;//接单人员
	private String receiverPhone;//接单人员电话
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date receiveTime;//接单时间
	private String orderStatus;//指定客户状态1.已领取2.未领取3.无人领取4.领取未开始
	private String orderType;//订单类型:1立即领取,2竞拍,3唯一低价,4指定推送,5重置
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
	private Double creditReal;//实际贷款
	private String applicantFastId;//快速申贷申请人信息
	private String companyFastId;//快速申贷公司信息
	private String productId;//产品id
	private String manageId;//信贷经理id
	private String productName;//产品名称
	private String productCode;//产品编号
	private String organization;//所属机构
	
	private String type;//1.普通2.有产品
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
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
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getManageId() {
		return manageId;
	}
	public void setManageId(String manageId) {
		this.manageId = manageId;
	}
	public String getApplicantFastId() {
		return applicantFastId;
	}
	public void setApplicantFastId(String applicantFastId) {
		this.applicantFastId = applicantFastId;
	}
	public String getCompanyFastId() {
		return companyFastId;
	}
	public void setCompanyFastId(String companyFastId) {
		this.companyFastId = companyFastId;
	}
	public Double getCreditReal() {
		return creditReal;
	}
	public void setCreditReal(Double creditReal) {
		this.creditReal = creditReal;
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
	public int getBlankAuditeStatus() {
		return blankAuditeStatus;
	}
	public void setBlankAuditeStatus(int blankAuditeStatus) {
		this.blankAuditeStatus = blankAuditeStatus;
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
	public int getTaxAuditeStatus() {
		return taxAuditeStatus;
	}
	public void setTaxAuditeStatus(int taxAuditeStatus) {
		this.taxAuditeStatus = taxAuditeStatus;
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
	public String getStatusValue() {
		return statusValue;
	}
	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAreaProvince() {
		return areaProvince;
	}
	public void setAreaProvince(String areaProvince) {
		this.areaProvince = areaProvince;
	}
	public String getAreaCity() {
		return areaCity;
	}
	public void setAreaCity(String areaCity) {
		this.areaCity = areaCity;
	}
	public String getAreaZone() {
		return areaZone;
	}
	public void setAreaZone(String areaZone) {
		this.areaZone = areaZone;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public String getCreatedId() {
		return createdId;
	}
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	
	
	

}
