package com.xinyue.manage.beans;

import java.util.Date;

/**信贷经理:我的客户列表model
 * author lzc
 */
public class OrderCustomer {
	private String id;//指定推送或者立即领取id
	private String type;////订单表:1立即领取,2竞拍,3唯一低价,4指定推送
	private String code;//订单编号
	private String applicantName;//申请人姓名
	private String productName;//产品名称
	private String applicantPhone;//申请人电话
	private String credit;//贷款额度
	private String limitDate;//贷款期限
	private String companyName;//贷款单位
	private Date applicantTime;//申请时间
	private String orderType;//获客来源
	private String status;//订单状态
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getApplicantPhone() {
		return applicantPhone;
	}
	public void setApplicantPhone(String applicantPhone) {
		this.applicantPhone = applicantPhone;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getApplicantTime() {
		return applicantTime;
	}
	public void setApplicantTime(Date applicantTime) {
		this.applicantTime = applicantTime;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
