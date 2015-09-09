package com.xinyue.manage.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * author lzc
 * 2015年6月30日下午3:34:59
 * 
 * 立即领取
 */
public class OrderFixed {
	private String id;//主键
	private Double price;//立即领取价格
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startTime;//领取开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;//领取结束时间
	private int deleted;
	private String createdId;
	private Date createdTime;
	private String modifiedId;
	private Date modifiedTime;
	private String orderId;//订单外键
	private int type;//1.订单2快速申贷
	private String manageId;//信贷经理外键
	
	
	
	private String companyType;//企业类型
	private String personNum;//员工人数
	private String sales;//年销售收入
	private String runYear;//企业经营年限
	private Double credit;//贷款额度
	private String guaranteeType;//担保方式
	private String twoYearCredit;//信用记录
	private String collateral;//抵押物
	private String limitDate;//申贷期限
	private String totalVat;//企业年增值税
	
	private String applicantName;//申请人姓名
	private String image;//头像
	
	
	
	
	
	
	
	
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getPersonNum() {
		return personNum;
	}
	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getRunYear() {
		return runYear;
	}
	public void setRunYear(String runYear) {
		this.runYear = runYear;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public String getGuaranteeType() {
		return guaranteeType;
	}
	public void setGuaranteeType(String guaranteeType) {
		this.guaranteeType = guaranteeType;
	}
	public String getTwoYearCredit() {
		return twoYearCredit;
	}
	public void setTwoYearCredit(String twoYearCredit) {
		this.twoYearCredit = twoYearCredit;
	}
	public String getCollateral() {
		return collateral;
	}
	public void setCollateral(String collateral) {
		this.collateral = collateral;
	}
	public String getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}
	public String getTotalVat() {
		return totalVat;
	}
	public void setTotalVat(String totalVat) {
		this.totalVat = totalVat;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
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
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getManageId() {
		return manageId;
	}
	public void setManageId(String manageId) {
		this.manageId = manageId;
	}

	
	
	
	
	
}
