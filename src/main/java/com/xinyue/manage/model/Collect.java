package com.xinyue.manage.model;

import java.io.Serializable;

/**
 * 产品收藏 普通会员 
 * @author wenhai.you
 * @2015年7月21日
 * @上午10:56:22
 */
public class Collect implements Serializable {

	private int id;
	private String productName;//产品名称
	private String orgName;//机构名称 
	private String credit;//信贷额度
	private String interestFrom;//月息
	private String interestTo;
	private String periodFrom;//贷款周期
	private String periodTo;
	private String collectTime;//收藏时间
	private String memberid;//会员id
	private String productid;//产品id
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getInterestFrom() {
		return interestFrom;
	}
	public void setInterestFrom(String interestFrom) {
		this.interestFrom = interestFrom;
	}
	public String getInterestTo() {
		return interestTo;
	}
	public void setInterestTo(String interestTo) {
		this.interestTo = interestTo;
	}
	public String getPeriodFrom() {
		return periodFrom;
	}
	public void setPeriodFrom(String periodFrom) {
		this.periodFrom = periodFrom;
	}
	public String getPeriodTo() {
		return periodTo;
	}
	public void setPeriodTo(String periodTo) {
		this.periodTo = periodTo;
	}
	public String getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	
}
