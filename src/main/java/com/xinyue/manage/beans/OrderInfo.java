package com.xinyue.manage.beans;

import java.util.Date;

/**信贷->客户管理->我的客户->详情
 * 订单跟总记录bean
 * author lzc
 */
public class OrderInfo {
	private String id;//订单id
	private String type;//1订单2快速申贷
	private String productInfo;//产品名称
	private String organization;//所属机构
	private Double credit;//信贷额度
	private String limitDate;//期限
	private String applicantName;//申请人
	private String applicantPhone;//申请电话
	private String companyName;//公司名称
	private Date applicantTime;//申请日期
	private String status;//订单状态
	private String orderStatus;//订单状态数字形式
	private String remark;//备注
	private Date receiveTime;//放款时间
	private Double creditReal;//放款金额
	private Double price;//下载价格
	private String info;//企业信息
	
	//ywh start 
	private String topage;
	private String memberid;
	//ywh over
	
	
	
	
	public Double getPrice() {
		return price;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getTopage() {
		return topage;
	}
	public void setTopage(String topage) {
		this.topage = topage;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public Double getCreditReal() {
		return creditReal;
	}
	public void setCreditReal(Double creditReal) {
		this.creditReal = creditReal;
	}
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
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public String getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getApplicantPhone() {
		return applicantPhone;
	}
	public void setApplicantPhone(String applicantPhone) {
		this.applicantPhone = applicantPhone;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
